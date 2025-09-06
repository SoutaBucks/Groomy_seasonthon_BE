package com.groom.seasonthon.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Application {
    private Long id;
    private Long jobId; // Job 엔티티 대신 Job의 ID만 저장
    private String applicantName;
    private String contact;
    private boolean policyChecked;
    private String status;
    private LocalDateTime createdAt;

    public Application(Long id, Long jobId, String applicantName, String contact, boolean policyChecked) {
        this.id = id;
        this.jobId = jobId;
        this.applicantName = applicantName;
        this.contact = contact;
        this.policyChecked = policyChecked;
        this.status = "APPLIED";
        this.createdAt = LocalDateTime.now();
    }
}
