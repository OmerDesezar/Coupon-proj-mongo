package com.omer.couponprojmongo.services;

import com.omer.couponprojmongo.exceptions.AlreadyExistsException;
import com.omer.couponprojmongo.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface EntityService<Entity extends BaseEntity> {

    Entity save(Entity entity)throws AlreadyExistsException;

    Optional<Entity> findById(String id);

    List<Entity> findAll();
}