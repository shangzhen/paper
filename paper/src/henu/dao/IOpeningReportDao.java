package henu.dao;

import java.util.List;

import henu.bean.OpeningReport;
/**
 * 开题报告的DAO操作
 * @author 梁胜彬
 * 2015年10月12日
 */
public interface IOpeningReportDao {
	/**
	 * 添加
	 * @param report
	 * @return
	 */
	public int add(OpeningReport report);
	/**
	 * 修改
	 * @param fNo
	 * @param report
	 * @return
	 */
	public int update(String fNo, OpeningReport report);
	/**
	 * 根据学号删除
	 * @param fNo
	 * @return
	 */
	public int delete(String fNo);
	/**
	 * 查找所有开题报告
	 * @return
	 */
	public List<OpeningReport> findAll();
	/**
	 * 根据学号查找开题报告
	 * @param fNo
	 * @return
	 */
	public OpeningReport find(String fNo);
	
	/**
	 * 根据指导教师查找
	 * @param teacherId
	 * @return
	 */
	public List<OpeningReport> findByTeacher(String teacherId);

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
	public List<OpeningReport> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end);

	
}
