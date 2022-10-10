package com.task.btstest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//Класс представляющий таблицу  resumes в бд в виде класса
@Entity
@Table(name = "resumes")
@Setter
@Getter
@NoArgsConstructor
public class Resume implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; //id кандидата, присваивается автоматически

    @Column(name = "name")
    private String name; //ФИО кандидата

    @Column(name = "previous_job")
    private String previousJob; //Предыдущее место работы

    @Column(name = "position")
    private String position; //Желаемая должность

    @Column(name = "tech_level")
    private String techLevel; //Уровень навыков

    @Column(name = "salary")
    private BigDecimal salary; //Желаемый уровень ЗП

    @Column(name = "summary")
    private String summary; // Рассказ о себе

    @Column(name = "status")
    private String status; // статус резюме

    @Column(name = "decision")
    private String decision; //принятое решение по кандидату

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "resume_technologies",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private List<Technologies> technologyStack = new ArrayList<>(); //Стэк технологий

}
