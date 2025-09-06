package com.groom.seasonthon.repository;

import com.groom.seasonthon.dto.JobWithHotelCreateDto;
import com.groom.seasonthon.dto.JobWithHotelListDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryJobRepositoryTest {

  private MemoryJobRepository repository;

  @BeforeEach
  void setup() {
    repository = new MemoryJobRepository();
  }

  @AfterEach
  void teardown() {
    repository.clearStore();
  }

  @Test
  void save() {
    JobWithHotelCreateDto job = new JobWithHotelCreateDto();
    job.setCompanyName("Water");
    job.setJobName("물 사오기");
    job.setRecruitNumber(2);
    job.setRecruitDeadline(new Date());
    job.setJobLocation("서울시 강남구");
    job.setPay(10000);
    job.setJobDetail("편의점에서 물 사오기");
    job.setHotelName("서울 롯데 호텔");
    job.setHotelLocation("서울시 은평구");
    job.setDistance(500);
    job.setFreeHotel(true);

    JobWithHotelCreateDto savedJob = repository.save(job);

    Assertions.assertThat(savedJob.getId()).isNotNull();
    Assertions.assertThat(savedJob.getCompanyName()).isEqualTo("Water");
    Assertions.assertThat(savedJob.getJobDetail()).isNotEqualTo("사랑");
  }

  @Test
  void findAll() {
    JobWithHotelCreateDto job1 = new JobWithHotelCreateDto();
    JobWithHotelCreateDto job2 = new JobWithHotelCreateDto();

    job1.setCompanyName("Water");
    job1.setJobName("물 사오기");
    job1.setRecruitNumber(2);
    job1.setRecruitDeadline(new Date());
    job1.setJobLocation("서울시 강남구");
    job1.setPay(10000);
    job1.setJobDetail("편의점에서 물 사오기");
    job1.setHotelName("서울 롯데 호텔");
    job1.setHotelLocation("서울시 은평구");
    job1.setDistance(500);
    job1.setFreeHotel(true);


    job2.setCompanyName("Rabbit");
    job2.setJobName("토끼 잡기");
    job2.setRecruitNumber(3);
    job2.setRecruitDeadline(new Date());
    job2.setJobLocation("서울시 서대문구");
    job2.setPay(30000);
    job2.setJobDetail("편의점에서 물 팔기");
    job2.setHotelName("조선 호텔");
    job2.setHotelLocation("서울시 광화문구?");
    job2.setDistance(250);
    job2.setFreeHotel(false);

    repository.save(job1);
    repository.save(job2);

    List<JobWithHotelListDto> jobs = repository.findAll();

    Assertions.assertThat(jobs.size()).isEqualTo(2);
    Assertions.assertThat(jobs.getFirst().getCompanyName()).isEqualTo("Water");
    Assertions.assertThat(jobs.getLast().get)
  }

  @Test
  void findbyId() {
  }

  @Test
  void clearStore() {
  }
}