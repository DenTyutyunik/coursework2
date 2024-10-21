package org.tyutyunik.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Question Already Added")
public class QuestionAlreadyAddedException extends RuntimeException {
    public QuestionAlreadyAddedException() {
        super("[EXCEPTION] Question Already Added");
    }
}
