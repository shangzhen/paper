package henu.dao;

import java.util.List;

import henu.bean.Online;

/**
 * ������ѯ���DAO����
 * @author ��ʤ��
 * 2015��10��12��
 */
public interface IOnlineDao {
	/**
	 * ���
	 * @param online
	 * @return
	 */
	public int add(Online online);
	/**
	 * ɾ��
	 * @param fId
	 * @return
	 */
	public int delete(int fId);
	/**
	 * �����������ҵ�����¼
	 * @param fId
	 * @return
	 */
	public Online find(int fId);
	/**
	 * �ظ�ָ������Ϣ
	 * @param fId
	 * @param online
	 * @return
	 */
	public int reply(int fId, Online online);
	/**
	 * ��������
	 * @return
	 */
	public List<Online> findAll();
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
	public List<Online> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end);
	/**
	 * ����������ѯ 
	 * @param Property �ֶ���
	 * @param key ֵ
	 * @param order �����ֶ�
	 * @param sort ����ʽ
	 * @return
	 */
	public List<Online> findByProperty(String property, String key,String order, 
			String sort, int start, int end);
	/**
	 * �鿴�����ѻظ�����
	 * @param order �����ֶ�
	 * @param sort ����ʽ
	 * @return
	 */
	public List<Online> findByOut(String order,String sort, int start, int end);
	/**
	 * ���ݽ�ʦ���Ų鿴��ʦδ�ظ�������
	 * @param fTNo ��ʦ���ţ����������ϲ�ѯ��
	 * @param order �����ֶ�
	 * @param sort ����ʽ
	 * @param start ��ʼ��
	 * @param end	������
	 * @return
	 */
	public List<Online> findByTeacher(String fTNo,String order,String sort, int start, int end);
	/**
	 * ���ݽ�ʦ���Ų鿴��ʦ�Ѿ��ظ�������
	 * @param fTNo	��ʦ���ţ����������ϲ�ѯ��
	 * @param order	�����ֶ�
	 * @param sort	����ʽ
	 * @param start	��ʼ��
	 * @param end	������
	 * @return
	 */
	public List<Online> findByTeacherOut(String fTNo,String order,String sort, int start, int end);
}
