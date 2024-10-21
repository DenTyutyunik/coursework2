package org.tyutyunik.coursework2.controller;

import org.tyutyunik.coursework2.service.ExaminerService;
import org.tyutyunik.coursework2.model.Question;

import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
