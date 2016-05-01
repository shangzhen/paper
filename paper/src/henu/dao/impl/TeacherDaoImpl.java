package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Announcement;
import henu.bean.Task;
import henu.bean.Teacher;
import henu.dao.IAnnouncementDao;
import henu.dao.ITeacherDao;
import henu.factory.DaoFactory;
import henu.util.Md5Token;

public class TeacherDaoImpl implements ITeacherDao {
  
	private QueryRunner queryRunner;
	

	public TeacherDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}

	@Override
	public int add(Teacher teacher) {
		String sql = "INSERT INTO t_teacher(fTid,fName,fDepartment,"
				+ "fPosition,fPhone,fEmail,fQQ,fQGNo,fPsw,fType,"
				+ "fMemo,fCollege)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Object[] params={teacher.getFtid(),teacher.getFname(),
				teacher.getFdepartment(),teacher.getFposition(),teacher.getFphone(),
				teacher.getFemail(),teacher.getFqq(),teacher.getFqgno(),
				teacher.getFpsw(),teacher.getFtype(),teacher.getFmemo(),
				teacher.getFcollege()};
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
	public int update(String fTid, Teacher teacher) {
		String sql ="UPDATE t_teacher SET fName=?,fDepartment=?,fPosition=?,fPhone=?,"
				+ "fEmail=?,fQQ=?,fQGNo=?,fType=?,fMemo=?,fCollege=? WHERE fTid=?";
		int result = 0;
		Object[] params = {teacher.getFname(),teacher.getFdepartment(),teacher.getFposition(),
				teacher.getFphone(),teacher.getFemail(),teacher.getFqq(),teacher.getFqgno(),
				teacher.getFtype(),teacher.getFmemo(),teacher.getFcollege(),fTid};
		
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(String fTid) {
		String sql="DELETE FROM t_teacher WHERE fTid=?";
		int result = 0;
		try {
			result = queryRunner.update(sql,fTid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Teacher> findAll() {
		String sql = "SELECT * FROM t_teacher ORDER BY fTid DESC";
		List<Teacher> list = null;
		
		try {
			list = queryRunner.query(sql, new BeanListHandler<Teacher>(Teacher.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Teacher find(String fTid) {
		String sql = "SELECT * FROM t_teacher WHERE fTid=?";
		
		Teacher teacher = null;
			try {
				teacher = queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class),fTid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return teacher;
	}

	@Override
	public List<Teacher> findByProperty(String property, String key,
			 String order, String sort,int start, int end) {
		String sql = "SELECT * FROM t_teacher WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
		
			List<Teacher> list = null;
			try {
				list = queryRunner.query(sql, new BeanListHandler<Teacher>(Teacher.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
	}

	@Override
	public Teacher login(String fNo, String fTPsw, String fTType) {
		String tpsw = Md5Token.getInstance().getLongLongToken(fTPsw);
		
		String sql = "SELECT * FROM t_teacher WHERE fTid=? AND fPsw=? AND fType=?";
		Teacher  teacher = null;
		 Object[] params = {fNo,tpsw,fTType};
		try{
			teacher = queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class),params);
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}

	@Override
	public int resetPassword(String fNo, String OldfTPsw, String NewfTPsw,String act) {
		String sql = "UPDATE t_teacher SET fPsw=? WHERE fTid=?";
		int teacher = 0;
		Object[] params = {NewfTPsw,fNo};
		if(login(fNo,OldfTPsw,act)!=null)
		{
			try {
				teacher = queryRunner.update(sql,params);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return teacher;
	}

	/*public static void main(String[] args) {*/
		/*Teacher a = new Teacher();
		a.setfTid("6");
		a.setfType("title2");
		a.setfMemo("111111");
		a.setfName("123121");*/
		
		/*ITeacherDao adao = DaoFactory.createTeacherDao();*/
//		adao.delete("2");
	/*	adao.add(a);*/
		
		/*adao.update("7",a);*/
		
		/*Teacher adao1 = adao.find("5");*/
		
		
		/*List<Teacher> list = adao.findAll();
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println( list.get(i).getfType());
		}*/
	//}
	
}
