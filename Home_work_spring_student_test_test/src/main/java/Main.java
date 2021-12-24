import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import entity.Student;
import service.QuizService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        QuizService service = context.getBean(QuizService.class);
        service.answerLogic(new Student());
    }
}