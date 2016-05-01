package henu.util;
/**
 * 此类用于存放系统用到的各种常量值。
 * <font color="red">开发人员可以追加，注意加上注释</font>
 * 如放到session中的对象名称
 * @author 梁胜彬
 * @version 1.0
 * 
 * 2014-11-02
 *
 */
public class CONSTANTS {

	
	//================================================================================================================
    //==                                         session名称                                                                                                                                                                                                         ==
	//================================================================================================================
	// 校验码
	public static final String SESSION_VALIDATE_CODE = "SESSION_VALIDATE_CODE";
	
	

	//================================================================================================================
    //==                                         常用页面                                                                                                                                                                                                                        ==
	//================================================================================================================
	//错误处理页面
	public static final String PAGE_ERROR = "inc/error.jsp";
	

	//================================================================================================================
    //==                                         数据库信息                                                                                                                                                                                                                    ==
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
        //==                                      用户session名称                                                                                                                                                                       ==
	//================================================================================================================
	public static String SESSION_STUDENT = "STUDENT";
	public static String SESSION_ADMIN = "ADMIN";
	public static String SESSION_STATUS = "STATUS";
	public static String SESSION_MAP = "MAP";
        
	//================================================================================================================
    //==                                      允许访问的连接列表                                                                                                                                                                ==
	//================================================================================================================
	
	public static final String  ALLOWLIST = "ALLOWLIST";
        
	//================================================================================================================
    //==                                      权限名称                                                                                                                                                               ==
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
