package at.kk.msc.hcov.sdk.verificationtask.model;

import java.util.UUID;
import lombok.Data;

@Data
/**
 * Basic class specifiyng the object for a verification task / HIT.
 */
public class VerificationTask {

  /**
   * Name of the verification.
   */
  private String verificationName;
  /**
   * Name of the ontology to be verified.
   */
  private String ontologyName;
  /**
   * UUID of the extracted ontology element typically provided by an DataProvider.
   */
  private UUID ontologyElementId;
  /**
   * String containing a populate HTML template of the task to be uploaded to the crowdsourcing platform.
   */
  private String taskHtml;

}
