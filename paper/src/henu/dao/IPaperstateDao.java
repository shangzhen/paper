package henu.dao;

import java.util.List;

import henu.bean.Paperstate;

public interface IPaperstateDao {

	/**
	 * 添加一条学生状态信息
	 * @param paperstate
	 * @return 
	 */
	public int add(Paperstate paperstate);
	/**
	 * 删除一条学生状态信息
	 * @param fno
	 * @return
	 */
	public int delete(String fno);
	/**
	 * 更新一条学生论文状态信息
	 * @param fno
	 * @param paperstate
	 * @return
	 */
	public int update(String fno,Paperstate paperstate);
	/**
	 * 修改学生指定属性的值。
	 * @param fno  学号
	 * @param property 属性（字段名）
	 * @param value 属性值
	 * @return 
	 */
	public int update(String fno,String property,String value);
	
	/**
	 * 根据学号获取一条学生论文状态信息
	 * @param fno
	 * @return
	 */
	public Paperstate find(String fno);
	
	/**
	 * 根据教师的工号获取所带学生的所有状态信息
	 * @param ftid
	 * @return
	 */
	public List<Paperstate> findAll(String ftid, int start, int end);
	/**
	 * 根据属性进行查找
	 * @param property
	 * @param key
	 * @param order
	 * @param sort
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Paperstate> findByProperty(String property, String key,
			int start, int end);
}
