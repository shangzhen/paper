package henu.util;

import java.io.UnsupportedEncodingException;

/**
 * �����ַ��������ת��
 * @author ��ʤ��
 * @version 1.0
 * 2014-11-02
 *
 */
public class CharsetUtil {
	/**
	 * ��ISO-8859-1������ַ���ת��ΪUTF-8����
	 * @param s ISO-8859-1������ַ���
	 * @return String���ͣ�����UTF-8����
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
