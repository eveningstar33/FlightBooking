package com.dgs.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgs.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}