package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Score;
import henu.dao.IScoreDao;
import henu.factory.DaoFactory;

public class ScoreDaoImpl implements IScoreDao {

    private QueryRunner queryRunner;
	
	
	public ScoreDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}
	
	public int add(Score score){
		
		String sql = "INSERT INTO t_score(fNo,fName,fMajor,fTutorName,fAverage,fTitle,fCoach"
				+ ",fOpenReportScore,fVarcharScore,fShowScore,fQualityScore,fReviewTime"
				+ ",fCommentTeacher,fCommentReportScore,fCommentVarcharScore,fCommentShowScore"
				+ ",fCommentQualityScore,fCommentTime,fAdjunct,fMemo)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Object[] params = {score.getFno(),score.getFname(),score.getFmajor(),score.getFtutorName()
				,score.getFaverage(),score.getFtitle(),score.getFcoach(),score.getFopenReportScore()
				,score.getFvarcharScore(),score.getFshowScore(),score.getFqualityScore(),score.getFreviewTime()
				,score.getFcommentTeacher(),score.getFcommentReportScore(),score.getFcommentVarcharScore()
				,score.getFcommentShowScore(),score.getFcommentQualityScore(),score.getFcommentTime()
				,score.getFadjunct(),score.getFmemo()};
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(String fNo, Score score){
		String sql = "UPDATE t_score SET fName=?,fMajor=?"
				+ ",fTutorName=?,fAverage=?,fTitle=?"
				+ ",fOpenReportScore=?,fVarcharScore=?,fShowScore=?"
				+",fQualityScore=?,fReviewTime=?,fAttitude=?,fScoreSum=?,fState=?"
				+ "WHERE fNo=?";
	
		int result = 0 ;
		int sum = Integer.parseInt(score.getFopenReportScore())+Integer.parseInt(score.getFvarcharScore())+Integer.parseInt(score.getFshowScore())+Integer.parseInt(score.getFqualityScore())+Integer.parseInt(score.getFattitude());
		String ScoreSum = String.valueOf(sum);
		Object[] params = {score.getFname(),score.getFmajor(),score.getFtutorName()
				,score.getFaverage(),score.getFtitle(),score.getFopenReportScore()
				,score.getFvarcharScore(),score.getFshowScore(),score.getFqualityScore(),score.getFreviewTime()
				,score.getFattitude(),ScoreSum,"已评阅",score.getFno()};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int update1(String fNo, Score score){
		String sql = "UPDATE t_score SET fName=?,fMajor=?"
				+ ",fTutorName=?"
				+ ",fCommentReportScore=?,fCommentVarcharScore=?,fCommentShowScore=?"
				+",fCommentQualityScore=?,fCommentTime=?,fCommentAttitude=?,fCommentScoreSum=?,fCommentState=?"
				+ "WHERE fNo=?";
	
		int result = 0 ;
		int sum = Integer.parseInt(score.getFcommentReportScore())+Integer.parseInt(score.getFcommentVarcharScore())+
				Integer.parseInt(score.getFcommentShowScore())+Integer.parseInt(score.getFcommentQualityScore())+Integer.parseInt(score.getFcommentAttitude());
		String CommentScoreSum = String.valueOf(sum);
		//System.out.println("commentscoresum:"+CommentScoreSum);
		Object[] params = {score.getFname(),score.getFmajor(),score.getFtutorName()
				,score.getFcommentReportScore()
				,score.getFcommentVarcharScore(),score.getFcommentShowScore(),score.getFcommentQualityScore(),score.getFcommentTime()
				,score.getFcommentAttitude(),CommentScoreSum,"已评阅",score.getFno()}; 
		
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int update2(String fNo, String title){
		String sql = "UPDATE t_score SET fTitle=? WHERE fNo=?";
		
		int result = 0 ;
		Object[] params = {title,fNo};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public int update3(String fNo, String title,String tname,String profession,String sname){
		String sql = "UPDATE t_score SET fTitle=?,fTutorName=?,fMajor=?,fName=? WHERE fNo=?";
		
		int result = 0 ;
		Object[] params = {title,tname,profession,sname,fNo};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public int update4(String fNo, Score score){
		
		String sql = "UPDATE t_score SET fCoach=? WHERE fNo=?";
		int result = 0 ;
		System.out.println("score"+score.getFcoach()+fNo);
		Object[] params = {score.getFcoach(),fNo};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int update5(String fNo, Score score){
		
		String sql = "UPDATE t_score SET fCommentTeacher=? WHERE fNo=?";
		int result = 0 ;
		Object[] params = {score.getFcommentTeacher(),fNo};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete(String fNo){
		String sql = "DELETE FROM t_score WHERE fNo=?";
		int result = 0 ;
		try {
			result = queryRunner.update(sql, fNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<Score> findAll(){
		String sql = "SELECT * FROM t_score ORDER BY fNo";
		List<Score> list = null;
		
		try {
			list = queryRunner.query(sql, new BeanListHandler<Score>(Score.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Score find(String fNo){
        String sql = "SELECT * FROM t_score WHERE fNo=?";
		
        Score sc = null;
		try {
			sc = queryRunner.query(sql, new BeanHandler<Score>(Score.class),fNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sc;
	}
	
	
	public List<Score> findByStuderntId(String Studentid){
		String sql = "SELECT * FROM t_score WHERE fNo=?";
		List<Score> list = null;
		
		try {
			list = queryRunner.query(sql, new BeanListHandler<Score>(Score.class),Studentid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Score> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end){
		 String sql = "SELECT * FROM t_score WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
		
		List<Score> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Score>(Score.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
			
		return list;
	}
	/*public static void main(String[] args){
		Score score = new Score();
		score.setFno("1245030666");
		score.setFname("zhaoliu");
		score.setFmajor("rjgc");
		int result = DaoFactory.createScoreDao().update(score.getFno(),score);
		System.out.println(result);
	}
*/
	}
