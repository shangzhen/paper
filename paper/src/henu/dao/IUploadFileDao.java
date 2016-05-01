package henu.dao;

import java.util.List;

import henu.bean.UploadFile;

/**
 * �ļ��ϴ����DAO�����
 * @author ��ʤ��
 * 2015��10��12��
 */
public interface IUploadFileDao {
	/**
	 * �ϴ��ļ�
	 * @param file
	 * @return
	 */
	public int add(UploadFile file);
	/**
	 * �޸�
	 * @param fid
	 * @param file
	 * @return
	 */
	public int update(int fid,UploadFile file);
	/**
	 * �������ɾ��
	 * @param fid
	 * @return
	 */
	public int delete(int fid);
	/**
	 * �鿴�����ļ�
	 * @param fid
	 * @return
	 */
	public UploadFile find(int fid);
	/**
	 * ��������
	 * @return
	 */
	public List<UploadFile> findAll();
	/**
	 * ģ�����
	 * @param property
	 * @param key
	 * @param order
	 * @param sort
	 * @param start
	 * @param end
	 * @return
	 */
	public List<UploadFile> findByProperty(String property, String key,String order, String sort, int start, int end);

}


