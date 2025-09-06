package com.groom.seasonthon.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class JobCreateDto {
    private String employerName;
    private String title;
    private String description;
    private int requiredPeople;
    private LocalDate deadline;
}