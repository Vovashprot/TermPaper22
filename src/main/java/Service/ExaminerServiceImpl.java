package Service;

import Question.Question;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExaminerServiceImpl implements ExaminerService{
    private JavaQuestionService questionService = new JavaQuestionService();
    private ArrayList<Question> examineQuestions;
    @Override
    public Collection<Question> getQuestion(int amount) {
        if (questionService.questionsList.size() < 5){
            throw new RuntimeException();
        }
        while (examineQuestions.size()<5) {
            Question randomQuestion = questionService.getRandomQuestion();
            if (examineQuestions.contains(randomQuestion) == false) {
                examineQuestions.add(randomQuestion);
            }
        }
        return examineQuestions;
    }
}
