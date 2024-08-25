package com.embarkx.firstjobapp.review.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.embarkx.firstjobapp.company.Company;
import com.embarkx.firstjobapp.company.CompanyService;
import com.embarkx.firstjobapp.review.Review;
import com.embarkx.firstjobapp.review.ReviewRepository;
import com.embarkx.firstjobapp.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;
	private CompanyService companyservice;

	public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyservice) {
		this.reviewRepository = reviewRepository;
		this.companyservice = companyservice;
	}

	@Override
	public List<Review> getAllReview(Integer id) {
		List<Review> review = reviewRepository.findByCompany(id);
		return review;
	}

	@Override
	public void addReview(Integer id, Review review) {

		Company company = companyservice.getCompany(id);
		if (company != null) {
			review.setCompnay(company);
			reviewRepository.save(review);
		}

	}

	@Override
	public Review getReview(Integer id, Integer reviewid) {
		List<Review> r = reviewRepository.findByCompany(id);
		return r.stream().filter(review -> review.getId().equals(reviewid)).findFirst().orElse(null);

	}

	@Override
	public boolean updateReview(Integer companyid, Integer reviewid, Review updatedreview) {
		if(companyservice.getCompany(companyid) != null) {
			updatedreview.setCompnay(companyservice.getCompany(companyid));
			updatedreview.setId(reviewid);
			reviewRepository.save(updatedreview);
			return true;
		}
		return false;
	}

	@Override
	public void deleteReview(Integer companyid, Integer reviewid) {
		if(companyservice.getCompany(companyid) !=null && reviewRepository.existsById(reviewid)){
			Review review = reviewRepository.findById(reviewid).orElse(null);
			Company company = review.getCompnay();
			company.getReview().remove(review);
			review.setCompnay(null);
			companyservice.updateCompany(companyid, company);
			reviewRepository.deleteById(reviewid);
		}
	}

	
}
