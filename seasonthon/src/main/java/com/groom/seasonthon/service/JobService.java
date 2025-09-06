package com.groom.seasonthon.service;

import com.groom.seasonthon.dto.JobCreateDto;
import com.groom.seasonthon.dto.JobDto;
import com.groom.seasonthon.entity.Job;
import com.groom.seasonthon.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    @Transactional
    public JobDto createJob(JobCreateDto createDto) {
        Job job = new Job();
        job.setEmployerName(createDto.getEmployerName());
        job.setTitle(createDto.getTitle());
        job.setDescription(createDto.getDescription());
        job.setRequiredPeople(createDto.getRequiredPeople());
        job.setDeadline(createDto.getDeadline());

        Job savedJob = jobRepository.save(job);
        return new JobDto(savedJob);
    }
}