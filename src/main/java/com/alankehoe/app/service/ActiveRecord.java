package com.alankehoe.app.service;

import com.alankehoe.app.exception.RecordNotFoundException;
import com.alankehoe.app.exception.UnprocessableEntityException;

import java.util.List;
import java.util.UUID;

/**
 * Created by alan on 10/10/2014.
 */

public interface ActiveRecord<T> {

    public List<T> all() throws RecordNotFoundException;

    public T find(UUID id) throws RecordNotFoundException;

    public T create(T model) throws UnprocessableEntityException;

    public T update(UUID id, T model) throws UnprocessableEntityException, RecordNotFoundException;

    public T destroy(UUID id) throws RecordNotFoundException;

}
