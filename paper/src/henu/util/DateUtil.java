package henu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��java.util.Date������String���ͻ�������ָ�����ڸ�ʽ
 * @author ��ʤ��
 * @version 1.0
 * 2014-11-02
 *
 */
public class DateUtil {
	/**
	* ����ת�����ַ���: yyyy-MM-dd HH:mm:ss
	* @param date 
	* @return str
	*/
	public static String DateToStr(Date date) {
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String str = format.format(date);
	   return str;
	} 
	/**
	 * ����ת�����ַ�����yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String DateToSimpleStr(Date date)
	{
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		   String str = format.format(date);
		   return str;
	}
	/**
	* �ַ���ת��������
	* @param str
	* @return date
	*/
	public static Date StrToDate(String str) {
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   Date date = null;
	   try {
	    date = format.parse(str);
	   } catch (ParseException e) {
	    e.printStackTrace();
	   }
	   return date;
	}
	/**
	 * ���ַ������͵�����ת��Ϊjava.util.Date���͵�����
	 * @param str
	 * @return
	 */
	public static Date StrToSimpleDate(String str) {
		  
		   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		   Date date = null;
		   try {
		    date = format.parse(str);
		   } catch (ParseException e) {
		    e.printStackTrace();
		   }
		   return date;
		}

	/**
	 * java.sql.Date��java.util.Date����ת��
	 * @param sdate
	 * @return
	 */
	public static java.util.Date sqlDateToutilDate(java.sql.Date sdate)
	{
		java.util.Date udate = null;
		long t = sdate.getTime();
		udate = new Date(t);
		return udate;
	}
	/**
	 * ��java.util.Date��ʽת��Ϊjava.sql.Date��ʽ
	 * @param udate
	 * @return
	 */
	public static java.sql.Date utilDateTosqlDate(java.util.Date udate)
	{
		java.sql.Date sdate = null;
		long t = udate.getTime();
		sdate = new java.sql.Date(t);
		return sdate;
	}

	public static void main(String[] args) {
	  
	   Date date = new Date();
	   System.out.println("����ת�ַ�����" + DateUtil.DateToStr(date));
	   System.out.println("�ַ���ת���ڣ�" + DateUtil.StrToDate(DateUtil.DateToStr(date)));
	  
	}

}
