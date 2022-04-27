package at.kk.msc.hcov.sdk.verificationtask;

import at.kk.msc.hcov.sdk.verificationtask.model.Context;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.apache.commons.lang3.function.TriFunction;
import org.apache.jena.ontology.OntModel;
import org.springframework.plugin.core.Plugin;


/**
 * Interface specifying methods that need to be implemented by plugins creating verification tasks.
 */
public interface IVerificationTaskPlugin extends Plugin<String> {

  /**
   * Returns a function used to extract the required model elements for each verification task / HIT.
   *
   * @param verificationTaskPluginConfiguration map containing possible configuration values needed to create the extractor.
   * @return a Function that maps a Jena {@link OntModel} to a {@link List} of {@link OntModel}s representing the data needed for individual verification tasks.
   */
  Function<OntModel, List<OntModel>> getElementExtractor(Map<String, Object> verificationTaskPluginConfiguration);

  /**
   * Function that returns a function that is able to resolve the template variables from either the {@link OntModel} or the {@link Context}
   *
   * @return a Function that consumes a template-variable-name {@link String}, {@link OntModel}, {@link Context} and provides a string value
   * for the given template-variable-name to be used while templating
   */
  TriFunction<String, OntModel, Context, String> getTemplateVariableValueResolver();

  /**
   * Returns the template to be processed by thymeleaf.
   *
   * @param verificationTaskPluginConfiguration map containing possible configuration values needed to create the template.
   * @return a Thmyeleaf template where the extracted elements can be included.
   */
  String getTemplate(Map<String, Object> verificationTaskPluginConfiguration);


}
