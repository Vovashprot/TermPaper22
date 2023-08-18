package com.example.TempPaper2.Service;

import com.example.TempPaper2.Question.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private QuestionService questionService;

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount){
            throw new RuntimeException();
        }
        if (questionService.getAll().size() == amount){
            return questionService.getAll() ;
        }
        var examineQuestions = new HashSet<Question>(amount);
        while (examineQuestions.size()<amount) {
            Question randomQuestion = questionService.getRandomQuestion();
                examineQuestions.add(randomQuestion);
        }
        return examineQuestions;
    }
}
