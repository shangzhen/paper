package henu.factory;

import henu.dao.IAcclaimDao;
import henu.dao.IAnnouncementDao;
import henu.dao.ICheckDao;
import henu.dao.IDistributionDao;
import henu.dao.INoticeDao;
import henu.dao.IOnlineDao;
import henu.dao.IOpeningReportDao;
import henu.dao.IPaperDetailsDao;
import henu.dao.IPaperstateDao;
import henu.dao.IRegistrationDao;
import henu.dao.IReviewDao;
import henu.dao.IScoreDao;
import henu.dao.IStudentDao;
import henu.dao.ITaskDao;
import henu.dao.ITeacherDao;
import henu.dao.IThesisDao;
import henu.dao.IThesisListDao;
import henu.dao.ITimeLimitDao;
import henu.dao.IUploadFileDao;
import henu.dao.impl.AcclaimDaoImpl;
import henu.dao.impl.AnnouncementDaoImpl;
import henu.dao.impl.CheckDaoImpl;
import henu.dao.impl.DistributionDaoImpl;
import henu.dao.impl.IThesisDaoImpl;
import henu.dao.impl.IThesisListDaoImpl;
import henu.dao.impl.NoticeDaoImpl;
import henu.dao.impl.OnlineDaoImpl;
import henu.dao.impl.OpeningReportDaoImpl;
import henu.dao.impl.PaperDetailsDaoImpl;
import henu.dao.impl.PaperstateImpl;
import henu.dao.impl.RegistrationDaoImpl;
import henu.dao.impl.ReviewDaoImpl;
import henu.dao.impl.ScoreDaoImpl;
import henu.dao.impl.StudentDaoImpl;
import henu.dao.impl.TaskDaoImpl;
import henu.dao.impl.TeacherDaoImpl;
import henu.dao.impl.TimeLimitDaoImpl;
import henu.dao.impl.UploadFileDaoImpl;
import henu.util.Dbcp;

import org.apache.commons.dbutils.QueryRunner;

public class DaoFactory {
	// 锟斤拷锟斤拷QueryRunner锟斤拷锟斤拷
	static QueryRunner queryRunner = new QueryRunner(Dbcp.getDataSource());

	public static IAnnouncementDao createAnnouncementDao() {
		return new AnnouncementDaoImpl(queryRunner);
	}

	public static ICheckDao createCheckDao() {
		return new CheckDaoImpl(queryRunner);
	}

	public static IOnlineDao createOnlineDAO() {
		// TODO Auto-generated method stub
		return new OnlineDaoImpl(queryRunner);
	}
	
	public static IPaperDetailsDao createPaperDetailsDao() {
		// TODO Auto-generated method stub
		return new PaperDetailsDaoImpl(queryRunner);
	}

	public static IOpeningReportDao createOpeningReportDAO() {
		// TODO Auto-generated method stub
		return new OpeningReportDaoImpl(queryRunner);
	}

	public static ITimeLimitDao createITimeLimitDao(){
		
		return new TimeLimitDaoImpl(queryRunner);
	}
	public static IUploadFileDao createIUploadFileDao(){
		return new UploadFileDaoImpl(queryRunner);
	}	

	/*
	 * public static INoticeDao createNoticeDao() { return new NoticeDaoImpl();
	 * }
	 */
	public static IScoreDao createScoreDao() {
		return new ScoreDaoImpl(queryRunner);
	}

	public static IReviewDao createReviewDao() {
		return new ReviewDaoImpl(queryRunner);
	}

	// 锟斤拷锟斤拷锟�
	public static ITaskDao createTaskDao() {
		return new TaskDaoImpl(queryRunner);
	}

	// 锟斤拷师锟斤拷
	public static ITeacherDao createTeacherDao() {
		return new TeacherDaoImpl(queryRunner);
	}
	public static IRegistrationDao createRegistrationDao()
	{
		return new RegistrationDaoImpl(queryRunner);
	}
	public static IDistributionDao createDistribution() {
		// TODO Auto-generated method stub
		return new DistributionDaoImpl(queryRunner);
	}


	public static INoticeDao createNoticeDao() {
		// TODO Auto-generated method stub
		
		return new NoticeDaoImpl(queryRunner);
	}
	
	public static IThesisDao createIThesisDao()
	{
		return new IThesisDaoImpl(queryRunner);
	}
	
	public static IThesisListDao createIThesisListDao()
	{
		return new IThesisListDaoImpl(queryRunner);
	}
	
	public static IPaperDetailsDao createIPaperDetailsDao()
	{
		return new PaperDetailsDaoImpl(queryRunner);
	}
	public static IPaperstateDao createIPaperstateDao(){
		return new PaperstateImpl(queryRunner);
	}
	public static IStudentDao createIStudentDao(){
		return new StudentDaoImpl(queryRunner);
	}
	public static IAcclaimDao createIAcclaimDao(){
		return new AcclaimDaoImpl(queryRunner);
	}
}
