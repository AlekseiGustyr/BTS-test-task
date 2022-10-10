package com.task.btstest.dao.repository;

import com.task.btstest.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Класс-репозиторий для формирования запросов к бд, для резюме
@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    @Query(value = "select distinct r from Resume r join Technologies t on r.id = t.id")
    List<Resume> findAllResumes(); // получение списка всех резюме

    List<Resume> findAllByStatus(String status); // поиск резюме по категории


}
