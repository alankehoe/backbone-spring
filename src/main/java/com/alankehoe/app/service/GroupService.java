package com.alankehoe.app.service;

import com.alankehoe.app.exception.RecordNotFoundException;
import com.alankehoe.app.exception.UnprocessableEntityException;
import com.alankehoe.app.model.Group;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * Created by alan on 10/10/2014.
 */

@Service
public class GroupService implements ActiveRecord<Group> {

    @Override
    public List<Group> all() throws RecordNotFoundException {
        List<Group> groups = Lists.newArrayList();
        IntStream.range(0, 100).forEach((i -> groups.add(mockUser())));
        return groups;
    }

    @Override
    public Group find(UUID id) throws RecordNotFoundException {
        Group group = mockUser();
        group.setId(id);
        return group;
    }

    @Override
    public Group create(Group group) throws UnprocessableEntityException {
        return group;
    }

    @Override
    public Group update(UUID id, Group group) throws UnprocessableEntityException, RecordNotFoundException {
        return group;
    }

    @Override
    public Group destroy(UUID id) throws RecordNotFoundException {
        return mockUser();
    }

    private Group mockUser() {
        Group group = new Group();
        group.setId(UUID.randomUUID());
        group.setName("Some Group");
        return group;
    }
}
