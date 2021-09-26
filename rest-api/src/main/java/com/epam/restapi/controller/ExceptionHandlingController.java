package com.epam.restapi.controller;

import com.epam.restapi.exception.NotFoundEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@ControllerAdvice
public class ExceptionHandlingController {

  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  @ExceptionHandler(NotFoundEntityException.class)
  public void handlingNotFoundEntity() {

  }

}
