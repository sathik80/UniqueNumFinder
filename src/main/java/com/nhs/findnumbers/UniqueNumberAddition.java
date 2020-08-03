package com.nhs.findnumbers;

/**
 * @author srahman
 * 
 *         This class carries out the second step of the calcualtion. Checks and adds the possible
 *         unique double digit to the first step multiplication results.
 */
public class UniqueNumberAddition {

  private final DoubleDigitMultiplication ddm;
  private final DoubleDigit ddToAdd;
  private final boolean isUnique;
  private final DoubleDigit result;

  /**
   * Check for uniqueness of the digits and returns the possible value to be added to the list.
   * 
   * @param ddm
   * @param ddToAdd
   */
  public UniqueNumberAddition(DoubleDigitMultiplication ddm, DoubleDigit ddToAdd) {
    this.ddm = ddm;
    this.ddToAdd = ddToAdd;
    result = new DoubleDigit(ddm.getResult().asNumber() + ddToAdd.asNumber());
    if (!result.isValidAndUnique()) {
      isUnique = false;
      return;
    }
    if (result.containsDigits(ddToAdd.getDigit1(), ddToAdd.getDigit2())) {
      isUnique = false;
      return;
    }
    if (result.containsDigits(ddm.getResult().getDigit1(), ddm.getResult().getDigit2())) {
      isUnique = false;
      return;
    }
    if (result.containsDigits(ddm.getDoubleDigitToMultiply().getDigit1(), ddm.getDoubleDigitToMultiply().getDigit2())) {
      isUnique = false;
      return;
    }
    if (ddToAdd.containsDigits(ddm.getResult().getDigit1(), ddm.getResult().getDigit2())) {
      isUnique = false;
      return;
    }
    if (ddToAdd.containsDigits(ddm.getDoubleDigitToMultiply().getDigit1(), ddm.getDoubleDigitToMultiply().getDigit2())) {
      isUnique = false;
      return;
    }
    isUnique = !(result.containsDigit(ddm.getSingleDigitToMultiply())) && !(ddToAdd.containsDigit(ddm.getSingleDigitToMultiply()));
  }

  /**
   * Set in calculation
   * 
   * @return boolean
   * 
   */
  public boolean isUnique() {
    return isUnique;
  }

  /**
   * print Variable Names And Values And the Calculation format.
   */
  public void printVariableNameAndValues() {
    // Print Variable names and values
    System.out.println("Variable a  : " + ddm.getDoubleDigitToMultiply().getDigit1());
    System.out.println("Variable b  : " + ddm.getDoubleDigitToMultiply().getDigit2());

    System.out.println("Variable c  : " + ddm.getSingleDigitToMultiply());

    System.out.println("Variable d  : " + ddm.getResult().getDigit1());
    System.out.println("Variable e  : " + ddm.getResult().getDigit2());

    System.out.println("Variable f  : " + ddToAdd.getDigit1());
    System.out.println("Variable g  : " + ddToAdd.getDigit2());

    System.out.println("Variable m  : " + result.getDigit1());
    System.out.println("Variable n  : " + result.getDigit2());

    // Print Calculation
    ddm.print();
    ddToAdd.print();
    System.out.println("+"); //$NON-NLS-1$
    System.out.println("-----"); //$NON-NLS-1$
    System.out.println("|" + result.getDigit1() + "|" + result.getDigit2() + "|"); //$NON-NLS-1$
    System.out.println("-----"); //$NON-NLS-1$

  }

}
