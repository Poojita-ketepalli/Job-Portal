package com.jobportal.reviewms.review.impl;


import com.jobportal.reviewms.review.Review;
import com.jobportal.reviewms.review.ReviewService;
import com.jobportal.reviewms.review.Reviewrespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final Reviewrespository reviewrespository;
    //private final CompanyService companyService;

    public ReviewServiceImpl(Reviewrespository reviewrespository) {
        this.reviewrespository = reviewrespository;

    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewrespository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {

        if(companyId!=null && review!=null){
            review.setCompanyId(companyId);
            reviewrespository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long reviewId) {
        return reviewrespository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Review updatedReview) {
        Review review = reviewrespository.findById(reviewId).orElse(null);
        if(review!=null){
            review.setDescription(updatedReview.getDescription());
            review.setTitle(updatedReview.getTitle());
            review.setRating(updatedReview.getRating());
            review.setCompanyId(updatedReview.getCompanyId());
            reviewrespository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Review review = reviewrespository.findById(reviewId).orElse(null);
        if(review!=null){
            reviewrespository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
