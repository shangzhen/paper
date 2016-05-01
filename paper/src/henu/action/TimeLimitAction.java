package henu.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import henu.bean.TimeLimit;
import henu.dao.ITimeLimitDao;
import henu.factory.DaoFactory;
import henu.util.AJAX;
import henu.util.Page;

public class TimeLimitAction extends ActionSupport {
	Page page;
	private int pageNum = 1;
	private int numPerPage = 10;

	private String orderField = "fId";
	private String orderDirection = "asc";

	private String property = "-1";
	private String key = "-1";
	private String fid;
	private AJAX ajax;
	private String url = "/teacher/ajax.jsp";
	public List<TimeLimit> timelimitlist;
	private TimeLimit timeLimit;

	public List<TimeLimit> getTimelimitlist() {
		return timelimitlist;
	}

	public void setTimelimitlist(List<TimeLimit> timelimitlist) {
		this.timelimitlist = timelimitlist;
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

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
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

	public TimeLimit getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(TimeLimit timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String add() {
		System.out.println(timeLimit.toString());
		int result = DaoFactory.createITimeLimitDao().add(timeLimit);
		ajax = new AJAX();
		if (result != 0) {
			ajax.setStatusCode("200");
			ajax.setMessage("保存成功");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("page10");
		} else {
			ajax.setStatusCode("300");
			ajax.setMessage("保存失败");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("page10");
		}
		return SUCCESS;
	}

	public String delete() {
		int result = DaoFactory.createITimeLimitDao().delete(fid);
		ajax = new AJAX();
		if (result != 0) {
			ajax.setStatusCode("200");
			ajax.setMessage("删除成功");
			ajax.setNavTabId("page10");
			ajax.setCallbackType("");

		} else {
			ajax.setStatusCode("300");
			ajax.setMessage("删除失败");
			ajax.setCallbackType("");
		}
		return SUCCESS;
	}

	public String update() {
		System.out.println("-----------------------------------");
		ITimeLimitDao dao = DaoFactory.createITimeLimitDao();
		ajax = new AJAX();
		System.out.println(timeLimit.toString());
		System.out.println(fid);
		int result = dao.update(fid, timeLimit);
		if (result != 0) {
			ajax.setStatusCode("200");
			ajax.setMessage("更新成功");
			ajax.setNavTabId("page10");
			ajax.setCallbackType("closeCurrent");
		} else {
			ajax.setStatusCode("300");
			ajax.setMessage("更新失败");
			ajax.setCallbackType("");
		}
		return SUCCESS;
	}
	public String updateBegin(){
		ITimeLimitDao dao = DaoFactory.createITimeLimitDao();
		timeLimit = dao.find(fid);
		url = "/teacher/timelimit_update.jsp";
		return SUCCESS;
	}
	public String find() {
		System.out.println("find");
		ITimeLimitDao dao = DaoFactory.createITimeLimitDao();
		timeLimit = dao.find(fid);
		url = "/teacher/timelimit_detail.jsp";
		return SUCCESS;
	}

	public String findAll() {
		System.out.println("----");
		page = new Page();
		if(orderField.equals("")||orderDirection.equals(""))
		{
			orderField="fId";
			orderDirection="desc";
		}
		if(property.equals("")||key.equals(""))
		{
			property="-1";
			key="-1";
		}
		

		timelimitlist = DaoFactory.createITimeLimitDao().findAll();
		/* System.out.println(list.get(0).toString()); */
		url = "/teacher/timelimit_manage.jsp";
		return SUCCESS;
	}

	public String findProperty() throws Exception {
		page = new Page();
		if(orderField.equals("")||orderDirection.equals(""))
		{
			orderField="fId";
			orderDirection="desc";
		}
		if(property.equals("")||key.equals(""))
		{
			property="-1";
			key="-1";
		}
		// property, key, "userName", "DESC", page.getStart(),
		// page.getEnd());
		page.setProperties("t_timelimit", pageNum, numPerPage, property, key);
		timelimitlist = DaoFactory.createITimeLimitDao().findByProperty(property, key, "", "", "fid", "DESC",
				page.getStart(), numPerPage);
		url = "/teacher/timelimit_manage.jsp";
		return SUCCESS;
	}
	public String findSingleTimeLimit(){
		timeLimit = DaoFactory.createITimeLimitDao().find(fid);
		url = "/student/timeLimitDetail_dialog.jsp";
		return SUCCESS;
	}

}
