package edu.grinnell.csc207.util;

/**
 * AllCipherUtils class.
 */
public class CipherUtils {
  /**
   * The length of the alphabet.
   */
  private static final int ALPHABETLENGTH = 26;
  /**
   * Converts a leter into in integer.
   * @param letter character in ASCII
   * @return it return an integer for coresponding letter between [0, 25]
   */
  private static int letter2int(char letter) {
    int base = (int) 'a'; // setting character "a" as a base
    int code = (int) (letter - base); // letter integer code
    return code;
  } // letter2int(char letter)

  /**
   * converts letter to an integer.
   * @param i an integer for coresponding letter
   * @return character for coresponding integer (addig base to an integer)
   */
  private static char int2letter(int i) {
    int base = (int) 'a'; // setting character "a" as a base
    char code = (char) (i + base); // integer code to letter
    return code;
  } // int2letter(int i)

  /**
   * encrypt the letter into a string.
   * @param str    string representing a message
   * @param letter character in ASCII (encoding into a string)
   * @return return new encoded string
   */
  public static String caesarEncrypt(String str, char letter) {
    StringBuilder encode = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      int code = letter2int(str.charAt(i));
      int key = letter2int(letter);
      encode.append(int2letter((code + key) % ALPHABETLENGTH)); // encode the message
    } // looping through string (array of strings)
    String newStr = encode.toString(); // convert the object to a string
    return newStr;
  } // caesarEncrypt(String str, char letter)

  /**
   * decode the string based on the key letter.
   * @param str string representing a message
   * @param letter character in ASCII (decoding from a string)
   * @return returns a new decoded string
   */
  public static String caesarDecrypt(String str, char letter) {
    StringBuilder decode = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      int code = letter2int(str.charAt(i));
      int key = letter2int(letter);
      // if subtraction of the charachter code and the srtring goes below 0 than weadd 26
      if (code - key < 0) {
        decode.append(int2letter(code - key + ALPHABETLENGTH));
      } else {
        decode.append(int2letter(code - key));
      } // decode the message
    } // going through each charachter of the string
    String newStr = decode.toString(); // object to string
    return newStr;
  } // caesarDecrypt(String str, char letter)

  /**
   * encrupt a string into a string.
   * @param str string representing a message
   * @param key string used to encode into a message
   * @return return a new encode string
   */
  public static String vigenereEncrypt(String str, String key) {
    StringBuilder encode = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      int code = letter2int(str.charAt(i));
      // converting letters of the ciphertext into int(loop around if key is smaller than str)
      int seceretLetter = letter2int(key.charAt(i % key.length()));
      encode.append(int2letter((code + seceretLetter) % ALPHABETLENGTH)); // encode the message
    } // going through each charachter of the string
    String newStr = encode.toString(); // object to strig
    return newStr;
  } // vigenereEncrypt(String str, String str)

  /**
   * decrypt a string based on the secrete string.
   * @param str string representing a message
   * @param key string is used to decode a massage
   * @return a new decoded string
   */
  public static String vigenereDecrypt(String str, String key) {
    StringBuilder decode = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      int code = letter2int(str.charAt(i));
      // converting letters of the ciphertext into int(loop around if key is smaller than str)
      int secreteLetter = letter2int(key.charAt(i % key.length()));
      // looping around(+26) if we go below 0 and decoding the message
      if (code - secreteLetter < 0) {
        decode.append(int2letter(code - secreteLetter + ALPHABETLENGTH));
      } else {
        decode.append(int2letter(code - secreteLetter));
      } // decoding the massage
    } // going through each charachter of the string
    String newStr = decode.toString(); // object to string
    return newStr;
  } // vigenereDecrypt(String str, String str)

} //CipherUtils
