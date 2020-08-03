package com.nhs.launcher;

import java.util.ArrayList;
import java.util.List;

import com.nhs.findnumbers.DoubleDigit;
import com.nhs.findnumbers.DoubleDigitMultiplication;
import com.nhs.findnumbers.UniqueNumberAddition;

/**
 * @author srahman
 *
 *         UniqueNumberFinderSolutionOne class finds the possible values for variables of the
 *         following mathematical expression. Double digit |a|b| Multiply by a single digit |*|c| =
 *         |d|e| Add another double digit |f|g| = |m|n|. In the above figure a, b, c, d, e, f, g, m,
 *         and n, are single digit numbers. These numbers are to be chosen such that they are all
 *         unique (no repetitions) and they satisfy the above expression.
 */
public class UniqueNumberFinderSolutionOne {

  private final List<DoubleDigit> allUniqueDoubleDigits;
  private final List<DoubleDigitMultiplication> allUniqueDoubleDigitMultiplications;
  private final List<UniqueNumberAddition> allUniqueNumberCalculations;

  /**
   * Constructor that created the Unique combination of Multiplications, Additions and Results.
   */
  public UniqueNumberFinderSolutionOne() {
    allUniqueDoubleDigits = createUniqueDoubleDigits();
    allUniqueDoubleDigitMultiplications = createUniqueDoubleDigitMultiplications();
    allUniqueNumberCalculations = createUniqueNumberCalculations();
  }

  /**
   * Creates a list of unique double digit numbers that has no repetitions.
   * 
   * @return ArrayList of type DobleDigit.
   */
  private List<DoubleDigit> createUniqueDoubleDigits() {
    List<DoubleDigit> createdDoubleDigits = new ArrayList<DoubleDigit>();
    for (int i = 0; i < 10; i++) {
      for (int x = 0; x < 10; x++) {
        DoubleDigit dd = new DoubleDigit(i, x);
        /*
         * Replace below if condition with if(dd.isValidAndUnique() && dd.asNumber() > 9) { for only
         * possibilities with starting above 10.
         */
        if (dd.isValidAndUnique()) {
          createdDoubleDigits.add(dd);
        }
      }
    }

    return createdDoubleDigits;

  }

  /**
   * Creates the list of unique double digits results multiplying form 1 -9.
   * 
   * @return ArrayList of type DobleDigit.
   */
  private List<DoubleDigitMultiplication> createUniqueDoubleDigitMultiplications() {
    List<DoubleDigitMultiplication> createdDoubleDigitMultiplications = new ArrayList<DoubleDigitMultiplication>();
    for (DoubleDigit dd : allUniqueDoubleDigits) {
      // iterate numbers 1-9 (zero is not needed as multiplications by zero are always zero which is
      // not unique)
      for (int x = 1; x < 10; x++) {
        DoubleDigitMultiplication ddm = new DoubleDigitMultiplication(dd, x);
        if (ddm.isUnique()) {
          createdDoubleDigitMultiplications.add(ddm);
        }
      }
    }

    return createdDoubleDigitMultiplications;
  }

  /**
   * Creates a list of Unique double digits for Addition and results.
   * 
   * @return
   */
  private List<UniqueNumberAddition> createUniqueNumberCalculations() {
    List<UniqueNumberAddition> createdUniqueNumberCalculations = new ArrayList<UniqueNumberAddition>();
    for (DoubleDigit dd : allUniqueDoubleDigits) {
      for (DoubleDigitMultiplication ddm : allUniqueDoubleDigitMultiplications) {
        UniqueNumberAddition unc = new UniqueNumberAddition(ddm, dd);
        if (unc.isUnique()) {
          createdUniqueNumberCalculations.add(unc);
        }
      }
    }
    return createdUniqueNumberCalculations;
  }

  /**
   * Prints the final result.
   */
  public void printResult() {
    int i = 1;
    for (UniqueNumberAddition uniqueNumberAdditon : allUniqueNumberCalculations) {
      System.out.println("No. " + i++ + " - variables Set");
      System.out.println("=======================");
      uniqueNumberAdditon.printVariableNameAndValues();
    }
  }

  public static void main(String[] args) {
    UniqueNumberFinderSolutionOne uniqNumVarFinder = new UniqueNumberFinderSolutionOne();
    uniqNumVarFinder.printResult();
  }

}
