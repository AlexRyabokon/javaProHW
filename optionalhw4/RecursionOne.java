package org.hillel.optionalhw4;

public class RecursionOne {

    /*Task1
    Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).
    factorial(1) → 1
    factorial(2) → 2
    factorial(3) → 6
    * */

    public int factorial(int n) {
        try {
            if (n == 1) return 1;
            return n * factorial(n - 1);
        } catch (StackOverflowError err) {
            System.out.println("Please, don`t input negative num");
            return 0;
        }

    }

    /*Task2
    We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears.
    The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively
    return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).

    bunnyEars2(0) → 0
    bunnyEars2(1) → 2
    bunnyEars2(2) → 5
    * */

    public int bunnyEars2(int bunnies) {
        try {
            return bunnies == 0 ? 0 :
                    bunnies % 2 == 1 ? 2 + bunnyEars2(bunnies - 1) :
                            3 + bunnyEars2(bunnies - 1);
        } catch (StackOverflowError err) {
            System.out.println("Please, don`t input negative num");
            return 0;
        }
    }


    /*Task3
    Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
    countHi("xxhixx") → 1
    countHi("xhixhix") → 2
    * */
    public int countHi(String str) {
        return str.length() <= 1 ? 0 :
                str.charAt(0) == 'h' && str.charAt(1) == 'i' ? 1 + countHi(str.substring(2)) :
                        countHi(str.substring(1));
    }


    /*Task4
    We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has
    3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in
    such a triangle with the given number of rows.
    triangle(0) → 0
    triangle(1) → 1
    * */
    public int triangle(int rows) {
        try {
            return rows == 0 ? 0 : rows + triangle(rows - 1);
        } catch (StackOverflowError err) {
            System.out.println("Please, don`t input negative num");
            return 0;
        }
    }

    /*Task5
   Given a string, compute recursively (no loops) the number of "11" substrings in the string.
   The "11" substrings should not overlap.
   count11("11abc11") → 2
   count11("abc11x11x11") → 3
   * */
    public int count11(String str) {
        return str.length() <= 1 ? 0 :
                str.substring(0, 2).equals("11") ? 1 + count11(str.substring(2)) :
                        count11(str.substring(1));
    }


    /*Task6
    Given a string, compute recursively a new string where all the 'x' chars have been removed.
    noX("xaxb") → "ab"
    noX("abc") → "abc"
   * */
    public String noX(String str) {
        return str.length() == 0 ? str :
                str.charAt(0) == 'x' ? noX(str.substring(1)) :
                        str.charAt(0) + noX(str.substring(1));
    }


    /*Task7
    Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8
    as a digit, except that an 8 with another 8 immediately to its left counts double, so 8818
    yields 4. Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/)
    by 10 removes the rightmost digit (126 / 10 is 12).
    count8(8) → 1
    count8(818) → 2
    */
    public int count8(int n) {
        if (n == 0)
            return 0;

        if (n % 10 == 8) {
            if ((n / 10) % 10 == 8)
                return 2 + count8(n / 10);

            return 1 + count8(n / 10);
        }

        return count8(n / 10);
    }

    /*Task8
    Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".
    changePi("xpix") → "x3.14x"
    changePi("pipi") → "3.143.14"
    */

    public String changePi(String str) {
        return str.length() <= 1 ? str :
                str.substring(0, 2).equals("pi") ? "3.14" + changePi(str.substring(2)) :
                        str.charAt(0) + changePi(str.substring(1));
    }

    /*Task9
   Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.
   endX("xxre") → "rexx"
   endX("xxhixx") → "hixxxx"
   endX("xhixhix") → "hihixxx"
   */
    public String endX(String str) {
        return str.length() <= 1 ? str :
                str.charAt(0) == 'x' ? endX(str.substring(1)) + 'x' :
                        str.charAt(0) + endX(str.substring(1));
    }

     /*Task10
    The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive
    definition. The first two values in the sequence are 0 and 1 (essentially 2 base cases).
    */

    public int fibonacci(int n) {
        return n <= 1 ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static void main(String[] args) {
        RecursionOne recursionOne = new RecursionOne();



    }
}

