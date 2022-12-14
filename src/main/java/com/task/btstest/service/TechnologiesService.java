package com.task.btstest.service;

import com.task.btstest.dao.repository.TechnologiesRepository;
import com.task.btstest.model.Technologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TechnologiesService {

    private final TechnologiesRepository technologiesRepository;

    @Autowired
    public TechnologiesService(TechnologiesRepository technologiesRepository) {
        this.technologiesRepository = technologiesRepository;
    }

    // Получение списка технологий
    public ArrayList<Technologies> getAllTechnologies() {
        return (ArrayList<Technologies>) technologiesRepository.findAll();
    }
}
