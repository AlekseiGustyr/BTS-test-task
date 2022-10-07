package com.task.btstest.dao.repository;

import com.task.btstest.model.Technologies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TechnologiesRepository extends JpaRepository<Technologies,Long> {

}
