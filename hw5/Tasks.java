package org.hillel.hw5;

public class Tasks {

/*
2. Створити метод findSymbolOccurance. Метод приймає як параметр
рядок і символ. Необхідно обчислити, скільки разів символ зустрічається
в переданому рядку і повернути це числове значення.
*/

    public static int findSymbolOccurance(String str, char symbol) {
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) {
                result++;
            }
        }

        return result;
    }

    /*3. Створити метод findWordPosition. Метод приймає як параметри два рядки (source, target).
    Необхідно з'ясувати, чи є target (підрядок) частиною рядка source. Якщо так, тоді повернути номер
    позиції (індекс) першого елемента підрядка у рядку, інакше повернути -1.

    Приклад 1:
    Source: Apollo
    Target: pollo
    Result: 1

    Приклад 2:
    Source: Apple
    Target: Plant
    Result: -1
    */

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    /*
    4. Створити метод stringReverse. Метод приймає як параметр - рядок. Необхідно її розгорнути та повернути змінений варіант.
    Наприклад:
    Hello -> olleH
    * */

    public static String stringReverse(String str) {
        char[] firstChar = str.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = firstChar.length - 1; i >= 0; i--) {
            res.append(firstChar[i]);
        }
        return res.toString();
    }

    /*5. Створити метод isPalindrome. Метод приймає як параметр - рядок. Необхідно Перевірити, чи є переданий рядок
    паліндромом. Якщо так, тоді повернуть true, інакше false.

    Приклад 1:
    ERE -> true

    Приклад 2:
    Allo -> false
    */

    public static boolean isPalindrome(String str) {
        return str.equals(stringReverse(str));
    }

    public static boolean isPalindrome(String str, boolean ignoreCase) {

        if (ignoreCase == true) {
            return str.equalsIgnoreCase(stringReverse(str));
        } else {
            return isPalindrome(str);
        }
    }

}



