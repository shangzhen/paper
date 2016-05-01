package henu.dao;

import java.util.List;

import henu.bean.Acclaim;

/**
 * t_acclaim瀵瑰簲鐨刣ao
 * @author Administrator
 * 2016骞�3鏈�27鏃�
 */

public interface IAcclaimDao {
	/**
	 * @param String fatype
	 * @return
	 */
	public int add(Acclaim acclaim);
	
	/**
	 * @param String fatype
	 * @param acclaim
	 * @return
	 */
	public int update(String fatype, Acclaim acclaim);
	
	/**
	 * @param String fatype
	 * @return 
	 */
	public int delete(String fatype);
	
	/**
	 * @param String fatype
	 * @return
	 */
	public Acclaim find(String fatype);
	
	/**
	 * @param String fatype
	 * @return
	 */
	public Acclaim findByNumber(int number);
	/**
	 * @param String fatype,String agrade
	 * @return
	 */
	public List<Acclaim> findbyAgrade(String atype,String agrade);
	
	/**
	 * @return
	 */
	/*
	public List<Acclaim> findAll();
	
	*//**
	 * @param property
	 * @param key
	 * @param order
	 * @param sort
	 * @param start
	 * @param end
	 * @return
	 *//*
	public List<Acclaim> findByProperty(String property, String key,
			               String order, String sort, int start, int end);*/
	
	

}
