package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Student;
import henu.dao.IStudentDao;
import henu.factory.DaoFactory;

public class StudentDaoImpl implements IStudentDao {
	
	private QueryRunner queryRunner;
	
	public StudentDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}
	@Override
	public int add(Student student) {
		String sql = "INSERT INTO t_student(fNo,fSname,fMarjor,fGreade,fPlace,"
				+ "fClass,fCNmae,fCid,fPhone,fEmail,fQQ,fTranning,fWork,"
				+ "fState)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Object[] params={student.getFno(),student.getFsname(),student.getFmarjor(),student.getFgreade(),
				student.getFplace(),student.getFclass(),student.getFcnmae(),student.getFcid(),student.getFphone(),
				student.getFemail(),student.getFqq(),student.getFtranning(),student.getFwork(),student.getFstate()
		};
		int result = 0;
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(String fNo) {
		String sql = "DELETE FROM t_student WHERE fNo=?";
		int result = 0;
		try {
			result = queryRunner.update(sql,fNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(String fNo, Student student) {
		String sql = "UPDATE t_student SET fSname=?,fMarjor=?,fGreade=?,fPlace=?,fClass=?,fCNmae=?"
				+ ",fCid=?,fPhone=?,fEmail=?,fQQ=?,fTranning=?,fWork=?,fState=? WHERE fNo=?";
		int result = 0;
		Object[] params = {student.getFsname(),student.getFmarjor(),student.getFgreade(),
				student.getFplace(),student.getFclass(),student.getFcnmae(),student.getFcid(),student.getFphone(),
				student.getFemail(),student.getFqq(),student.getFtranning(),student.getFwork(),student.getFstate(),fNo};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Student> findAll() {
		String sql = "SELECT * FROM t_student ORDER BY fNo ASC";
		List<Student> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Student find(String fNo) {
		String sql = "SELECT * FROM t_student WHERE fNo=?";
		Student student = null;
		try {
			student = queryRunner.query(sql, new BeanHandler<Student>(Student.class),fNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Student> findByProperty(String property, String key, String order, String sort, int start, int end) {
		String sql = "SELECT * FROM t_student WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
		List<Student> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Student> findByProperty1(String property, String key,String order, String sort, int start, int end) {
		String sql = "SELECT * FROM t_student WHERE fNo NOT IN(SELECT fNo FROM t_thesislist) AND "+property+" LIKE '%"+key+"%'  ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
		List<Student> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Student> findByProperty2(String property, String key) {
		String sql = "SELECT * FROM t_student WHERE fNo NOT IN(SELECT fNo FROM t_thesislist) AND "+property+"="+key;
		List<Student> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Student> findByProperty3(String property,String key) {
		String sql = "SELECT * FROM t_student WHERE "+property+"="+key;
		List<Student> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
