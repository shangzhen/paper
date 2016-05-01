package henu.util;

import java.io.UnsupportedEncodingException;

/**
 * 用于字符串编码的转换
 * @author 梁胜彬
 * @version 1.0
 * 2014-11-02
 *
 */
public class CharsetUtil {
	/**
	 * 将ISO-8859-1编码的字符串转换为UTF-8编码
	 * @param s ISO-8859-1编码的字符串
	 * @return String类型，采用UTF-8编码
	 */
	public static String ISO2UTF(String s)
	{
		try {
			s = new String(s.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			
		}
		return s;
		
	}
}
