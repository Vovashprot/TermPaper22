package com.example.TempPaper2.Service;

import com.example.TempPaper2.Question.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question>getAll();
    Question getRandomQuestion();

}
