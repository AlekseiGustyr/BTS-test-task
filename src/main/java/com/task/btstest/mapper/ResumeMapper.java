package com.task.btstest.mapper;

import com.task.btstest.dto.ResumeDto;
import com.task.btstest.model.Resume;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ResumeMapper {

    Resume toResume (ResumeDto resumeDto);

    ResumeDto toDto (Resume resume);

    public List<ResumeDto> toResumeList (List<Resume> resumes);
}
