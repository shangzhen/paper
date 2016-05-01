package henu.dao;

import java.util.List;

import henu.bean.Thesis;

/**
 * ����״̬��DAO�����
 * @author ��ʤ��
 * 2015��10��12��
 */
public interface IThesisDao {
	public int add(Thesis thesis);
	/**
	 * ����ĳ�����ĵ�״̬
	 * @param fNo ѧ��
	 * @param property �ֶ�����
	 * @param obj �ֶ�ֵ
	 * @return
	 */
	public int update(String fNo,Thesis thesis);
	/**
	 ����ĳ�����ĵ�״̬
	 * @param fNo ѧ��
	 * @param property �ֶ�����
	 * @param obj �ֶ�ֵ
	 * @return
	 * */
	public int update1(String fNo);
	/**
	 ����ĳ�����ĵ�״̬
	 * @param fNo ѧ��
	 * @param property �ֶ�����
	 * @param obj �ֶ�ֵ
	 * @return
	 * */
	public int update2(String fNo);
	/**
	 * ��������
	 * @return
	 */
	public List<Thesis> findAll();
	

	
	public Thesis findByNo(String fNo);
	
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
	public List<Thesis> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end);
	/**
	 * ���ݽ̹��Ų��Ҹý�ʦָ����ѧ������״̬
	 * @param teacherId
	 * @return
	 */
	public List<Thesis> findByTeacher(String teacherId);
	
	
}
