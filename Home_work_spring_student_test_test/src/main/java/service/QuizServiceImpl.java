package service;

import entity.Quiz;
import entity.Student;
import utility.QuizMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizServiceImpl implements QuizService {

    private QuizMapping quizMapping;

    public QuizServiceImpl(QuizMapping quizMapping) {
        this.quizMapping = quizMapping;
    }

    public List<Quiz> getQuestions() {
        return quizMapping.questionReader();
    }

    private static int checkAnswers(List<Integer> studentsAnswers, List<Integer> rightAnswers) {
        int point = 0;
        for (int i = 0; i < studentsAnswers.size(); i++) {
            if (rightAnswers.get(i).equals(studentsAnswers.get(i))) {
                point++;
            }
        }
        return point;
    }

    public void answerLogic(Student student) {
        try {
            List<Quiz> questions = this.getQuestions();
            List<Integer> rightAnswers = new ArrayList<>();
            List<Integer> studentAnswers = new ArrayList<>();
            int answer;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            String result = scanner.nextLine();
            student.setName(result);
            System.out.println("Enter your surname:");
            result = scanner.nextLine();
            student.setSurname(result);
            for (Quiz question : questions) {
                System.out.println(question);
                answer = scanner.nextInt();
                studentAnswers.add(answer);
                rightAnswers.add(question.getRightAnswer());
            }
            student.setPoint(checkAnswers(studentAnswers, rightAnswers));
            System.out.println(student);
        } catch (Exception e) {
            System.err.println("Problem with source file");
        }
    }

}