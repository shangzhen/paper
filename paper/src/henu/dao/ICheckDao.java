package henu.dao;

import java.util.List;

import henu.bean.Check;

/**
 * Check对应的DAO层接口
 * @author 梁胜彬
 * 2015年10月12日
 */
public interface ICheckDao {
	/**
	 * 添加操作
	 * @param check
	 * @return
	 */
	public int add(Check check);
	/**
	 * 根据学号删除
	 * @param fNo
	 * @return
	 */
	public int delete(String fNo);
	/**
	 * 根据学号修改记录
	 * @param fNo 学号
	 * @param check 中期检查报告
	 * @return
	 */
	public int update(String fNo,Check check);
	/**
	 * 根据学号单个查询
	 * @param fNO 学号
	 * @return
	 */
	public Check find(String fNO);
	/**
	 * 查找所有
	 * @return
	 */
	public List<Check> findAll();
	/**
	 * 根据属性查找
	 * @param property 属性名
	 * @param key 关键字
	 * @param order 排序字段
	 * @param sort 排序方式
	 * @param start 该页起始记录
	 * @param end 该页的显示记录数
	 * @return
	 */
	public List<Check> findByProperty(String property, String key, String order,
			String sort, int start, int end);
}
