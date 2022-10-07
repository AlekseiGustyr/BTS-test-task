package com.task.btstest.service;

import com.task.btstest.dao.repository.ResumeRepository;
import com.task.btstest.enums.BadReputationCandidates;
import com.task.btstest.enums.BadReputationOrganizations;
import com.task.btstest.model.Resume;
import com.task.btstest.model.Technologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }


    public void addNewResume(Resume resume, List<Technologies> technologies) {

        if(badReputationCandidateCheck(resume)){
            resume.setStatus("Отказ в принятии резюме");
        } else if (firstCategoryCheck(resume, technologies)) {
            resume.setStatus("Первая очередность");
        } else if (secondCategoryCheck(resume,technologies)) {
            resume.setStatus("Вторая очередность");
        } else if(thirdCategoryCheck(resume)){
            resume.setStatus("Третяя очередность");
        }else {
            resume.setStatus("Необходим пересмотр");
        }
        resumeRepository.save(resume);
    }

    /**
     * Метод для проверки принадлежности кандидата к первой очередности
     *
     * @return true - если кандидат принадлежит к первой очередности
     */
    public boolean firstCategoryCheck(Resume resume, List<Technologies> technologies) {
        if (resume.getSalary().intValue() >= 1000 && resume.getSalary().intValue() <= 2000
                && resume.getTechLevel().equals("Middle") && technologies.size() >= 7) {
            if (!badReputationOrganizationCheck(resume)) {
                return !badReputationCandidateCheck(resume);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Метод для проверки принадлежности кандидата ко второй очередности
     *
     * @param resume Резюме кандидата
     *
     * @param technologies Список технологий кандидата
     *
     * @return true - если кандидат принадлежит ко второй очередности
     */
    public boolean secondCategoryCheck(Resume resume, List<Technologies> technologies) {
        if (resume.getSalary().intValue() >= 2001 && resume.getSalary().intValue() <= 999
                && resume.getSalary().intValue() <= 3000 &&
                (resume.getTechLevel().equals("Junior") || resume.getTechLevel().equals("Senior")) &&
                technologies.size() <= 6) {
            if (badReputationOrganizationCheck(resume)) {
                return badReputationCandidateCheck(resume);
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    /**
     * Метод для проверки принадлежности кандидата к третьей категории
     * @param resume Резюме кандидата
     *
     * @return true - если кандидат подходит к категории
     *
     *
     */
    public boolean thirdCategoryCheck(Resume resume) {
        if (resume.getSalary().intValue() >= 3001) {
                return badReputationCandidateCheck(resume);
        } else {
            return false;
        }
    }

    /**
     * Метод ддя проверки на принадлежность к списку кандидатов с плохой репутацией
     */
    public boolean badReputationCandidateCheck(Resume resume) {
        for (BadReputationCandidates candidate : BadReputationCandidates.values()) {
            if(candidate.name().equals(resume.getName())){
                return true;
            }
        }
        return false;
    }

    /**
     * Метод ддя проверки на принадлежность к организации с плохой репутацией
     */
    public boolean badReputationOrganizationCheck(Resume resume) {
        for (BadReputationOrganizations organization : BadReputationOrganizations.values()) {
            if (organization.name().equals(resume.getPreviousJob())) {
                return true;
            }
        }
        return false;
    }

    public List<Resume> findAll(){
        return resumeRepository.findAllResumes();
    }

    public List<Resume> findAllByStatus(String status){
        return resumeRepository.findAllByStatus(status);
    }
}
