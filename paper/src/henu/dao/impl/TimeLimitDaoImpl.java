package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Announcement;
import henu.bean.TimeLimit;
import henu.dao.IAnnouncementDao;
import henu.dao.ITimeLimitDao;
import henu.factory.DaoFactory;
import henu.util.LSFUtils;

public class TimeLimitDaoImpl implements ITimeLimitDao{
	
	private QueryRunner queryRunner;
	public TimeLimitDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}
/**
 * 在t_timeLimit表里添加数据
 * fJobTasks  工作任务
 * fTimeRequirement  时间要求
 * fRemindContent 提醒内容
 * fRemindTime 提醒时间
 * fTid 教师ID
 */
	@Override
	public int add(TimeLimit timeLimit) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO t_timelimit(fJobTasks,fTimeRequirement,fRemindContent,fRemindTime,fTid)VALUES(?,?,?,?,?)";
		Object[] params = {timeLimit.getFjobTasks(),timeLimit.getFtimeRequirement(),
				timeLimit.getFremindContent(),timeLimit.getFremindTime(),timeLimit.getFtid()};
		
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 在t_timeLimit表功更新数据
	 * fJobTasks  工作任务
	 * fTimeRequirement  时间要求
	 * fRemindContent 提醒内容
	 * fRemindTime 提醒时间
	 * fTid 教师ID
	 */
	@Override
	public int update(String fId, TimeLimit report) {
		// TODO Auto-generated method stub
		String sql = "UPDATE t_timelimit SET fJobTasks=?,fTimeRequirement=?,fRemindContent=?,fRemindTime=? WHERE fid=?";
		
		Object[] params = {report.getFjobTasks(),report.getFtimeRequirement(),report.getFremindContent(),
				          report.getFremindTime(),fId};
		int result = 0;
		try {
			result = queryRunner.update( sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 在t_timeLimit表中根据fId 删除数据
	 * fJobTasks  工作任务
	 * fTimeRequirement  时间要求
	 * fRemindContent 提醒内容
	 * fRemindTime 提醒时间
	 * fTid 教师ID
	 */
	@Override
	public int delete(String fId) {
		// TODO Auto-generated method stub
		String sql="DELETE  from t_timelimit WHERE fId=?";
		int result = 0;
		try {
			result = queryRunner.update(sql,fId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 在t_timeLimit表里查询出所以信息
	 * fJobTasks  工作任务
	 * fTimeRequirement  时间要求
	 * fRemindContent 提醒内容
	 * fRemindTime 提醒时间
	 * fTid 教师ID
	 */
	@Override
	public List<TimeLimit> findAll() {
		// TODO Auto-generated method stub
		String sql ="SELECT * FROM t_timelimit ORDER BY fId desc";
		List<TimeLimit> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<TimeLimit>(TimeLimit.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * 在t_timeLimit表里根据ID进行查询
	 * fJobTasks  工作任务
	 * fTimeRequirement  时间要求
	 * fRemindContent 提醒内容
	 * fRemindTime 提醒时间
	 * fTid 教师ID
	 */
	@Override
	public TimeLimit find(String fId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM t_timelimit WHERE fId=?";
		TimeLimit tl=null;
		try {
			tl = queryRunner.query(sql, new BeanHandler<TimeLimit>(TimeLimit.class),fId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tl;
	}
	/**
	 * 在t_timeLimit表里根据日期进行查询
	 * fJobTasks  工作任务
	 * fTimeRequirement  时间要求
	 * fRemindContent 提醒内容
	 * fRemindTime 提醒时间
	 * fTid 教师ID
	 */
	@Override
	public TimeLimit findByDate(String time) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM t_timelimit Where fRemindTime=?";
		TimeLimit tl = null;
		try {
			tl = queryRunner.query(sql, new BeanHandler<TimeLimit>(TimeLimit.class),time);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tl;
	}
	/**
	 * 在t_timeLimit根据老师ID进行查询
	 * fJobTasks  工作任务
	 * fTimeRequirement  时间要求
	 * fRemindContent 提醒内容
	 * fRemindTime 提醒时间
	 * fTid 教师ID
	 */
	@Override
	public List<TimeLimit> findByTeacher(String teacherId) {
		String sql="SELECT * FROM t_timelimit WHERE fTid=? ORDER BY fId DESC LIMIT?";
		List<TimeLimit> list =null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<TimeLimit>(TimeLimit.class),teacherId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}
	/**
	 * 在t_timeLimit表里信息进行查询  ，并进行分页显示
	 * fJobTasks  工作任务
	 * fTimeRequirement  时间要求
	 * fRemindContent 提醒内容
	 * fRemindTime 提醒时间
	 * fTid 教师ID
	 */
	@Override
	public List<TimeLimit> findByProperty(String property, String key, String property1, String key1, String order,
			String sort, int start, int end) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM t_timelimit WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
		List<TimeLimit> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<TimeLimit>(TimeLimit.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
	
		
	}
	@Override
	public List<TimeLimit> findByStudentId(String stuId) {
		//获取评阅老师工号
		String ftid_p = DaoFactory.createDistribution().findFtidByStudentId(stuId);
		//获取指导老师工号
		String ftid_z = DaoFactory.createIThesisListDao().find(stuId).getFtid();
		String sql="SELECT * FROM t_timelimit WHERE fTid=? or fTid=? ORDER BY fTimeRequirement";
		List<TimeLimit> list =null;
		Object[] params = {ftid_p, ftid_z};
		try {
			list = queryRunner.query(sql, new BeanListHandler<TimeLimit>(TimeLimit.class),params);
			System.out.println("Begin:" + list.size());
			for(int i = 0; i < list.size(); i++){
				if(LSFUtils.getBetweenTime(list.get(i).getFtimeRequirement())>list.get(i).getFremindTime()){
					list.remove(i);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("After:" + list.size());
		return list;
	}

}
