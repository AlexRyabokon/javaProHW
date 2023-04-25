package homework14.phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phonebook {

    private final List<Note> noteList;

    public Phonebook() {
        this.noteList = new ArrayList<>();
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
        ArrayList<Note> result = new ArrayList<>();
        for (Note note : noteList) {
            if (note.getName().equals(name)) {
                result.add(note);
            }
        }
        return result.size() > 0 ? result : null;

    }

}
