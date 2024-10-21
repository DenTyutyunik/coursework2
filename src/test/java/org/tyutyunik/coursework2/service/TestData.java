package org.tyutyunik.coursework2.service;

import org.tyutyunik.coursework2.model.Question;

import java.util.Collection;
import java.util.List;

public class TestData {
    public final static Question QUESTION1 = new Question("Question 1", "Answer 1");
    public final static Question QUESTION2 = new Question("Question 2", "Answer 2");
    public final static Question QUESTION3 = new Question("Question 3", "Answer 3");

    public static Collection<Question> getAll() {
        return List.of(QUESTION1, QUESTION2, QUESTION3);
    }
}
