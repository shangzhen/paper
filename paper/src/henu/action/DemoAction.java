package henu.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baidu.ueditor.define.State;
import com.opensymphony.xwork2.ActionSupport;

import henu.bean.Paperstate;
import henu.bean.Review;
import henu.bean.Score;
import henu.bean.Teacher;
import henu.bean.ThesisList;
import henu.bean.TimeLimit;
import henu.dao.ITeacherDao;
import henu.factory.DaoFactory;

public class DemoAction extends ActionSupport {
	private String result;
	private String username;
	private String password;
	private String act;
	private ThesisList thesislist;
	private List<Object[]> tlist;
	private List<TimeLimit> timeLimitList;
	private Teacher teacher;
	private Paperstate paperstate;
	private Score score;
	private Review review;
	private double sum;

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Paperstate getPaperstate() {
		return paperstate;
	}

	public void setPaperstate(Paperstate paperstate) {
		this.paperstate = paperstate;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<TimeLimit> getTimeLimitList() {
		return timeLimitList;
	}

	public void setTimeLimitList(List<TimeLimit> timeLimitList) {
		this.timeLimitList = timeLimitList;
	}

	public ThesisList getThesislist() {
		return thesislist;
	}

	public void setThesislist(ThesisList thesislist) {
		this.thesislist = thesislist;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	@Override
	public String execute() throws Exception {
		// 鍒涘缓request
		HttpServletRequest request = ServletActionContext.getRequest();
		// 鍒涘缓session
		HttpSession session = request.getSession();
		// 鍒ゆ柇act绫诲瀷 0,绠＄悊鍛� 1,鏁欏笀 2,瀛︾敓
		if (act.equals("管理员")) {
			if (DaoFactory.createTeacherDao().login(username, password, act) != null) {
				tlist = DaoFactory.createIThesisListDao().getStudentList(username, "0");
				session.setAttribute("Teacher", DaoFactory.createTeacherDao().find(username));
				session.setAttribute("Tuserlist", tlist);
				session.setAttribute("user", username);
				result = "admin";
			} else {
				result = "error";
			}
		} else if (act.equals("教师")) {
			if (DaoFactory.createTeacherDao().login(username, password, act) != null) {
				tlist = DaoFactory.createIThesisListDao().getStudentList(username, "0");
				session.setAttribute("Teacher", DaoFactory.createTeacherDao().find(username));
				session.setAttribute("Tstulist", tlist);
				session.setAttribute("user", username);
				
				result = "teacher";
			} else {
				result = "error";
			}
		} else if (act.equals("学生")) {
			if (DaoFactory.createIThesisListDao().login(username, password) != null) {

				session.setAttribute("Student", DaoFactory.createIThesisListDao().find(username));
				session.setAttribute("user", username);
				//我的导师
				String teacherid = ((ThesisList)session.getAttribute("Student")).getFtid();
				teacher = DaoFactory.createTeacherDao().find(teacherid);
				session.setAttribute("myteacher", teacher);
				//论文状态
				paperstate = DaoFactory.createIPaperstateDao().find(username);
				session.setAttribute("paperstate", paperstate);
				//我的成绩
				score = DaoFactory.createScoreDao().find(username);
				session.setAttribute("score", score);
				review = DaoFactory.createReviewDao().find(username);
				session.setAttribute("review", review);
				
				double s1 = Double.valueOf(review.getFcontentScore());
				double s2 = Double.valueOf(review.getFscoreDefense());
				double s3 = Double.valueOf(review.getFwordScore());
				double s4 = Double.valueOf(review.getFqualityScore());
				sum = s1+s2+s3+s4; 
				session.setAttribute("sum", sum);
				
				
				timeLimitList = DaoFactory.createITimeLimitDao().findByStudentId(username);
				session.setAttribute("timeLimitList", timeLimitList);
				
				result = "student";
			} else {
				result = "error";
			}
		}
		
		
		return result;
		// result="鎴愬姛";
		// return super.execute();
	}

	
	
	
	
	
	
}
