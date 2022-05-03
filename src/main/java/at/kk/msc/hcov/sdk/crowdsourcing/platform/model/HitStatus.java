package at.kk.msc.hcov.sdk.crowdsourcing.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HitStatus {

  /**
   * Id of the crowdsourcing task.
   */
  private String crowdsourcingId;
  /**
   * Maximum number of expected assignment for a task.
   */
  private int maxAssignments;
  /**
   * Number of assignemnts that are completed.
   */
  private int numCompleted;

}
