package henu.dao;
import java.util.List;
import henu.bean.Announcement;;
/**
 * Announcement的DAO操作接口
 * @author 梁胜彬
 * 2015年10月12日
 */
public interface IAnnouncementDao {
	/**
	 * 更改记录
	 * @param fSerialNo
	 * @return
	 */
	public int update(int fSerialNo,Announcement announcement);
	/**
	 * 添加
	 * @param announcement
	 * @return
	 */
	public int add(Announcement announcement);
	/**
	 * 根据主键删除
	 * @param fSerialNo
	 * @return
	 */
	public int delete(int fSerialNo);
	
	/**
	 * 更改浏览次数
	 * @param fSerialNo#主键
	 * @param count#新的浏览次数
	 * @return
	 */
	public int updateBrowseTime(int fSerialNo,int count);
	
	/**
	 * 根据主键查询单个记录
	 * @param fSerialNo
	 * @return
	 */
	public Announcement find(int fSerialNo);
	/**
	 * 查看详细信息
	 * @param fSerialNo
	 * @return
	 */
	public Announcement findDetail(int fSerialNo);
	/**
	 * 查找所有记录
	 * @return
	 */
	public List<Announcement> findAll();
	/**
	 * 获取公告前n条记录
	 * @param n 记录个数
	 * @return
	 */
	public List<Announcement> getTop(int n);
	
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
	List<Announcement> findByProperty(String property, String key,
			String order,String sort, int start, int end);
	/**
	 * 根据属性查找1
	 * @param key 关键字
	 * @param order 排序字段
	 * @param sort 排序方式
	 * @param start 该页起始记录
	 * @param end 该页的显示记录数
	 * @return
	 */
	List<Announcement> findByProperty(String key,String order,String sort, int start, int end);
	
}
