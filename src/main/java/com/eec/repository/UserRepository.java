package com.eec.repository;

import com.eec.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2015/3/16.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
