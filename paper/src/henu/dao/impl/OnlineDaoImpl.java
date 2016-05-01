package henu.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Announcement;
import henu.bean.Online;
import henu.dao.IOnlineDao;
import henu.factory.DaoFactory;

import java.util.List;

public class OnlineDaoImpl implements IOnlineDao {
	private QueryRunner queryRunner;

	public OnlineDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;

	}

	@Override
	public int add(Online online) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO t_online(ftitle,fContent,fIsTop,fAnswer,fReply,fQueryTime,fStudentName,fReplyTime,fNo)"
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		Object[] params = { online.getFtitle(), online.getFcontent(), online.getFisTop(), online.getFanswer(),
				online.getFreply(), online.getFqueryTime(), online.getFstudentName(), online.getFreplyTime(),online.getFno() };
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int delete(int fId) {
		String sql = "DELETE FROM t_online WHERE fId=?";
		int result = 0;
		try {
			result = queryRunner.update(sql, fId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Online find(int fId) {
		String sql = "SELECT * FROM t_online WHERE FId=?";
		Online on = null;
		try {
			on = queryRunner.query(sql, new BeanHandler<Online>(Online.class), fId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return on;
	}

	@Override
	public int reply(int fId, Online online) {
		String sql = "UPDATE t_online SET ftitle=?,fContent=?,fIsTop=?,fAnswer=?,fReply=?,fQueryTime=?,"
				+ "fStudentName=?,fReplyTime=? WHERE fId=?";
		Object[] params = { online.getFtitle(), online.getFcontent(), online.getFisTop(), online.getFanswer(),
				online.getFreply(), online.getFqueryTime(), online.getFstudentName(), online.getFreplyTime(),fId };
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return result;
	}

	public List<Online> findAll() {
		String sql = "SELECT * FROM t_online ORDER BY fId DESC";
		List<Online> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Online>(Online.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Online> findByProperty(String property, String key, String property1, String key1, String order,
			String sort, int start, int end) {
		String sql = "SELECT * FROM t_online WHERE " + property + " LIKE '%" + key + "%'" + " ORDER BY " + order + " "
				+ sort + " LIMIT " + start + "," + end;
		List<Online> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Online>(Online.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Online> findByProperty(String property, String key, String order, String sort, int start, int end) {
		String sql = "SELECT * FROM t_online WHERE " + property + " LIKE '%" + key + "%'" + " ORDER BY " + order + " "
				+ sort + " LIMIT " + start + "," + end;
		List<Online> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Online>(Online.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Online> findByOut(String order, String sort, int start, int end) {
		
		String sql = "SELECT * FROM t_online WHERE + fReply is not null ORDER BY " + order + " "
				+ sort + " LIMIT " + start + "," + end;
		List<Online> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Online>(Online.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Online> findByTeacher(String fTNo, String order, String sort, int start, int end) {
		
		String sql = "SELECT DISTINCT * FROM  t_online where fReply is  null AND fNo in (SELECT fNo FROM t_thesislist WHERE fTid='"+fTNo+"' )"+
				"ORDER BY "+order + " "+ sort + " LIMIT " + start + "," + end;
		List<Online> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Online>(Online.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public List<Online> findByTeacherOut(String fTNo, String order, String sort, int start, int end) {
		
		String sql = "SELECT DISTINCT * FROM  t_online where fReply is not null AND fNo in (SELECT fNo FROM t_thesislist WHERE fTid='"+fTNo+"' )"+
				"ORDER BY "+order + " "+ sort + " LIMIT " + start + "," + end;
		List<Online> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Online>(Online.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

}
