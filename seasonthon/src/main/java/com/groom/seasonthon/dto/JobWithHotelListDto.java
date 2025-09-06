package com.groom.seasonthon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobWithHotelListDto {
  private Long id;
  private String companyName;
  private String jobName;
  private Integer pay;
  private String category;
  private String wageType;
  private String worktime;
  private String jobLocationDetail;
  private Date jobStartDate;
  private Date jobEndDate;

  private String hotelType;
  private Boolean canSmoke;
  private Boolean wantBreakFast;
  private String hotelRules;
  private Integer hotelPrice;
}
