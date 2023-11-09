package org.formflowstartertemplate.app.submission.conditions;

import formflow.library.config.submission.Condition;
import formflow.library.data.Submission;
import formflow.library.inputs.UnvalidatedField;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SnapSelected implements Condition{
  @Override
  public Boolean run(Submission submission, String data) {
    if (submission.getInputData().containsKey("benefitElection")) {
      // Change logic to suit your needs
      var incomeArr = (ArrayList<Map<String, Object>>) submission.getInputData().get("benefitElection");
      Map<String, Object> benefitSelection = incomeArr.stream()
          .filter(entry -> entry.get("uuid").equals(data))
          .toList()
          .get(0);
      return benefitSelection.get("benefitElection").equals("SNAP"); // should be true here ..
    }
    return false;

  }
}
