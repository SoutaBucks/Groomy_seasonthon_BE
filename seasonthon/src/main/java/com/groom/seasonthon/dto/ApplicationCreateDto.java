package com.groom.seasonthon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationCreateDto {
    private String applicantName; // 지원자 이름 추가
    private String contact;
    private boolean policyChecked;
}