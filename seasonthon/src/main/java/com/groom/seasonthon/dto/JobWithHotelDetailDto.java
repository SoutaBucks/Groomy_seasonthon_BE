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
  private Integer recruitNumber;
  private String jobDetail;
  private Date jobDate;
  private String jobLocation;
  private Integer pay;

  // 호텔 관련
  private String hotelName;
  private Integer distance;
  private String hotelLocation;

  public JobWithHotelDetailDto() {}
  public JobWithHotelDetailDto(String companyName, String jobName, Integer recruitNumber, Date jobDate, String jobDetail, String jobLocation, Integer pay, String hotelName, Integer distance, String hotelAddress) {
    this.companyName = companyName;
    this.jobName = jobName;
    this.recruitNumber = recruitNumber;
    this.jobDate = jobDate;
    this.jobDetail = jobDetail;
    this.jobLocation = jobLocation;
    this.pay = pay;
    this.hotelName = hotelName;
    this.distance = distance;
    this.hotelLocation = hotelAddress;
  }
}
