package com.groom.seasonthon.controller;

import com.groom.seasonthon.dto.JobWithHotelCreateDto;
import com.groom.seasonthon.dto.JobWithHotelDetailDto;
import com.groom.seasonthon.dto.JobWithHotelListDto;
import com.groom.seasonthon.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobController {

  private final JobRepository jobRepository;

  // 메인 화면에 사용할 공고 전체 목록을 받아옵니다
  @GetMapping("")
  public List<JobWithHotelListDto> getJobList() {
    log.info("공고 목록 조회 요청");
    return jobRepository.findAll();
  }

  // 아무 공고를 눌렀을 때 세부 내용을 얻고 싶어요
  @GetMapping("/{id}")
  public JobWithHotelDetailDto getJobDetail(@PathVariable Long id) {
    log.info("공고 세부 사항 요청");
    JobWithHotelDetailDto job = jobRepository.findbyId(id);

    if (job == null) {
      log.warn("공고를 찾을 수 없습니다. ID {}", id);
      throw new RuntimeException("공고를 찾을 수 없습니다");
    }

    return job;
  }

  // 공고 등록
  @PostMapping("")
  public JobWithHotelCreateDto createJob(@RequestBody JobWithHotelCreateDto job) {
    log.info("새 공고 등록");
    return jobRepository.save(job);
  }

  //
  //@PutMapping("/{id}")      // 공고 수정

  //
  //@DeleteMapping("/{id}")   // 공고 삭제
}

