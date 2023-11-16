package org.bp;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.HashMap;
import java.util.Map;

public class ReportMessage implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("application_productName", execution.getVariable("application_productName"));
        variables.put("application_productAmount", execution.getVariable("application_productAmount"));
        variables.put("application_productType", execution.getVariable("application_productType"));
        variables.put("application_productDescription", execution.getVariable("application_productDescription"));

        String status = (String) execution.getVariable("status");
        String extraInfo = (String) execution.getVariable("reject_reason");
        if ((extraInfo == null || extraInfo.isEmpty()) && status.equals("accept")) {
            extraInfo = "Everything went well";
        }

        variables.put("extraInfo", extraInfo);
        variables.put("status", status);


        execution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("ReportMessage")
                .setVariables(variables)
                .correlate();
    }
}
