package com.task.btstest.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//Список кандидатов с плохой репутацией
@Getter
@RequiredArgsConstructor
public enum BadReputationCandidates {

    first("Иванов Иван Иванович"),
    second("Артеменко Дмитрий Олегович"),
    third("Кривенко Андрей Петрович"),
    fourth("Качук Марина Андреевна"),
    fifth("Федосюк Иван Петрович"),
    sixth("Павлов Игорь Геннадиевич"),
    seventh("Якушев Валерий Альбертович"),
    eighth("Пупкин Артемий Алексеевич"),
    ninth("Гребенков Михаил Сергеевич"),
    tenth("Марков Игорь Петрович");

    private final String badReputationCandidate;
}
