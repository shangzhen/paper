package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Announcement;
import henu.bean.Task;
import henu.dao.ITaskDao;
import henu.factory.DaoFactory;

public class TaskDaoImpl implements ITaskDao {
    private QueryRunner queryRunner;
	
	
	public TaskDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}
	
	
	public int add(Task report) {
		String sql = "INSERT INTO t_task(fNo,fTitle,fCollege,fName"
				+ ",fMajor,fRequire,fTime,fTutorName,fAdjunct,fMemo,fReviewTime,fMentorOpinion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {report.getFno(),report.getFtitle()
				,report.getFcollege(),report.getFname(),
				report.getFmajor(),report.getFrequire(),report.getFtime(),
				report.getFtutorName(),report.getFadjunct(),report.getFmemo(),report.getFreviewTime(),report.getFmentorOpinion()};
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	public int update(String fno, Task task) {
		String sql = "UPDATE t_task SET fTitle=?,fCollege=?,fName=?,fMajor=?,"
				+ "fRequire=?,fTime=?,fTutorName=?,fAdjunct=?,fMemo=?,fReviewTime=?,fMentorOpinion=? WHERE fNo=?";
		Object[] params = {task.getFtitle()
				,task.getFcollege(),task.getFname(),
				task.getFmajor(),task.getFrequire(),task.getFtime(),
				task.getFtutorName(),task.getFadjunct(),task.getFmemo(),task.getFreviewTime(),task.getFmentorOpinion(),fno};
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	public int delete(String fno) {
		String sql = "DELETE FROM t_task WHERE fNo=?";
		int result = 0;
		try {
			result = queryRunner.update(sql, fno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	public List<Task> findAll() {
		String sql = "SELECT * FROM t_task ORDER BY fNo DESC";
		List<Task> list = null;
		
		try {
			list = queryRunner.query(sql, new BeanListHandler<Task>(Task.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	public Task find(String fno) {
       String sql = "SELECT * FROM t_task WHERE fNo=?";
		
       Task task = null;
		try {
			task = queryRunner.query(sql, new BeanHandler<Task>(Task.class),fno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return task;
	}

	
	public List<Task> findByTeacher(String teacherId) {
		String sql = "SELECT * FROM t_task WHERE fTutorName = ?";
		
		List<Task> list = null;
		
		try {
			list = queryRunner.query(sql, new BeanListHandler<Task>(Task.class),teacherId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}

	
	public List<Task> findByProperty(String property, String key,String order, String sort,
			int start, int end) {
		String sql = "SELECT * FROM t_task WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
		
			List<Task> list = null;
			try {
				list = queryRunner.query(sql, new BeanListHandler<Task>(Task.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
	}
	/*public static void main(String[] args) {
		Task a = new Task();
		a.setfNo("7");
		a.setfTitle("title7");
		a.setfMajor("11111");
		a.setfName("12312");
		a.setfTutorName("zs4");
		ITaskDao adao = DaoFactory.createTaskDao();
		adao.delete(1);
		adao.add(a);
		
		adao.update("7",a);
		
	    List<Task> list = adao.findByTeacher("zs");
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println( list.get(i).getfName());
		}
	}*/
}
