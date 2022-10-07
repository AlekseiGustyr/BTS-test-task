package com.task.btstest.dao.repository;

import com.task.btstest.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Класс-репозиторий для сущности Resume
 */

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    @Query(value = "select distinct r from Resume r join Technologies t on r.id = t.id")
    List<Resume> findAllResumes();

    List<Resume> findAllByStatus(String status);


}
