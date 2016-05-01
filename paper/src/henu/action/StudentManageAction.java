package henu.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import henu.bean.Announcement;
import henu.bean.Teacher;
import henu.bean.ThesisList;
import henu.bean.UploadFile;
import henu.dao.IAnnouncementDao;
import henu.dao.ITeacherDao;
import henu.dao.IThesisListDao;
import henu.factory.DaoFactory;
import henu.util.AJAX;
import henu.util.Md5Token;
import henu.util.Page;

public class StudentManageAction extends ActionSupport {
	private static final int ThesisList = 0;
	
	private int result;
	private String oldpsw;
	private String rnewpsw;
	private ThesisList s;
	private String url;
	private Announcement info;
	private String fno;
	private List<UploadFile> list;
	private String property="-1";
	private String key="-1";
	private AJAX ajax;
	private Teacher teacher;



	/**
	 * 锟斤拷页锟斤拷询
	 */
	Page page;
	private int pageNum=1;
	private int numPerPage=10;
	
	private String orderField="fid";
	private String orderDirection="asc";
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public static int getThesislist() {
		return ThesisList;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	public AJAX getAjax() {
		return ajax;
	}

	public void setAjax(AJAX ajax) {
		this.ajax = ajax;
	}
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	

	

	public List<UploadFile> getList() {
		return list;
	}

	public void setList(List<UploadFile> list) {
		this.list = list;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

	public Announcement getInfo() {
		return info;
	}

	public void setInfo(Announcement info) {
		this.info = info;
	}

	public ThesisList getS() {
		return s;
	}

	public void setS(ThesisList s) {
		this.s = s;
	}

	public String getRnewpsw() {
		return rnewpsw;
	}

	public void setRnewpsw(String rnewpsw) {
		this.rnewpsw = rnewpsw;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getOldpsw() {
		return oldpsw;
	}

	public void setOldpsw(String oldpsw) {
		this.oldpsw = oldpsw;
	}

	
	
	/**
	 * 瀵嗙爜淇敼
	 * @return 
	 * @return
	 */

	public String resetPassword()
	{
	/*	s.setFpsw(Md5Token.getInstance().getLongToken(s.getFpsw()));*/
		 String fNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
		 String pawstring = Md5Token.getInstance().getLongToken(rnewpsw);
		 s = DaoFactory.createIThesisListDao().resetPassword(fNo, oldpsw, pawstring);
		
	   ajax = new AJAX();
		if(s!=null){
			ajax.setStatusCode("200");
			ajax.setMessage("璁剧疆鎴愬姛");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("studentMessage");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("璁剧疆澶辫触锛岃閲嶆柊濉啓");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("teacherInf");
		}
		url="/student/ajax.jsp";
		/*if(t!=null){		
		return SUCCESS;
		}
        else
		return ERROR;*/
		return SUCCESS;
		
	}

	
	
	/**
	 * 鏌ヨ涓汉淇℃伅
	 * @return
	 */
	public String find(){
		String fNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
		s = DaoFactory.createIThesisListDao().find(fNo);
		url="/student/student_message.jsp";
		return SUCCESS;
	}	
	
	public String findTeacher(){
		String fNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
		s = DaoFactory.createIThesisListDao().find(fNo);
		teacher = DaoFactory.createTeacherDao().find(s.getFtid());
		url="/student/teacher_message.jsp";
		return SUCCESS;
	}
	
	/**
	 * 鏌ヨ鎵�鏈�
	 * @return
	 */
	public String findAll()
	{
	
		list = DaoFactory.createIUploadFileDao().findAll();
		System.out.println(list);
		url="/student/Common_file.jsp";
		return SUCCESS;
	}
	
	
	
	
	/**
	 * 瀛︾敓淇℃伅淇敼
	 * @return
	 */
	public String update()
	{
		IThesisListDao dao = DaoFactory.createIThesisListDao();
		ajax = new AJAX();
		int result = dao.update(s.getFno(), s);
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("鏇存柊鎴愬姛");
			ajax.setNavTabId("teacherMessage");
			ajax.setCallbackType("closeCurrent");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("鏇存柊澶辫触");
			ajax.setCallbackType("");
		}
		url="/student/ajax.jsp";
		return SUCCESS;
	}
	
	
	
	
	/**
	 * 鍒嗙被鏌ヨ
	 * @return
	 */
	public String findByProperty() {
		page = new Page();
		if(orderField.equals("")||orderDirection.equals(""))
		{
			orderField="fid";
			orderDirection="asc";
		}
		if(property.equals("")||key.equals(""))
		{
			property="-1";
			key="-1";
		}
		page.setProperties("t_file", pageNum, numPerPage, property, key);
		list = DaoFactory.createIUploadFileDao().findByProperty(property, key,orderField, orderDirection, page.getStart()	, page.getEnd());
		System.out.println(list);
		url="/student/Common_file.jsp";
		return SUCCESS;
	}
}
