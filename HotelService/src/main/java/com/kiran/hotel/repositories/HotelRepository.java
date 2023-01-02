package com.kiran.hotel.repositories;

import com.kiran.hotel.entities.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel,String> {
}
