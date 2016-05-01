package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Acclaim;
import henu.bean.Review;
import henu.dao.IReviewDao;
import henu.factory.DaoFactory;

public class ReviewDaoImpl implements IReviewDao {

    private QueryRunner queryRunner;
	
	public ReviewDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}
	@Override
	public int add(Review review){
		String sql="INSERT INTO t_review(fComment,fPersonnel,fDirector,fContentScore"
				+ ",fScoreDefense,fWordScore,fQualityScore,fComprehensiveScore,fRating"
				+ ",fDefenceTime,fAdjunct,fNo,fMemo) VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {review.getFcomment(),review.getFpersonnel(),review.getFdirector()
				,review.getFcontentScore(),review.getFscoreDefense(),review.getFwordScore()
				,review.getFqualityScore(),review.getFcomprehensiveScore(),review.getFrating()
				,review.getFdefenceTime(),review.getFadjunct(),review.getFno(),review.getFmemo()};
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(String fNo, Review review){
		String sql = "UPDATE t_review SET fPersonnel=?,fDirector=?"
				+ ",fContentScore=?,fScoreDefense=?,fWordScore=?,fQualityScore=?"
				+ ",fComprehensiveScore=?,fRating=?,fDefenceTime=?,fAdjunct=?"
				+ ",fMemo=? WHERE fNo=?";
		int result = 0 ;
		Object[] params = {review.getFpersonnel(),review.getFdirector()
				,review.getFcontentScore(),review.getFscoreDefense(),review.getFwordScore()
				,review.getFqualityScore(),review.getFcomprehensiveScore(),review.getFrating()
				,review.getFdefenceTime(),review.getFadjunct(),review.getFmemo(),fNo};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public int update1(String fNo, Review review){
		String sql = "UPDATE t_review SET fContentScore=?,fScoreDefense=?,fWordScore=?,fQualityScore=?"
				+ ",fComprehensiveScore=? ,fRating=? ,fComment=? WHERE fNo=?";
		int result = 0 ;
		Object[] params = {review.getFcontentScore(),review.getFscoreDefense(),review.getFwordScore()
				,review.getFqualityScore(),review.getFcomprehensiveScore(),review.getFrating()
				,review.getFcomment(),fNo};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public int update2(String fNo, Review review){
		String sql = "UPDATE t_review SET fComment=? WHERE fNo=?";
		int result = 0 ;
		Object[] params = {review.getFcomment(),fNo};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int delete(String fNo){
		String sql = "DELETE * FROM t_review WHERE fNo=?";
		int result = 0 ;
		try {
			result = queryRunner.update(sql, fNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public List<Review> findAll(){
		String sql = "SELECT * FROM t_review ORDER BY fNo";
		List<Review> list = null;
		
		try {
			list = queryRunner.query(sql, new BeanListHandler<Review>(Review.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Review find(String fNo){
		
        String sql = "SELECT * FROM t_review WHERE fNo=?";
        Review detail = null;
		try {
			detail = queryRunner.query(sql, new BeanHandler<Review>(Review.class),fNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("re:::::::::"+detail);
		return detail;
	}
	
	
	public List<Review> findByTeacher(String teacherId){
		String sql = "SELECT * FROM t_review WHERE fTutorName=?";
		List<Review> list = null;
		
		try {
			list = queryRunner.query(sql, new BeanListHandler<Review>(Review.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Review> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end){
                String sql = "SELECT * FROM t_review WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
		
		List<Review> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Review>(Review.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
			
		return list;
		
	}
	
	


}
