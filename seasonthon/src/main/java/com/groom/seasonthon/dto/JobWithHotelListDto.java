package com.groom.seasonthon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobWithHotelListDto {
  private String companyName;
  private String jobName;
  private Integer pay;
  private String hotelName;
  private Integer distance;

  public JobWithHotelListDto() {}

  public JobWithHotelListDto(String companyName, String jobName, Integer pay, String hotelName, Integer distance) {
    this.companyName = companyName;
    this.jobName = jobName;
    this.pay = pay;
    this.hotelName = hotelName;
    this.distance = distance;
  }

}
