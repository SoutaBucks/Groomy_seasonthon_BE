package com.groom.seasonthon.dto;

import com.groom.seasonthon.entity.Application;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class ApplicationDto {
    private final Long id;
    private final String applicantName;
    private final String contact;
    private final String status;
    private final LocalDateTime createdAt;
    private final Long jobId;

    public ApplicationDto(Application application) {
        this.id = application.getId();
        this.applicantName = application.getApplicantName();
        this.contact = application.getContact();
        this.status = application.getStatus();
        this.createdAt = application.getCreatedAt();
        this.jobId = application.getJob().getId();
    }
}