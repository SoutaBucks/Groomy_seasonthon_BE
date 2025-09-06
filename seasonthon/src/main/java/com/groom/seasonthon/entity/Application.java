package com.groom.seasonthon.entity;
//
////import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import java.time.LocalDateTime;
//
////@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//public class Application {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "job_id")
//    private Job job;
//
//    // User 엔티티가 없으므로 지원자 정보를 직접 저장합니다.
//    @Column(nullable = false)
//    private String applicantName;
//
//    @Column(nullable = false)
//    private String contact;
//
//    @Column(nullable = false)
//    private boolean policyChecked;
//
//    private String status;
//
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//
//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//        this.status = "APPLIED"; // 지원 시 초기 상태
//    }
//}