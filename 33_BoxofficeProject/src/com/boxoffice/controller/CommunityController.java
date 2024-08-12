package com.boxoffice.controller;

import java.util.List;

import com.boxoffice.model.service.FavoriteService;
import com.boxoffice.model.service.ReviewService;
import com.boxoffice.model.vo.Favorite;
import com.boxoffice.model.vo.Review;

public class CommunityController {
	FavoriteService favoriteService = new FavoriteService();
	ReviewService reviewService = new ReviewService();
	
	public boolean setFavorite(int mNo, int movieNo){
		int result = favoriteService.insert(new Favorite(movieNo, mNo));
		return result > 0 ? true : false; 
	}

	public boolean removeFavorite(int mNo, int movieNo){
		int result = favoriteService.delete(new Favorite(movieNo, mNo));
		return result > 0 ? true : false; 
	}
	
	public List<Favorite> getFavoriteListByMovieNo(int movieNo){
		return favoriteService.selectByBno(movieNo);
	}
	
	public List<Favorite> getFavoriteListByMemberNo(int mno){
		return favoriteService.selectByMno(mno);
	}
	
	public boolean writeReview(Review review) {
		int result = reviewService.insert(review);
		return result > 0 ? true : false; 
	}
	
	public boolean deleteReview(int rNo) {
		int result = reviewService.delete(rNo);
		return result > 0 ? true : false; 
	}
	
	public List<Review> getReviewAllList() {
		return reviewService.selectAll();
	}
	
	public Review getReviewDetail(int rNo) {
		return reviewService.selectOneDetail(rNo);
	}
	
	public List<Review> getReviewMemberList(int mno) {
		return reviewService.selectByMno(mno);
	}
	
	public List<Review> getReviewMoviewList(int boxofficeNo) {
		return reviewService.selectByBNo(boxofficeNo);
	}
}
