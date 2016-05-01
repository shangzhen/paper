package henu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ʹ��DBCP���������ݿ����ӳأ����䳣�������ݿ����
 * @author Administrator
 *
 */
public class Dbcp {

	private static DataSource dataSource = null;

	protected static Statement s=null;
	protected static ResultSet rs = null;
	protected static Connection conn = null;
	
	public static DataSource getDataSource() {
		if(dataSource == null){
			dataSource=new ComboPooledDataSource("paper");
		}
		return dataSource;
	}
	 /**
     *
     */
    static{
   
        try {
         	dataSource=new ComboPooledDataSource("paper");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*
    
    /**
     * ��������
     * @return
     * @throws SQLException
     */
    public static synchronized Connection getConnection() throws  SQLException {
       
        if (dataSource != null) {
            conn = dataSource.getConnection();
        }
        return conn;
    }
    /**
	 *ִ��UPDATE/INSERT/DELETE SQL���
	 * @param sql
	 * @return ��Ӱ��ļ�¼����
	 */
	public static int executeUpdate(String sql)
	{
		int result = 0;
		try {
			s = getConnection().createStatement();
			result = s.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * ִ��SELECT SQL���
	 * @param sql
	 * @return ResultSet����
	 */
	public static ResultSet executeQuery(String sql)
	{
		
		try {
			s = getConnection().createStatement();
			rs = s.executeQuery(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * ִ��PreparedStatement����
	 * @param sql
	 * @return
	 */
	public static PreparedStatement executePS(String sql)
	{
		PreparedStatement ps = null;
		try
		{
			ps = getConnection().prepareStatement(sql);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ps;
	}
	
	/**
	 * ����ع�
	 */
	public static void rollback() {
		try {
			conn.rollback();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * �ر����ݿ�����
	 */
	public static void close()
	{
		try
		{
			if(rs!=null)
				rs.close();
			if(s!= null)
				s.close();
			if(conn!=null)
				conn.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
}
