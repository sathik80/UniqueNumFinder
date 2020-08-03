package com.nhs.findnumbers;

/**
 * @author srahman
 *
 *         Double is the object of a 2 digit number structure used across the classes. DoubleDigit
 *         is for the First step to be multiplied double digit, Multiplied double digit and the
 *         Double Digit Addition and final result.
 */
public class DoubleDigit {

  private final int _digit1;
  private final int _digit2;
  private boolean _isValidAndUnique;

  /**
   * Constructor
   * 
   * @param digit1
   * @param digit2
   */
  public DoubleDigit(final int digit1, final int digit2) {
    _digit1 = digit1;
    _digit2 = digit2;
    _isValidAndUnique = digit1 != digit2;
  }

  /**
   * Double digit to check the validity and uniqueness. Should be less than 100 and greater than
   * zero. Not the same number in 2 digits. For a number less than 10, prefixed with zero
   * 
   * @param doubleDigit
   */
  DoubleDigit(final int doubleDigit) {
    _isValidAndUnique = doubleDigit < 100 && doubleDigit > 9;
    if (!_isValidAndUnique) {
      _digit1 = 0;
      _digit2 = 0;
      return;
    }
    if (doubleDigit < 10) {
      _digit1 = 0;
      _digit2 = doubleDigit;
    } else {
      _digit1 = doubleDigit / 10;
      _digit2 = doubleDigit % 10;
    }
    _isValidAndUnique = _digit1 == _digit2 ? false : _isValidAndUnique;
  }

  /**
   * Returns first digit of the double digit number.
   * 
   * @return int
   */
  int getDigit2() {
    return _digit2;
  }

  /**
   * Returns second digit of the double digit number.
   * 
   * @return int
   */
  int getDigit1() {
    return _digit1;
  }

  /**
   * Returns if the double digit is unique and valid.
   * 
   * @return
   */
  public boolean isValidAndUnique() {
    return _isValidAndUnique;
  }

  /**
   * Checks if the given 2 digits are not in the first double digit number to be Multiplied
   * 
   * @param digit1
   * @param digit2
   * @return
   */
  boolean containsDigits(final int digit1, final int digit2) {
    return (containsDigit(digit1) || containsDigit(digit2));
  }

  /**
   * Checks if the given digit is part of the Double digit.
   * 
   * @param digit
   * @return true if it contains false otherwise.
   */
  boolean containsDigit(final int digit) {
    return (digit == _digit1 || digit == _digit2);
  }

  /**
   * Return double digit as an int value for calculations.
   * 
   * @return
   */
  int asNumber() {
    return _digit1 == 0 ? _digit2 : ((_digit1 * 10) + _digit2);
  }

  /**
   * Prints the Double Digit number to be in calculation format.
   */
  void print() {
    System.out.print("|" + getDigit1() + "|" + getDigit2() + "|");
  }

}
