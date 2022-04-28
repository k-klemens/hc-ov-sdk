package at.kk.msc.hcov.sdk.verificationtask;

import at.kk.msc.hcov.sdk.verificationtask.model.ProvidedContext;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.jena.ontology.OntModel;
import org.springframework.plugin.core.Plugin;

/**
 * Interface specifying methods that need to be implemented by context providers.
 */
public interface IContextProviderPlugin extends Plugin<String> {

  /**
   * Extracts the context for one given extracted ontological elements.
   *
   * @param extractedElementsId UUID of the extracted ontology elements as provided by the data provider.
   * @param ontModel            OntModel for which the context shall be provided.
   * @param configuration       Map with configuration paramters to be passed to be context provider.
   * @return a {@link ProvidedContext} object containing the context of provided elements.
   */
  ProvidedContext provideContextFor(UUID extractedElementsId, OntModel ontModel, Map<String, Object> configuration);

  /**
   * Extracts the context for a given list of extracted ontological elements.
   *
   * @param extractedElementsMap List of UUIDs of the extracted ontology elements as provided by the data provider.
   * @param configuration        Map with configuration paramters to be passed to be context provider.
   * @return a Map of context objects keyed by their UUIDs
   */
  default Map<UUID, ProvidedContext> provideContextFor(Map<UUID, OntModel> extractedElementsMap, Map<String, Object> configuration) {
    Map<UUID, ProvidedContext> providedContexts = new HashMap<>();
    for (Map.Entry<UUID, OntModel> extractedElementsEntry : extractedElementsMap.entrySet()) {
      UUID elementsId = extractedElementsEntry.getKey();
      OntModel ontModel = extractedElementsEntry.getValue();
      providedContexts.put(elementsId, provideContextFor(elementsId, ontModel, configuration));
    }
    return providedContexts;
  }

}
