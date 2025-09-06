package com.groom.seasonthon.repository;

import com.groom.seasonthon.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}