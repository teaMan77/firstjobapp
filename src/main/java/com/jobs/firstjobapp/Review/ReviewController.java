package com.jobs.firstjobapp.Review;

import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable int companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable int companyId,
                                            @RequestBody Review review) {
        boolean isCreated = reviewService.addReview(companyId, review);

        if (isCreated)
            return new ResponseEntity<>("Review added successfully!", HttpStatus.CREATED);
        return new ResponseEntity<>("Company not found!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable int companyId,
                                                @PathVariable int reviewId) {
        return new ResponseEntity<>(reviewService.getReviewById(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable int companyId,
                                                   @PathVariable int reviewId,
                                                   @RequestBody Review updatedReview) {
        boolean isReviewUpdated = reviewService.updateReviewById(companyId, reviewId, updatedReview);

        if (isReviewUpdated)
            return new ResponseEntity<>("Review updated successfully1", HttpStatus.OK);
        return new ResponseEntity<>("Review not updated!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable int companyId,
                                               @PathVariable int reviewId) {
        boolean isReviewDeleted = reviewService.deleteReviewById(companyId, reviewId);

        if (isReviewDeleted)
            return new ResponseEntity<>("Review deleted successfully!", HttpStatus.OK);
        return new ResponseEntity<>("Review not deleted!", HttpStatus.NOT_FOUND);
    }
}
