package com.task.btstest.mapper.impl;

import com.task.btstest.dto.ResumeDto;
import com.task.btstest.mapper.ResumeMapper;
import com.task.btstest.model.Resume;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Реализация маппера объектов из Dto Обхектов и обратно
@Component
public class ResumeMapperImpl implements ResumeMapper {

    //Маппинг из Dto к сущности
    @Override
    public Resume toResume(ResumeDto resumeDto) {
        Resume resume = new Resume();
        resume.setId(resumeDto.getId());
        resume.setName(resumeDto.getName());
        resume.setPreviousJob(resumeDto.getPreviousJob());
        resume.setPosition(resumeDto.getPosition());
        resume.setSalary(resumeDto.getSalary());
        resume.setTechLevel(resumeDto.getTechLevel());
        resume.setTechnologyStack(resumeDto.getTechnologyStack());
        resume.setSummary(resumeDto.getSummary());
        resume.setStatus(resumeDto.getStatus());
        resume.setDecision(resumeDto.getDecision());
        return resume;
    }

    //Маппинг из сущности к Dto
    @Override
    public ResumeDto toDto(Resume resume) {
        ResumeDto resumeDto = new ResumeDto();
        resumeDto.setId(resume.getId());
        resumeDto.setName(resume.getName());
        resumeDto.setPreviousJob(resume.getPreviousJob());
        resumeDto.setPosition(resume.getPosition());
        resumeDto.setSalary(resume.getSalary());
        resumeDto.setTechLevel(resume.getTechLevel());
        resumeDto.setTechnologyStack(resume.getTechnologyStack());
        resumeDto.setSummary(resume.getSummary());
        resumeDto.setStatus(resume.getStatus());
        resumeDto.setDecision(resume.getDecision());
        return resumeDto;
    }

    //Маппинг списка из сущности к Dto
    public List<ResumeDto> toResumeList(List<Resume> resumes) {

        List<ResumeDto> resumeDto = new ArrayList<>();
        for (Resume resume :
                resumes) {
            resumeDto.add(toDto(resume)); // вызов метода toDto для каждого элемента списка
        }
        return resumeDto;
    }
}
