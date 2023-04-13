package homework14.phonebook;

import java.util.ArrayList;
import java.util.Collections;

public class Phonebook {

    private ArrayList<Note> noteList;

    public Phonebook() {
        this.noteList = new ArrayList<Note>();
    }

    public void add(Note note) {
        this.noteList.add(note);
    }

    public void add(Note[] notes) {
        Collections.addAll(this.noteList, notes);
    }

    public Note find(String name) {
        for (Note note : noteList) {
            if (note.getName().equals(name)) {
                return note;
            }
        }
        return null;
    }

    public ArrayList<Note> findAll(String name) {
        ArrayList<Note> result = new ArrayList<Note>();
        for (Note note : noteList) {
            if (note.getName().equals(name)) {
                result.add(note);
            }
        }
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }
    }

}
