package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Announcement;
import henu.dao.IAnnouncementDao;
import henu.factory.DaoFactory;

public class AnnouncementDaoImpl implements IAnnouncementDao {
	private QueryRunner queryRunner;

	public AnnouncementDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}

	@Override
	public int update(int fSerialNo, Announcement announcement) {
		String sql = "UPDATE t_announcement SET fTitle=?,fPublisher=?"
				+ ",fPublishMessage=?,fType=?,fContent=?,fBrowseTime=?" + ",fAdjunct=? WHERE fSerialNo=?";
		/*
		 * PreparedStatement ps = Dbcp.executePS(sql); ps.setString(1,
		 * announcement.getfTitle()); ...getClass() ps.executeUpdate();
		 * ps.close();
		 */
		int result = 0;
		Object[] params = { announcement.getFtitle(), announcement.getFpublisher(), announcement.getFpublishMessage(),
				announcement.getFtype(), announcement.getFcontent(), announcement.getFbrowseTime(),
				announcement.getFadjunct(), fSerialNo };
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int add(Announcement announcement) {
		String sql = "INSERT INTO t_announcement(fTitle,fPublisher,fPublishMessage"
				+ ",fType,fContent,fBrowseTime,fAdjunct) VALUES(?,?,?,?,?,?,?)";
		Object[] params = { announcement.getFtitle(), announcement.getFpublisher(), announcement.getFpublishMessage(),
				announcement.getFtype(), announcement.getFcontent(), announcement.getFbrowseTime(),
				announcement.getFadjunct() };
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
	public int delete(int fSerialNo) {
		String sql = "DELETE FROM t_announcement WHERE fSerialNo=?";
		int result = 0;
		try {
			result = queryRunner.update(sql, fSerialNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int updateBrowseTime(int fSerialNo, int count) {
		String sql = "UPDATE t_announcement SET fBrowseTime=? WHERE fSerialNo=?";
		Object[] params = { count, fSerialNo };
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
	public Announcement find(int fSerialNo) {
		String sql = "SELECT * FROM t_announcement WHERE fSerialNo=?";

		Announcement ann = null;
		try {
			ann = queryRunner.query(sql, new BeanHandler<Announcement>(Announcement.class), fSerialNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ann;
	}

	@Override
	public Announcement findDetail(int fSerialNo) {
		String sql = "SELECT * FROM t_announcement WHERE fSerialNo=?";

		Announcement detail = null;
		try {
			detail = queryRunner.query(sql, new BeanHandler<Announcement>(Announcement.class), fSerialNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * detail = queryRunner.query(sql, new
		 * BeanHandler<Announcement>(Announcement.class),fSerialNo);
		 */
		return detail;
	}

	@Override
	public List<Announcement> findAll() {
		String sql = "SELECT * FROM t_announcement ORDER BY fSerialNo DESC";
		List<Announcement> list = null;

		try {
			list = queryRunner.query(sql, new BeanListHandler<Announcement>(Announcement.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Announcement> getTop(int n) {
		String sql = "SELECT * FROM t_announcement ORDER BY fSerialNo DESC LIMIT ?";
		List<Announcement> list = null;

		try {
			list = queryRunner.query(sql, new BeanListHandler<Announcement>(Announcement.class), n);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Announcement> findByProperty(String property, String key, String order, String sort, int start,
			int end) {

		String sql = "SELECT * FROM t_announcement WHERE " + property + " LIKE '%" + key + "%'" + " ORDER BY " + order
				+ " " + sort + " LIMIT " + start + "," + end;
		List<Announcement> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Announcement>(Announcement.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Announcement> findByProperty(String key, String order, String sort, int start, int end) {
		String sql = "select * from t_announcement where fType='所有可见' or fType='学生可见' or fPublisher='" + key + "'";
		List<Announcement> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Announcement>(Announcement.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
