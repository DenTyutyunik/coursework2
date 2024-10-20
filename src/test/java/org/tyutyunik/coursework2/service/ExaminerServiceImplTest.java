package org.tyutyunik.coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.tyutyunik.coursework2.exceptions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private final QuestionService questionService = Mockito.mock(QuestionService.class);
    @InjectMocks
    private final ExaminerServiceImpl examinerService = new ExaminerServiceImpl(questionService);

    /*@Test
    void getQuestions_validAmount() {
        Mockito.when(questionService.getAll()).thenReturn(List.of(
                new Question("Question 1", "Answer 1"),
                new Question("Question 2", "Answer 2"),
                new Question("Question 3", "Answer 3")
        ));
        Collection<Question> questions = examinerService.getQuestions(2);
        assertEquals(2, questions.size());
    }*/

    @Test
    void getQuestions_invalidAmount_negative() {
        assertThrows(QuestionAmountMismatchException.class, () -> examinerService.getQuestions(-1));
    }
}