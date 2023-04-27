package homework14.phonebook;

public class App {
    public static void main(String[] args) {
        var note1 = new Note("Alex", "253253");
        var note2 = new Note("Dmitry", "23456");
        var note3 = new Note("Lexa", "8884");
        var note4 = new Note("Lexa", "2345");


        Phonebook phonebook = new Phonebook();
        phonebook.add(new Note[]{note1, note2, note3, note4});

        System.out.println(phonebook.findAll("Alex"));

    }
}
