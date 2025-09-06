package com.groom.seasonthon.repository;

import com.groom.seasonthon.entity.Application;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ApplicationRepository {

    private final Map<Long, Application> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0L);

    public Application save(Application application) {
        if (application.getId() == null) {
            application.setId(sequence.incrementAndGet());
        }
        store.put(application.getId(), application);
        return application;
    }

    public Optional<Application> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
}