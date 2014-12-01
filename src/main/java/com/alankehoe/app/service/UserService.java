package com.alankehoe.app.service;

import com.alankehoe.app.exception.RecordNotFoundException;
import com.alankehoe.app.exception.UnprocessableEntityException;
import com.alankehoe.app.model.User;

import java.util.List;
import java.util.UUID;

/**
 * Created by alan on 10/10/2014.
 */

public interface UserService {

    public List<User> all() throws RecordNotFoundException;

    public User find(UUID id) throws RecordNotFoundException;

    public User create(User user) throws UnprocessableEntityException;

    public User update(UUID id, User user) throws UnprocessableEntityException, RecordNotFoundException;

    public User destroy(UUID id) throws RecordNotFoundException;

}
