package Controller;

import Question.Question;
import Service.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping( "/exam/start")
public class ExamController {
    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }
    @GetMapping("/{amount}")
    public Collection getQuestions(@PathVariable("amount") int amount)
    {
        return service.getQuestions(amount);
    }
}
