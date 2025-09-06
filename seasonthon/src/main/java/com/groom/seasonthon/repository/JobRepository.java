package com.groom.seasonthon.repository;

import com.groom.seasonthon.dto.job.JobCreateDto;
import com.groom.seasonthon.dto.job.JobDetailDto;
import com.groom.seasonthon.dto.job.JobListDto;

import java.util.List;

public interface JobRepository {
  JobCreateDto save(JobCreateDto job);
  void delete(Long id);
  JobDetailDto findById(Long id);
  List<JobListDto> findAll();
  //추후 업데이트 기능 추가
  void clearStore();  // 저장소 비우기
}