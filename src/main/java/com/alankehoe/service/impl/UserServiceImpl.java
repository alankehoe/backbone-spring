package com.alankehoe.service.impl;

import com.alankehoe.model.dto.UserDTO;
import com.alankehoe.exceptions.RecordNotFoundException;
import com.alankehoe.exceptions.UnprocessableEntityException;
import com.alankehoe.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alan on 10/10/2014.
 */

@Service
public class UserServiceImpl implements UserService {

  @Override
  public List<UserDTO> all() throws RecordNotFoundException {
    return Lists.newArrayList(mockUser(), mockUser());
  }

  @Override
  public UserDTO find(int id) throws RecordNotFoundException {
    return mockUser();
  }

  @Override
  public UserDTO create(UserDTO userDTO) throws UnprocessableEntityException {
    return userDTO;
  }

  @Override
  public UserDTO update(int id, UserDTO userDTO) throws UnprocessableEntityException, RecordNotFoundException {
    return userDTO;
  }

  @Override
  public UserDTO destroy(int id) throws RecordNotFoundException {
    return mockUser();
  }

  private UserDTO mockUser() {
    UserDTO userDTO = new UserDTO();
    userDTO.setFirstName("alan");
    userDTO.setLastName("kehoe");
    userDTO.setAge(23);
    return userDTO;
  }
}
