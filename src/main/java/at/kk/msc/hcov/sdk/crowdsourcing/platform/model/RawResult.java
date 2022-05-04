package at.kk.msc.hcov.sdk.crowdsourcing.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * Unprocessed result from one worker.
 */
public class RawResult {

  /**
   * ID of the result. (If provided by the crowdsourcing platform)
   */
  private String resultId;

  /**
   * ID of the task.
   */
  private String crowdscouringId;

  /**
   * ID of the worker who submitted the answer.
   */
  private String workerId;

  /**
   * Answer submitted for the given task.
   */
  private String answer;
}
