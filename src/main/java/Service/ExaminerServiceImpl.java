package Service;

import Question.Question;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class ExaminerServiceImpl implements ExaminerService{
    private JavaQuestionService questionService = new JavaQuestionService();
    private ArrayList<Question> examineQuestions;
    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.questionsList.size() < 5){
            throw new RuntimeException();
        }
        while (examineQuestions.size()<amount) {
            Question randomQuestion = questionService.getRandomQuestion();
            if (examineQuestions.contains(randomQuestion) == false) {
                examineQuestions.add(randomQuestion);
            }
        }
        return examineQuestions;
    }
}
