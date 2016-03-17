package com.javaschool.repository;

import com.javaschool.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
}
