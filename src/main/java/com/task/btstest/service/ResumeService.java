package com.task.btstest.service;

import com.task.btstest.dao.repository.ResumeRepository;
import com.task.btstest.model.Resume;
import com.task.btstest.model.Technologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }


    public String addNewResume(Resume resume){
        List<Technologies> list = new ArrayList<>();
        resume.setTechnologyStack(list);
        resumeRepository.save(resume);
        return "Резюме добавлено";
    }
}
