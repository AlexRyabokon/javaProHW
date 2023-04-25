package homework14;

import java.util.*;

public class Homework14 {

    public static int countOccurance(List<String> list, String str) {
        int counter = 0;

        for (String s : list) {
            if (s.equals(str)) {
                counter++;
            }
        }

        return counter;
    }

    public static <T> List<T> toList(T[] array) {
        List<T> result = new ArrayList<>();
        result.addAll(Arrays.asList(array));

        return result;
    }

    public static Set<Integer> findUnique(List <Integer> list){
        return new HashSet<>(list);
    }

    public static int calcOccurance(List<String> words) {
        Set<String> uniqueWords = new HashSet<>(words);
        for (String word : uniqueWords) {
            return Collections.frequency(words, word);
        }
        throw new RuntimeException("CalcOccurance method Error, Please, check your input parameters");
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
