package at.kk.msc.hcov.sdk.verificationtask.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProvidedContext {

  public ProvidedContext(UUID extractedElementsId) {
    this.extractedElementsId = extractedElementsId;
    this.contextString = "";
  }

  UUID extractedElementsId;
  String contextString;

}
