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

// Контроллер, обрабатывающий запросы, связанные с резюме
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

    //Обработка Get запроса на получение формы для заполнения
    @GetMapping("/new")
    public String showResumeForm(Model model) {
        model.addAttribute("resumeDto", new ResumeDto());
        ArrayList<Technologies> technologies;
        technologies = technologiesService.getAllTechnologies();//получение списка технологий из бд
        model.addAttribute("technologies", technologies);
        return "Resume_Form";//название отображаемой страницы, находящейся в templates
    }

    //Обработка Post запроса для сохранения нового резюме
    @PostMapping
    public String createNewResume(@ModelAttribute ResumeDto resumeDto) {
        resumeService.addNewResume(resumeMapper.toResume(resumeDto));// создание нового резюме
        return "redirect:/resumes";
    }

    //Обработка Get запроса, и отображение списка всех резюме
    @GetMapping
    public String resumeList(Model model) {
        List<ResumeDto> resumes = resumeMapper.toResumeList(resumeService.findAll());// получение списка всех резюме из бд
        model.addAttribute("resumes", resumes);
        return "Candidates";
    }

    //Отображение кандидатов первой очередности
    @GetMapping("/firstCategory")
    public String firstCategoryResumes(Model model) {
        List<ResumeDto> resumes = resumeMapper.toResumeList(resumeService.findAllByStatus("Первая очередность"));
        model.addAttribute("resumes", resumes);
        return "Candidates";
    }

    //Отображение кандидатов второй очередности
    @GetMapping("/secondCategory")
    public String secondCategoryResumes(Model model) {
        List<ResumeDto> resumes = resumeMapper.toResumeList(resumeService.findAllByStatus("Вторая очередность"));
        model.addAttribute("resumes", resumes);
        return "Candidates";
    }

    //Отображение кандидатов третьей очередности
    @GetMapping("/thirdCategory")
    public String thirdCategoryResumes(Model model) {
        List<ResumeDto> resumes = resumeMapper.toResumeList(resumeService.findAllByStatus("Третяя очередность"));
        model.addAttribute("resumes", resumes);
        return "Candidates";
    }

    //Отображение кандидата с определенным id, указаным в url
    @GetMapping("/{id}")
    public String simpleResume(@PathVariable Long id, Model model) {
        model.addAttribute("resume", resumeMapper.toDto(resumeService.findById(id)));
        return "Single_resume";
    }

    //Сохранение принятого решения
    @PostMapping("/{id}")
    public String makeDecision(@ModelAttribute ResumeDto resumeDto, Model model) {
        resumeService.makeDecision(resumeDto.getId(), resumeDto.getDecision());
        model.addAttribute("resume", resumeDto);
        return "redirect:/resumes";
    }
}
