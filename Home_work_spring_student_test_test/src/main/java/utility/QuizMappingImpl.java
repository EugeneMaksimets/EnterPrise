package utility;

import entity.Quiz;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanReader;
import org.supercsv.io.dozer.ICsvDozerBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class QuizMappingImpl implements QuizMapping {
    private static final String[] MAPPING = new String[]{
            "number",
            "question",
            "answers[0]",
            "answers[1]",
            "answers[2]",
            "rightAnswer"
    };
    private static final CellProcessor[] processors = new CellProcessor[]{
            new Optional(new ParseInt()),
            new Optional(),
            new Optional(),
            new Optional(),
            new Optional(),
            new ParseInt()
    };

    public List<Quiz> questionReader() {
        List<Quiz> questions = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File source = new File(Objects.requireNonNull(classLoader.getResource("question.csv")).getFile());
        try (ICsvDozerBeanReader reader = new CsvDozerBeanReader(new FileReader(source),
                CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE)) {
            reader.getHeader(true);
            reader.configureBeanMapping(Quiz.class, MAPPING);
            Quiz question;
            while ((question = reader.read(Quiz.class, processors)) != null) {
                questions.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
}