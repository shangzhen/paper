package henu.dao;

import java.util.List;

import henu.bean.Task;

/**
 * ���������t_Task��DAO��ӿ�
 * @author ��ʤ��
 * 2015��10��12��
 */
public interface ITaskDao {
	/**
	 * ���
	 * @param report
	 * @return
	 */
	public int add(Task	 report);
	/**
	 * �޸�
	 * @param fNo
	 * @param report
	 * @return
	 */
	public int update(String fNo, Task task);
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
	public List<Task> findAll();
	/**
	 * ����ѧ�Ų��ҿ��ⱨ��
	 * @param fNo
	 * @return
	 */
	public Task find(String fNo);
	
	/**
	 * ����ָ����ʦ����
	 * @param teacherId
	 * @return
	 */
	public List<Task> findByTeacher(String teacherId);

	/**
	 * ģ������ 
	 * @param Property �ֶ���
	 * @param key ֵ
	 * @param Property1 �ֶ���
	 * @param key1 ֵ
	 * @param order �����ֶ�
	 * @param sort ����ʽ
	 * @return
	 */
	public List<Task> findByProperty(String property, String key,
			String order, String sort, int start, int end);
	

}
