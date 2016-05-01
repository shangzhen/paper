package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Acclaim;
import henu.bean.Announcement;
import henu.bean.Score;
import henu.bean.UploadFile;
import henu.dao.IAcclaimDao;

public class AcclaimDaoImpl implements IAcclaimDao {
	
	private QueryRunner queryRunner;
	
	public AcclaimDaoImpl(QueryRunner queryRunner){
		super();
		this.queryRunner = queryRunner;
	}

	@Override//添加
	public int add(Acclaim acclaim) {
		String sql="INSERT INTO t_acclaim(famessage,fagrade，fnumber) VALUES(?,?,?)";
		Object[] params ={acclaim.getFamessage(),acclaim.getFagrade(),acclaim.getFnumber()};
		int result =0;
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}


	@Override//修改
	public int update(String fatype, Acclaim acclaim) {
		String sql="UPDATE t_acclaim SET fatype=?,famessage=?,fagrade? WHERE fnumber=?";
		Object[] params ={fatype,acclaim.getFagrade(),acclaim.getFnumber(),acclaim.getFamessage()};
		int result =0;
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	@Override//删除
	public int delete(String fatype) {
		String sql="DELETE from t_acclaim WHERE fnumber=?";
		int result = 0;
		try {
			result =queryRunner.update(sql,fatype);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	@Override//查看
	public Acclaim find(String fatype) {
		String sql="SELECT * from t_acclaim ";
		Object[] params = {fatype};
		Acclaim acclaim=null;
		try {
			acclaim=queryRunner.query(sql, new BeanHandler<Acclaim>(Acclaim.class),params);
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return acclaim;
	}
	@Override//根据等级查找
	public List<Acclaim> findbyAgrade(String atype,String agrade) {
		String sql = "SELECT * FROM t_acclaim WHERE fAtype=? AND fAgrade=?";
		List<Acclaim> list=null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Acclaim>(Acclaim.class),atype,agrade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Acclaim findByNumber(int number) {
		String sql="SELECT * from t_acclaim WHERE fNumber=?";
		Acclaim acclaim=null;
		try {
			acclaim=queryRunner.query(sql, new BeanHandler<Acclaim>(Acclaim.class),number);
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return acclaim;
	}
	

	/*@Override
	public List<Acclaim> findAll() {
		String sql="SELECT * from t_acclaim ORDER BY fatype DESC";
		List<Acclaim> list=null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Acclaim>(Acclaim.class));
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Acclaim> findByProperty(String property, String key, String order, String sort, int start, int end) {
		String sql = "SELECT * FROM t_acclaim WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
			
			List<Acclaim> list = null;
			try {
				list = queryRunner.query(sql, new BeanListHandler<Acclaim>(Acclaim.class));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return list;
	}
*/

}
