package com.groom.seasonthon.repository;

import com.groom.seasonthon.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}