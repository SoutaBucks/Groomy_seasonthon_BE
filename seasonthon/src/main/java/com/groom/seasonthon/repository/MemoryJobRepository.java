package com.groom.seasonthon.repository;

import com.groom.seasonthon.dto.job.JobCreateDto;
import com.groom.seasonthon.dto.job.JobDetailDto;
import com.groom.seasonthon.dto.job.JobListDto;
import com.groom.seasonthon.entity.Job;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryJobRepository implements JobRepository {

  private static final Map<Long, JobCreateDto> storage = new HashMap<>();
  private static long sequence = 0L;

  @Override
  public JobCreateDto save(JobCreateDto job) {
    job.setId(++sequence);
    storage.put(job.getId(), job);
    return job;
  }

  @Override
  public void delete(Long id) {
    storage.remove(id);
  }

  @Override
  public JobDetailDto findById(Long id) {
    JobCreateDto findJob = storage.get(id);

  }

  @Override
  public List<JobListDto> findAll() {
    return List.of();
  }

  @Override
  public void clearStore() {

  }
}
