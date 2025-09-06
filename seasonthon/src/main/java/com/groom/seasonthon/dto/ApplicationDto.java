package com.groom.seasonthon.dto;

import com.groom.seasonthon.entity.Application;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class ApplicationDto {
    private Long id;
    private Long jobId;
    private String applicantName;
    private String contact;
    private boolean policyChecked;
    private String status;
    private LocalDateTime createdAt;

    // Application 엔티티를 DTO로 변환하는 생성자 추가
    public ApplicationDto(Application application) {
        this.id = application.getId();
        this.jobId = application.getJobId();
        this.applicantName = application.getApplicantName();
        this.contact = application.getContact();
        this.policyChecked = application.isPolicyChecked();
        this.status = application.getStatus();
        this.createdAt = application.getCreatedAt();
    }
}