package com.jobs.firstjobapp.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(int companyId);

    boolean addReview(int companyId, Review review);

    Review getReviewById(int companyId, int reviewId);

    boolean updateReviewById(int companyId, int reviewId, Review updatedReview);

    boolean deleteReviewById(int companyId, int reviewId);
}
