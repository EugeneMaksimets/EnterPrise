package entity;

import java.util.List;

public class Quiz {
    private int number;
    private String question;
    private List<String> answers;
    private int rightAnswer;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getRightNumber() {
        return rightAnswer;
    }

    public void setRightNumber(int rightNumber) {
        this.rightAnswer = rightNumber;
    }

    public String toString() {
        return "Question №" + number + ":\n" + question + "\n"
                + "Answer options:\n" + "1. " + answers.get(0) + "\n"
                + "2. " + answers.get(1) + "\n"
                + "3. " + answers.get(2) + "\n"
                + "Enter number:";
    }
}