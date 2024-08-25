package com.embarkx.firstjobapp.review;

import java.util.List;

public interface ReviewService {

	List<Review> getAllReview(Integer id);
	void addReview(Integer id, Review review);
	Review getReview(Integer id, Integer reviewid);
	boolean updateReview(Integer companyid, Integer reviewid,Review review);
	void deleteReview(Integer companyid, Integer reviewid);
	
}
