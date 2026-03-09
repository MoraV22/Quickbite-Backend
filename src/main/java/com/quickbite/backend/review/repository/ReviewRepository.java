package com.quickbite.backend.review.repository;

import com.quickbite.backend.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByUser(Integer userId);

    List<Review> findByRestaurant(Integer restaurantId);
}
