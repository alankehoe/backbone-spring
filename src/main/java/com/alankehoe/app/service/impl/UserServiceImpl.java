package com.alankehoe.app.service.impl;

import com.alankehoe.app.exception.RecordNotFoundException;
import com.alankehoe.app.exception.UnprocessableEntityException;
import com.alankehoe.app.model.User;
import com.alankehoe.app.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * Created by alan on 10/10/2014.
 */

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> all() throws RecordNotFoundException {
        List<User> users = Lists.newArrayList();
        IntStream.range(0, 100).forEach((i -> users.add(mockUser())));
        return users;
    }

    @Override
    public User find(UUID id) throws RecordNotFoundException {
        return mockUser();
    }

    @Override
    public User create(User user) throws UnprocessableEntityException {
        return user;
    }

    @Override
    public User update(UUID id, User user) throws UnprocessableEntityException, RecordNotFoundException {
        return user;
    }

    @Override
    public User destroy(UUID id) throws RecordNotFoundException {
        return mockUser();
    }

    private User mockUser() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setFirstName("alan");
        user.setLastName("kehoe");
        user.setAge(23);
        return user;
    }
}
