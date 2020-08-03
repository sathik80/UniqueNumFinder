package com.nhs.launcher;

import java.util.HashSet;
import java.util.Set;

/**
 * Class solving the Unique set of Numbers satisfying the | a | b | * | c | = | d | e | + | f | g |
 * = | m | n | using hashset to prevent duplicates. This way is easier to compare string values than
 * arrays content.
 */
public class UniqueNumberFinderSolutionTwo {

  // | a | b | * | c | = | d | e | + | f | g | = | m | n |
  // using hashset to prevent duplicates. This way is easier to compare string values than arrays
  // content.
  private final Set<String> uniques = new HashSet<>();

  /**
   * Starting method of the class. Initializes the class and runs the method that does the checks
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    UniqueNumberFinderSolutionTwo t2 = new UniqueNumberFinderSolutionTwo();
    t2.process();
  }

  /**
   * defines the possible digits to use, calls the permutation method and send the results to
   * printing
   */
  private void process() {
    // all 10 digits
    String s = "0123456789";
    // Generate permutations
    permutation(s, "");
    // Print each generated permutation if valid
    // uniques.forEach(element -> System.out.println(element));
    uniques.forEach(this::checkForSolution);
  }

  /**
   * Recursive function to generate permutations of the string
   * 
   * @param str remaining part of the initial string
   * @param ans used part of the initial string
   */
  void permutation(String str, String ans) {
    // solution contains 9 digits out of 10 possible, so the remaining part has to be 1
    if (str.length() == 1) {
      // Try to add the generated permutation to the set in order to avoid duplicates
      uniques.add(ans);
      return;
    }
    for (int i = 0; i < str.length(); i++) {
      // ith character of str
      char ch = str.charAt(i);
      // Rest of the string after excluding the ith character
      String ros = str.substring(0, i) + str.substring(i + 1);
      // Recursive call
      permutation(ros, ans + ch);
    }
  }

  /**
   * splits the string to array of digits. String simplifies over integer parameter as those
   * starting with the zero are treated the same way.
   * 
   * @param num string to be converted
   */
  void checkForSolution(String num) {
    // map each character to the int and store them all to the array
    int[] digits = num.chars().map(c -> c - '0').toArray();

    // load each 'letter' in order
    int a = digits[0];
    int b = digits[1];
    int c = digits[2];
    int d = digits[3];
    int e = digits[4];
    int f = digits[5];
    int g = digits[6];
    int m = digits[7];
    int n = digits[8];
    // ab * c = de + fg = mn
    // if the calculation is correct, print the solution
    if ((a * 10 + b) * c == (d * 10 + e) && (d * 10 + e) + (f * 10 + g) == (m * 10 + n)) {
      System.out.println("a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e + ", f=" + f + ", g=" + g + ", m=" + m + ", n=" + n);
    }
  }

  /**
   * Returns unique string sets
   * 
   * @return Set<String>
   */
public Set<String> getUniques() {
	return uniques;
}
}
