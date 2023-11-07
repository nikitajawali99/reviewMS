package com.review.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.review.entity.Review;
import com.review.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

	private final ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	@GetMapping
	public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {

		return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {

		boolean isReviewedSaved = reviewService.addReview(companyId, review);

		if (isReviewedSaved)
			return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Review Not Saved", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{reviewId}")
	public ResponseEntity<Review> getReview(@PathVariable Long reviewId) {

		return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);
	}

	@DeleteMapping("/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {

		boolean isReviewedDeleted = reviewService.deleteReview(reviewId);

		if (isReviewedDeleted)
			return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Review Not Deleted", HttpStatus.NOT_FOUND);
	}

}
