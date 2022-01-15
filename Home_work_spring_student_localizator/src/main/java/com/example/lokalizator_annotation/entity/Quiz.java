package com.example.lokalizator_annotation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    private int number;
    private String question;
    private List<String> answers;
    private int rightNumber;
}
