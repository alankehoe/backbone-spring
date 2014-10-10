package com.alankehoe.services.impl;

import com.alankehoe.model.dto.User;
import com.alankehoe.model.exceptions.RecordNotFoundException;
import com.alankehoe.model.exceptions.UnprocessableEntityException;
import com.alankehoe.services.UserService;
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
    return Lists.newArrayList(mockUser(), mockUser());
  }

  @Override
  public User find(int id) throws RecordNotFoundException {
    return mockUser();
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
    return mockUser();
  }

  private User mockUser() {
    User user = new User();
    user.setFirstName("alan");
    user.setLastName("kehoe");
    user.setAge(23);
    return user;
  }
}
