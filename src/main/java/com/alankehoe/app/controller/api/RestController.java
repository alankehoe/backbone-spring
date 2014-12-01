package com.alankehoe.app.controller.api;

import com.alankehoe.app.exception.RecordNotFoundException;
import com.alankehoe.app.exception.UnprocessableEntityException;

import java.util.List;
import java.util.UUID;

/**
 * Created by alan on 01/12/2014.
 */
public interface RestController<T> {

    public List<T> index() throws RecordNotFoundException;

    public T show(UUID id) throws RecordNotFoundException;

    public T create(T object) throws UnprocessableEntityException;

    public T update(UUID id, T object) throws UnprocessableEntityException, RecordNotFoundException;

    public T destroy(UUID id) throws RecordNotFoundException;

}
