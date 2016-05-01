package henu.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import henu.bean.PaperDetails;
/**
 * PaperDetail������ϸ���DAO������ӿ�
 * @author ��ʤ��
 * 2015��10��12��
 */
public interface IPaperDetailsDao {
	/**
	 * ���
	 * @param report
	 * @return
	 */
	public int add(PaperDetails report);
	/**
	 * �޸�
	 * @param fNo
	 * @param report
	 * @return
	 */
	public int update(String fNo, PaperDetails report);
	
	
	public int update1(int fid, PaperDetails report);
	
	
	
	public int update2(int fid, PaperDetails report);
	/**
	 * ����ѧ��ɾ��
	 * @param fNo
	 * @return
	 */
	public int delete(String fNo);
	
	
	public int deleteByfId(int fid);
	/**
	 * 根据id删除
	 * @param fid
	 * @return
	 */
	public int deletee(int fid);
	/**
	 * �������п��ⱨ��
	 * @return
	 */
	public List<PaperDetails> findAll();
	/**
	 * �����������ҿ��ⱨ��
	 * @param fId
	 * @return
	 */
	public PaperDetails find(int fId);
	
	public List<PaperDetails> findByfnototitle(String fNo);
	
	
	public PaperDetails findByfNoAndTime(String fNo,int time);

	/**
	 * ����ָ����ʦ����
	 * @param teacherId
	 * @return
	 */
	public PaperDetails findByTeacher(String teacherId);
	/**
	 * ����ѧ�Ų���
	 * @param fNo
	 * @return
	 */
	public PaperDetails findByfNo(String fNo);
	
	/**
	 * 根据学号查找出list对象
	 * @param fno
	 * @return
	 */
	public List<PaperDetails> findByfffo(String fno);
	
	
	/**
	 * 查找该学号的条数
	 * @param fNo
	 * @return
	 */
	public int updatee(int id,PaperDetails report);

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
	public List<PaperDetails> findByProperty(String property, String key,String property1, String key1,
			String order, String sort, int start, int end);

	
	/**
	 * 根据版次，查找所有
	 * @param result1 版次
	 * @return
	 */
	public PaperDetails findByrevision(int result1);
	
	
	
	public PaperDetails findByfId(int fId);
	
	public List<PaperDetails> findByFnoDesc(String fno);
}
