package com.task.btstest.controller;

import com.task.btstest.model.Resume;
import com.task.btstest.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Класс-контроллер, обрабатывающий запросы поступающие от клиента.
 */
@Controller
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    /**
     *
     * @param model
     * @return Название html страницы
     * Метод возвращает название html страницы, которая будет отображена в браузере при GET запросе
     */
    @GetMapping
    public String showResumeForm(Model model){
        model.addAttribute("resume", new Resume());
        return "Resume_Form";
    }

    @PostMapping
    @ResponseBody
    public String submitResumeForm(@ModelAttribute Resume resume,Model model){
        resumeService.addNewResume(resume);
        return "shit";
    }

}
