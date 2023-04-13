package homework14;

import java.util.*;

public class Homework14 {

    public static int countOccurance(List<String> list, String str) {
        int x = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(str)) {
                x++;
            }
        }

        return x;
    }

    public static <T> List<T> toList(T[] array) {
        List<T> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            result.add(array[i]);
        }
        return result;
    }

    public static List<Integer> findUnique(List <Integer> list){
        return new ArrayList<>(new HashSet<>(list));
    }

    public static void calcOccurance(List<String> words) {
        Set<String> uniqueWords = new HashSet<>(words);
        for (String word : uniqueWords) {
            int frequency = Collections.frequency(words, word);
            System.out.println(word + ": " + frequency);
        }
    }

    public static Map<String, Integer> findOccurance(List<String> words){
        Map<String, Integer> occurance = new HashMap<>();
        for (String word : words) {
            occurance.put(word, occurance.getOrDefault(word, 0) + 1);
        }
        return occurance;
    }

    public static void main(String[] args) {
        ArrayList<String> arList = new ArrayList<>();
        arList.add("1");
        arList.add("1");
        arList.add("2");
        calcOccurance(arList);
        System.out.println(findOccurance(arList));
    }
}
