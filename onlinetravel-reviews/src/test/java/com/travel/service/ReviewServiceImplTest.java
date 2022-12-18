package com.travel.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.entity.Review;
import com.travel.repository.ReviewRepository;

@SpringBootTest



class ReviewServiceImplTest {
	
	@Mock
	ReviewRepository reviewRepository;
	
	@InjectMocks
	ReviewServiceImpl reviewService;

	@Test
	@Disabled
	@DisplayName("Get all InsertReview")
	void testInsertReview() throws Exception {
		Review sampleInput = new Review("bad", "bad experience overall", 2, "7-1-2021", "mansi");
		Review expectedOutput = new Review("bad", "bad experience overall", 2, "7-1-2021", "mansi");
		BDDMockito.given(reviewService.insertReview(sampleInput)).willReturn(expectedOutput);
		Review actualOutput = reviewService.insertReview(sampleInput);

		
		assertEquals(expectedOutput, actualOutput);
	}

	
	@Test
	@Disabled
    @DisplayName("Get all review by review id")
	void testGetReviewByReviewId() throws Exception {
		Review sampleOutput = new Review("bad", "bad experience overall", 2, "9-1-2021", "mansi");
		sampleOutput.setReviewId(1);

		int sampleInput = 1;

		BDDMockito.given(reviewService.getReviewByReviewId(sampleInput)).willReturn(sampleOutput);

		// when
		Review actualOutput = reviewService.getReviewByReviewId(sampleInput);
		// verify
		assertEquals(sampleOutput, actualOutput);
		assertSame(sampleOutput.getReviewId(), actualOutput.getReviewId());
		assertThat(actualOutput.getReviewId()).isGreaterThan(0);
	
	}

	@Test
	@DisplayName("Get all reviews")
	void testGetAllReviews() throws Exception {
		Review review1 = new Review("bad", "bad experience overall", 2, "7-1-2021", "mansi");

		Review review2 = new Review("bad", "bad experience overall", 2, "9-1-2021", "mansi");

		List<Review> sampleOutput = new ArrayList<>();
		sampleOutput.add(review1);
		sampleOutput.add(review2);
		
		BDDMockito.given(reviewService.getAllReviews()).willReturn(sampleOutput);
		List<Review> actualOutput = reviewService.getAllReviews();
		assertNotNull(actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);

	}

}
