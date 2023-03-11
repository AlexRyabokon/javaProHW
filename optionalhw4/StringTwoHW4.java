package org.hillel.optionalhw4;

import java.util.ArrayList;

public class StringTwoHW4 {
    /* Task1
    Given a string, return a string where for every char in the original, there are two chars.
    doubleChar("The") → "TThhee"
    doubleChar("AAbb") → "AAAAbbbb"
    */

    public String doubleChar(String str) {
        char[] arr = new char[2 * str.length()];
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            arr[count] = str.charAt(i);
            count++;
            arr[count] = str.charAt(i);
            count++;
        }

        return new String(arr);
    }

    /*
    Task2
    Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
    countCode("aaacodebbb") → 1
    countCode("codexxcode") → 2
    */

    public int countCode(String str) {
        int count = 0;

        for (int i = 0; i < str.length() - 3; i++) {
            if (str.substring(i, i + 2).equals("co") && str.charAt(i + 3) == 'e')
                count++;
        }

        return count;
    }

    /*
    Task3
    Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
    bobThere("abcbob") → true
    bobThere("b9b") → true
    */

    public boolean bobThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b')
                return true;
        }

        return false;
    }

    /*
    Task4
    Given a string and an int n, return a string made of n repetitions of the last n characters of the string. You may assume that n is between 0 and the length of the string, inclusive.
    repeatEnd("Hello", 3) → "llollollo"
    repeatEnd("Hello", 2) → "lolo"
    */

    public String repeatEnd(String str, int n) {
        StringBuffer result = new StringBuffer();
        String end = str.substring(str.length() - n);

        for (int i = 0; i < n; i++) {
            result.append(end);
        }
        return result.toString();
    }

    /*
    Task5
    Return the number of times that the string "hi" appears anywhere in the given string.
    countHi("abc hi ho") → 1
    countHi("ABChi hi") → 2
    * */

    public int countHi(String str) {
        int result = 0;

        for (int i = 0; i < str.length()-1; i++) {
            if (str.substring(i, i + 2).equals("hi")) {
                result++;
            }
        }

        return result;
    }
}