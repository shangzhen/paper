package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.PaperDetails;
import henu.dao.IPaperDetailsDao;

public class PaperDetailsDaoImpl implements IPaperDetailsDao {

	private QueryRunner queryRunner;
	public PaperDetailsDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}

	@Override
	public int add(PaperDetails report) {

		String sql = "INSERT INTO t_paperdetails(fRevision,fTitle,fModifyContent,fThesisAdjunct"
				+ ",fPptAdjunct,fSourceCodeAdjunct,fCheckAdjunct,fUploadTime,"
				+ "fReviewComment,fReviewTime,fReviewAdjunct,"
				+ "fReviewTeacher,fIdentification,fRepetitionRate,fMemo,fTeacherId,fNo) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {report.getFrevision(),report.getFtitle(),report.getFmodifyContent(),report.getFthesisAdjunct()
				,report.getFpptAdjunct(),report.getFsourceCodeAdjunct(),report.getFcheckAdjunct(),report.getFuploadTime()
				,report.getFreviewComment(),report.getFreviewTime(),report.getFreviewAdjunct(),report.getFreviewTeacher()
				,report.getFidentification(),report.getFrepetitionRate(),report.getFmemo(),report.getFteacherId(),report.getFno()};
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
		
	@Override
	public int update(String fno, PaperDetails report) {
		String sql = "UPDATE t_paperdetails SET fRevision=?,fTitle=?,fModifyContent=?,fThesisAdjunct=?"
				+ ",fPptAdjunct=?,fSourceCodeAdjunct=?,fCheckAdjunct=?,fUploadTime=?,"
				+ "fReviewComment=?,fReviewTime=?,fReviewAdjunct=?,"
				+ "fReviewTeacher=?,fIdentification=?,fRepetitionRate=?,fMemo=?,fTeacherId=? WHERE fNo=?";
		Object[] params = {report.getFrevision(),report.getFtitle(),report.getFmodifyContent(),report.getFthesisAdjunct()
				,report.getFpptAdjunct(),report.getFsourceCodeAdjunct(),report.getFcheckAdjunct(),report.getFuploadTime()
				,report.getFreviewComment(),report.getFreviewTime(),report.getFreviewAdjunct(),report.getFreviewTeacher()
				,report.getFidentification(),report.getFrepetitionRate(),report.getFmemo(),report.getFteacherId(),fno};
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update1(int fid, PaperDetails report) {
		String sql = "UPDATE t_paperdetails SET fReviewTime=?,fReviewAdjunct=? WHERE fId=?";
		Object[] params = {report.getFreviewTime(),report.getFreviewAdjunct(),fid};
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int update2(int fid, PaperDetails report) {
		String sql = "UPDATE t_paperdetails SET fReviewComment=?,fReviewTime=? WHERE fId=?";
		Object[] params = {report.getFreviewComment(),report.getFreviewTime(),fid};
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(String fno) {
		String sql = "DELETE FROM t_paperdetails WHERE fNo=?";
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
	public int deleteByfId(int fid) {
		String sql = "DELETE FROM t_paperdetails WHERE fId=?";
		
		int result = 0 ;
		try {
			result = queryRunner.update(sql, fid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<PaperDetails> findAll() {
		String sql = "SELECT * FROM t_paperdetails ORDER BY fNo DESC";
		List<PaperDetails> list = null;
		
		try {
			list = queryRunner.query(sql, new BeanListHandler<PaperDetails>(PaperDetails.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public PaperDetails find(int fid) {
          String sql = "SELECT * FROM t_paperdetails WHERE fId=?";
		
          PaperDetails detail = null;
		try {
			detail = queryRunner.query(sql, new BeanHandler<PaperDetails>(PaperDetails.class),fid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detail;
	}

	@Override
	public PaperDetails findByTeacher(String teacherId) {
		 String sql = "SELECT * FROM t_paperdetails WHERE fTeacherId=?";
			
		PaperDetails paper = null;
		try {
			paper =  queryRunner.query(sql, new BeanHandler<PaperDetails>(PaperDetails.class),teacherId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paper;
	}

	@Override
	public PaperDetails findByfNo(String fNo) {
		
		String sql = "SELECT * FROM t_paperdetails WHERE fNo=?";
		
		PaperDetails pd = null;
		try {
			pd = queryRunner.query(sql, new BeanHandler<PaperDetails>(PaperDetails.class),fNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public List<PaperDetails> findByProperty(String property, String key, String property1, String key1, String order,
			String sort, int start, int end) {
		String sql = "SELECT * FROM t_paperdetails WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
			List<PaperDetails> list = null;
			try {
				list = queryRunner.query(sql, new BeanListHandler<PaperDetails>(PaperDetails.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
	}

	/*查找学生数量*/
	/*public int countfsno(String fNo) {
		
		String sql = "SELECT count(*) FROM t_paperdetails WHERE WHERE fNo=?";
		
		PaperDetails pd= null;
		
		try {
		   	pd = queryRunner.query(sql, new BeanHandler<PaperDetails>(PaperDetails.class),fNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pd;
	}	*/
	
	/*根据版次，查找这条数据的Id*/
	
	public PaperDetails findByrevision(int frevision) {
		
		String sql = "SELECT * FROM t_paperdetails WHERE fRevision=?";
		PaperDetails pd = null;
		try {
			pd = queryRunner.query(sql, new BeanHandler<PaperDetails>(PaperDetails.class),frevision);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public List<PaperDetails> findByfffo(String fno) {
      String sql = "SELECT * FROM t_paperdetails WHERE fNo=?";
		
		List<PaperDetails> pd = null;
		try {
			pd = queryRunner.query(sql, new BeanListHandler<PaperDetails>(PaperDetails.class),fno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public int updatee(int fId, PaperDetails report) {
			String sql = "UPDATE t_paperdetails SET fRevision=?,fTitle=?,fModifyContent=?,fThesisAdjunct=?"
					+ ",fPptAdjunct=?,fSourceCodeAdjunct=?,fCheckAdjunct=?,fUploadTime=?,"
					+ "fReviewComment=?,fReviewTime=?,fReviewAdjunct=?,"
					+ "fReviewTeacher=?,fIdentification=?,fRepetitionRate=?,fMemo=?,"
					+ "fTeacherId=?,fNo=? WHERE fId=?";
			Object[] params = {report.getFrevision(),report.getFtitle(),report.getFmodifyContent(),report.getFthesisAdjunct()
					,report.getFpptAdjunct(),report.getFsourceCodeAdjunct(),report.getFcheckAdjunct(),report.getFuploadTime()
					,report.getFreviewComment(),report.getFreviewTime(),report.getFreviewAdjunct(),report.getFreviewTeacher()
					,report.getFidentification(),report.getFrepetitionRate(),report.getFmemo(),report.getFteacherId(),report.getFno(),fId};
			int result = 0;
			try {
				result = queryRunner.update(sql, params);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}

	@Override
	public int deletee(int fid) {
		String sql = "DELETE FROM t_paperdetails WHERE fId=?";
		int result = 0 ;
		try {
			result = queryRunner.update(sql, fid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public List<PaperDetails> findByFnoDesc(String fno) {
		String sql = "SELECT * FROM t_paperdetails WHERE fNo=? ORDER BY fRevision DESC";
		List<PaperDetails> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<PaperDetails>(PaperDetails.class),fno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public PaperDetails findByfId(int fId) {
		String sql = "SELECT * FROM t_paperdetails WHERE fId=?";
		
		PaperDetails pd = null;
		try {
			pd = queryRunner.query(sql, new BeanHandler<PaperDetails>(PaperDetails.class),fId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public List<PaperDetails> findByfnototitle(String fNo) {
		String sql = "SELECT * FROM t_paperdetails WHERE fNo=?";
		List<PaperDetails> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<PaperDetails>(PaperDetails.class),fNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("fno:"+fNo);
		System.out.println("list:"+list);
		return list;
	}
	@Override
	public PaperDetails findByfNoAndTime(String fNo,int time) {
		
		String sql = "SELECT * FROM t_paperdetails WHERE fNo=?,fRevision=?";
		String time1 = String.valueOf(time);
		PaperDetails pd = null;
		try {
			pd = queryRunner.query(sql, new BeanHandler<PaperDetails>(PaperDetails.class),fNo,time1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pd;
	}

	
}
