package com.memo.pk.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.memo.pk.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
