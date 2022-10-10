package com.task.btstest.service;

import com.task.btstest.dao.repository.ResumeRepository;
import com.task.btstest.enums.BadReputationCandidates;
import com.task.btstest.enums.BadReputationOrganizations;
import com.task.btstest.model.Resume;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//Класс в котором реализуется основная бизнес-логика
@Service
@Transactional
public class ResumeService {

    private static final Logger LOG = LoggerFactory.getLogger(ResumeService.class);
    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    //Создание нового резюме
    public void addNewResume(Resume resume) {

        // Категоризация резюме
        if (badReputationCandidateCheck(resume)) { // Проверка на наличие кандидата в списке ФИО с плохой репутацией
            resume.setStatus("Отказ в принятии резюме");
        } else if (firstCategoryCheck(resume)) { // Проверка на принадлежность к первой категории
            resume.setStatus("Первая очередность");
        } else if (secondCategoryCheck(resume)) { // Проверка на принадлежность к второй категории
            resume.setStatus("Вторая очередность");
        } else if (thirdCategoryCheck(resume)) { // Проверка на принадлежность к третьей категории
            resume.setStatus("Третяя очередность");
        } else {
            resume.setStatus("Необходим пересмотр");
        }
        resumeRepository.save(resume); // сохранение резюме в бд
        LOG.info("Создано новое резюме");
    }

    public boolean firstCategoryCheck(Resume resume) {
        if (resume.getSalary().intValue() >= 1000 && resume.getSalary().intValue() <= 2000
                && resume.getTechLevel().equals("Middle") && resume.getTechnologyStack().size() >= 7 &&
                !badReputationOrganizationCheck(resume)) {
            return true;
        } else {
            return false;
        }
    }


    public boolean secondCategoryCheck(Resume resume) {
        if (resume.getSalary().intValue() <= 999 || (resume.getSalary().intValue() >= 2001
                && resume.getSalary().intValue() <= 3000) &&
                (resume.getTechLevel().equals("Junior") || resume.getTechLevel().equals("Senior")) &&
                resume.getTechnologyStack().size() <= 6 && !badReputationOrganizationCheck(resume)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean thirdCategoryCheck(Resume resume) {
        return resume.getSalary().intValue() >= 3001;
    }

    public boolean badReputationCandidateCheck(Resume resume) {
        for (BadReputationCandidates candidate : BadReputationCandidates.values()) {
            if (candidate.getBadReputationCandidate().equals(resume.getName())) {
                return true;
            }
        }
        return false;
    }

    // Проверка на наличие в списке организаций с плохой репутацией
    public boolean badReputationOrganizationCheck(Resume resume) {
        for (BadReputationOrganizations organization : BadReputationOrganizations.values()) {
            if (organization.getBadReputationOrganization().equals(resume.getPreviousJob())) {
                return true;
            }
        }
        return false;
    }

    // Получение списка всех резюме из бд
    public List<Resume> findAll() {
        return resumeRepository.findAllResumes();
    }

    // Получение списка резюме определенной категории
    public List<Resume> findAllByStatus(String status) {
        return resumeRepository.findAllByStatus(status);
    }

    // Посик резюме по id
    public Resume findById(Long id) {
        return resumeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Кандидата с id=" + id + "нет")); // в случае отсутствия резюме с указаным id выбрасывается исключение
    }

    //Сохранение принятого решения
    public void makeDecision(Long id, String decision) {
        Resume resume = findById(id);
        resume.setDecision(decision);
        LOG.info("решение по кандидату" + resume.getName() + "принято");
        resumeRepository.save(resume);
    }

}
