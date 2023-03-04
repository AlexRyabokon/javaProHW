package org.hillel.hw5;

import java.util.Random;
import java.util.Scanner;


//First version fo Words Game
public class WordsGame {

    private final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado" ,
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"};

    int indexWord = new Random().nextInt(words.length);
    private String wordToGuess = words[indexWord];
    int wordLength = wordToGuess.length();

    public void startTheGame(){
        Scanner scanner = new Scanner(System.in);
        String inputUserWord = "";

        System.out.println("Guess the word! You can write 'quit' and game will stop.");

        while (!inputUserWord.equals(wordToGuess)) {
            System.out.print("Enter your guess: ");
            inputUserWord = scanner.nextLine().toLowerCase();

            if (inputUserWord.equals(wordToGuess)) {
                System.out.println("Congratulations! You guessed the word.");
                break;
            }else if(inputUserWord.equals("quit")){
                System.out.println("Game over. Goodbye");
                break;
            } else {
                for (int i = 0; i < wordLength; i++) {
                    char char1 = wordToGuess.charAt(i);

                    char char2;
                    if (inputUserWord.length() > i) {
                        char2 = inputUserWord.charAt(i);
                    } else {
                        char2 = '#';
                    }

                    if (char1 == char2) {
                        System.out.print(char1);
                    } else {
                        System.out.print("#");
                    }
                }
                System.out.println();
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        WordsGame wordsGame = new WordsGame();
        wordsGame.startTheGame();
    }

}
