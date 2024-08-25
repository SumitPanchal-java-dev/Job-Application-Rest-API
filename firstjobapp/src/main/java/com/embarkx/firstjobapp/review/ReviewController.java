package com.embarkx.firstjobapp.review;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{compnayid}")
public class ReviewController {

	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping("/reviews")
	public List<Review> getAllReview(@PathVariable Integer compnayid){
		return reviewService.getAllReview(compnayid);
	}
	
	
	@PostMapping("/reviews")
	public String createReview(@PathVariable Integer compnayid, @RequestBody Review review) {
		reviewService.addReview(compnayid, review);
		return "success";
	}
	
	@GetMapping("/reviews/{reviewid}")
	public Review getReview(@PathVariable Integer compnayid, @PathVariable Integer reviewid) {
		return reviewService.getReview(compnayid, reviewid);
		
	}
	
	@PutMapping("/reviews/{reviewid}")
	public String updateReview(@PathVariable Integer companyid, @PathVariable Integer reviewid, @RequestBody Review review) {
		
		reviewService.updateReview(companyid, reviewid, review);
		return "success";
		
	}
	
	@DeleteMapping("/reviews/{reviewid}")
	public String deleteReview(@PathVariable Integer companyid, @PathVariable Integer reviewid) {
		reviewService.deleteReview(companyid,companyid);
		return "Success";
	}
	
}
