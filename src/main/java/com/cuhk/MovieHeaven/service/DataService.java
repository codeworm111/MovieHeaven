package com.cuhk.MovieHeaven.service;

import com.cuhk.MovieHeaven.dao.ReviewMapper;
import com.cuhk.MovieHeaven.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    @Autowired
    ReviewMapper reviewMapper;

    public float calAveScore(int movieId){
        List<Review> reviews = reviewMapper.selectAllReviewsByMovieId(movieId);
        float sum=0;
        int size=reviews.size();
        if(reviews!=null){
            for(Review review:reviews){
                sum+=review.getStars();
            }
        }
        return size==0?0:sum/size;
    }
}
