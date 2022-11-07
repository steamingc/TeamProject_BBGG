package com.example.mainProject.domain.repository;

import com.example.mainProject.domain.entity.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long> {
}
