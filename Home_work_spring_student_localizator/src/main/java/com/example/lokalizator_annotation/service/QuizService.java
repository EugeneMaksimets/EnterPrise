package com.example.lokalizator_annotation.service;

import com.example.lokalizator_annotation.entity.Quiz;

import java.util.List;

public interface QuizService {
    List<Quiz> getQuestions() throws Exception;

    void answerLogic() throws Exception;
}
