package henu.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Announcement;
import henu.bean.Check;
import henu.dao.ICheckDao;
import henu.factory.DaoFactory;

public class CheckDaoImpl implements ICheckDao {

	private QueryRunner queryRunner;
	
	
	public CheckDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}

	@Override
	public int add(Check check) {
		

		String sql = "INSERT INTO t_check(fNo,fTitle,fCollege,fName"
				+ ",fMajor,fFare,fProblem,fSelfEvaluation,fTutorEvaluation,fTutorTime,fCheck,fAdjunct,fMemo,fTime) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {check.getFno(),check.getFtitle(),check.getFcollege(),check.getFname(),
				check.getFmajor(),check.getFfare(),check.getFproblem(),check.getFselfEvaluation(),check.getFtutorEvaluation(),check.getFtutorTime(),check.getFcheck(),check.getFadjunct(),check.getFmemo(),check.getFtime()};
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(String fno) {
		String sql = "DELETE FROM t_check WHERE fNo=?";
		int result = 0;
		try {
			result = queryRunner.update(sql, fno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(String fno, Check check) {
		String sql = "UPDATE t_check SET fTitle=?,fCollege=?,fName=?"
				+ ",fMajor=?,fFare=?,fProblem=?,fSelfEvaluation=?,fTutorEvaluation=?,fTutorTime=?,"
				+ "fCheck=?,fAdjunct=?,fMemo=?,fTime=? WHERE fNo=?";
		Object[] params = {check.getFtitle(),check.getFcollege(),check.getFname(),check.getFmajor(),
				check.getFfare(),check.getFproblem(),check.getFselfEvaluation(),check.getFtutorEvaluation(),
				check.getFtutorTime(),check.getFcheck(),check.getFadjunct(),check.getFmemo(),check.getFtime(),fno};
		
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Check find(String fno) {
		String sql = "SELECT * FROM t_check WHERE fNo = ?";
		Check ck = null;
		try {
			ck  = queryRunner.query(sql, new BeanHandler<Check>(Check.class), fno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ck;
	}

	@Override
	public List<Check> findAll() {
		String sql = "SELECT * FROM t_check";
		List<Check> list = null;
		try {
			list = queryRunner.query(sql,new BeanListHandler<Check>(Check.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Check> findByProperty(String property, String key, String order, String sort, int start, int end) {
		String sql = "SELECT * FROM t_check WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
		List<Check> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Check>(Check.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
