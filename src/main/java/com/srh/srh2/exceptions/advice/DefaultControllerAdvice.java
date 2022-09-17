package com.srh.srh2.exceptions.advice;

import com.srh.srh2.exceptions.ResourceNotFoundException;
import com.srh.srh2.exceptions.WrongInputDataException;
import com.srh.srh2.exceptions.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class DefaultControllerAdvice {
    @ExceptionHandler({ConstraintViolationException.class, MethodArgumentNotValidException.class,
            WrongInputDataException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseDto defaultExceptionHandler(Exception exception) {
        return getResponse(exception);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseDto defaultExceptionHandler(ResourceNotFoundException exception) {
        return getResponse(exception);
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDto defaultExceptionHandler(RuntimeException exception) {
        return getResponse(exception);
    }

    private ResponseDto getResponse(Exception exception) {
        log.error(exception.getMessage());
        return new ResponseDto(exception.getMessage());
    }
}
