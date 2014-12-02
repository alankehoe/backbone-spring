package com.alankehoe.app.controller.api;

import com.alankehoe.app.exception.RecordNotFoundException;
import com.alankehoe.app.exception.UnprocessableEntityException;
import com.alankehoe.app.model.Group;
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
public class GroupsController extends BaseController implements RestController<Group> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupsController.class);

    @Override
    @ResponseBody
    @RequestMapping(value = "/groups", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Group> index() throws RecordNotFoundException {
        try {
            return groupService.all();
        } catch (RecordNotFoundException e) {
            LOGGER.error("Error", e.getMessage());
            throw e;
        }
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/groups/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Group show(@PathVariable("id") UUID id) throws RecordNotFoundException {
        try {
            return groupService.find(id);
        } catch (RecordNotFoundException e) {
            LOGGER.error("Error", e.getMessage());
            throw e;
        }
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/groups", method = RequestMethod.POST, headers = "Accept=application/json")
    public Group create(@RequestBody Group group) throws UnprocessableEntityException {
        try {
            return groupService.create(group);
        } catch (UnprocessableEntityException e) {
            LOGGER.error("Error", e.getMessage());
            throw e;
        }
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/groups/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
    public Group update(@PathVariable("id") UUID id, @RequestBody Group group) throws UnprocessableEntityException, RecordNotFoundException {
        try {
            return groupService.update(id, group);
        } catch (UnprocessableEntityException | RecordNotFoundException e) {
            LOGGER.error("Error", e.getMessage());
            throw e;
        }
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/groups/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public Group destroy(@PathVariable("id") UUID id) throws RecordNotFoundException {
        return null;
    }
}
