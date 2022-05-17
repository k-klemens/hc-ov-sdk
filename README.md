# HC-OV (Human-Centred Ontology Verification) SDK

This Java based project allows to create extension plugins for the end-to-end process support platform for human-centred ontology
verification [`hc-ov-core`](https://github.com/k-klemens/hc-ov-core).

Using this SDK four different types of extension-plugins can be provided to the platform:

- **Verification Task Plugin**: Implementing the interface `IVerificationTaskPlugin` allows specifying methodology of extracting ontological elements, providing
  a
  micro-task user-interface and specifying how to resolve templating variables.
- **Context Provider Plugin**: Implementing the interface `IContextProviderPlugin` allows specifying a methodology how to provide contextual information for a
  set
  of
  given ontological elements.
- **Crowdsourcing Connector Plugin**: Implementing the interface `ICrowdsourcingConnectorPlugin` allows publishing a verification, retrieving the status of a
  published verification and retrieving the results of a completed verification on a selected crowdsourcing platform.
- **Processor Plugin**: Implementing the interface `IProcessorPlugin` allows to specify a new methodology how to process obtained results.

For a sample set of implemented plugins visit
either [Pizza `hasTopping` Restriction Verification Plugins](https://github.com/k-klemens/hc-ov-pizza-verification-plugins)
or [Mocked Sample Plugins](https://github.com/k-klemens/hc-ov-sample-plugins).
A prototypical implementation of connecting to [Amazon Mechanical Turk](https://www.mturk.com/) can be found
at [hc-ov-amt-connector](https://github.com/k-klemens/hc-ov-amt-connector).

## How to implement a new plugin and include it with the platform:

1. Create a new `maven` project that includes this project as a dependency
2. Implement the desired plugin interface(s) in a sub-package of `at.kk.msc.hcov.plugin`*
3. Make sure each plugin implementation is annotated with
   a [Spring Stereotype](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/package-summary.html) annotation to
   ensure the `hc-ov-core` can load the plugin.
4. Install the project containing the new plugins to a maven repository (e.g. locally by executing `mvn clean install` in the project directory)
5. Add this project to the dependencies of the `hc-ov-core` [pom.xml](https://github.com/k-klemens/hc-ov-core/blob/master/pom.xml)
6. Build the `hc-ov-core` (e.g. locally by executing `mvn clean install`)
7. The created jar-file includes the implemented plugins and by specifying the correct plugin `delimiter` in the requested ``Verification Specification`` the
   correct plugin is loaded and executed at runtime.

\* If a different package than `at.kk.msc.hcov.plugin` is used the `scanBasePackages` of the `@SpringBootApplication` annotation in the core needs to be
adapted. (Found in [PlatformCore.java](https://github.com/k-klemens/hc-ov-core/blob/master/src/main/java/at/kk/msc/hcov/core/PlatformCore.java)) 
