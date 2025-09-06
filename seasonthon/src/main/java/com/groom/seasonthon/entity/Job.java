package com.groom.seasonthon.entity;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/*
* id - 구직 관련 아이디
* jobName - 공고내용
* recruitNumber - 모집 인원
* recruitDeadline - 모집 마감일
* jobLocation - 근무지 주소
* pay - 시급/월급
* jobDetail - 업무 자세한 내용
* freeHotel - 숙박 제공 여부
* */

@Data
public class Job {
  private Long id;
  private String jobName;
  private String recruitNumber;
  private Date recruitDeadline;
  private String jobLocation;
  private Long pay;
  private String jobDetail;
  private Boolean freeHotel;
}
