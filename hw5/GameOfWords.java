package org.hillel.hw5;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

//Second version of Word Game
public class GameOfWords {
    //Main Array of vegetables and fruits
    private final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"};

    //Word, which user will write
    private String inputUserWord;
    private int indexWord = new Random().nextInt(words.length);
    String wordToGuess = words[indexWord];


    public void gameStart() {
        /* To enable god mode  - uncomment this lines

        System.out.println("\n" + indexWord);
        System.out.println(wordToGuess);*/

        System.out.println("Guess the word! You can write '404' and game will stop.");
        Scanner scanner = new Scanner(System.in);
        inputUserWord = scanner.nextLine().toLowerCase();

        //Win condition
        if (Objects.equals(inputUserWord, this.wordToGuess)) {
            System.out.println("You won! Your word is " + inputUserWord);
            return;
        }

        //Exit condition
        if (this.inputUserWord.equals("404")) {
            System.out.println("Game over. Goodbye. This word was --- "+this.wordToGuess);
            return;
        }

        //Main logic
        if (!this.inputUserWord.equals(this.wordToGuess)) {
            System.out.println("TRY AGAIN!");
            StringBuilder sb = new StringBuilder("##################");
            String tempWord;

            for (int i = 0; i < inputUserWord.length(); i++) {
                for (int j = 0; j < wordToGuess.length(); j++) {
                    if (inputUserWord.charAt(i) == wordToGuess.charAt(j)) {
                        sb.setCharAt(i, wordToGuess.charAt(i));
                    }
                }
            }
            tempWord = sb.toString();
            System.out.print(tempWord);
            gameStart();
        }


    }


    public static void main(String[] args) {
        GameOfWords gameOfWords = new GameOfWords();

        gameOfWords.gameStart();
    }

}
