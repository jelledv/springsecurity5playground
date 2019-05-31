package com.jelledv.springsecurityplayground.repository;

import com.jelledv.springsecurityplayground.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findUserEntityByEmail(String email);
}
