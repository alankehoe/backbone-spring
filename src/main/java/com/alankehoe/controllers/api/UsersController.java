package com.alankehoe.controllers.api;

import com.alankehoe.model.dto.UserDTO;
import com.alankehoe.exceptions.RecordNotFoundException;
import com.alankehoe.exceptions.UnprocessableEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
  List<UserDTO> index() throws RecordNotFoundException {
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
  UserDTO show(@PathVariable("id") int id) throws RecordNotFoundException {
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
  UserDTO create(@RequestBody UserDTO userDTO) throws UnprocessableEntityException {
    try {
      return userService.create(userDTO);
    } catch (UnprocessableEntityException e) {
      LOGGER.error("Error", e.getMessage());
      throw e;
    }
  }
}