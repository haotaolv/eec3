package com.eec.repository;

import com.eec.model.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2015/3/16.
 */
public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {
//    public ContentEntity save(ContentEntity contentEntity);
}
