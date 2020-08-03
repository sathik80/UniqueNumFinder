package com.nhs.findnumbers;

/**
 * @author srahman
 * 
 *         This class carries out the first step of the calculation. Checks and multiplies the
 *         possible unique double digit with single digit to be added in the list for next step.
 */
public class DoubleDigitMultiplication {

  private final DoubleDigit _dd;
  private final int _singleDigitToMultiply;
  private final boolean _isUnique;
  private final DoubleDigit _ddResult;

  /**
   * Unique non-repetitive results of Multiplication. Checked against Unique double digit numbers
   * used for multiplication.
   * 
   * @param dd
   * @param singleDigitToMultiply
   */
  public DoubleDigitMultiplication(final DoubleDigit dd, final int singleDigitToMultiply) {
    _dd = dd;
    _singleDigitToMultiply = singleDigitToMultiply;
    _ddResult = new DoubleDigit(dd.asNumber() * singleDigitToMultiply);
    _isUnique = _ddResult.isValidAndUnique() && !(dd.containsDigits(_ddResult.getDigit1(), _ddResult.getDigit2()))
      && !(_ddResult.containsDigit(_singleDigitToMultiply)) && !dd.containsDigit(_singleDigitToMultiply);
  }

  /**
   * Unique is set in the calculation.
   * 
   * @return boolean
   */
  public boolean isUnique() {
    return _isUnique;
  }

  /**
   * Retuens double digit result of Multiplication
   * 
   * @return
   */
  DoubleDigit getResult() {
    return _ddResult;
  }

  /**
   * Returns the Double Digit number to multiply.
   * 
   * @return
   */
  DoubleDigit getDoubleDigitToMultiply() {
    return _dd;
  }

  /**
   * Single Digit multiplier
   * 
   * @return
   */
  int getSingleDigitToMultiply() {
    return _singleDigitToMultiply;
  }

  /**
   * Prints the step for final presentation.
   */
  void print() {
    System.out.println("Calculation Format");
    System.out.println("=======================");
    _dd.print();
    System.out.println("\n " + "*" + "|" + _singleDigitToMultiply + "|"); //$NON-NLS-1$ //$NON-NLS-2$
    System.out.println("---"); //$NON-NLS-1$
    _ddResult.print();
    System.out.print("\n"); //$NON-NLS-1$
  }

}