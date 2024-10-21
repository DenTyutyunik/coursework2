package org.tyutyunik.coursework2.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.tyutyunik.coursework2.service.TestData.*;

import org.tyutyunik.coursework2.exceptions.*;
import org.tyutyunik.coursework2.model.Question;

class QuestionServiceImplTest {

    private final QuestionService questionService = new QuestionServiceImpl();

    @Test
    void addQuestion() {
        Question question = QUESTION1;
        Question addedQuestion = questionService.add(question);
        assertEquals(question, addedQuestion);
        assertTrue(questionService.getAll().contains(question));
    }

    @Test
    void addQuestion_duplicate() {
        Question question = questionService.getAll().iterator().next();
        assertThrows(QuestionAlreadyAddedException.class, () -> questionService.add(question));
    }

    @Test
    void removeQuestion() {
        Question question = questionService.getAll().iterator().next();
        questionService.remove(question);
        assertFalse(questionService.getAll().contains(question));
    }

    @Test
    void removeQuestion_notFound() {
        assertThrows(QuestionNotFoundException.class, () -> questionService.remove(QUESTION1));
    }

    @Test
    void getRandomQuestion() {
        Question randomQuestion = questionService.getRandomQuestion();
        assertTrue(questionService.getAll().contains(randomQuestion));
    }
}
