package com.alankehoe.app.service.impl;

import com.alankehoe.app.exception.RecordNotFoundException;
import com.alankehoe.app.exception.UnprocessableEntityException;
import com.alankehoe.app.model.User;
import com.alankehoe.app.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alan on 10/10/2014.
 */

@Service
public class UserServiceImpl implements UserService {

  @Override
  public List<User> all() throws RecordNotFoundException {
    List<User> users = Lists.newArrayList();
    for (int i = 0; i < 100; i++)
      users.add(mockUser(i));
    return users;
  }

  @Override
  public User find(int id) throws RecordNotFoundException {
    return mockUser(id);
  }

  @Override
  public User create(User user) throws UnprocessableEntityException {
    return user;
  }

  @Override
  public User update(int id, User user) throws UnprocessableEntityException, RecordNotFoundException {
    return user;
  }

  @Override
  public User destroy(int id) throws RecordNotFoundException {
    return mockUser(id);
  }

  private User mockUser(int id) {
    User user = new User();
    user.setId(id);
    user.setFirstName("alan");
    user.setLastName("kehoe");
    user.setAge(23);
    return user;
  }
}
