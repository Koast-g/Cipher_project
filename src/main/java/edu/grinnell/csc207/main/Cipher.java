package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;
/**
 * Cipher class.
 */
public class Cipher {
  /**
   * max size of an array.
   */
  public static final int MAX_SIZE = 4;
  /**
   * method to compare the arguments to a string(option).
   * @param str an array of strings
   * @param option string
   * @return true if one string in the array is equal to option string
   */
  public static boolean containsOption(String[] str, String option) {
    for (String arg : str) {
      if (arg.equals(option)) {
        return true;
      } // if argument equals to option
    } // looping around the array of arguments
    return false;
  } // containsOption(String[] str, String optioon)

 /**
  * checks if the argument is encode.
  * @param str an array of string (command argument line)
  * @return true if one of the arguments equals -encode
  */
  public static boolean isEncode(String[] str) {
    return containsOption(str, "-encode");
  } // isEncode(String[] str)

  /**
   * checks if the argument is decode.
   * @param str an array of string (command argument line)
   * @return true if one of the arguments equals -decode
   */
  public static boolean isDecode(String[] str) {
    return containsOption(str, "-decode");
  } // isDecode(String[] str)

  /**
   * checks if the argument is caeser.
   * @param str an array of string (command argument line)
   * @return true if one of the arguments equals -caesar
   */
  public static boolean isCaeser(String[] str) {
    return containsOption(str, "-caesar");
  } // isCaesar(String[] str)

  /**
   * checks if the argument is vifenere.
   * @param str an array of string (command argument line)
   * @return true if one of the arguments equals -vigenere
   */
  public static boolean isVigenere(String[] str) {
    return containsOption(str, "-vigenere");
  } // isVigenere(String[] str)

  /**
   * finding the key argument in the array of strings.
   * @param str an array of string (command argument line)
   * @return second string without a flag from the command line
   */
  public static String findKey(String[] str) {
    int num = 0;
    for (String arg : str) {
      if (arg.charAt(0) != '-') {
        if (num == 1) {
          return arg;
        } // if it is second string without a flag than we return a string(key)
        num++;
      } // is first letter a flag
    } // looping around the array of arguments
    return "";
  } // findKey(String[] str)

  /**
   * looking for message in the array of arguments.
   * @param str an array of string (command argument line)
   * @return first string without a flag from the command line
   */
  public static String getMessage(String[] str) {
    for (String arg : str) {
      if (arg.charAt(0) != '-') {
        return arg;
      } // first string that doesnt have flag is a message
    } // looping around the array of arguments
    return "";
  } // getMessage(String[] str)

  /**
   * checking if arguments are lower case.
   * @param str an array of string (command argument line)
   * @return true if all of the arguments(strings) are lowercase/flagged
   */
  public static boolean isArgumentLineLowercase(String[] str) {
    for (String arg : str) {
      if (!AllCaesar.isLower(arg) && arg.charAt(0) != '-') {
        return true;
      } // if the string contains anything else but lowercase and flag return true
    } // looping around the array of arguments
    return false;
  } // isArgumentLineLowercase(String[] str)

  /**
   * checking if any argument contains.
   * @param str an array of string (command argument line)
   * @return true if any argument is null or empty string
   */
  public static boolean isEmptyOrNull(String[] str) {
    for (String arg : str) {
      if (arg == null || arg.isEmpty()) {
        return true;
      } // is argument null or empty
    } // looping around the array of arguments
    return false;
  } // isEmptyOrNull(String[] str)

  /**
   * main method.
   * @param args an array of strings
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != MAX_SIZE) {
      System.err.println("Error: Incorrect number of parameters");
      return;
    } // if there is less/more than 4 arguments we return an error

    if (isEmptyOrNull(args)) {
      System.err.println("Error: Invalid srting or empty string");
      return;
    } // return an error if any arg is empty of null

    if (isArgumentLineLowercase(args)) {
      System.err.println("Error: String contains characters other than lowercase letters");
      return;
    } // return an error if any argument contains anything but lowercase and flag
    String key = findKey(args);
    String message = getMessage(args);
    // return an error if it's caeser and the key length is more than one charachter
    if (isCaeser(args) && key.length() > 1) {
      System.err.println("Error: Using a Caesar cipher with a multi-character key");
    } else if (isCaeser(args) && isEncode(args)) {
      pen.printf("%s\n", CipherUtils.caesarEncrypt(message, key.charAt(0)));
    } else if (isCaeser(args) && isDecode(args)) {
      pen.printf("%s\n", CipherUtils.caesarDecrypt(message, key.charAt(0)));
    } else if (isVigenere(args) && isEncode(args)) {
      pen.printf("%s\n", CipherUtils.vigenereEncrypt(message, key));
    } else {
      pen.printf("%s\n", CipherUtils.vigenereDecrypt(message, key));
    } //end of if statement
    pen.close();
  } //main(String[] str)
} //Cipher
