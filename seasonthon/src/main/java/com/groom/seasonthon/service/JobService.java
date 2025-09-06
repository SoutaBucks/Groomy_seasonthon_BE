package com.groom.seasonthon.service;

import com.groom.seasonthon.dto.JobWithHotelCreateDto;
import com.groom.seasonthon.dto.JobWithHotelDetailDto;
import com.groom.seasonthon.dto.JobWithHotelListDto;

import java.util.List;

public interface JobService {
  JobWithHotelCreateDto upload(JobWithHotelCreateDto job);
  Boolean delete(Long id);
  JobWithHotelDetailDto findJobById(Long id);
  List<JobWithHotelListDto> findJobListById(Long id);
  //void update(JobWithHotelUpdateDto job);
}
