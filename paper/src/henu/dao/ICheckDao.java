package henu.dao;

import java.util.List;

import henu.bean.Check;

/**
 * Check��Ӧ��DAO��ӿ�
 * @author ��ʤ��
 * 2015��10��12��
 */
public interface ICheckDao {
	/**
	 * ��Ӳ���
	 * @param check
	 * @return
	 */
	public int add(Check check);
	/**
	 * ����ѧ��ɾ��
	 * @param fNo
	 * @return
	 */
	public int delete(String fNo);
	/**
	 * ����ѧ���޸ļ�¼
	 * @param fNo ѧ��
	 * @param check ���ڼ�鱨��
	 * @return
	 */
	public int update(String fNo,Check check);
	/**
	 * ����ѧ�ŵ�����ѯ
	 * @param fNO ѧ��
	 * @return
	 */
	public Check find(String fNO);
	/**
	 * ��������
	 * @return
	 */
	public List<Check> findAll();
	/**
	 * �������Բ���
	 * @param property ������
	 * @param key �ؼ���
	 * @param order �����ֶ�
	 * @param sort ����ʽ
	 * @param start ��ҳ��ʼ��¼
	 * @param end ��ҳ����ʾ��¼��
	 * @return
	 */
	public List<Check> findByProperty(String property, String key, String order,
			String sort, int start, int end);
}
