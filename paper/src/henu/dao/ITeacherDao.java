package henu.dao;

import java.util.List;

import henu.bean.Teacher;

/**
 * ��ʦ��t_teacher��DAO�����
 * @author ��ʤ��
 * 2015��10��12��
 */

public interface ITeacherDao {
	/**
	 * ��½
	 * @param fNo
	 * @param fTPsw
	 * @param fTType
	 * @return
	 */
	public Teacher login(String fNo,String fTPsw,String fTType);
	/**
	 * ���
	 * @param teacher
	 * @return
	 */
	public int add(Teacher	 teacher);
	/**
	 * �޸�
	 * @param fTid
	 * @param teacher
	 * @return
	 */
	public int update(String fTid, Teacher teacher);
	/**
	 * ���ݽ̹���ɾ��
	 * @param fTid
	 * @return
	 */
	public int delete(String fTid);
	/**
	 * �������н�ʦ
	 * @return
	 */
	public List<Teacher> findAll();
	/**
	 * ���ݽ̹��Ų��ҿ��ⱨ��
	 * @param fNo
	 * @return
	 */
	public Teacher find(String fTid);
	
	
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
	public List<Teacher> findByProperty(String property, String key,
			String order, String sort, int start, int end);
/**
 * 
 * @param fNo
 * @param OldfTPsw ������
 * @param NewfTPsw ������
 * @param act �û�����
 * @return
 */
	public int resetPassword(String fNo ,String OldfTPsw, String NewfTPsw ,String act);

}
