package henu.dao;

import java.util.List;

import henu.bean.OpeningReport;
import henu.bean.ThesisList;

/**
 * 锟斤拷锟侥凤拷锟斤拷锟斤拷锟斤拷DAO锟斤拷锟斤拷锟�
 * @author 锟斤拷胜锟斤拷
 * 2015锟斤拷10锟斤拷12锟斤拷
 */
public interface IThesisListDao {
	/**
	 * 锟斤拷陆
	 * @param fno学锟斤拷
	 * @param id 锟斤拷锟斤拷锟斤拷锟街わ拷锟斤拷锟轿伙拷锟�
	 * @return
	 */
	public ThesisList login(String fNo,String id);
	/**
	 * 锟斤拷锟�
	 * @param thesisList
	 * @return
	 */
	public int add(ThesisList thesisList);
	/**
	 * 锟斤拷锟斤拷学锟斤拷锟睫革拷
	 * @param fNo
	 * @param thesisList
	 * @return
	 */
	public int update(String fNo,ThesisList thesisList);
	
	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷
	 * @return
	 */
	public List<ThesisList> findAll();
	/**
	 * 锟斤拷锟斤拷学锟脚诧拷锟斤拷
	 * @param fNo
	 * @return
	 */
	public ThesisList find(String fNo);
	
	public ThesisList findState(String fNo);
	
	/**
	 * 锟斤拷锟斤拷指锟斤拷锟斤拷师锟斤拷锟斤拷
	 * @param teacherId
	 * @return
	 */
	public List<ThesisList> findByTeacher(String teacherId);

	/**
	 * 模锟斤拷锟斤拷锟斤拷 
	 * @param Property 锟街讹拷锟斤拷
	 * @param key 值
	 * *@param Property1 锟街讹拷锟斤拷
	 * @param key1 值
	 * @param order 锟斤拷锟斤拷锟街讹拷
	 * @param sort 锟斤拷锟斤拷式
	 * @return
	 */
	public List<ThesisList> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end);
	/**
	 * 
	 * @param fNo
	 * @param OldId 锟斤拷锟斤拷锟斤拷
	 * @param NewId 锟斤拷锟斤拷锟斤拷
	 * @return
	 */
	public ThesisList resetPassword(String fNo,String OldId,String NewId);
	
	/**
	 * 获取在校或毕业的导师工号列表
	 * @param state：在校或毕业
	 * @return List
	 */
	public List<Object[]> getTeacherList(String state);
	
	/**
	 * 根据导师工号和学生状态查找导师所指导的学生列表。
	 * @param TNo
	 * @param state
	 * @return
	 */
	public List<Object[]> getStudentList(String TNo, String state);
	
	

}
