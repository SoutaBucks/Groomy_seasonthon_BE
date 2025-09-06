package com.groom.seasonthon.service;

import com.groom.seasonthon.dto.ApplicationCreateDto;
import com.groom.seasonthon.dto.ApplicationDto; // ApplicationDto가 있다고 가정
//import com.groom.seasonthon.entity.Application;
import com.groom.seasonthon.dto.ApplicationDto;
import com.groom.seasonthon.entity.Application;
import com.groom.seasonthon.entity.Job;
import com.groom.seasonthon.repository.JobRepository;
import com.groom.seasonthon.repository.MemoryApplicationRepository; // 메모리 기반 Repository로 변경
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final MemoryApplicationRepository applicationRepository;
    private final JobRepository jobRepository; // Job 정보를 불러오는 로직은 JobRepository에 의존

    public ApplicationDto applyToJob(Long jobId, ApplicationCreateDto createDto) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + jobId));

        if (!createDto.isPolicyChecked()) {
            throw new IllegalArgumentException("취소/패널티 정책을 확인해야 합니다.");
        }

        // 새 Application 객체를 생성하고, ID를 직접 할당합니다.
        Application newApplication = new Application();
        newApplication.setJobId(job.getId()); // Job 엔티티 대신 ID를 저장합니다.
        newApplication.setApplicantName(createDto.getApplicantName());
        newApplication.setContact(createDto.getContact());
        newApplication.setPolicyChecked(createDto.isPolicyChecked());
        newApplication.setStatus("APPLIED");
        newApplication.setCreatedAt(LocalDateTime.now());

        // 메모리 저장소에 Application 객체를 저장합니다.
        Application savedApplication = applicationRepository.save(newApplication);

        return new ApplicationDto(savedApplication);
    }
}
