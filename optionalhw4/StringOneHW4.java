package org.hillel.optionalhw4;

public class StringOneHW4 {

    /*Task1
    Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
     helloName("Bob") → "Hello Bob!"
    helloName("Alice") → "Hello Alice!"
    */

    public String helloName(String name) {
        return "Hello " + name + '!';
    }

    /*
    * Task2
    * Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting at index i and going up to but not including index j.
       makeOutWord("<<>>", "Yay") → "<<Yay>>"
    makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
    */
    public String makeOutWord(String out, String word) {
        return out.substring(0, 2) + word + out.substring(2);
    }

    /*
    Task3
    Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
    firstHalf("HelloThere") → "Hello"
    firstHalf("abcdef") → "abc"
    */

    public String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }

    /*
    Task4
    Given 2 strings, return their concatenation, except omit the first char of each. The strings will be at least length 1.
    nonStart("shotl", "java") → "hotlava"
    */

    public String nonStart(String a, String b) {
        return a.substring(1, a.length()) + b.substring(1, +b.length());
    }

    /*
    Task5
    Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end. The string length will be at least 2.
    left2("Hello") → "lloHe"
    left2("java") → "vaja"
    */

    public String left2(String str) {
        return str.substring(2) + str.substring(0, 2);
    }

    /*
    Task6
    Given a string, return a "rotated right 2" version where the last 2 chars are moved to the start. The string length will be at least 2.
    right2("Hello") → "loHel"
    right2("java") → "vaja"
    */

    public String right2(String str) {
        return str.substring(str.length() - 2) + str.substring(0, str.length() - 2);
    }

    /*
    Task7
    Given a string, return a string length 1 from its front, unless front is false, in which case return a string length 1 from its back. The string will be non-empty.
    theEnd("Hello", true) → "H"
    theEnd("Hello", false) → "o"
    */

    public String theEnd(String str, boolean front) {
        if(front) {
            return str.substring(0, 1);
        } else return str.substring(str.length() - 1);
    }

    /*Task8
    Given a string, return a version without both the first and last char of the string. The string may be any length, including 0.
    withouEnd2("Hello") → "ell"
    withouEnd2("abc") → "b"
    */

    /*Variant 8-1*/
    public String withouEnd2v1(String str) throws Exception{
         try{
             return str.substring(1, str.length()-1);
         } catch (StringIndexOutOfBoundsException e){
             return "";
         }
    }
    /*Variant 8-2*/
    public String withouEnd2v2(String str){
        if(str.length() <= 2)
            return "";

        return str.substring(1, str.length() - 1);
    }

    /*Task9
    Given a string of even length, return a string made of the middle two chars, so the string "string" yields "ri". The string length will be at least 2.
    middleTwo("string") → "ri"
    middleTwo("code") → "od"
    */

    public String middleTwo(String str) {
        return str.substring(str.length() / 2 - 1, str.length() / 2 + 1);
    }

    /*
    Task10
    Given a string, return true if it ends in "ly".
    endsLy("oddly") → true
    endsLy("y") → false
    */
    public boolean endsLy(String str) {
        if(str.length() < 2){
            return false;
        } else return str.substring(str.length() - 2).equals("ly");
    }

}
