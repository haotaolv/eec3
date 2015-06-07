package com.eec.repository;

import com.eec.model.TestEntity;
import com.eec.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2015/3/17.
 */
public interface TestRepository extends JpaRepository<TestEntity, Integer> {
//    @Modifying
//    @Transactional
//    @Query("update TestEntity te set te.name = :testName ")
//    public void setName(@Param("testName")String testName);
    @Modifying
    @Transactional
    @Query(value = "insert into TestEntity(name ,to,time,message) values (:name,:to,:time,:message)",nativeQuery = true)
    public void insertTest(@Param("name")String name,@Param("to")String to,@Param("time")String time,
                           @Param("message")String message);
}
