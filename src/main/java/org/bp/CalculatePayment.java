package org.bp;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CalculatePayment implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws IllegalArgumentException {
        String productType = (String) execution.getVariable("application_productType");
        Integer productAmount = (Integer) execution.getVariable("application_productAmount");

if (productAmount == null) productAmount = 0;

        Integer finalPaymentAmount = calculatePaymentAmount(productType, productAmount);
        execution.setVariable("application_paymentCost", finalPaymentAmount.toString());
    }

    public Integer calculatePaymentAmount(String productType, Integer productAmount) {
        Float typeMultiplier = ProductType.valueOf(productType.toUpperCase()).multiplier;
        Float amountMultiplier = ProductAmount.valueOf(mapAmountToDescription(productAmount).toUpperCase()).multiplier;

        return (int) (productAmount * typeMultiplier * amountMultiplier);
    }

    private String mapAmountToDescription(Integer amount) {
        if (amount <= 50) return "few";
        if (amount <= 150) return "normal";
        if (amount <= 500) return "lot";
        return "huge";
    }
}
