package com.groom.seasonthon.controller;

import com.groom.seasonthon.dto.ApplicationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class ApplicationController {

//  @GetMapping("/api/applications/already")
//  public ApplicationDto getApplication() {
//    ApplicationDto applicationDto = new ApplicationDto();
//    return applicationDto;
//  }
}