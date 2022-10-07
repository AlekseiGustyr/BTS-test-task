package com.task.btstest.mapper.impl;

import com.task.btstest.dto.ResumeDto;
import com.task.btstest.mapper.ResumeMapper;
import com.task.btstest.model.Resume;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Маппер объектов из dto к сущности и обратно
 */
@Component
public class ResumeMapperImpl implements ResumeMapper {
    @Override
    public Resume toResume(ResumeDto resumeDto) {
        Resume resume = new Resume();
        resume.setName(resumeDto.getName());
        resume.setPreviousJob(resumeDto.getPreviousJob());
        resume.setPosition(resumeDto.getPosition());
        resume.setSalary(resumeDto.getSalary());
        resume.setTechLevel(resumeDto.getTechLevel());
        resume.setTechnologyStack(resumeDto.getTechnologyStack());
        resume.setSummary(resumeDto.getSummary());
        resume.setStatus(resumeDto.getStatus());
        return resume;
    }

    @Override
    public ResumeDto toDto(Resume resume) {
        ResumeDto resumeDto = new ResumeDto();
        resumeDto.setName(resume.getName());
        resumeDto.setPreviousJob(resume.getPreviousJob());
        resumeDto.setPosition(resume.getPosition());
        resumeDto.setSalary(resume.getSalary());
        resumeDto.setTechLevel(resume.getTechLevel());
        resumeDto.setTechnologyStack(resume.getTechnologyStack());
        resumeDto.setSummary(resume.getSummary());
        resumeDto.setStatus(resume.getStatus());
        return resumeDto;
    }

    public List<ResumeDto> toResumeList (List<Resume> resumes){

      List<ResumeDto> resumeDtos = new ArrayList<>();
        for (Resume resume:
             resumes) {
            resumeDtos.add(toDto(resume));
        }
       return resumeDtos;
    }
}
