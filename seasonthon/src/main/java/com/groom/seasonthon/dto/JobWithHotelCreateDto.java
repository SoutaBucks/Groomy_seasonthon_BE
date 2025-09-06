package com.groom.seasonthon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobWithHotelCreateDto {
  //직업 관련 내용들
  private Long id;
  private String companyName;
  private String jobName;
  private Integer recruitNumber;
  private Date jobStartDate;
  private Date jobEndDate;
  private String jobLocation;
  private String jobLocationDetail;
  private Integer pay;
  private String category;
  private String[] benefits;
  private String wageType;
  private String worktime;

  //숙소 관련 내용들
  private String hotelType;
  private Boolean canSmoke;
  private Boolean wantBreakFast;
  private String hotelRules;
  private Integer hotelPrice;
}
