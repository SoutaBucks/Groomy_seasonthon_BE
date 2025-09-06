package com.groom.seasonthon.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class JobWithHotelCreateDto {
  //직업 관련 내용들
  private Long id;
  private Long companyName;
  private String jobName;
  private String recruitNumber;
  private Date recruitDeadline;
  private Date jobDate;
  private String jobLocation;
  private Long pay;
  private String jobDetail;

  //숙소 관련 내용들
  private String hotelName;
  private String hotelLocation;
  private String distance;
  private Boolean freeHotel;
}
