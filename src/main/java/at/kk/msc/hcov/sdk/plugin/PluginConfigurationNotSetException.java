package at.kk.msc.hcov.sdk.plugin;

public class PluginConfigurationNotSetException extends Exception {

  public PluginConfigurationNotSetException() {
    super("Plugin configuration not set! Please set using setConfiguration()!");
  }

  public PluginConfigurationNotSetException(String message) {
    super(message);
  }
}
