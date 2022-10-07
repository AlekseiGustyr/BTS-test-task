package com.task.btstest.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
