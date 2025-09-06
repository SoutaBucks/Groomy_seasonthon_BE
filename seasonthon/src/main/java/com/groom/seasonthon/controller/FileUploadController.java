//package com.groom.seasonthon.controller;
//
//import com.groom.seasonthon.dto.S3FileDto;
//import com.groom.seasonthon.service.S3UploadService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import java.io.IOException;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/upload")
//public class FileUploadController {
//
//    private final S3UploadService s3UploadService;
//
//    @PostMapping
//    public ResponseEntity<S3FileDto> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//        String url = s3UploadService.uploadFile(file);
//        return ResponseEntity.ok(new S3FileDto(url));
//    }
//}