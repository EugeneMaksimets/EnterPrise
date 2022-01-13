package entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Quiz {
    private int number;
    private String question;
    private List<String> answers;
    private int rightAnswer;

    public String toString() {
        return "Question №" + number + ":\n" + question + "\n"
                + "Answer:\n" + "1. " + answers.get(0) + "\n"
                + "2. " + answers.get(1) + "\n"
                + "3. " + answers.get(2) + "\n"
                + "Enter number:";
    }
}