package henu.dao;
import java.util.List;
import henu.bean.Announcement;;
/**
 * Announcement��DAO�����ӿ�
 * @author ��ʤ��
 * 2015��10��12��
 */
public interface IAnnouncementDao {
	/**
	 * ���ļ�¼
	 * @param fSerialNo
	 * @return
	 */
	public int update(int fSerialNo,Announcement announcement);
	/**
	 * ���
	 * @param announcement
	 * @return
	 */
	public int add(Announcement announcement);
	/**
	 * ��������ɾ��
	 * @param fSerialNo
	 * @return
	 */
	public int delete(int fSerialNo);
	
	/**
	 * �����������
	 * @param fSerialNo#����
	 * @param count#�µ��������
	 * @return
	 */
	public int updateBrowseTime(int fSerialNo,int count);
	
	/**
	 * ����������ѯ������¼
	 * @param fSerialNo
	 * @return
	 */
	public Announcement find(int fSerialNo);
	/**
	 * �鿴��ϸ��Ϣ
	 * @param fSerialNo
	 * @return
	 */
	public Announcement findDetail(int fSerialNo);
	/**
	 * �������м�¼
	 * @return
	 */
	public List<Announcement> findAll();
	/**
	 * ��ȡ����ǰn����¼
	 * @param n ��¼����
	 * @return
	 */
	public List<Announcement> getTop(int n);
	
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
	List<Announcement> findByProperty(String property, String key,
			String order,String sort, int start, int end);
	/**
	 * �������Բ���1
	 * @param key �ؼ���
	 * @param order �����ֶ�
	 * @param sort ����ʽ
	 * @param start ��ҳ��ʼ��¼
	 * @param end ��ҳ����ʾ��¼��
	 * @return
	 */
	List<Announcement> findByProperty(String key,String order,String sort, int start, int end);
	
}
