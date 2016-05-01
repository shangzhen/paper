package henu.dao;

import java.util.List;
import henu.bean.TimeLimit;

/**
 * ʱ�����Ʊ�DAO��ӿ�
 * @author ��ʤ��
 * 2015��10��12��
 */
public interface ITimeLimitDao {
	/**
	 * ���
	 * @param timeLimit
	 * @return
	 */
	public int add(TimeLimit timeLimit);
	/**
	 * �޸�
	 * @param fId
	 * @param report
	 * @return
	 */
	public int update(String fId, TimeLimit report);
	/**
	 * ��������ɾ��
	 * @param fId
	 * @return
	 */
	public int delete(String fId);
	/**
	 * ��������
	 * @return
	 */
	public List<TimeLimit> findAll();
	/**
	 * ������������
	 * @param fId
	 * @return
	 */
	public TimeLimit find(String fId);
	/**
	 * ���ݵ�ǰʱ�����������������
	 * @param time
	 * @return
	 */
	public TimeLimit findByDate(String time);
	
	/**
	 * ����ָ����ʦ����
	 * @param teacherId
	 * @return
	 */
	public List<TimeLimit> findByTeacher(String teacherId);

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
	public List<TimeLimit> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end);
	/**
	 * 通过学生学号获取对应教师的进度提示信息
	 */
	public List<TimeLimit> findByStudentId(String stuId);

}
