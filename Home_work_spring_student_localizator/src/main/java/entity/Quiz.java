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

}