package com.company;


public class LineValidator {
    public static StateWithVATRate validate(String[] columns) throws ValidatorException {
        StateWithVATRate validatedLine = new StateWithVATRate();

        if (columns.length != 5) {
            throw new ValidatorException("Unexpected number of columns - found: " + columns.length + "expected: 5");
        }

        validatedLine.setStateCode(columns[0]);
        validatedLine.setStateName(columns[1]);


        String fullTaxRateFixed = columns[2].replace(',', Settings.DECIMAL_SEPARATOR);
        float fullTaxRate = Float.parseFloat(fullTaxRateFixed);
        if ((fullTaxRate < 100) && (fullTaxRate > 0)) {
            validatedLine.setFullTaxRate(fullTaxRate);
        } else {
            System.err.println("Unexpected full tax rate of state " + columns[1] + ": " + fullTaxRate + " (expecting a value between 0 and 100)");
        }

        String reducedTaxRateFixed = columns[3].replace(',',Settings.DECIMAL_SEPARATOR);
        float reducedTaxRate = Float.parseFloat(reducedTaxRateFixed);
        if ((reducedTaxRate < 100) && (reducedTaxRate > 0)) {
            validatedLine.setReducedTaxRate(reducedTaxRate);
        } else {
            System.err.println("Unexpected reduced tax rate of state " + columns[1] + ": " + reducedTaxRate + " (expecting a value between 0 and 100)");
        }

        if (columns[4].equals("true")) {
            validatedLine.setHasSpecialTaxRate(true);
        } else if (columns[4].equals("false")) {
            validatedLine.setHasSpecialTaxRate(false);
        } else {
            System.err.println("Unexpected value of special tax rate of state " + columns[1] + ": " + columns[4] + " (expecting true or false)");
        }

        // System.out.println(columns[0] + " (" + columns[1] + "): " + columns[2] + " %");

        return validatedLine;
    }
}
