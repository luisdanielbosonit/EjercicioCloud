package com.bosonit.spring_cloud.trips.infrastructure.repository;

import com.bosonit.spring_cloud.trips.entity.Trips;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TripsRepository extends JpaRepository<Trips, Integer> {

}
