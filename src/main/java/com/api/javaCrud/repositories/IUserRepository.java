package com.api.javaCrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.javaCrud.models.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long>{

}
