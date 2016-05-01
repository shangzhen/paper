package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import henu.bean.Distribution;
import henu.dao.IDistributionDao;
import henu.factory.DaoFactory;

public class DistributionDaoImpl implements IDistributionDao{
	private QueryRunner queryRunner;

	public DistributionDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}
	@Override
	public int add(Distribution distribution) {
		String sql = "INSERT INTO t_distribution (fTId,fNo) VALUES(?,?)";
		Object[] params = {distribution.getFtid(),distribution.getFno()};
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Distribution> findByTeahcer(String fTId) {
		String sql = "SELECT * FROM t_distribution WHERE fTId=?";
		
			List<Distribution> list = null;
			try {
				list = queryRunner.query(sql, new BeanListHandler<Distribution>(Distribution.class),fTId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	}

	@Override
	public List<Distribution> findAll() {
		String sql = "SELECT * FROM t_distribution ORDER BY fNo DESC";
		List<Distribution> list = null;
		
		try {
			list = queryRunner.query(sql, new BeanListHandler<Distribution>(Distribution.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Distribution> findByProperty(String property, String key,
			String order, String sort, int start, int end) {
		String sql = "SELECT * FROM t_distribution WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
		
			List<Distribution> list = null;
			try {
				list = queryRunner.query(sql, new BeanListHandler<Distribution>(Distribution.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM t_distribution WHERE id=?";
		int result = 0 ;
		try {
			result = queryRunner.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public static void main(String[] args) {
		/*Distribution a = new Distribution();
	    a.setfId("1111111");
	    a.setfNo("00003");
>>>>>>> branch 'master' of https://git.oschina.net/liangshengbin/paper.git
	
		IDistributionDao adao = DaoFactory.createDistribution();
	   // adao.add(a);
		//adao.delete(1);
		List<Distribution> list=adao.findByTeahcer("1111111");
	
	//List<Distribution> list = adao.findAll();
	
	for(int i=0;i<list.size();i++)
	{
		System.out.println( list.get(i));
	}*/
		
}
	@Override
	public String findFtidByStudentId(String studentId) {
		Distribution query = null;
		String sql = "SELECT * FROM t_distribution where fNo = " + studentId;
		try {
			query = queryRunner.query(sql, new BeanHandler<Distribution>(Distribution.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("query:" + query.toString());
		return query.getFtid();
	}

}
