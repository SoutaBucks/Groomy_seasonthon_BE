package com.groom.seasonthon.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class JobWithHotelDetailDto {
  // 직업 관련
  private String companyName;
  private String jobName;
  private String recruitNumber;
  private String jobDetail;
  private Date jobDate;
  private String jobLocation;
  private Long pay;

  // 호텔 관련
  private String HotelName;
  private Long distance;
  private String HotelAddress;
}
