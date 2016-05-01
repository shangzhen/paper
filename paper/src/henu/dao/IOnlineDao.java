package henu.dao;

import java.util.List;

import henu.bean.Online;

/**
 * 在线咨询表的DAO操作
 * @author 梁胜彬
 * 2015年10月12日
 */
public interface IOnlineDao {
	/**
	 * 添加
	 * @param online
	 * @return
	 */
	public int add(Online online);
	/**
	 * 删除
	 * @param fId
	 * @return
	 */
	public int delete(int fId);
	/**
	 * 根据主键查找单个记录
	 * @param fId
	 * @return
	 */
	public Online find(int fId);
	/**
	 * 回复指定的信息
	 * @param fId
	 * @param online
	 * @return
	 */
	public int reply(int fId, Online online);
	/**
	 * 查找所有
	 * @return
	 */
	public List<Online> findAll();
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
	public List<Online> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end);
	/**
	 * 根据条件查询 
	 * @param Property 字段名
	 * @param key 值
	 * @param order 排序字段
	 * @param sort 排序方式
	 * @return
	 */
	public List<Online> findByProperty(String property, String key,String order, 
			String sort, int start, int end);
	/**
	 * 查看所有已回复留言
	 * @param order 排序字段
	 * @param sort 排序方式
	 * @return
	 */
	public List<Online> findByOut(String order,String sort, int start, int end);
	/**
	 * 根据教师工号查看教师未回复的留言
	 * @param fTNo 教师工号（两个表联合查询）
	 * @param order 排序字段
	 * @param sort 排序方式
	 * @param start 开始行
	 * @param end	结束行
	 * @return
	 */
	public List<Online> findByTeacher(String fTNo,String order,String sort, int start, int end);
	/**
	 * 根据教师工号查看教师已经回复的留言
	 * @param fTNo	教师工号（两个表联合查询）
	 * @param order	排序字段
	 * @param sort	排序方式
	 * @param start	开始行
	 * @param end	结束行
	 * @return
	 */
	public List<Online> findByTeacherOut(String fTNo,String order,String sort, int start, int end);
}
