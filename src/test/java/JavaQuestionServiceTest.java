import com.example.TempPaper2.Exceptions.NotEnoughQuestionsException;
import com.example.TempPaper2.Question.Question;
import com.example.TempPaper2.Service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    public void setUp(){
        javaQuestionService = new JavaQuestionService();
        javaQuestionService.add ("sdsada","asdasd");
        javaQuestionService.add ("sdsada","as456sd");
    }

    @Test
    public void addAndGetAllTest(){
        assertEquals(javaQuestionService.getAll().size(),2);
        javaQuestionService.add("sdsada","asdasd");
        assertEquals(javaQuestionService.getAll().size(),2);
    }

    @Test
    public void removeTest(){
        assertEquals(javaQuestionService.getAll().size(),2);
        javaQuestionService.remove(new Question("sdsada","asdasd"));
        assertEquals(javaQuestionService.getAll().size(),1);
        System.out.println(javaQuestionService.getAll().toString());
        javaQuestionService.remove(new Question("sdsada","asdasd"));
        assertEquals(javaQuestionService.getAll().size(),1);
    }

    @Test()
    public void NotEnoughQuestionsExceptionTest(){
        javaQuestionService = new JavaQuestionService();
        assertThrows(NotEnoughQuestionsException.class, () ->javaQuestionService.getRandomQuestion());
        assertThrows(NotEnoughQuestionsException.class, () ->javaQuestionService.getAll());
    }

    @Test()
    public void getRandomQuestionTest(){
        javaQuestionService = new JavaQuestionService();
        javaQuestionService.add ("sdsada","asdasd");
        assertEquals(javaQuestionService.getRandomQuestion(),new Question("sdsada","asdasd"));
    }
}
