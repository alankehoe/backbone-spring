package com.alankehoe.app.controller.api;

import com.alankehoe.app.exception.RecordNotFoundException;
import com.alankehoe.app.exception.UnprocessableEntityException;
import com.alankehoe.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alan on 10/10/2014.
 */

@Controller
public class UsersController extends BaseController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

  @RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json")
  public
  @ResponseBody
  List<User> index() throws RecordNotFoundException {
    try {
      return userService.all();
    } catch (RecordNotFoundException e) {
      LOGGER.error("Error", e.getMessage());
      throw e;
    }
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
  public
  @ResponseBody
  User show(@PathVariable("id") int id) throws RecordNotFoundException {
    try {
      return userService.find(id);
    } catch (RecordNotFoundException e) {
      LOGGER.error("Error", e.getMessage());
      throw e;
    }
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST, headers = "Accept=application/json")
  public
  @ResponseBody
  User create(@RequestBody User user) throws UnprocessableEntityException {
    try {
      return userService.create(user);
    } catch (UnprocessableEntityException e) {
      LOGGER.error("Error", e.getMessage());
      throw e;
    }
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
  public
  @ResponseBody
  User update(@PathVariable("id") int id, @RequestBody User user) throws UnprocessableEntityException, RecordNotFoundException {
    try {
      return userService.update(id, user);
    } catch (UnprocessableEntityException | RecordNotFoundException e) {
      LOGGER.error("Error", e.getMessage());
      throw e;
    }
  }
}
