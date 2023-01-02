package com.kiran.rating.controller;

import com.kiran.rating.entities.Rating;
import com.kiran.rating.repositories.RatingRepository;
import com.kiran.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){

        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }
    @GetMapping()
    public ResponseEntity<List<Rating>> getRating(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
    }
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
    }


}

