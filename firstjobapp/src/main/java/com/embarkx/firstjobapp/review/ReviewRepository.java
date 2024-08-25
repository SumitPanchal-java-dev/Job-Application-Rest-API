package com.embarkx.firstjobapp.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	List<Review> findByCompany(Integer id);

}
