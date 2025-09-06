package com.groom.seasonthon.dto;

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
public class ApplicationDto {
    private Long id;
    private Long jobId;
    private String applicantName;
    private String contact;
    private boolean policyChecked;
    private String status;
    private LocalDateTime createdAt;

    // 기본 생성자는 @NoArgsConstructor로 처리
    // 모든 필드 생성자는 @AllArgsConstructor로 처리

    // 필요시 커스텀 생성자 추가 (선택사항)
    public ApplicationDto(Long id, Long jobId, String applicantName, String contact,
                          boolean policyChecked, String status, LocalDateTime createdAt) {
        this.id = id;
        this.jobId = jobId;
        this.applicantName = applicantName;
        this.contact = contact;
        this.policyChecked = policyChecked;
        this.status = status;
        this.createdAt = createdAt;
    }
}
