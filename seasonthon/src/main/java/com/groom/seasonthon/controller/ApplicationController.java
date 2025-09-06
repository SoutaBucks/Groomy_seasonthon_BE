package com.groom.seasonthon.controller;

import com.groom.seasonthon.dto.ApplicationCreateDto;
import com.groom.seasonthon.dto.ApplicationDto;
//import com.groom.seasonthon.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api")
//public class ApplicationController {
//
//    private final ApplicationService applicationService;
//
//    //@PostMapping("/jobs/{jobId}/apply")
//    public ResponseEntity<ApplicationDto> apply(
//            @PathVariable Long jobId,
//            @RequestBody ApplicationCreateDto createDto) {
//
//        ApplicationDto applicationDto = applicationService.applyToJob(jobId, createDto);
//
//        // 생성된 지원 정보의 URI와 함께 201 Created 응답 반환
//        return ResponseEntity.created(URI.create("/api/applications/" + applicationDto.getId()))
//                .body(applicationDto);
//    }
//}