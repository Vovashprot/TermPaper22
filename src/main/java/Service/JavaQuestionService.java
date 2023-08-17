package Service;

import Question.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
@Service

public class JavaQuestionService implements QuestionService {

    ArrayList<Question> questionsList;
    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question,answer);
        questionsList.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return questionsList;
    }

    @Override
    public Question getRandomQuestion() {
        Random ran = new Random();
        int random = ran.nextInt(questionsList.size());
        return questionsList.get(random);
    }

    @Override
    public Question remove(Question question) {
        questionsList.remove(question);
        return question;
    }

    @Override
    public Question add(Question question) {
        questionsList.add(question);
        return question;
    }
}
