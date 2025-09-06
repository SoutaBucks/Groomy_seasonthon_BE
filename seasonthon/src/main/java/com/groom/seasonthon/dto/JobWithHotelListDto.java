package com.groom.seasonthon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobWithHotelListDto {
  private String companyName;
  private String jobName;
  private Long pay;
  private String hotelName;
  private Long distance;
}
