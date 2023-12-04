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
  public Boolean run(Submission submission) {
    var inputData = submission.getInputData();
    if (inputData.containsKey("benefitElection[]")) {
      var programArr = (ArrayList<String>) submission.getInputData().get("benefitElection[]");
      return programArr.contains("SNAP");
    }
    return false;
  }

}


