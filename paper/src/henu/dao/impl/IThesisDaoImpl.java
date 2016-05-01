package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Thesis;
import henu.dao.IThesisDao;
import henu.factory.DaoFactory;

public class IThesisDaoImpl implements IThesisDao {
	private QueryRunner queryRunner;
	public IThesisDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}
	public int update(String fNo,Thesis thesis) {
		String sql = "UPDATE t_thesis SET fThePro=?,fTask=?,fMidCheck=?"
				+ ",fFinalDraft=?,fScore=?,fSenceRep=?,fEvaluate=?,fRepeat=?,fMemo=?,fTid=? WHERE fNo= ?";
	
		int result = 0 ;
		Object[] params = {thesis.getfThePro(),thesis.getfTask()
				,thesis.getfMidCheck(),thesis.getfFinalDraft(),
				thesis.getfScore(),thesis.getfSenceRep(),thesis.getfEvaluate(),
				thesis.getfRepeat(),thesis.getfMemo(),thesis.getfTid(),fNo};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return result;
	}
	public Thesis findByNo(String fNo){
		String sql = "SELECT * FROM t_thesis WHERE fNo=?";
		
        Thesis ts = null;
		try {
			ts = queryRunner.query(sql, new BeanHandler<Thesis>(Thesis.class),fNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ts;
		
	}
	/**
	 * 尚振
	 * 评阅教师批改完成绩之后，修改状态表中的成绩评定(评定结果)，值改为1。
	 * */
	public int update1(String fNo) {
		String sql = "UPDATE t_thesis SET fScore=? WHERE fNo= ?";
	
		int result = 0 ;
		Object[] params = {1,fNo};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return result;
	}
	/**
	 * 尚振
	 * 评阅教师批改完答辩成绩之后，修改状态表中的现场答辩(是否通过)，值改为1。
	 * */
	public int update2(String fNo) {
		String sql = "UPDATE t_thesis SET fMemo=?,fSenceRep=? WHERE fNo= ?";
		int result = 0 ;
		Object[] params = {1,1,fNo};
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
	public List<Thesis> findAll() {
		String sql = "SELECT * FROM t_thesis ORDER BY fNo DESC";
		List<Thesis> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Thesis>(Thesis.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*throw new RuntimeException();*/
		}
		return list;
		
	}

	@Override
	public List<Thesis> findByProperty(String property, String key, String property1, String key1, String order,
			String sort, int start, int end) {
		String sql = "SELECT * FROM t_thesis WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
		List<Thesis> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Thesis>(Thesis.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		return list;
	}

	@Override
	public List<Thesis> findByTeacher(String teacherId) {
		String sql = "SELECT * FROM t_thesis WHERE fteacherId=?";
		List<Thesis> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Thesis>(Thesis.class),teacherId);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
			return list;
	}
	@Override
	public int add(Thesis thesis) {
		String sql = "INSERT INTO t_thesis(fNo,fThePro,fTask,fMidCheck"
				+ ",fFinalDraft,fScore,fSenceRep,fEvaluate,fRepeat,fMemo,fTid) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {thesis.getfNo(),thesis.getfThePro(),thesis.getfTask()
				,thesis.getfMidCheck(),thesis.getfFinalDraft(),
				thesis.getfScore(),thesis.getfSenceRep(),thesis.getfEvaluate(),
				thesis.getfRepeat(),thesis.getfMemo(),thesis.getfTid()};
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

	

	/*public static void main(String[] args) {
		Thesis t = new Thesis();
		t.setfThePro("���ⱨ��");
		t.setfTask("�����");
		t.setfMidCheck("���ڼ��");
		t.setfFinalDraft("�ո�");
		t.setfScore("�ɼ��ж�");
		t.setfSenceRep("�ֳ����");
		t.setfEvaluate("�������");
		t.setfRepeat("����");
		t.setfTid("2");
		t.setfMemo("��ע");
		
		IThesisDaoImpl idao = DaoFactory.createIThesisDao();
		
		List<Thesis> list = idao.findAll();
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println( list.get(i).getfThePro());
		}
	}
	*/

}
