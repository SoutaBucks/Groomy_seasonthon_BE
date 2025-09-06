package com.groom.seasonthon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    private Long id;
    private Long jobId; // Job 엔티티 대신 Job의 ID만 저장
    private String applicantName;
    private String contact;
    private boolean policyChecked;
    private String status;
    private LocalDateTime createdAt;

    // 커스텀 생성자 - 새 지원서 생성용
    public Application(Long jobId, String applicantName, String contact, boolean policyChecked) {
        this.jobId = jobId;
        this.applicantName = applicantName;
        this.contact = contact;
        this.policyChecked = policyChecked;
        this.status = "APPLIED";
        this.createdAt = LocalDateTime.now();
    }

    // ID가 있는 커스텀 생성자 - 기존 지원서 복원용
    public Application(Long id, Long jobId, String applicantName, String contact, boolean policyChecked) {
        this.id = id;
        this.jobId = jobId;
        this.applicantName = applicantName;
        this.contact = contact;
        this.policyChecked = policyChecked;
        this.status = "APPLIED";
        this.createdAt = LocalDateTime.now();
    }

    // 상태 업데이트 메서드
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    // 지원서 유효성 검사
    public boolean isValid() {
        return applicantName != null && !applicantName.trim().isEmpty()
                && contact != null && !contact.trim().isEmpty()
                && policyChecked
                && jobId != null;
    }
}
