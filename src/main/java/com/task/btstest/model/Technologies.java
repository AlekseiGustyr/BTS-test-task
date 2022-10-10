package com.task.btstest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


//Класс представляющий таблицу  technologies в бд в виде класса
@Entity
@Table(name = "technologies")
@Getter
@Setter
@AllArgsConstructor
public class Technologies implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "technology")
    private String technology;

    public Technologies() {

    }
}
