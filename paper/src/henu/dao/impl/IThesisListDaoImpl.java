package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import henu.bean.Thesis;
import henu.bean.ThesisList;
import henu.dao.IThesisListDao;
import henu.factory.DaoFactory;
import henu.util.Md5Token;

public class IThesisListDaoImpl implements IThesisListDao {
	private QueryRunner queryRunner;
	public IThesisListDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}
	
	@Override
	public int add(ThesisList thesisList) {
		String sql = "INSERT INTO t_thesislist(fNo,fSName,fGrade,fProfessional,fTid"
				+ ",fTName,fState,fPrimaryWork,fPrimaryPay,fLeaveSchoolWork,fPay,fPsw"
				+ ",fDepartment,fMemo) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {thesisList.getFno(),thesisList.getFsName(),thesisList.getFgrade(),thesisList.getFprofessional(),thesisList.getFtid(),thesisList.getFtName(),
				thesisList.getFstate(),thesisList.getFprimaryWork(),thesisList.getFprimaryPay(),thesisList.getFleaveSchoolWork(),thesisList.getFpay(),thesisList.getFpsw(),thesisList.getFdepartment(),thesisList.getFmemo()};
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		return result;
	}
	@Override
	public int update(String fno, ThesisList thesisList) {
		String sql = "UPDATE t_thesislist SET fSName=?,fProfessional=?,fGrade=?,fTid=?"
				+ ",fTName=?,fState=?,fPrimaryWork=?,fPrimaryPay=?,fLeaveSchoolWork=?,fPay=?,fPsw=?"
				+ ",fDepartment=?,fMemo=? WHERE fNo=?";
		int result = 0 ;
		Object[] params = {thesisList.getFsName(),thesisList.getFprofessional()
				,thesisList.getFgrade(),thesisList.getFtid(),thesisList.getFtName(),
				thesisList.getFstate(),thesisList.getFprimaryWork(),thesisList.getFprimaryPay()
				,thesisList.getFleaveSchoolWork(),thesisList.getFpay(),thesisList.getFpsw(),thesisList.getFdepartment()
				,thesisList.getFmemo(),fno};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return result;
	}

	@Override
	public List<ThesisList> findAll() {
		String sql = "SELECT * FROM t_thesislist ORDER BY fNo DESC";
		List<ThesisList> list = null;
		
		try {
			list = queryRunner.query(sql, new BeanListHandler<ThesisList>(ThesisList.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		return list;
	}

	@Override
	public ThesisList find(String fNo) {
		String sql = "SELECT * FROM t_thesislist WHERE fNo=?";
		
		ThesisList tl = null;
		try {
			tl = queryRunner.query(sql, new BeanHandler<ThesisList>(ThesisList.class),fNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		return tl;
	}

	@Override
	public ThesisList findState(String fNo) {
		String sql = "SELECT * FROM t_thesislist WHERE fState=0 AND fTId=?";
		
		ThesisList tl = null;
		try {
			tl = queryRunner.query(sql, new BeanHandler<ThesisList>(ThesisList.class),fNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		return tl;
	}
	@Override
	public List<ThesisList> findByTeacher(String teacherId) {
		String sql = "SELECT * FROM t_thesislist WHERE fTNo = ?  ORDER BY fNo DESC";
		List<ThesisList> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<ThesisList>(ThesisList.class),teacherId);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
			return list;
	}

	@Override
	public List<ThesisList> findByProperty(String property, String key, String property1, String key1, String order,
			String sort, int start, int end) {
		String sql = "SELECT * FROM t_thesislist WHERE fState=0 AND " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
			List<ThesisList> list = null;
			try {
				list = queryRunner.query(sql, new BeanListHandler<ThesisList>(ThesisList.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
			
			return list;
	}
	@Override
	public ThesisList login(String fNo, String id) {
		String psw = Md5Token.getInstance().getLongLongToken(id);
		
		 String sql = "SELECT * FROM t_thesislist WHERE fNo=? AND fPsw=?";
		 ThesisList t1 = null;
		 Object[] params = {fNo,psw};
		 try {
				t1 = queryRunner.query(sql,new BeanHandler<ThesisList>(ThesisList.class),params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
		 return t1;
	}

	@Override
	public ThesisList resetPassword(String fNo, String OldId, String NewId) {
		//String sql = "UPDATE t_thesislist SET fPsw='" + NewId  +"'WHERE fNo='" + fNo +"'";
		String sql = "UPDATE t_thesislist SET fPsw= ? WHERE fNo = ?";
		ThesisList thesisList = null;
		int result = 0;
		if(login(fNo,OldId)!=null)
		{
			try {
				Object[] objects = new Object[]{NewId,fNo};
				result = queryRunner.update(sql,objects);
				if(result!=0){
					String sql1 = "SELECT * FROM t_thesislist WHERE fNo = " + fNo;
					
					thesisList = queryRunner.query(sql1, new BeanHandler<ThesisList>(ThesisList.class));
				}
				//t1 = queryRunner.query(sql, new BeanHandler<ThesisList>(ThesisList.class),objects);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return thesisList;
	}
	@Override
	public List<Object[]> getTeacherList( String state) {
		String sql = "SELECT DISTINCT fTNo FROM t_thesislist WHERE fState = '" + state  + "'";
		List<Object[]> result = null;
		
		try {
			result = queryRunner.query(sql, new ArrayListHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return result;
	}

	@Override
	public List<Object[]> getStudentList(String TNo, String state) {
		String sql = "SELECT fNo FROM t_thesislist where ftno = ? and fState = ?";
		List<Object[]> result = null;
		Object[] params = {TNo,state};
		try {
			result = queryRunner.query(sql, new ArrayListHandler(), params);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	

}
