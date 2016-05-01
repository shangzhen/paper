package henu.dao;

import java.util.List;

import henu.bean.OpeningReport;
/**
 * ���ⱨ���DAO����
 * @author ��ʤ��
 * 2015��10��12��
 */
public interface IOpeningReportDao {
	/**
	 * ���
	 * @param report
	 * @return
	 */
	public int add(OpeningReport report);
	/**
	 * �޸�
	 * @param fNo
	 * @param report
	 * @return
	 */
	public int update(String fNo, OpeningReport report);
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
	public List<OpeningReport> findAll();
	/**
	 * ����ѧ�Ų��ҿ��ⱨ��
	 * @param fNo
	 * @return
	 */
	public OpeningReport find(String fNo);
	
	/**
	 * ����ָ����ʦ����
	 * @param teacherId
	 * @return
	 */
	public List<OpeningReport> findByTeacher(String teacherId);

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
	public List<OpeningReport> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end);

	
}
