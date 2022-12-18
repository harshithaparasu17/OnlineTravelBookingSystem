package com.travel.controller;

import org.springframework.http.HttpStatus;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.Review;
import com.travel.service.ReviewService;

@RestController
@RequestMapping("/travel/review")
@Validated

public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	public ReviewController() {
		System.out.println("\n\n\n====>> Inside Constructor " + this);
	}

	@PostMapping("/addreview") //here adding reviews using postman
	public ResponseEntity<String> addReview(@RequestBody Review review) {
		try {
			Review savedUser = reviewService.insertReview(review);
			String responseMsg = savedUser.getUserName() + " save with Id " + savedUser.getReviewId();
			mylogs.info(" ---->> Inside App User Constroller Post mapping , user created "+responseMsg);
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} 
		catch (Exception e) {
			String errorMsg = "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/reviewId/{reviewId}") //getting reviewid  using postman
	public Review getReviewByReviewId(@PathVariable int reviewId) throws Exception {
		return reviewService.getReviewByReviewId(reviewId);
	}

	@DeleteMapping("/delete/{deletereviewId}") //deleting reviewid using postman
	public String deleteReview(@PathVariable int deletereviewId) throws Exception {
		try {
			reviewService.delete(deletereviewId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "deleted successfully";

	}

	@PutMapping("/reviewidd/{reviewId}") //for updating purpose we used putmapping
	public Review updateReview(@PathVariable int reviewId, @RequestBody Review reviewDetails) throws Exception {
		reviewService.getReviewByReviewId(reviewId);
		reviewDetails.setReviewId(reviewId);
		Review updateReview = reviewService.insertReview(reviewDetails);
		return updateReview;
	}

	@GetMapping("/title/{title}") //getting title using postman
	public List<Review> getReviewByTitle(@PathVariable String title) throws Exception {
		return reviewService.getReviewBytitle(title);
	}

	@GetMapping("/points/{points}") //getting points using postman
	public List<Review> getReviewByPoints(@PathVariable int points) throws Exception {
		return reviewService.getReviewBypoints(points);
	}

	@GetMapping("/allreviews") //getting allreviews
	public List<Review> getAllReviews() {
		try {
			List<Review> allExtractedReview = reviewService.getAllReviews();

			return allExtractedReview;

		} catch (Exception e) {
			System.out.println(e);

		}

		return null;

	}

	@GetMapping("/filterTitle/{title}") //getting filteredtitle using postman
	public List<Review> filterReviews(@PathVariable String title) throws Exception {
		List<Review> filtered = reviewService.filterByTitle(title);
		return filtered;
	}

}
