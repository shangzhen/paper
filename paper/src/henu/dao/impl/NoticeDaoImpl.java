package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Announcement;
import henu.bean.Notice;
import henu.dao.IAnnouncementDao;
import henu.dao.INoticeDao;
import henu.factory.DaoFactory;

public class NoticeDaoImpl implements INoticeDao{
	private QueryRunner queryRunner;

	public NoticeDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}
	@Override
	public int add(Notice notice) {
		String sql = "INSERT INTO t_notice(fDefenceTime,fDefencePlace,fRoute,fReleaseTime,fReleasePerson,fMemo) VALUES(?,?,?,?,?,?)";
		Object[] params = {notice.getFdefencetime(),notice.getFdefenceplace()
					,notice.getFroute(),notice.getFreleasetime(),notice.getFreleaseperson(),notice.getFmemo()};
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
	public int delete(int fid) {
		String sql = "DELETE FROM t_notice WHERE fId=?";
		int result = 0 ;
		try {
			result = queryRunner.update(sql, fid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Notice find(int fid) {
		String sql = "SELECT * FROM t_notice WHERE fId=?";
		
		Notice ann = null;
		try {
			ann = queryRunner.query(sql, new BeanHandler<Notice>(Notice.class),fid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ann;
	}

	@Override
	public List<Notice> findAll() {
		String sql = "SELECT * FROM t_notice ORDER BY fId DESC";
		List<Notice> list = null;
		
		try {
			list = queryRunner.query(sql, new BeanListHandler<Notice>(Notice.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Notice> findByProperty(String property, String key,
			String order, String sort, int start, int end) {
			
			String sql = "SELECT * FROM t_notice WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
		
			List<Notice> list = null;
			try {
				list = queryRunner.query(sql, new BeanListHandler<Notice>(Notice.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
	}
	@Override
	public int update(int fid, Notice notice) {
		String sql = "UPDATE t_notice SET fDefenceTime=?,fDefencePlace=?,fRoute=?"
				+ ",fReleaseTime=?,fReleasePerson=?,fMemo=? WHERE fId=?";
		int result = 0 ;
		Object[] params = {notice.getFdefencetime(),notice.getFdefenceplace()
				,notice.getFroute(),notice.getFreleasetime(),notice.getFreleaseperson(),notice.getFmemo(),fid};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	

}
