package org.tyutyunik.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Question Not Found")
public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException() {
        super("[EXCEPTION] Question Not Found");
    }
}
