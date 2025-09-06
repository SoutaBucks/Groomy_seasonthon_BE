package com.groom.seasonthon.controller;

import com.groom.seasonthon.dto.JobCreateDto;
import com.groom.seasonthon.dto.JobDto;
import com.groom.seasonthon.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    @PostMapping
    public ResponseEntity<JobDto> createJob(@RequestBody JobCreateDto createDto) {
        JobDto createdJob = jobService.createJob(createDto);
        return ResponseEntity.created(URI.create("/api/jobs/" + createdJob.getId()))
                .body(createdJob);
    }
}