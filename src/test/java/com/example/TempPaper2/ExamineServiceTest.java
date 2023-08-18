package com.example.TempPaper2;

import com.example.TempPaper2.Question.Question;
import com.example.TempPaper2.Service.ExaminerServiceImpl;
import com.example.TempPaper2.Service.JavaQuestionService;
import com.example.TempPaper2.Service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ExamineServiceTest {
    @Mock
    private QuestionService javaQuestionService;
    private ExaminerServiceImpl examinerService = new ExaminerServiceImpl();
    Question questionOne = new Question ("baa2","dude1");
    Question questionTwo = new Question ("ba6a2","dud6e1");

    @BeforeEach
    void setUp(){
        when(javaQuestionService.getAll()).thenReturn(Set.of(questionOne,questionTwo));
    }
    @Test
    void getQuestionsTest(){
        Collection<Question> needed = examinerService.getQuestions(1);
        assertEquals(needed.equals(Set.of(questionTwo,questionOne)),true );
    }
}
