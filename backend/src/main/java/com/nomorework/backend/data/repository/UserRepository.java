package com.nomorework.backend.data.repository;

import com.nomorework.backend.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
