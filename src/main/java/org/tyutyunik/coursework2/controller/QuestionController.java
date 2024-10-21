package org.tyutyunik.coursework2.controller;

import org.tyutyunik.coursework2.model.Question;
import org.tyutyunik.coursework2.service.QuestionService;

import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question,
                        @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question,
                           @RequestParam("answer") String answer) {
        return questionService.remove(question, answer);
    }

    @GetMapping("")
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
