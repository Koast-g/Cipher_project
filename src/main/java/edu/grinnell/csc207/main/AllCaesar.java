package edu.grinnell.csc207.main;
import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;
/**
 * AllCaesar class.
 */
public class AllCaesar {
  /**
   * max size od an array os strings.
   */
  public static final int MAX_SIZE = 2;
  /**
   * checks if the charackter in a string is lowercase.
   * @param str string
   * @return true if string contains only lowercase characters
   */
  public static boolean isLower(String str) {
    for (char ch : str.toCharArray()) {
      if (!Character.isLowerCase(ch)) {
        return false;
      } // if any character of the string is not lowercase
    } // looping through string(an array of character)
    return true;
  } // isLower(String str)

  /**
   * main method.
   * @param args an array of strings
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != MAX_SIZE) {
      System.err.println("Error: Incorrect number of parameters");
      return;
    } // if there is less than two arguments we return an error

    String arg0 = args[0];
    String arg1 = args[1];

    // if argument one is not encode or decode we return an error
    if (!arg0.equals("encode") && !arg0.equals("decode")) {
      System.err.println("Error: Invalid option: " + arg0 + ". Options: \"encode\" or \"decode\"");
      return;
    } // if argument one is not encode or decode we return an error

    if (!isLower(arg1)) {
      System.err.println("Error: String contains characters other than lowercase letters.");
      return;
    } // if message is not lowercase return an error;

    // if arugument one is encode
    if (arg0.equals("encode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(arg1, ch));
      } // encrypting the message using alphabet
    } else {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(arg1, ch));
      } // decrypting the massage using alphabet
    } // if argument one is decode
    pen.close();
  } //main(String[] args)
} //AllCaesar
