package henu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 使用DBCP创建的数据库连接池，及其常见的数据库操作
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
     * 建立连接
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
	 *执行UPDATE/INSERT/DELETE SQL语句
	 * @param sql
	 * @return 受影响的记录个数
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
	 * 执行SELECT SQL语句
	 * @param sql
	 * @return ResultSet对象
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
	 * 执行PreparedStatement对象
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
	 * 事务回滚
	 */
	public static void rollback() {
		try {
			conn.rollback();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 关闭数据库连接
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
