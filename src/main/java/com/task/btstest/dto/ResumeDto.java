package com.task.btstest.dto;

import com.task.btstest.model.Technologies;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
public class ResumeDto {

    private String name; //ФИО кандидата

    private String previousJob; //Предыдущее место работы

    private String position; //Желаемая должность

    private String techLevel; //Уровень навыков

    private BigDecimal salary; //Желаемый уровень ЗП

    private String summary; // Рассказ о себе

    private String status; // статус резюме

    private List<Technologies> technologyStack = new ArrayList<>();
}
