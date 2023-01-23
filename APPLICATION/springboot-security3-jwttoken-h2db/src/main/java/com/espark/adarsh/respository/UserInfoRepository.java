package com.espark.adarsh.respository;

import com.espark.adarsh.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

    Optional<UserInfo> findByUserName(String userName);
}
