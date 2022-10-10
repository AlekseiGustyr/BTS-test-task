package com.task.btstest.dao.repository;

import com.task.btstest.model.Technologies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Класс-репозиторий для формирования запросов к бд, для технологий
@Repository
public interface TechnologiesRepository extends JpaRepository<Technologies, Long> {

}
