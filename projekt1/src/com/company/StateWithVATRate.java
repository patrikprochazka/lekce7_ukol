package com.company;

public class StateWithVATRate {

    private String stateCode;
    private String stateName;
    private float fullTaxRate;
    private float reducedTaxRate;
    private boolean hasSpecialTaxRate;

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public float getFullTaxRate() {
        return fullTaxRate;
    }

    public void setFullTaxRate(float fullTaxRate) {
        this.fullTaxRate = fullTaxRate;
    }

    public float getReducedTaxRate() {
        return reducedTaxRate;
    }

    public void setReducedTaxRate(float reducedTaxRate) {
        this.reducedTaxRate = reducedTaxRate;
    }

    public boolean isHasSpecialTaxRate() {
        return hasSpecialTaxRate;
    }

    public void setHasSpecialTaxRate(boolean hasSpecialTaxRate) {
        this.hasSpecialTaxRate = hasSpecialTaxRate;
    }
}
