package com.groom.seasonthon.service;

import com.groom.seasonthon.dto.ApplicationCreateDto;
import com.groom.seasonthon.dto.ApplicationDto;
import com.groom.seasonthon.entity.Application;
import com.groom.seasonthon.entity.Job;
import com.groom.seasonthon.repository.ApplicationRepository;
import com.groom.seasonthon.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final JobRepository jobRepository;

    @Transactional
    public ApplicationDto applyToJob(Long jobId, ApplicationCreateDto createDto) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + jobId));

        if (!createDto.isPolicyChecked()) {
            throw new IllegalArgumentException("취소/패널티 정책을 확인해야 합니다.");
        }

        Application newApplication = new Application();
        newApplication.setJob(job);
        newApplication.setApplicantName(createDto.getApplicantName());
        newApplication.setContact(createDto.getContact());
        newApplication.setPolicyChecked(createDto.isPolicyChecked());

        Application savedApplication = applicationRepository.save(newApplication);

        return new ApplicationDto(savedApplication);
    }
}