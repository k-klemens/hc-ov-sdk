package at.kk.msc.hcov.sdk.crowdsourcing.platform;

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

}
