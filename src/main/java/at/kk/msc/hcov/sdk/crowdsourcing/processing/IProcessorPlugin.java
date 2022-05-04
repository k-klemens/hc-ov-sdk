package at.kk.msc.hcov.sdk.crowdsourcing.processing;

import at.kk.msc.hcov.sdk.plugin.ConfigurablePlugin;
import at.kk.msc.hcov.sdk.plugin.PluginConfigurationNotSetException;
import java.util.List;

/**
 * Interface specifying the methods which need to be provided by a processor plugin.
 */
public interface IProcessorPlugin extends ConfigurablePlugin<String> {

  /**
   * Processes a given input and returns the result.
   *
   * @param input a list of {@link ProcessingResult} objects to be processed.
   * @return a list of {@link ProcessingResult} objects containing the result.
   */
  List<ProcessingResult> process(List<ProcessingResult> input)
      throws RequiredKeyNotPresentException, PluginConfigurationNotSetException;

  /**
   * Describes which keys need to be present in each input result processing map.
   * This method should be checked by each input provided to the process method.
   *
   * @return a list of keys which should be present in the given input result data map such that the data can be processed.
   */
  List<String> requiresInputResultDataKeys();

  default void validateAllInputHasRequiredKeys(List<ProcessingResult> input) throws RequiredKeyNotPresentException {
    boolean everyInputContainsAllKeys = input.stream().allMatch(
        processingResult -> processingResult.getResultData().keySet().containsAll(requiresInputResultDataKeys())
    );
    if (!everyInputContainsAllKeys) {
      throw new RequiredKeyNotPresentException("One or more required keys are not present!");
    }
  }

}
