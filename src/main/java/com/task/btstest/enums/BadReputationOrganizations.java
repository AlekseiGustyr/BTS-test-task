package com.task.btstest.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Организации с плохой репутацией
 */
@Getter
@RequiredArgsConstructor
public enum BadReputationOrganizations {

    EPAM("ЭпамСистемз"),
    IsSoft("ИзСофт"),
    Gaz("Газоаппарат"),
    MTZ("МТЗ"),
    MTS("МТС"),
    A1("А1"),
    BrSTU("БрГТУ"),
    Korona("Корона"),
    Exadel("Экзадель"),
    Senla("СЕНЛА"),
    Godel("Годель");


    private final String badReputationOrganization;
}

