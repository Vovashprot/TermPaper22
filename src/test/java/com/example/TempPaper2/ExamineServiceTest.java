package com.example.TempPaper2;

import com.example.TempPaper2.Exceptions.NotEnoughQuestionsException;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class ExamineServiceTest {

    ExaminerServiceImpl examinerService;

    @Mock
    QuestionService javaQuestionService ;

    Question questionOne = new Question ("baa2","dude1");
    Question questionTwo = new Question ("ba6a2","dud6e1");


    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        examinerService = new ExaminerServiceImpl(javaQuestionService);
        when(javaQuestionService.getAll()).thenReturn(Set.of(questionOne,questionTwo));
    }
    @Test
    void getQuestionsTest(){
        int amount = 1;
        when(javaQuestionService.getAll()).thenReturn(Set.of(questionOne,questionTwo));
        Collection<Question> needed = examinerService.getQuestions(amount);
        assertEquals(needed.size(),1 );
        needed = examinerService.getQuestions(2);
        System.out.println(needed.toString());
        assertThrows(NotEnoughQuestionsException.class, () ->examinerService.getQuestions(3));

    }
}
