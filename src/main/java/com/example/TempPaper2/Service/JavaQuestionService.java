package com.example.TempPaper2.Service;

import com.example.TempPaper2.Exceptions.NotEnoughQuestionsException;
import com.example.TempPaper2.Question.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class JavaQuestionService implements QuestionService {

    private final Set<Question> questionsList = new HashSet<>();
    private final Random random = new Random();
    @Override
    public Question add(String question, String answer) {
        return add(new Question(question,answer));
    }

    @Override
    public Collection<Question> getAll() {
        if (questionsList.isEmpty()){
            throw new NotEnoughQuestionsException();
        }

        return Collections.unmodifiableCollection(questionsList );
    }

    @Override
    public Question getRandomQuestion() {
        if (questionsList.size()<1){
            throw new NotEnoughQuestionsException();
        }
        var ran = random.nextInt(questionsList.size());
        int i = 0;
        for (Question question : questionsList) {
            if (ran == i){
                return question;
            }
            i++;
        }
        return null;
    }

    @Override
    public Question remove(Question question) {
        if(questionsList.remove(question)) {
            return question;
        };
        return null;
    }

    @Override
    public Question add(Question question) {
        questionsList.add(question);
        return question;
    }
}
