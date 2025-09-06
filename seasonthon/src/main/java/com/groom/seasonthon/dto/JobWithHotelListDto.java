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

  public JobWithHotelListDto() {}

  public JobWithHotelListDto(String companyName, String jobName, Integer pay, String hotelName) {
    this.companyName = companyName;
    this.jobName = jobName;
    this.pay = pay;
    this.hotelName = hotelName;
  }

}
