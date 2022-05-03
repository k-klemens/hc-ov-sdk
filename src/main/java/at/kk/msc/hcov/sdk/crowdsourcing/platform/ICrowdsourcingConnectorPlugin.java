package at.kk.msc.hcov.sdk.crowdsourcing.platform;

import at.kk.msc.hcov.sdk.crowdsourcing.platform.model.HitStatus;
import at.kk.msc.hcov.sdk.plugin.ConfigurablePlugin;
import at.kk.msc.hcov.sdk.plugin.PluginConfigurationNotSetException;
import at.kk.msc.hcov.sdk.verificationtask.model.VerificationTask;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ICrowdsourcingConnectorPlugin extends ConfigurablePlugin<String> {

  /**
   * Publishes a given set of verification tasks. Requires a configuration to be set early by calling setConfiguration().
   *
   * @param verificationTasks a List of Verification tasks to be published
   * @return a Map of IDs provided by crowdsourcing platform keyed with the internal extracted element Ids.
   * @throws PluginConfigurationNotSetException if the required configuration for the crowdsourcing platform is not set.
   */
  Map<UUID, String> publishTasks(List<VerificationTask> verificationTasks) throws PluginConfigurationNotSetException;

  /**
   * Obtains the status for the given set of HIT ids and retuns them in a map.
   *
   * @param crowdsourcingIds Ids of the HITs to retrieve the status for.
   * @return a Map of {@link HitStatus} objects keyed by the crowdsourcing id.
   * @throws PluginConfigurationNotSetException if the required configuration for the crowdsourcing platform is not set.
   */
  Map<String, HitStatus> getStatusForHits(List<String> crowdsourcingIds) throws PluginConfigurationNotSetException;

}
