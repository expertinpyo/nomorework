package com.nomorework.v1.db.repository;

import com.nomorework.v1.db.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
