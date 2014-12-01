package com.alankehoe.app.controller.api;

import com.alankehoe.app.exception.RecordNotFoundException;
import com.alankehoe.app.exception.UnprocessableEntityException;

import java.util.List;

/**
 * Created by alan on 01/12/2014.
 */
public interface RestController<T> {

    public List<T> index() throws RecordNotFoundException;

    public T show(int id) throws RecordNotFoundException;

    public T create(T object) throws UnprocessableEntityException;

    public T update(int id, T object) throws UnprocessableEntityException, RecordNotFoundException;

    public T destroy(int id) throws RecordNotFoundException;
}
