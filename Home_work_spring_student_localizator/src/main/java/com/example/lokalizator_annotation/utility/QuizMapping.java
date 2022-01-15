package com.example.lokalizator_annotation.utility;

import com.example.lokalizator_annotation.entity.Quiz;

import java.util.List;

public interface QuizMapping {

    List<Quiz> questionReader() throws Exception;
}