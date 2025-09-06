package com.groom.seasonthon.service;

import com.groom.seasonthon.dto.ApplicationCreateDto;
import com.groom.seasonthon.dto.ApplicationDto;
import com.groom.seasonthon.entity.Application;
import com.groom.seasonthon.entity.Job;
import com.groom.seasonthon.exception.JobNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final JobService jobService;
    private final ConcurrentHashMap<Long, Application> applications = new ConcurrentHashMap<>();
    private final AtomicLong applicationIdGenerator = new AtomicLong(1);

    public ApplicationDto applyToJob(Long jobId, ApplicationCreateDto createDto) {
        // Job 존재 확인
        Job job = jobService.getJobById(jobId);
        if (job == null) {
            throw new JobNotFoundException("Job not found with id: " + jobId);
        }

        // 새로운 Application 생성
        Application application = Application.builder()
                .id(applicationIdGenerator.getAndIncrement())
                .jobId(jobId)
                .applicantName(createDto.getApplicantName())
                .email(createDto.getEmail())
                .phoneNumber(createDto.getPhoneNumber())
                .coverLetter(createDto.getCoverLetter())
                .appliedAt(LocalDateTime.now())
                .build();

        // 메모리에 저장
        applications.put(application.getId(), application);

        // DTO로 변환하여 반환
        return convertToDto(application, job);
    }

    public ApplicationDto getApplication(Long applicationId) {
        Application application = applications.get(applicationId);
        if (application == null) {
            throw new RuntimeException("Application not found with id: " + applicationId);
        }

        Job job = jobService.getJobById(application.getJobId());
        return convertToDto(application, job);
    }

    private ApplicationDto convertToDto(Application application, Job job) {
        return ApplicationDto.builder()
                .id(application.getId())
                .jobId(application.getJobId())
                .jobTitle(job.getTitle())
                .companyName(job.getCompanyName())
                .applicantName(application.getApplicantName())
                .email(application.getEmail())
                .phoneNumber(application.getPhoneNumber())
                .coverLetter(application.getCoverLetter())
                .appliedAt(application.getAppliedAt())
                .build();
    }
}
