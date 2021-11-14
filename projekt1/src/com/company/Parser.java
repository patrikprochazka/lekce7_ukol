package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Parser {

    public static void parseCsvIntoList(File inputFile,
                                        ArrayList<StateWithVATRate> statesList,
                                        ArrayList<StateWithVATRate> statesBelowOrEqualTresholdList,
                                        ArrayList<StateWithVATRate> statesAboveTresholdList,
                                        int taxTreshold) {
        try (Scanner sc = new Scanner(inputFile)) {
            int lineCounter = 0;

            while ((sc.hasNextLine())) {
                lineCounter = lineCounter + 1;
                String line = sc.nextLine();
                String[] columns = line.split(Settings.LINE_DELIMITER);
                StateWithVATRate parsedLine = new StateWithVATRate();

                try {
                    parsedLine = LineValidator.validate(columns);
                } catch (ValidatorException ex) {
                    System.err.println(ex);
                }


                statesList.add(parsedLine);
                if (parsedLine.getFullTaxRate() <= taxTreshold){
                    statesBelowOrEqualTresholdList.add(parsedLine);
                } else {
                    statesAboveTresholdList.add(parsedLine);
                }



            }

        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }

    }
}

