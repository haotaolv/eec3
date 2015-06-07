package com.eec.repository;

import com.eec.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* Created by 智康 on 2015/2/10 0010.
*/
public interface CourseRepository extends JpaRepository<Course, Long> {

}
