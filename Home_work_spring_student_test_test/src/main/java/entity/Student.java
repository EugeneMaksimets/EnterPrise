package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String name;
    private String surname;
    private int point;

    public String toString() {
        return name + " " + surname + "." + " You have " + point + " correct answers";
    }
}