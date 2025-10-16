package com.jobapp.review.impl;

import com.jobapp.company.Company;
import com.jobapp.company.CompanyService;
import com.jobapp.review.Review;
import com.jobapp.review.ReviewService;
import com.jobapp.review.Reviewrespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final Reviewrespository reviewrespository;
    private final CompanyService companyService;

    public ReviewServiceImpl(Reviewrespository reviewrespository, CompanyService companyService) {
        this.reviewrespository = reviewrespository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewrespository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyByID(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewrespository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewrespository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if(companyService.getCompanyByID(companyId)!=null){
            updatedReview.setId(reviewId);
            reviewrespository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyByID(companyId)!=null && reviewrespository.existsById(reviewId)){
            Review review = reviewrespository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompany(company,companyId);
            reviewrespository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
