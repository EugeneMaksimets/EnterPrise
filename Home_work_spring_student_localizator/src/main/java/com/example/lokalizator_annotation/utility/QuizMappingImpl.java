package com.example.lokalizator_annotation.utility;

import com.example.lokalizator_annotation.entity.Quiz;
import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanReader;
import org.supercsv.io.dozer.ICsvDozerBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Component
public class QuizMappingImpl implements QuizMapping {
    private static final String[] MAPPING = new String[]{
            "number",
            "question",
            "answers[0]",
            "answers[1]",
            "answers[2]",
            "rightNumber"
    };
    private static final CellProcessor[] PROCESSORS = new CellProcessor[]{
            new ParseInt(),
            new Optional(),
            new Optional(),
            new Optional(),
            new Optional(),
            new ParseInt()
    };

    @Override
    public List<Quiz> questionReader() throws Exception {
        List<Quiz> questions = new ArrayList<>();
        Locale locale = Locale.getDefault();
        ClassLoader classLoader = getClass().getClassLoader();
        File source;
        switch (locale.toString()) {
            case "en":
                source = new File(Objects.requireNonNull(classLoader.getResource("question_en.csv")).getFile());
                break;
            case "ru_UA":
                source = new File(Objects.requireNonNull(classLoader.getResource("question_ru.csv")).getFile());
                break;
            default:
                source = new File(Objects.requireNonNull(classLoader.getResource("source_en.csv")).getFile());
        }
        try (ICsvDozerBeanReader reader = new CsvDozerBeanReader(new FileReader(source),
                CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE)) {
            reader.getHeader(true);
            reader.configureBeanMapping(Quiz.class, MAPPING);
            Quiz question;
            while ((question = reader.read(Quiz.class, PROCESSORS)) != null) {
                questions.add(question);
            }
        }
        return questions;
    }
}