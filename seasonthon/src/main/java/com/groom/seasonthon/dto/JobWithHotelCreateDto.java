package com.groom.seasonthon.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class JobWithHotelCreateDto {
  //직업 관련 내용들
  private Long id;
  private String companyName;
  private String jobName;
  private Integer recruitNumber;
  private Date recruitDeadline;
  private Date jobDate;
  private String jobLocation;
  private Integer pay;
  private String jobDetail;

  //숙소 관련 내용들
  private String hotelName;
  private String hotelLocation;
  private Integer distance;
  private Boolean freeHotel;

  public JobWithHotelCreateDto() {}
  public JobWithHotelCreateDto(Long id, String jobName, String companyName, Integer recruitNumber, Date recruitDeadline, Date jobDate, Integer pay, String jobLocation, String jobDetail, String hotelName, String hotelLocation, Integer distance, Boolean freeHotel) {
    this.id = id;
    this.jobName = jobName;
    this.companyName = companyName;
    this.recruitNumber = recruitNumber;
    this.recruitDeadline = recruitDeadline;
    this.jobDate = jobDate;
    this.pay = pay;
    this.jobLocation = jobLocation;
    this.jobDetail = jobDetail;
    this.hotelName = hotelName;
    this.hotelLocation = hotelLocation;
    this.distance = distance;
    this.freeHotel = freeHotel;
  }
}
