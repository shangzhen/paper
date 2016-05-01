package henu.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import henu.bean.Notice;
import henu.bean.Teacher;
import henu.dao.ITeacherDao;
import henu.factory.DaoFactory;
import henu.util.AJAX;
import henu.util.Page;

public class NoticeAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private Notice notice; 	
	private AJAX ajax;
	private String url = "/teacher/ajax.jsp";
	private List<Notice> noticeList;
	private int fid;
	
	//分页查询
		Page page;
		private int pageNum=1;
		private int numPerPage=10;
		
		private String orderField="fid";
		private String orderDirection="asc";
		
		//检索
		private String property="-1";
		private String key="-1";

		
	public Notice getNotice() {
			return notice;
		}

		public void setNotice(Notice notice) {
			this.notice = notice;
		}

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

		public List<Notice> getNoticeList() {
			return noticeList;
		}

		public void setNoticeList(List<Notice> noticeList) {
			this.noticeList = noticeList;
		}

		public int getFid() {
			return fid;
		}

		public void setFid(int fid) {
			this.fid = fid;
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

	public String add() throws Exception{
		
			ajax = new AJAX();
			//设置系统时间为添加时间
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			String curDate = simpleDateFormat.format(date);
			notice.setFreleasetime(curDate);
			
			int result = DaoFactory.createNoticeDao().add(notice);
			
			if(result!=0){
				ajax.setStatusCode("200");
				ajax.setMessage("保存成功");
				ajax.setNavTabId("page6");
				ajax.setCallbackType("closeCurrent");
			}else{
				ajax.setStatusCode("300");
				ajax.setMessage("保存失败");
				ajax.setCallbackType("");
			}
			return SUCCESS;
		}
	
	public String delete()
	{
		int result = DaoFactory.createNoticeDao().delete(fid);
		ajax=new AJAX();
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("删除成功");
			ajax.setNavTabId("page6");
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
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		String curDate = simpleDateFormat.format(date);
		notice.setFreleasetime(curDate);
		
		int result = DaoFactory.createNoticeDao().update(fid, notice);
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("更新成功");
			ajax.setNavTabId("page6");
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
			orderField="fid";
			orderDirection="asc";
		}
		if(property.equals("")||key.equals(""))
		{
			property="-1";
			key="-1";
		}
		page.setProperties("t_notice", pageNum, numPerPage, property, key);
		
		noticeList = DaoFactory.createNoticeDao().findByProperty(property, key, orderField, orderDirection, page.getStart()	, page.getEnd());
		url="/teacher/notice_manage.jsp";
		return SUCCESS;
	}
	
	public String findAll()
	{
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
		page.setProperties("t_notice", pageNum, numPerPage, property, key);
		
		noticeList = DaoFactory.createNoticeDao().findAll();
		url="/teacher/notice_manage.jsp";
		return SUCCESS;
	}
	
	public String find()
	{
		Notice n = DaoFactory.createNoticeDao().find(fid);
		
		ServletActionContext.getRequest().getSession().setAttribute("notice",n);
		url="/teacher/notice_update.jsp";
		return SUCCESS;
		
	}
}
