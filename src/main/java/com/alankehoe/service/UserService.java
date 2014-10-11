package com.alankehoe.service;

import com.alankehoe.model.dto.UserDTO;
import com.alankehoe.exceptions.RecordNotFoundException;
import com.alankehoe.exceptions.UnprocessableEntityException;

import java.util.List;

/**
 * Created by alan on 10/10/2014.
 */

public interface UserService {
  public List<UserDTO> all() throws RecordNotFoundException;

  public UserDTO find(int id) throws RecordNotFoundException;

  public UserDTO create(UserDTO userDTO) throws UnprocessableEntityException;

  public UserDTO update(int id, UserDTO userDTO) throws UnprocessableEntityException, RecordNotFoundException;

  public UserDTO destroy(int id) throws RecordNotFoundException;
}
