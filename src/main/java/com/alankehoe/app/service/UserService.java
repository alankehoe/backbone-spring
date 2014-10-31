package com.alankehoe.app.service;

import com.alankehoe.app.exception.RecordNotFoundException;
import com.alankehoe.app.exception.UnprocessableEntityException;
import com.alankehoe.app.model.User;

import java.util.List;

/**
 * Created by alan on 10/10/2014.
 */

public interface UserService {
  public List<User> all() throws RecordNotFoundException;

  public User find(int id) throws RecordNotFoundException;

  public User create(User user) throws UnprocessableEntityException;

  public User update(int id, User user) throws UnprocessableEntityException, RecordNotFoundException;

  public User destroy(int id) throws RecordNotFoundException;
}
