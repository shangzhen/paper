package henu.dao;

import java.util.List;

import henu.bean.Student;

public interface IStudentDao {

	/**
	 * ���ѧ��
	 * @param student
	 * @return
	 */
	public int add(Student student);
	/**
	 * ɾ��ѧ��
	 * @param fno
	 * @return
	 */
	public int delete(String fNo);
	/**
	 * ����ѧ���޸�
	 * @param fno
	 * @param student
	 * @return
	 */
	public int update(String fNo,Student student);
	/**
	 * ��������ѧ��
	 * @return
	 */
	public List<Student> findAll();
	/**
	 * ����ѧ�Ų���ѧ��
	 * @param fno
	 * @return
	 */
	public Student find(String fNo);
	/**
	 * ģ����ѯ
	 * @param property �ֶ���
	 * @param key ֵ
	 * @param order �����ֶ�
	 * @param sort ����ʽ
	 * @param start ��ҳ��ʼ��¼
	 * @param end ��ҳ����ʾ��¼��
	 * @return
	 */
	public List<Student> findByProperty(String property, String key,
			String order, String sort, int start, int end);
	/**
	 * 查找未分配学生名单
	 * @param property
	 * @param key
	 * @param order
	 * @param sort
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Student> findByProperty1(String property, String key,String order, String sort, int start, int end);
	/**
	 * 查找未分配学生名单
	 * @param property
	 * @param key
	 * @return
	 */
	public List<Student> findByProperty2(String property, String key);
	/**
	 * 
	 * @param property
	 * @param key
	 * @param order
	 * @param sort
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Student> findByProperty3(String property,String key);
}
