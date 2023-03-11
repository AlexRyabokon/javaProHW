package org.hillel.optionalhw4;

public class StringThreeHW4 {
    /*Task1
    Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
    but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not
    an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
    countYZ("fez day") → 2
    countYZ("day fez") → 2
    countYZ("day fyyyz") → 2*/

    public int countYZ(String str) {
        int num = 0;
        str = str.toLowerCase();

        if(str.endsWith("y") || str.endsWith("z")){
            num++;
        }

        for(int i = 0; i < str.length() - 1; i++){
            if( (str.charAt(i) == 'y' || str.charAt(i) == 'z') &&
                    !(Character.isLetter(str.charAt(i+1))) ){
                num++;
            }
        }
        return num;
    }

    /*Task2
    * Given two strings, base and remove, return a version of the base string where all instances of the remove string
    *  have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only
    *  non-overlapping instances, so with "xxx" removing "xx" leaves "x".
    withoutString("Hello there", "llo") → "He there"
    withoutString("Hello there", "e") → "Hllo thr"
    withoutString("Hello there", "x") → "Hello there"*/

    public String withoutString(String base, String remove) {

        for (int i = 0; i < base.length(); i++) {

        }
        return null;
    }

}
