package henu.dao;

import java.util.List;

import henu.bean.Distribution;

public interface IDistributionDao {
	/**
	 * ��������
	 * @param distribution
	 * @return
	 */
	public int add(Distribution distribution);
	/**
	 * ���ݽ̹��Ų�ѯ�ý�ʦ����������
	 * @param fId
	 * @return
	 */
	public List<Distribution> findByTeahcer(String fId);
	/**
	 * ��������
	 * @return
	 */
	public List<Distribution> findAll();
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
	public List<Distribution> findByProperty(String property, String key, String order,
			String sort, int start, int end);
	/**
	 * ��������ɾ��
	 * @param id
	 * @return
	 */
	public int delete(int id);
	public String findFtidByStudentId(String studentId);
}
