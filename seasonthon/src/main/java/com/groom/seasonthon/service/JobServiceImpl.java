package com.groom.seasonthon.service;

import com.groom.seasonthon.dto.JobWithHotelCreateDto;
import com.groom.seasonthon.dto.JobWithHotelDetailDto;
import com.groom.seasonthon.dto.JobWithHotelListDto;
import com.groom.seasonthon.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobServiceImpl implements JobService{

  private final JobRepository jobRepository;

  public JobServiceImpl(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
  }

  @Override
  public JobWithHotelCreateDto upload(JobWithHotelCreateDto job) {
    jobRepository.save(job);
    return job;
  }

  @Override
  public Boolean delete(Long id) {
    if(jobRepository.findbyId(id) != null) {
      jobRepository.delete(id);
      return true;
    } else
      return false;
  }

  @Override
  public JobWithHotelDetailDto findJobById(Long id) {
    return jobRepository.findbyId(id);
  }

  @Override
  public List<JobWithHotelListDto> findJobListById(Long id) {
    return jobRepository.findAll();
  }
}
