package henu.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import henu.bean.Student;
import henu.bean.Teacher;
import henu.dao.ITeacherDao;
import henu.factory.DaoFactory;
import henu.util.AJAX;
import henu.util.Md5Token;
import henu.util.Page;

public class TeacherAction extends ActionSupport {

	//分页查询
	Page page;
	private int pageNum=1;
	private int numPerPage=10;
	private String Fno;
	private String orderField="ftid";
	private String field = "fNo";
	private String orderDirection="asc";
	private String value;
	


	//检索
	private String property="-1";
	private String key="-1";
	
	private AJAX ajax;
	
	private Teacher tc;
	private String url="/teacher/ajax.jsp";
	
	private String ftid;
	
	private List<Teacher> list;
	private List<Student> stulist;

	
	private String oldPassword;
	private String newPassword;
	private Teacher t;
	private Student stu;
	
	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public String getFno() {
		return Fno;
	}

	public void setFno(String fno) {
		Fno = fno;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public List<Student> getStulist() {
		return stulist;
	}

	public void setStulist(List<Student> stulist) {
		this.stulist = stulist;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Teacher getT() {
		return t;
	}

	public void setT(Teacher t) {
		this.t = t;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
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

	public AJAX getAjax() {
		return ajax;
	}

	public void setAjax(AJAX ajax) {
		this.ajax = ajax;
	}

	public Teacher getTc() {
		return tc;
	}

	public void setTc(Teacher tc) {
		this.tc = tc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFtid() {
		return ftid;
	}

	public void setFtid(String ftid) {
		this.ftid = ftid;
	}

	public List<Teacher> getList() {
		return list;
	}

	public void setList(List<Teacher> list) {
		this.list = list;
	}
	
	public String resetPassword()
	{
		int result;
		String fNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
		String pawstring = Md5Token.getInstance().getLongLongToken(newPassword);
		tc = DaoFactory.createTeacherDao().find(fNo);
		result = DaoFactory.createTeacherDao().resetPassword(fNo, oldPassword, pawstring, tc.getFtype());
		ajax=new AJAX();
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("设置成功");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("page4");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("设置失败，请重新填写");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("page4");
		}
		url="/teacher/ajax.jsp";
		return SUCCESS;
	}
	
	public String add()
	{
		
		String p = Md5Token.getInstance().getLongLongToken(tc.getFpsw());
		tc.setFpsw(p);
		int result=DaoFactory.createTeacherDao().add(tc);
		ajax=new AJAX();
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("设置成功");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("page4");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("设置失败，请重新填写");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("page4");
		}
		url="/teacher/ajax.jsp";
		return SUCCESS;
	}
	
	public String delete()
	{
		int result = DaoFactory.createTeacherDao().delete(ftid);
		ajax=new AJAX();
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("删除成功");
			ajax.setNavTabId("page4");
			ajax.setCallbackType("");
			
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("删除失败");
			ajax.setCallbackType("");
		}
		url="/teacher/ajax.jsp";
		return SUCCESS;
	}
	
	public String update()
	{
		ITeacherDao dao = DaoFactory.createTeacherDao();
		ajax = new AJAX();
		int result = dao.update(tc.getFtid(), tc);
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("更新成功");
			ajax.setNavTabId("page4");
			ajax.setCallbackType("closeCurrent");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("更新失败");
			ajax.setCallbackType("");
		}
		return SUCCESS;
	}
	
	public String find()
	{
		ITeacherDao dao = DaoFactory.createTeacherDao();
		Teacher t = dao.find(ftid);
		ServletActionContext.getRequest().getSession().setAttribute("teacher", t);
		url="/teacher/teacher_update.jsp";
		return SUCCESS;
		
	}
	
	public String findAll()
	{
		page = new Page();
		if(orderField.equals("")||orderDirection.equals(""))
		{
			orderField="ftid";
			orderDirection="asc";
		}
		if(property.equals("")||key.equals(""))
		{
			property="-1";
			key="-1";
		}
		page.setProperties("t_teacher", pageNum, numPerPage, property, key);
		
		list = DaoFactory.createTeacherDao().findAll();
		url="/teacher/teacher_info.jsp";
		return SUCCESS;
	}
	
	public String findProperty(){
		page = new Page();
		if(orderField.equals("")||orderDirection.equals(""))
		{
			orderField="ftid";
			orderDirection="asc";
		}
		if(property.equals("")||key.equals(""))
		{
			property="-1";
			key="-1";
		}
		page.setProperties("t_teacher", pageNum, numPerPage, property, key);
		
		list = DaoFactory.createTeacherDao().findByProperty(property, key, orderField, orderDirection, page.getStart()	, numPerPage);
		url="/teacher/teacher_info.jsp";
		return SUCCESS;
	}
	
	public String findSProperty(){
		page = new Page();
		if(orderField.equals("")||orderDirection.equals(""))
		{
			field="fNo";
			orderDirection="asc";
		}
		if(property.equals("")||key.equals(""))
		{
			property="-1";
			key="-1";
		}
		page.setProperties("t_student", pageNum, numPerPage, property, key);
		
		stulist = DaoFactory.createIStudentDao().findByProperty(property, key, field, orderDirection, page.getStart()	, numPerPage);
		url="/teacher/student_info.jsp";
		return SUCCESS;
	}
	
	public String findByFno(){
		stulist = DaoFactory.createIStudentDao().findByProperty3(property,value);
		url="/teacher/student_info.jsp";
		return SUCCESS;
	}
	
}
