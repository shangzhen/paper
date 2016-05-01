package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Announcement;
import henu.bean.Notice;
import henu.bean.Paperstate;
import henu.dao.IPaperstateDao;
import henu.factory.DaoFactory;

public class PaperstateImpl implements IPaperstateDao {

	private QueryRunner queryRunner;

	public PaperstateImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}
	
	@Override
	public int add(Paperstate paperstate) {
		String sql = "INSERT INTO t_paperstate(fNo,fOpenReport,fTaskBook,fMidInspect,fFirstDraft,fFinalDraft,fCheck,fJoinDefence,fScoreJudge,fMemo) VALUES(?,?,?,?,?,?,?,?,?,?)";Object[] params = {paperstate.getFno(),paperstate.getFopenReport(),paperstate.getFtaskBook(),paperstate.getFmidInspect(),paperstate.getFfirstDraft(),paperstate.getFfinalDraft(),paperstate.getFcheck(),paperstate.getFjoinDefence(),paperstate.getFscoreJudge(),paperstate.getFmemo()};
		
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
	public int delete(String fno) {
		String sql = "DELETE FROM t_paperstate WHERE fNo=?";
		int result = 0 ;
		try {
			result = queryRunner.update(sql, fno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(String fno, Paperstate paperstate) {
		String sql = "UPDATE t_paperstate SET fOpenReport=?,fTaskBook=?,fMidInspect=?,fFirstDraft=?,fFinalDraft=?,fCheck=?,fJoinDefence=?,fScoreJudge=?,fMemo=? WHERE fNo=?";
		int result = 0 ;
		Object[] params = {paperstate.getFopenReport(),paperstate.getFtaskBook(),paperstate.getFmidInspect(),
				paperstate.getFfirstDraft(),paperstate.getFfinalDraft(),paperstate.getFcheck(),paperstate.getFjoinDefence(),paperstate.getFscoreJudge(),paperstate.getFmemo(),fno};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Paperstate find(String fno) {
		String sql = "SELECT * FROM t_paperstate WHERE fNo=?";
		
		Paperstate paperstate = null;
		try {
			paperstate = queryRunner.query(sql, new BeanHandler<Paperstate>(Paperstate.class),fno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paperstate;
	}

	@Override
	public int update(String fno, String property, String value) {
		String sql = "UPDATE t_paperstate SET " + property +  " =? WHERE fNo=?";
		int result = 0 ;
		Object[] params = {value,fno};
		try {
			result = queryRunner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Paperstate> findAll(String ftid, int start, int end) {
		String sql = "SELECT * FROM t_paperstate WHERE fNo IN (SELECT fNo FROM t_thesislist WHERE fTid = "+ftid+") "+ 
				" LIMIT " + start + "," + end;
		
		List<Paperstate> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Paperstate>(Paperstate.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Paperstate> findByProperty(String property, String key,
			int start, int end) {
		String sql = "select * from t_paperstate where  "+property+" LIKE '%" + key + "%'";
		List<Paperstate> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Paperstate>(Paperstate.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
