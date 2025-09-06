package com.groom.seasonthon.controller;

import com.groom.seasonthon.dto.JobWithHotelCreateDto;
import com.groom.seasonthon.dto.JobWithHotelDetailDto;
import com.groom.seasonthon.dto.JobWithHotelListDto;
import com.groom.seasonthon.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8000")
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


  //1단계 공고 등록 (기본 정보 등록)
  @PostMapping("/draft")
  public JobWithHotelCreateDto createJob(@RequestBody JobWithHotelCreateDto job) {
    log.info("공고 초안 등록: {}", job.getJobName());
    return jobRepository.save(job);
  }

  // 2단계 공고 등록 (숙소 정보 추가)
  @PutMapping("/{id}/hotel")
  @CrossOrigin(origins = "http://localhost:8000")
  public JobWithHotelCreateDto addHotelInfo(@PathVariable Long id,
                                            @RequestBody JobWithHotelCreateDto hotelInfo) {
    log.info("숙소 정보 추가: {}", hotelInfo.getJobName());

    //숙소 정보 추가
    JobWithHotelCreateDto unfinishedJob = jobRepository.findUnfinishedJobById(id);
    if (unfinishedJob == null) {
      log.warn("공고 등록 중이 아닙니다!!");
      throw new RuntimeException("공고 등록 중 아닙");
    }
    try {
      unfinishedJob.setHotelType(hotelInfo.getHotelType());
      unfinishedJob.setCanSmoke(hotelInfo.getCanSmoke());
      unfinishedJob.setWantBreakFast(hotelInfo.getWantBreakFast());
      unfinishedJob.setHotelRules(hotelInfo.getHotelRules());
      unfinishedJob.setHotelPrice(hotelInfo.getHotelPrice());
    } catch (Exception e) {
      jobRepository.save(unfinishedJob);
      throw new RuntimeException();
    }
    return jobRepository.save(unfinishedJob);
  }

  //
  //@PutMapping("/{id}")      // 공고 수정

  //
  //@DeleteMapping("/{id}")   // 공고 삭제
}

