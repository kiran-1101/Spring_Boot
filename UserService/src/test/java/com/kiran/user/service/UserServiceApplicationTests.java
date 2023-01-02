package com.kiran.user.service;

import com.kiran.user.service.entities.Rating;
import com.kiran.user.service.external.services.RatingService;
import com.netflix.discovery.converters.Auto;
import org.hibernate.annotations.NaturalId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	RatingService ratingService;

	@Test
	void contextLoads() {
	}

//	@Test
//	void createRating(){
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("this is create using feign client").build();
//		ResponseEntity<Rating> ratingResponseEntity = ratingService.createRating(rating);
//		System.out.println("new rating created..");
//	}

}
