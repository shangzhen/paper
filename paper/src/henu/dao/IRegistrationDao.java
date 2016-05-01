package henu.dao;

import java.util.List;

import henu.bean.Registration;
/**
 * Regstration��DAO������ӿ�
 * @author ��ʤ��
 * 2015��10��12��
 */
public interface IRegistrationDao {
	/**
	 * ���
	 * @param registration
	 * @return
	 */
	public int add(Registration registration);
	/**
	 * ��������ɾ��
	 * @param fId
	 * @return
	 */
	public int delete(int fId);
	/**
	 * ���¼�¼
	 * @param fId
	 * @param registration
	 * @return
	 */
	public int update(int fId,Registration registration);
	/**
	 * ���ݴ�繫����Ҵ��ԤԼ����
	 * @param fNoticeId
	 * @return
	 */
	public List<Registration> findByNotice(int fNoticeId); 
	/**
	 * �����������ҵ�����¼
	 * @param fId
	 * @return
	 */
	public Registration find(int fId);
	/**
	 * ��������
	 * @return
	 */
	public List<Registration> findAll();
	
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
	public List<Registration> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end);

}
