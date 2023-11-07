package com.review.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.review.entity.Review;
import com.review.repository.ReviewRepository;
import com.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepository reviewRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		super();
		this.reviewRepository = reviewRepository;
	}

	@Override
	public List<Review> getAllReviews(Long companyId) {

		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews;
	}

	@Override
	public boolean addReview(Long companyId, Review review) {

		if (companyId != null && review != null) {

			review.setCompanyId(companyId);
			if (review.getId() != null) {
				review.setId(review.getId());
			}
			reviewRepository.save(review);
			return true;
		} else
			return false;

	}

	@Override
	public Review getReview(Long reviewId) {

		return reviewRepository.findById(reviewId).orElse(null);
	}

	@Override
	public boolean deleteReview(Long reviewId) {

		Review review = reviewRepository.findById(reviewId).orElse(null);

		if (review != null) {

			reviewRepository.deleteById(reviewId);
			return true;
		} else
			return false;

	}
}
