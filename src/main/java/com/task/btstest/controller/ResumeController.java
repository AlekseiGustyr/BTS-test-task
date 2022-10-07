package com.task.btstest.controller;

import com.task.btstest.dto.ResumeDto;
import com.task.btstest.mapper.ResumeMapper;
import com.task.btstest.model.Technologies;
import com.task.btstest.service.ResumeService;
import com.task.btstest.service.TechnologiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-контроллер, обрабатывающий запросы поступающие от клиента.
 */
@Controller
@RequestMapping("/resumes")
public class ResumeController {

    private final ResumeService resumeService;
    private final ResumeMapper resumeMapper;
    private final TechnologiesService technologiesService;

    @Autowired
    public ResumeController(ResumeService resumeService,
                            ResumeMapper resumeMapper, TechnologiesService technologiesService) {
        this.resumeService = resumeService;
        this.resumeMapper = resumeMapper;
        this.technologiesService = technologiesService;
    }

    /**
     * @param model
     * @return Название html страницы
     * Метод возвращает название html страницы, которая будет отображена в браузере при GET запросе
     */
    @GetMapping("/new")
    public String showResumeForm(Model model) {
        model.addAttribute("resumeDto", new ResumeDto());
        ArrayList<Technologies> technologies;
        technologies = technologiesService.getAllTechnologies();
        model.addAttribute("technologies", technologies);
        return "Resume_Form";
    }

    @PostMapping
    public String createNewResume(@ModelAttribute ResumeDto resumeDto,
                                   @ModelAttribute(value = "technologies") ArrayList<Technologies> technologies,
                                   Model model) {
        resumeService.addNewResume(resumeMapper.toResume(resumeDto), technologies);
        return "Candidates";
    }

    @GetMapping
    public String resumeList(Model model){
        List<ResumeDto> resumes = resumeMapper.toResumeList(resumeService.findAll());
        model.addAttribute("resumes", resumes);
        return "Candidates";
    }

    @GetMapping("/firstCategory")
    public String firstCategoryResumes(Model model){
        List<ResumeDto> resumes = resumeMapper.toResumeList(resumeService.findAllByStatus("Первая очередность"));
        model.addAttribute("resumes", resumes);
        return "Candidates";
    }

    @GetMapping("/secondCategory")
    public String secondCategoryResumes(Model model){
        List<ResumeDto> resumes = resumeMapper.toResumeList(resumeService.findAllByStatus("Вторая очередность"));
        model.addAttribute("resumes", resumes);
        return "Candidates";
    }

    @GetMapping("/thirdCategory")
    public String thirdCategoryResumes(Model model){
        List<ResumeDto> resumes = resumeMapper.toResumeList(resumeService.findAllByStatus("Третяя очередность"));
        model.addAttribute("resumes", resumes);
        return "Candidates";
    }

}
