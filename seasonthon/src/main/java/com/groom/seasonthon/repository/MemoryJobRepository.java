package com.groom.seasonthon.repository;

import com.groom.seasonthon.dto.JobWithHotelCreateDto;
import com.groom.seasonthon.dto.JobWithHotelDetailDto;
import com.groom.seasonthon.dto.JobWithHotelListDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
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
                job.getId(), job.getCompanyName(), job.getJobName(), job.getPay(), job.getCategory(), job.getWageType(), job.getWorktime(), job.getJobLocation(), job.getJobLocationDetail(),
                job.getJobStartDate(), job.getJobEndDate(), job.getHotelType(), job.getCanSmoke(), job.getWantBreakFast(), job.getHotelRules(), job.getHotelPrice()
        );
        jobs.add(convertedJob);
      }
      return jobs;
    }
  }

  @Override
  public JobWithHotelCreateDto findUnfinishedJobById(Long id) {
    return storage.remove(id);
  }

  @Override
  public JobWithHotelDetailDto findbyId(Long id) {
    JobWithHotelCreateDto job = storage.get(id);
    if(job == null)
      return null;
    else {
      return new JobWithHotelDetailDto(
          job.getId(), job.getCompanyName(), job.getJobName(), job.getRecruitNumber(), job.getJobStartDate(), job.getJobEndDate(), job.getJobLocation(), job.getJobLocationDetail(),
          job.getPay(), job.getBenefits(), job.getWageType(), job.getWorktime(), job.getHotelType(), job.getCanSmoke(), job.getWantBreakFast(), job.getHotelRules(), job.getHotelPrice()
      );
    }
  }

  @Override
  public Boolean delete(Long id) {
    if(storage.containsKey(id)) {
      storage.remove(id);
      return true;
    } else
      return false;
  }

  @Override
  public void clearStore() {
    storage.clear();
  }
}
