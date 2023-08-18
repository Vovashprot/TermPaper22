package com.example.TempPaper2.Controller;

import com.example.TempPaper2.Question.Question;
import com.example.TempPaper2.Service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(
            @RequestParam("question") String question, @RequestParam ("answer") String answer)
    {
        return service.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(
            @RequestParam ("question") String question,  @RequestParam ("answer") String answer)
    {;
        return service.remove(new Question (question,answer));
    }

    @GetMapping
    public Collection getAllQuestion()
    {
        return service.getAll();
    }
}
