package com.groom.seasonthon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationCreateDto {
    private String applicantName;
    private String contact;
    private boolean policyChecked;
}