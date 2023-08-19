package com.example.TempPaper2.Service;

import com.example.TempPaper2.Question.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
