package com.alankehoe.app.controller.api;

import com.alankehoe.app.controller.ApplicationController;
import com.alankehoe.app.exception.RecordNotFoundException;
import com.alankehoe.app.exception.UnprocessableEntityException;
import com.alankehoe.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by alan on 10/10/2014.
 */

@Controller
@RequestMapping("/api")
public class BaseController extends ApplicationController {

  private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

  @Autowired
  protected UserService userService;

  /**
   * The following code is for catching exceptions that have been thrown from a controller
   * method they will render a nice error message to the client in JSON format
   */

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler({RecordNotFoundException.class})
  public
  @ResponseBody
  String handleRecordNotFoundException() {
    LOGGER.error("The requested resource could not be found");
    return String.format("{\"code\": %d, \"message\": \"%s\"}", 404, "The requested resource could not be found");
  }

  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ExceptionHandler({UnprocessableEntityException.class})
  public
  @ResponseBody
  String handleUnprocessableEntityException() {
    LOGGER.error("unprocessable entity provided");
    return String.format("{\"code\": %d, \"message\": \"%s\"}", 422, "unprocessable entity provided");
  }
}
