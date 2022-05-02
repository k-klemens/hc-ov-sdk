package at.kk.msc.hcov.sdk.crowdsourcing.platform;

import at.kk.msc.hcov.sdk.crowdsourcing.platform.model.PublishedTaskIdMappings;
import at.kk.msc.hcov.sdk.plugin.ConfigurablePlugin;
import at.kk.msc.hcov.sdk.plugin.PluginConfigurationNotSetException;
import at.kk.msc.hcov.sdk.verificationtask.model.VerificationTask;
import java.util.List;

public interface ICrowdsourcingConnectorPlugin extends ConfigurablePlugin<String> {

  /**
   * Publishes a given set of verification tasks. Requires a configuration to be set early by calling setConfiguration().
   *
   * @param verificationTasks a List of Verification tasks to be published
   * @return returns the results of the published verificaiton tasks
   * @throws PluginConfigurationNotSetException if the required configuration for the crowdsourcing platform is not set.
   */
  PublishedTaskIdMappings publishTasks(List<VerificationTask> verificationTasks) throws PluginConfigurationNotSetException;

}
