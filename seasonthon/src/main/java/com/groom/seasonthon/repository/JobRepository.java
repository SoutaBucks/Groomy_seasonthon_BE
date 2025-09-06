package com.groom.seasonthon.repository;

import com.groom.seasonthon.dto.JobWithHotelCreateDto;
import com.groom.seasonthon.dto.JobWithHotelDetailDto;
import com.groom.seasonthon.dto.JobWithHotelListDto;


import java.util.List;

public interface JobRepository {
  JobWithHotelCreateDto save(JobWithHotelCreateDto job);
  List<JobWithHotelListDto> findAll();
  JobWithHotelDetailDto findbyId(Long id);
  //추후 업데이트 기능 추가
  void clearStore();  // 저장소 비우기
}