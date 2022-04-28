package at.kk.msc.hcov.sdk.plugin;

import java.util.Map;
import org.springframework.plugin.core.Plugin;

public interface ConfigurablePlugin<T> extends Plugin<T> {

  /**
   * Sets the configuration of the plugin.
   *
   * @param verificationTaskPluginConfiguration Map specifying the configuration of the plugin as key value pairs.
   */
  void setConfiguration(Map<String, Object> verificationTaskPluginConfiguration);


  /**
   * Gets the current configuration of the plugin.
   */
  Map<String, Object> getConfiguration();

  /**
   * Validates if the set configuration is correct otherwhise throws exception.
   * Utility method to be called for plugin methods that require configuration.
   *
   * @throws PluginConfigurationNotSetException if the configuraiton is not set or incorrect.
   */
  default void validateConfigurationSetOrThrow() throws PluginConfigurationNotSetException {
    if (getConfiguration() == null) {
      throw new PluginConfigurationNotSetException();
    }
  }

}
