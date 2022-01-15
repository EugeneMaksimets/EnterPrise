package com.example.lokalizator_annotation.service;

import com.example.lokalizator_annotation.entity.Quiz;
import com.example.lokalizator_annotation.entity.Student;
import com.example.lokalizator_annotation.utility.QuizMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


@Service
public class QuizServiceImpl implements QuizService {

    private QuizMapping quizMapping;
    private MessageSource messageSource;

    @Autowired
    public QuizServiceImpl(QuizMapping quizMapping, MessageSource messageSource) {
        this.quizMapping = quizMapping;
        this.messageSource = messageSource;
    }

    private static int checkAnswers(List<Integer> studentsAnswers, List<Integer> rightAnswers) {
        int result = 0;
        for (int i = 0; i < studentsAnswers.size(); i++) {
            if (rightAnswers.get(i).equals(studentsAnswers.get(i))) {
                result++;
            }
        }
        return result;
    }

    private void printQuestion(Quiz quiz) {
        System.out.println(messageSource.getMessage("question.number", null, Locale.getDefault()) + quiz.getNumber()
                + ":\n" + quiz.getQuestion() + "\n"
                + messageSource.getMessage("student.answers", null, Locale.getDefault()) + "\n 1. "
                + quiz.getAnswers().get(0)
                + "\n 2. " + quiz.getAnswers().get(1)
                + "\n 3. " + quiz.getAnswers().get(2) + "\n"
                + messageSource.getMessage("student.number", null, Locale.getDefault()));
    }

    private void printResult(Student student) {
        System.out.println(messageSource.getMessage("student.name", null, Locale.getDefault()) + student.getName() + " "
                + student.getSurname()
                + ", " + messageSource.getMessage("student.point", null, Locale.getDefault()) + student.getPoint() + " "
                + messageSource.getMessage("student.result", null, Locale.getDefault()));
    }

    @Override
    public List<Quiz> getQuestions() throws Exception {
        return quizMapping.questionReader();
    }

    @Override
    @Bean
    public void answerLogic() throws Exception {

        List<Quiz> questions = this.getQuestions();
        List<Integer> rightAnswers = new ArrayList<>();
        List<Integer> studentsAnswers = new ArrayList<>();
        Student student = new Student();
        int answer;
        Scanner scanner = new Scanner(System.in);
        System.out.println(messageSource.getMessage("enter.name", null, Locale.getDefault()));
        String input = scanner.nextLine();
        student.setName(input);
        System.out.println(messageSource.getMessage("enter.surname", null, Locale.getDefault()));
        input = scanner.nextLine();
        student.setSurname(input);
        for (Quiz question : questions) {
            printQuestion(question);
            answer = scanner.nextInt();
            studentsAnswers.add(answer);
            rightAnswers.add(question.getRightNumber());
        }
        student.setPoint(checkAnswers(studentsAnswers, rightAnswers));
        printResult(student);

    }


}
