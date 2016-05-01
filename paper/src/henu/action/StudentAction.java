package henu.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import henu.bean.Student;
import henu.bean.Task;
import henu.factory.DaoFactory;
import henu.util.AJAX;
import henu.util.Page;

public class StudentAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private Task task; 	
	private AJAX ajax;
	private String url = "/teacher/ajax.jsp";
	private List<Task> taskList;
	private String fno;
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

		//分页查询
		Page page;
		private int pageNum=1;
		private int numPerPage=10;
		
		private String orderField="fno";
		private String orderDirection="asc";
		
		//检索
		private String property="-1";
		private String key="-1";

		public AJAX getAjax() {
			return ajax;
		}

		public void setAjax(AJAX ajax) {
			this.ajax = ajax;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
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

		
	public Task getTask() {
			return task;
		}

		public void setTask(Task task) {
			this.task = task;
		}

		public List<Task> getTaskList() {
			return taskList;
		}

		public void setTaskList(List<Task> taskList) {
			this.taskList = taskList;
		}

		public String getFno() {
			return fno;
		}

		public void setFno(String fno) {
			this.fno = fno;
		}

	public String add() throws Exception{
		
			ajax = new AJAX();
			
			int result = DaoFactory.createTaskDao().add(task);
			
			if(result!=0){
				ajax.setStatusCode("200");
				ajax.setMessage("保存成功");
				ajax.setNavTabId("page1");
				ajax.setCallbackType("closeCurrent");
			}else{
				ajax.setStatusCode("300");
				ajax.setMessage("保存失败");
				ajax.setCallbackType("page1");
				ajax.setCallbackType("closeCurrent");
			}
			return SUCCESS;
		}
	
	public String delete()
	{
		int result =  DaoFactory.createTaskDao().delete(fno);
		ajax=new AJAX();
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("删除成功");
			ajax.setNavTabId("page1");
			ajax.setCallbackType("");
			
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("删除失败");
			ajax.setCallbackType("");
		}
		return SUCCESS;
	}
		
	public String update()
	{
		ajax = new AJAX();
		int result =  DaoFactory.createTaskDao().update(task.getFno(), task);
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("更新成功");
			ajax.setNavTabId("page1");
			ajax.setCallbackType("closeCurrent");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("更新失败");
			ajax.setCallbackType("");
		}
		return SUCCESS;
	}
	
	public String findProperty(){
		page = new Page();
		if(orderField.equals("")||orderDirection.equals(""))
		{
			orderField="fno";
			orderDirection="asc";
		}
		if(property.equals("")||key.equals(""))
		{
			property="-1";
			key="-1";
		}
		page.setProperties("t_task", pageNum, numPerPage, property, key);
		
		taskList =  DaoFactory.createTaskDao().findByProperty(property, key, orderField, orderDirection, page.getStart()	, page.getEnd());
		url="/teacher/student_manage.jsp";
		return SUCCESS;
	}
	
	public String findAll()
	{
		page = new Page();
		if(orderField.equals("")||orderDirection.equals(""))
		{
			orderField="fno";
			orderDirection="asc";
		}
		if(property.equals("")||key.equals(""))
		{
			property="-1";
			key="-1";
		}
		page.setProperties("t_task", pageNum, numPerPage, property, key);
		
		taskList =  DaoFactory.createTaskDao().findAll();
		url="/teacher/student_manage.jsp";
		return SUCCESS;
	}
	
	public String find()
	{
		Task t =  DaoFactory.createTaskDao().find(fno);
		
		ServletActionContext.getRequest().getSession().setAttribute("task",t);
		url="/teacher/student_edit.jsp";
		return SUCCESS;
	}
	
	public String addstumessage(){
		ajax = new AJAX();
		int result =  DaoFactory.createIStudentDao().add(student);
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("添加成功");
			ajax.setNavTabId("page1");
			ajax.setCallbackType("closeCurrent");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("添加失败");
			ajax.setCallbackType("");
		}
		return SUCCESS;
	}
	
	public String deletestu(){
		ajax = new AJAX();
		int result =  DaoFactory.createIStudentDao().delete(fno);
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("删除成功");
			ajax.setNavTabId("page1");
			ajax.setCallbackType("");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("删除失败");
			ajax.setCallbackType("");
		}
		return SUCCESS;
	}
	
	public String findstu(){
		ajax = new AJAX();
		student =  DaoFactory.createIStudentDao().find(fno);
		/*if(student!=null){
			ajax.setStatusCode("200");
			ajax.setMessage("删除成功");
			ajax.setNavTabId("page1");
			ajax.setCallbackType("");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("删除失败");
			ajax.setCallbackType("");
		}*/
		url="/teacher/student_update.jsp";
		return SUCCESS;
	}
	public String updatestu(){
		ajax = new AJAX();
		int result  =  DaoFactory.createIStudentDao().update(student.getFno(), student);
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("修改成功");
			ajax.setNavTabId("page1");
			ajax.setCallbackType("closeCurrent");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("修改失败");
			ajax.setCallbackType("");
		}
		url="/teacher/ajax.jsp";
		return SUCCESS;
	}
}
