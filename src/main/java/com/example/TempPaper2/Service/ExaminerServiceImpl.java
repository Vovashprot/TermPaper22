package com.example.TempPaper2.Service;

import com.example.TempPaper2.Exceptions.NotEnoughQuestionsException;
import com.example.TempPaper2.Question.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private QuestionService javaQuestionService;

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (javaQuestionService.getAll().size() < amount){
            throw new NotEnoughQuestionsException();
        }
        if (javaQuestionService.getAll().size() == amount){
            return javaQuestionService.getAll() ;
        }
        var examineQuestions = new HashSet<Question>(amount);
        while (examineQuestions.size()<amount) {
            Question randomQuestion = javaQuestionService.getRandomQuestion();
                examineQuestions.add(randomQuestion);
        }
        return examineQuestions;
    }
}
