package at.kk.msc.hcov.sdk.crowdsourcing.processing;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data structure defining a processed result.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProcessingResult {

  /**
   * Task id for which the result is created for.
   */
  private String crowdsourcingId;

  /**
   * Map containing key value pair describing the processing result.
   */
  private Map<String, String> resultData;

  /**
   *
   */
  private String resultDescription;

}
