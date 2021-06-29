package com.espark.adarsh.persistance.repository;

import javax.transaction.Transactional;

import com.espark.adarsh.persistance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
