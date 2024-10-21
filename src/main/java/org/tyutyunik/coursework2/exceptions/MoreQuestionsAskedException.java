package org.tyutyunik.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "More Question Asked")
public class MoreQuestionsAskedException extends RuntimeException {
    public MoreQuestionsAskedException() {
        super("[EXCEPTION] More Question Asked");
    }
}
