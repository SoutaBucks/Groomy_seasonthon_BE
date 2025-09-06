package com.groom.seasonthon.dto.job;

import lombok.Getter;
import lombok.Setter;

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

@Getter
@Setter
public class JobCreateDto {
  private Long id;
  private String jobName;
  private String recruitNumber;
  private Date recruitDeadline;
  private String jobLocation;
  private Long pay;
  private String jobDetail;
  private Boolean freeHotel;
}
