package henu.dao;

import java.util.List;
import henu.bean.Score;

/**
 * ��ʦ���ĵ÷ֱ�DAO��ӿ�
 * @author ��ʤ��
 * 2015��10��12��
 */
public interface IScoreDao {
	/**
	 * ���
	 * @param score
	 * @return
	 */
	public int add(Score score);
	/**
	 * �޸�
	 * @param fNo
	 * @param score
	 * @return
	 */
	public int update(String fNo, Score score);
	
	/**
	 * �޸�
	 * @param fNo
	 * @param score
	 * @return
	 */
	public int update1(String fNo, Score score);
	
	/**
	 * �޸�
	 * @param fNo
	 * @param score
	 * @return
	 */
	public int update2(String fNo, String title);
	public int update3(String fNo, String title,String tname,String profession,String sname);
	
	public int update4(String fNo, Score score);
	
	
	public int update5(String fNo, Score score);
	/**
	 * ����ѧ��ɾ��
	 * @param fNo
	 * @return
	 */
	public int delete(String fNo);
	/**
	 * �������п��ⱨ��
	 * @return
	 */
	public List<Score> findAll();
	/**
	 * ����ѧ�Ų��ҿ��ⱨ��
	 * @param fNo
	 * @return
	 */
	public Score find(String fNo);
	
	/**
	 * ����ָ����ʦ����
	 * @param teacherId
	 * @return
	 */
	

	
	public List<Score> findByStuderntId(String teacherId);

	/**
	 * ģ������ 
	 * @param Property �ֶ���
	 * @param key ֵ
	 * *@param Property1 �ֶ���
	 * @param key1 ֵ
	 * @param order �����ֶ�
	 * @param sort ����ʽ
	 * @return
	 */
	public List<Score> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end);

}
