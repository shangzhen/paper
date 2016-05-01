package henu.dao;

import java.util.List;

import henu.bean.Registration;
/**
 * Regstration的DAO层操作接口
 * @author 梁胜彬
 * 2015年10月12日
 */
public interface IRegistrationDao {
	/**
	 * 添加
	 * @param registration
	 * @return
	 */
	public int add(Registration registration);
	/**
	 * 根据主键删除
	 * @param fId
	 * @return
	 */
	public int delete(int fId);
	/**
	 * 更新记录
	 * @param fId
	 * @param registration
	 * @return
	 */
	public int update(int fId,Registration registration);
	/**
	 * 根据答辩公告查找答辩预约名单
	 * @param fNoticeId
	 * @return
	 */
	public List<Registration> findByNotice(int fNoticeId); 
	/**
	 * 根据主键查找单个记录
	 * @param fId
	 * @return
	 */
	public Registration find(int fId);
	/**
	 * 查找所有
	 * @return
	 */
	public List<Registration> findAll();
	
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
	public List<Registration> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end);

}
