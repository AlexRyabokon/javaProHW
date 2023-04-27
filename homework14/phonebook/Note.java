package homework14.phonebook;

import java.util.Objects;

public class Note {
    private String name;
    private String phone;

    public Note(String name, String phone) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.phone = Objects.requireNonNull(phone, "Phone cannot be null");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Note{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
