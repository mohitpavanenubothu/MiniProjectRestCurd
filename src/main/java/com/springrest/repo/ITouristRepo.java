package com.springrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
