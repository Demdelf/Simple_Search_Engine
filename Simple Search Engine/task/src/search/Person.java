package search;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String secondName;
    private String mail;
    private List<String> strings = new ArrayList<>();

    public List<String> getStrings() {
        return strings;
    }

    public Person(String firstName, String secondName, String mail) {
        this.firstName = firstName;
        this.strings.add(firstName);
        this.secondName = secondName;
        this.strings.add(secondName);
        this.mail = mail;
        this.strings.add(mail);
    }

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.strings.add(firstName);
        this.secondName = secondName;
        this.strings.add(secondName);
        this.mail = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMail() {
        return mail;
    }

    public String getData(){
        if (mail.length() > 0)
            return firstName + " " + secondName + " "+ mail;
        else return firstName + " " + secondName;
    }
}
