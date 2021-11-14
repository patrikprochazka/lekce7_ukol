package com.company;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        File inputFile = new File(Settings.INPUT_FILENAME);
        ArrayList<StateWithVATRate> statesList = new ArrayList<>();
        ArrayList<StateWithVATRate> statesBelowOrEqualTresholdList = new ArrayList<>();
        ArrayList<StateWithVATRate> statesAboveTresholdList = new ArrayList<>();

        Parser.parseCsvIntoList(inputFile, statesList, statesBelowOrEqualTresholdList, statesAboveTresholdList, Settings.DEFAULT_TAX_TRESHOLD);

        StatePrinter.printWithFullTaxRate(statesList);

        StatePrinter.printWithBothTaxRates(statesAboveTresholdList);

        System.out.print("Sazba VAT " + Settings.DEFAULT_TAX_TRESHOLD + " % nebo nižší nebo používají speciální sazbu: ");
        StatePrinter.printStateCodes(statesBelowOrEqualTresholdList);

        StateWriter.writeOutputToFile();

    }
}
