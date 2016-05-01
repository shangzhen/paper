package henu.dao;

import java.util.List;

import henu.bean.Teacher;

/**
 * 教师表t_teacher的DAO层操作
 * @author 梁胜彬
 * 2015年10月12日
 */

public interface ITeacherDao {
	/**
	 * 登陆
	 * @param fNo
	 * @param fTPsw
	 * @param fTType
	 * @return
	 */
	public Teacher login(String fNo,String fTPsw,String fTType);
	/**
	 * 添加
	 * @param teacher
	 * @return
	 */
	public int add(Teacher	 teacher);
	/**
	 * 修改
	 * @param fTid
	 * @param teacher
	 * @return
	 */
	public int update(String fTid, Teacher teacher);
	/**
	 * 根据教工号删除
	 * @param fTid
	 * @return
	 */
	public int delete(String fTid);
	/**
	 * 查找所有教师
	 * @return
	 */
	public List<Teacher> findAll();
	/**
	 * 根据教工号查找开题报告
	 * @param fNo
	 * @return
	 */
	public Teacher find(String fTid);
	
	
	/**
	 * 模糊查找 
	 * @param Property 字段名
	 * @param key 值
	 * *@param Property1 字段名
	 * @param key1 值
	 * @param order 排序字段
	 * @param sort 排序方式
	 * @return
	 */
	public List<Teacher> findByProperty(String property, String key,
			String order, String sort, int start, int end);
/**
 * 
 * @param fNo
 * @param OldfTPsw 旧密码
 * @param NewfTPsw 新密码
 * @param act 用户类型
 * @return
 */
	public int resetPassword(String fNo ,String OldfTPsw, String NewfTPsw ,String act);

}
