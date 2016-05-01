package henu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将java.util.Date类型与String类型互换，并指定日期格式
 * @author 梁胜彬
 * @version 1.0
 * 2014-11-02
 *
 */
public class DateUtil {
	/**
	* 日期转换成字符串: yyyy-MM-dd HH:mm:ss
	* @param date 
	* @return str
	*/
	public static String DateToStr(Date date) {
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String str = format.format(date);
	   return str;
	} 
	/**
	 * 日期转换成字符串：yyyy-MM-dd
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
	* 字符串转换成日期
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
	 * 将字符串类型的日期转换为java.util.Date类型的数据
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
	 * java.sql.Date与java.util.Date类型转换
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
	 * 将java.util.Date格式转换为java.sql.Date格式
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
	   System.out.println("日期转字符串：" + DateUtil.DateToStr(date));
	   System.out.println("字符串转日期：" + DateUtil.StrToDate(DateUtil.DateToStr(date)));
	  
	}

}
