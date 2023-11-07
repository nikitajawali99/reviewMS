package com.review.service;

import java.util.List;

import com.review.entity.Review;


public interface ReviewService {
	
	
	List<Review> getAllReviews(Long companyId);
	
	boolean addReview(Long companyId,Review review);
	
	Review getReview(Long reviewId);

	boolean deleteReview(Long reviewId);

}
