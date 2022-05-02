package at.kk.msc.hcov.sdk.crowdsourcing.platform.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class holding a mapping between ontology elements id and crowdsourcing task id.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublishedTask {

  /**
   * ID of the published task providded by the crowdsourcing platform.
   */
  private String crowdsourcingId;

  /**
   * ID of the ontologyElements as used by the core platform.
   */
  private UUID ontologyElementId;
}
