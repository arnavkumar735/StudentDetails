package com.brillio.demo.advice;

import com.brillio.demo.exception.BranchesException;
import com.brillio.demo.exception.DuplicateNameException;
import com.brillio.demo.exception.EmptyListException;
import com.brillio.demo.students_dao.Student;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateNameException.class)
    public ResponseEntity<String> handleFileProcessingException(DuplicateNameException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<String> EmptyListException(EmptyListException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }

    @ExceptionHandler(BranchesException.class)
    public ResponseEntity<String> BranchesException(BranchesException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }
}


