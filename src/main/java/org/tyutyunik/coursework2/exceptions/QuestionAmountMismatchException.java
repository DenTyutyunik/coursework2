package org.tyutyunik.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Question Amount Mismatch")
public class QuestionAmountMismatchException extends RuntimeException {
    public QuestionAmountMismatchException() {
        super("[EXCEPTION] Question Amount Mismatch");
    }
}
