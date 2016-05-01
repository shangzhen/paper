package henu.action;

import org.apache.struts2.ServletActionContext;

import henu.bean.Review;
import henu.bean.Score;
import henu.factory.DaoFactory;

public class PaperScoreAction {
	private Score score;
	private Review review;
	private double sum;
	
	public double getSum() {
		return sum;
	}



	public void setSum(double sum) {
		this.sum = sum;
	}



	public Review getReview() {
		return review;
	}



	public void setReview(Review review) {
		this.review = review;
	}



	public Score getScore() {
		return score;
	}



	public void setScore(Score score) {
		this.score = score;
	}



	/**
	 * 从前台获取学号
	 * *//*
	*/
	public String paperscore(){
		String fno = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
		score = DaoFactory.createScoreDao().find(fno);
		review = DaoFactory.createReviewDao().find(fno);
		
		return "paperscore";
	}
	
	public String papermessage(){
		String fno = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
		score = DaoFactory.createScoreDao().find(fno);
		review = DaoFactory.createReviewDao().find(fno);
		double s1 = Double.valueOf(review.getFcontentScore());
		double s2 = Double.valueOf(review.getFscoreDefense());
		double s3 = Double.valueOf(review.getFwordScore());
		double s4 = Double.valueOf(review.getFqualityScore());
		sum = s1+s2+s3+s4;
		return "papermessage";
	}
}
