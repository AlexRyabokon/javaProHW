package org.hillel.hw5;

public class App {
    public static void main(String[] args) {
        //Task2
        System.out.println("Char 'symbol' count = "+Tasks.findSymbolOccurance("java java", 'j'));
        //Task3
        System.out.println("Source: Apollo -- Target: pollo. Result off method: "+ Tasks.findWordPosition("Apollo", "pollo"));
        //Task4
        System.out.println("s");
        //Task5 - Case sensitive
        System.out.println(Tasks.isPalindrome("Radar"));
        //Task5 - Case ignore
        System.out.println(Tasks.isPalindrome("Radar", true));
    }
}
