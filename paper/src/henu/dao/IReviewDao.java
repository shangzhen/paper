package henu.dao;

import java.util.List;

import henu.bean.Review;

/**
 * ������ı�DAO��ӿ�
 * @author ��ʤ��
 * 2015��10��12��
 */
public interface IReviewDao {
	/**
	 * ���
	 * @param review
	 * @return
	 */
	public int add(Review review);
	/**
	 * �޸�
	 * @param fNo
	 * @param review
	 * @return
	 */
	public int update(String fNo, Review review);
	
	/**
	 * �޸�
	 * @param fNo
	 * @param review
	 * @return
	 */
	public int update1(String fNo, Review review);

	/**
	 * �޸�
	 * @param fNo
	 * @param review
	 * @return
	 */
	public int update2(String fNo, Review review);
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
	public List<Review> findAll();
	/**
	 * ����ѧ�Ų��ҽ�ʦ���ı�
	 * @param fNo
	 * @return
	 */
	public Review find(String fNo);
	
	/**
	 * ����ָ����ʦ����
	 * @param teacherId
	 * @return
	 */
	public List<Review> findByTeacher(String teacherId);

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
	public List<Review> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end);

}
