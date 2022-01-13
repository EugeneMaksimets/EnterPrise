import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import entity.Student;
import service.QuizService;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
        QuizService service = ctx.getBean(QuizService.class);
        try {
            service.answerLogic(new Student());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}