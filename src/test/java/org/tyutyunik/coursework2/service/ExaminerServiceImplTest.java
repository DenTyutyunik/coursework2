package org.tyutyunik.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.tyutyunik.coursework2.service.TestData.*;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.tyutyunik.coursework2.exceptions.*;
import org.tyutyunik.coursework2.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        when(questionService.getAll()).thenReturn(getAll());
        when(questionService.getRandomQuestion()).thenReturn(QUESTION1, QUESTION2, QUESTION3);

        Collection<Question> actual = examinerService.getQuestions(3);
        assertEquals(3, actual.size());
    }

    @Test
    void getQuestions_invalidAmount_negative() {
        assertThrows(QuestionAmountMismatchException.class, () -> examinerService.getQuestions(-1));
    }
}
