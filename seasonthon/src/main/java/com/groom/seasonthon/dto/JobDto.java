package com.groom.seasonthon.dto;

import com.groom.seasonthon.entity.Job;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class JobDto {
    private final Long id;
    private final String employerName;
    private final String title;
    private final String description;
    private final int requiredPeople;
    private final LocalDate deadline;

    public JobDto(Job job) {
        this.id = job.getId();
        this.employerName = job.getEmployerName();
        this.title = job.getTitle();
        this.description = job.getDescription();
        this.requiredPeople = job.getRequiredPeople();
        this.deadline = job.getDeadline();
    }
}