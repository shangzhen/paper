package henu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import henu.bean.Announcement;
import henu.bean.OpeningReport;
import henu.dao.IAnnouncementDao;
import henu.dao.IOpeningReportDao;
import henu.factory.DaoFactory;

public class OpeningReportDaoImpl implements IOpeningReportDao {
	private QueryRunner queryRunner;
	public OpeningReportDaoImpl(QueryRunner queryRunner) {
		super();
		this.queryRunner = queryRunner;
	}

	@Override
	public int add(OpeningReport report) {
		String sql="INSERT INTO t_report(fNo,fOpeningTime,fTopicTitle,fTopicSource,fSubjectPurpose,"
				+ "fResearchObject,fUseWay,fExpectedResults,fProgressPlan,fReference,fMentorOpinion,"
				+ "fAdjunct,fMemo,fTid,fReviewTime) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {report.getFno(),report.getFopeningTime(),report.getFtopicTitle(),report.getFtopicSource(),
				report.getFsubjectPurpose(),report.getFresearchObject(),report.getFuseWay(),report.getFexpectedResults(),
				report.getFprogressPlan(),report.getFreference(),report.getFmentorOpinion(),report.getFadjunct(),report.getFmemo(),report.getFtid(),report.getFreviewTime()};
		int result = 0;
		try {
			result = queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(String fno, OpeningReport report) {
		String sql = "UPDATE t_report SET fOpeningTime=?,fTopicTitle=?,fTopicSource=?,fSubjectPurpose=?,"
				+ "fResearchObject=?,fUseWay=?,fExpectedResults=?,fProgressPlan=?,fReference=?,fMentorOpinion=?,"
				+ "fAdjunct=?,fMemo=?,fTid=?,fReviewTime=? WHERE fNo=?";
		Object[] params = {report.getFopeningTime(),report.getFtopicTitle(),report.getFtopicSource(),
				report.getFsubjectPurpose(),report.getFresearchObject(),report.getFuseWay(),report.getFexpectedResults(),
				report.getFprogressPlan(),report.getFreference(),report.getFmentorOpinion(),report.getFadjunct(),report.getFmemo(),report.getFtid(),report.getFreviewTime(),fno};
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
		String sql="DELETE FROM t_report WHERE fNo=?";
		int result=0;
		try {
			result=queryRunner.update(sql,fno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<OpeningReport> findAll() {
		String sql="SELECT* FROM t_report ORDER BY fNO DESC";
		List<OpeningReport> list=null;
		try {
			list=queryRunner.query(sql,new BeanListHandler<OpeningReport>(OpeningReport.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public OpeningReport find(String fno) {
		String sql="SELECT * FROM t_report WHERE fNo=?";
		
		 OpeningReport or=null;
		try {
			or = queryRunner.query(sql, new BeanHandler<OpeningReport>(OpeningReport.class),fno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return or;
	}

	@Override
	public List<OpeningReport> findByTeacher(String ftid) {
		String sql="SELECT * FROM t_report WHERE fTid=?";
		List<OpeningReport> list=null;
		try {
			list=queryRunner.query(sql,new BeanListHandler<OpeningReport>(OpeningReport.class),ftid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OpeningReport> findByProperty(String property, String key, String property1, String key1, String order,
			String sort, int start, int end) {
		String sql = "SELECT * FROM t_report WHERE " + property  + " LIKE '%" + key + "%'" +
				" ORDER BY " + order + " " + sort + " LIMIT " + start + "," + end;
		List<OpeningReport> list=null;
		try {
			list=queryRunner.query(sql,new BeanListHandler<OpeningReport>(OpeningReport.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		/*OpeningReport a = new OpeningReport();
		a.setfNo("123446");
		a.setfTid("01014");
		a.setfProgressPlan("�����");
		IOpeningReportDao adao = DaoFactory.createOpeningReportDAO();
		//adao.add(a);
		//adao.delete("123409");
		//adao.update("123456", a);
		//System.out.println(adao.find("123456"));
		List<OpeningReport> list = adao.findByTeacher("01014");
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println( list.get(i));
		}*/
	}

}
