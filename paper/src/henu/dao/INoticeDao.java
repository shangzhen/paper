package henu.dao;

import java.util.List;
import henu.bean.Notice;

/**
 * ��繫����DAO�����ӿ�
 * @author ��ʤ��
 * 2015��10��12��
 */
public interface INoticeDao {
	/**
	 * ���
	 * @param notice
	 * @return
	 */
	public int add(Notice notice);
	public int update(int fid,Notice notice);
	/**
	 * ɾ��
	 * @param notice
	 * @return
	 */
	public int delete(int fid);
	/**
	 * ����������ѯ������¼
	 * @param fId
	 * @return
	 */
	public Notice find(int fid);
	/**
	 * ��ѯ���м�¼
	 * @return
	 */
	public List<Notice> findAll();
	
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
	public List<Notice> findByProperty(String property, String key, String order,
			String sort, int start, int end);
}
