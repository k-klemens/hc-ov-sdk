package at.kk.msc.hcov.sdk.verificationtask;

import at.kk.msc.hcov.sdk.plugin.ConfigurablePlugin;
import at.kk.msc.hcov.sdk.plugin.PluginConfigurationNotSetException;
import at.kk.msc.hcov.sdk.verificationtask.model.ProvidedContext;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.apache.jena.ontology.OntModel;


/**
 * Interface specifying methods that need to be implemented by plugins creating verification tasks.
 */
public interface IVerificationTaskPlugin extends ConfigurablePlugin<String> {

  /**
   * Returns a function used to extract the required model elements for each verification task / HIT.
   *
   * @return a Function that maps a Jena {@link OntModel} to a {@link List} of {@link OntModel}s representing the data needed for individual verification tasks.
   * @throws PluginConfigurationNotSetException if the a configuration is required and not set!
   */
  Function<OntModel, List<OntModel>> getElementExtractor() throws PluginConfigurationNotSetException;

  /**
   * Function that returns a function that is able to provide a map of values for the template variables from either the {@link OntModel} or the {@link ProvidedContext}
   *
   * @return a Function that consumes a {@link OntModel} and {@link ProvidedContext} and provides a Map of all variables needed in the template
   * keyed by the variable-name used in the template.
   * @throws PluginConfigurationNotSetException if the a configuration is required and not set!
   */
  BiFunction<OntModel, ProvidedContext, Map<String, Object>> getTemplateVariableValueResolver() throws PluginConfigurationNotSetException;

  /**
   * Returns the template to be processed by thymeleaf.
   *
   * @return a Thmyeleaf template where the extracted elements can be included.
   * @throws PluginConfigurationNotSetException if the a configuration is required and not set!
   */
  String getTemplate() throws PluginConfigurationNotSetException;


}
