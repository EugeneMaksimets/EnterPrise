package service;

import entity.Quiz;
import entity.Student;

import java.util.List;

public interface QuizService {

    List<Quiz> getQuestions();

    void answerLogic(Student student);

}