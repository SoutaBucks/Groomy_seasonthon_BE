package com.groom.seasonthon.repository;

import com.groom.seasonthon.dto.JobWithHotelCreateDto;
import com.groom.seasonthon.dto.JobWithHotelDetailDto;
import com.groom.seasonthon.dto.JobWithHotelListDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryJobRepository implements JobRepository {

  private static final Map<Long, JobWithHotelCreateDto> storage = new HashMap<>();
  private static long sequence = 0L;

  @Override
  public JobWithHotelCreateDto save(JobWithHotelCreateDto job) {
    job.setId(++sequence);
    storage.put(job.getId(), job);
    return job;
  }

  @Override
  public List<JobWithHotelListDto> findAll() {
    List<JobWithHotelListDto> jobs = new ArrayList<>();

    if(storage.isEmpty())
      return null;
    else {
      for(Map.Entry<Long, JobWithHotelCreateDto> entry : storage.entrySet()) {
        Long id = entry.getKey();
        JobWithHotelCreateDto job = entry.getValue();
        JobWithHotelListDto convertedJob = new JobWithHotelListDto(
            job.getCompanyName(), job.getJobName(), job.getPay(), job.getHotelName(), job.getDistance()
        );
        jobs.add(convertedJob);
      }
      return jobs;
    }
  }

  @Override
  public JobWithHotelDetailDto findbyId(Long id) {
    JobWithHotelCreateDto job = storage.get(id);
    if(job == null)
      return null;
    else {
      return new JobWithHotelDetailDto(
          job.getCompanyName(), job.getJobName(), job.getRecruitNumber(), job.getJobDate(),
          job.getJobDetail(), job.getJobLocation(), job.getPay(), job.getHotelName(), job.getDistance(), job.getHotelLocation()
      );
    }
  }

  @Override
  public void clearStore() {
    storage.clear();
  }
}
