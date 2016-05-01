package henu.dao.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Registration;
import henu.dao.IRegistrationDao;
import henu.factory.DaoFactory;

public class RegistrationDaoImpl implements IRegistrationDao {

	private QueryRunner queryRunner;
	public RegistrationDaoImpl(QueryRunner queryRunner)
	{
		super();
		this.queryRunner = queryRunner;
	}
	
	@Override
	public int add(Registration registration) {
		String sql = "INSERT INTO t_registration(fName,fDefencePlace,fThesisTopic,fReleaseTime"
				+ ",fGuideTeacher,fNo,fnoticeId) VALUES(?,?,?,?,?,?,?)";
		Object[] params = {registration.getfName(),registration.getfDefencePlace(),registration.getfThesisTopic()
					,registration.getfReleaseTime(),registration.getfGuideTeacher(),registration.getfNo()
					,registration.getfNoticeId()};
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
		String sql = "DELETE FROM t_registration WHERE fId=?";
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
	public int update(int fId, Registration registration) {
		String sql = "UPDATE t_registration SET fName=?,fDefencePlace=?,fThesisTopic=?"
					+ ",fReleaseTime=?,fGuideTeacher=?,fNo=?,fNoteceId=? WHERE fId=?";
		int result = 0;
		Object[] params = {registration.getfName(),registration.getfDefencePlace(),registration.getfThesisTopic(),
						registration.getfReleaseTime(),registration.getfGuideTeacher(),registration.getfNo(),
						fId};
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Registration> findByNotice(int fNoticeId) {
		String sql = "SELECT * FROM t_registration ORDER BY fNoticedId Desc";
		List<Registration> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Registration>(Registration.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Registration find(int fId) {
		String sql = "SELECT * FROM t_registration WHERE fId=?";
		Registration reg = null;
		try {
			reg = queryRunner.query(sql, new BeanHandler<Registration>(Registration.class),fId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reg;
	}

	@Override
	public List<Registration> findAll() {
		String sql ="SELECT * FROM t_registration ORDER BY fId DESC";
		List<Registration> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Registration>(Registration.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Registration> findByProperty(String property, String key, String property1, String key1, String order,
			String sort, int start, int end) {
		String sql = "SELECT * FROM t_registration WHERE " + property + "LIKE '%" + key + "%'" + property + "LIKE '%" + key1 + "%'" +
			"ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
		List<Registration> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Registration>(Registration.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

}
