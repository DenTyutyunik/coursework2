package org.tyutyunik.coursework2.service;

import org.tyutyunik.coursework2.exceptions.QuestionAlreadyAddedException;
import org.tyutyunik.coursework2.exceptions.QuestionNotFoundException;
import org.tyutyunik.coursework2.model.Question;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    public QuestionServiceImpl() {
        questions.add(new Question("Конструкция языка, позволяющая выполнять один и тот же код многократно в зависимости от условий?", "Цикл"));
        questions.add(new Question("Упорядоченная структура данных фиксированного размера?", "Массив"));
        questions.add(new Question("Неизменяемый массив символов?", "Строка"));
        questions.add(new Question("Два обычных метода, которые используются для получения значения поля класса или его изменения.?", "Геттеры и сеттеры"));
        questions.add(new Question("Особый метод, задача которого - в случае необходимости создать объект, мы обязаны корректно инициализировать его?", "Конструктор"));
    }

    @Override
    public Question add(String question, String answer) {
        Question questionResult = new Question(question, answer);
        if (questions.contains(questionResult)) {
            throw new QuestionAlreadyAddedException();
        }
        questions.add(questionResult);
        return questionResult;
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyAddedException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionResult = new Question(question, answer);
        if (!questions.contains(questionResult)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(questionResult);
        return questionResult;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Question[] questionArray = questions.toArray(new Question[0]);
        int randomIndex = random.nextInt(questionArray.length);
        return questionArray[randomIndex];
    }
}
