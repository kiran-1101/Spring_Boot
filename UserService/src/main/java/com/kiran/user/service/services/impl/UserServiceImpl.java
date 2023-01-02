package com.kiran.user.service.services.impl;

import com.kiran.user.service.entities.Hotel;
import com.kiran.user.service.entities.Rating;
import com.kiran.user.service.entities.User;
import com.kiran.user.service.exceptions.ResourceNotFoundException;
import com.kiran.user.service.external.services.HotelService;
import com.kiran.user.service.repositories.UserRepositories;
import com.kiran.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.EventRecodingLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepositories userRepositories;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    HotelService hotelService;

    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepositories.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepositories.findAll();
    }

    @Override
    public User getUserByUserId(String userId) {
        //get user from db
        User user = userRepositories.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not available:"+userId));
        //get rating of the above user from RATING-SERVICE
        //http://localhost:8083/ratings/users/6e5cb256-574d-44f9-997d-5e1e7b6bf72c

        Rating[] ratingofUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        log.info("{} ",ratingofUser);
        List<Rating> ratingList = Arrays.stream(ratingofUser).toList();

        List<Rating> collect = ratingList.stream().map(rating -> {
            //api call to hotel service to get the hotel
            //http://localhost:8082/hotels/4160e4ab-59f7-4ccd-861e-1de5421a0767
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            log.info("response status code: {}",forEntity.getStatusCode());

            //set the hotel to rating
            rating.setHotel(hotel);
            //return the rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }


}
