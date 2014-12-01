package com.alankehoe.app.controller.api;

import com.alankehoe.app.exception.RecordNotFoundException;
import com.alankehoe.app.exception.UnprocessableEntityException;
import com.alankehoe.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by alan on 10/10/2014.
 */

@Controller
public class UsersController extends BaseController implements RestController<User> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    @Override
    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<User> index() throws RecordNotFoundException {
        try {
            return userService.all();
        } catch (RecordNotFoundException e) {
            LOGGER.error("Error", e.getMessage());
            throw e;
        }
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public User show(@PathVariable("id") UUID id) throws RecordNotFoundException {
        try {
            return userService.find(id);
        } catch (RecordNotFoundException e) {
            LOGGER.error("Error", e.getMessage());
            throw e;
        }
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.POST, headers = "Accept=application/json")
    public User create(@RequestBody User user) throws UnprocessableEntityException {
        try {
            return userService.create(user);
        } catch (UnprocessableEntityException e) {
            LOGGER.error("Error", e.getMessage());
            throw e;
        }
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
    public User update(@PathVariable("id") UUID id, @RequestBody User user) throws UnprocessableEntityException, RecordNotFoundException {
        try {
            return userService.update(id, user);
        } catch (UnprocessableEntityException | RecordNotFoundException e) {
            LOGGER.error("Error", e.getMessage());
            throw e;
        }
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public User destroy(@PathVariable("id") UUID id) throws RecordNotFoundException {
        return null;
    }
}
