//package com.groom.seasonthon.service;
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import java.io.IOException;
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class S3UploadService {
//
//    private final AmazonS3 amazonS3;
//
//    @Value("${cloud.aws.s3.bucket}")
//    private String bucket;
//
//    public String uploadFile(MultipartFile multipartFile) throws IOException {
//        // 파일 이름이 중복되지 않도록 UUID를 추가
//        String originalFileName = multipartFile.getOriginalFilename();
//        String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFileName;
//
//        ObjectMetadata metadata = new ObjectMetadata();
//        metadata.setContentLength(multipartFile.getSize());
//        metadata.setContentType(multipartFile.getContentType());
//
//        amazonS3.putObject(bucket, uniqueFileName, multipartFile.getInputStream(), metadata);
//        return amazonS3.getUrl(bucket, uniqueFileName).toString();
//    }
//}