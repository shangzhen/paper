package henu.util;
/**
 * �������ڴ��ϵͳ�õ��ĸ��ֳ���ֵ��
 * <font color="red">������Ա����׷�ӣ�ע�����ע��</font>
 * ��ŵ�session�еĶ�������
 * @author ��ʤ��
 * @version 1.0
 * 
 * 2014-11-02
 *
 */
public class CONSTANTS {

	
	//================================================================================================================
    //==                                         session����                                                                                                                                                                                                         ==
	//================================================================================================================
	// У����
	public static final String SESSION_VALIDATE_CODE = "SESSION_VALIDATE_CODE";
	
	

	//================================================================================================================
    //==                                         ����ҳ��                                                                                                                                                                                                                        ==
	//================================================================================================================
	//������ҳ��
	public static final String PAGE_ERROR = "inc/error.jsp";
	

	//================================================================================================================
    //==                                         ���ݿ���Ϣ                                                                                                                                                                                                                    ==
	//================================================================================================================
	public static final String DB = "Oracle";
	public static final String DB_USER = "root";
	//public static final String DB_PASS = "root";
	public static final String DB_PASS = "123";
	public static final String DB_DRIVER = "oracle.jdbc.OracleDriver";
	//public static final String DB_URL = "jdbc:oracle:thin:@125.219.44.33:1521:orcl";
	public static final String DB_URL = "jdbc:oracle:thin:@192.168.6.99:1521:orcl";
	public static final String DB_REMOVEABANDONEDTIMEOUT = "120";
	public static final String DB_MAXACTIVE = "100";
	public static final String DB_MAXIDLE= "50";
	public static final String DB_MAXWAIT= "1000";
	
	//================================================================================================================
        //==                                      �û�session����                                                                                                                                                                       ==
	//================================================================================================================
	public static String SESSION_STUDENT = "STUDENT";
	public static String SESSION_ADMIN = "ADMIN";
	public static String SESSION_STATUS = "STATUS";
	public static String SESSION_MAP = "MAP";
        
	//================================================================================================================
    //==                                      ������ʵ������б�                                                                                                                                                                ==
	//================================================================================================================
	
	public static final String  ALLOWLIST = "ALLOWLIST";
        
	//================================================================================================================
    //==                                      Ȩ������                                                                                                                                                               ==
	//================================================================================================================

	public static final String  PER_XUE = "xueguan";
	public static final String  PER_JUN = "junxun";
	public static final String  PER_KAO = "kaoshi";
	public static final String  PER_ZHIXUN = "zhixun";
	public static final String  PER_ZHIYUAN= "zhiyuan";
	public static final String  PER_SU = "sushe";
	public static final String  PER_SHOU = "shoufei";
	public static final String  PER_XI = "xitong";
}
