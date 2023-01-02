package com.kiran.user.service.external.services;

import com.kiran.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.ws.rs.Path;

@FeignClient(name ="RATING-SERVICE")
public interface RatingService {

    //post
    @PostMapping("/ratings/")
    public ResponseEntity<Rating> createRating(Rating values);
    //put
    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating>  updateRating(@PathVariable ("ratingId") String ratingId,Rating rating );

    //delete
    @DeleteMapping("/ratings/{ratingId}")
    public Rating deleteRating(@PathVariable String ratingId);


}
