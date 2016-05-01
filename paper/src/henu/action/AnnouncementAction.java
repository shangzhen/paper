package henu.action;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import henu.bean.Announcement;
import henu.dao.IAnnouncementDao;
import henu.factory.DaoFactory;
import henu.util.AJAX;
import henu.util.Page;

public class AnnouncementAction extends ActionSupport {

	//分页
	Page page;
	private int pageNum=1;
	private int numPerPage=10;
	
	private String orderField="fpublishMessage";
	private String orderDirection="desc";
	
	//检索
	private String property="-1";
	private String key="-1";
	
	private AJAX ajax;
	
	private Announcement ac;
	private String url="/teacher/ajax.jsp";
	
	private int fserialNo;
	
	private List<Announcement> list;
	
	public String add()
	{
		Date date = new Date(System.currentTimeMillis());
		String dateStr = DateFormat.getDateInstance().format(date);
		ac.setFpublishMessage(dateStr);
		int result = DaoFactory.createAnnouncementDao().add(ac);
		ajax=new AJAX();
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("设置成功");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("page8");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("设置失败，请重新填写");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("page8");
		}
		url="/teacher/ajax.jsp";
		return SUCCESS;
	}
	
	public String delete()
	{
		System.out.println(fserialNo);
		int result = DaoFactory.createAnnouncementDao().delete(fserialNo);
		ajax=new AJAX();
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("删除成功");
			ajax.setNavTabId("page8");
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
		Date date = new Date(System.currentTimeMillis());
		String dateStr = DateFormat.getDateInstance().format(date);
		ac.setFpublishMessage(dateStr);
		IAnnouncementDao dao = DaoFactory.createAnnouncementDao();
		ajax = new AJAX();
		int result = dao.update(fserialNo, ac);
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("更新成功");
			ajax.setNavTabId("page8");
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
		IAnnouncementDao dao = DaoFactory.createAnnouncementDao();
		Announcement a = dao.find(fserialNo);
		ServletActionContext.getRequest().getSession().setAttribute("announcement", a);
		url="/teacher/announce_update.jsp";
		return SUCCESS;
		
	}
	public String findDetail()
	{
		IAnnouncementDao dao = DaoFactory.createAnnouncementDao();
		Announcement a = dao.findDetail(fserialNo);
		ServletActionContext.getRequest().getSession().setAttribute("announcement", a);
		int count = Integer.parseInt(a.getFbrowseTime())+1;
		DaoFactory.createAnnouncementDao().updateBrowseTime(fserialNo, count);
		url="/teacher/announce_detail.jsp";
		return SUCCESS;
	}
	public String findAll()
	{
		page = new Page();
		if(orderField.equals("")||orderDirection.equals(""))
		{
			orderField="fpublishMessage";
			orderDirection="desc";
		}
		if(property.equals("")||key.equals(""))
		{
			property="-1";
			key="-1";
		}
		page.setProperties("t_announcement", pageNum, numPerPage, property, key);
		
		list = DaoFactory.createAnnouncementDao().findAll();
	/*	System.out.println(list.get(0).toString());*/
		url="/teacher/announce_manage.jsp";
		return SUCCESS;
	}
	
	public String findProperty()
	{
		page = new Page();
		if(orderField.equals("")||orderDirection.equals(""))
		{
			orderField="fpublishMessage";
			orderDirection="desc";
		}
		if(property.equals("")||key.equals(""))
		{
			property="-1";
			key="-1";
		}
		page.setProperties("t_announcement", pageNum, numPerPage, property, key);
		//System.out.println("pro:"+property+",key:"+ key+",orderfield:"+ orderField+"orderdir："+ orderDirection+ page.getStart()+ page.getEnd());

		list = DaoFactory.createAnnouncementDao().findByProperty(property, key, orderField, orderDirection, page.getStart(), numPerPage);
		url="/teacher/announce_manage.jsp";
		return SUCCESS;
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

	public Announcement getAc() {
		return ac;
	}

	public void setAc(Announcement ac) {
		this.ac = ac;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getFserialNo() {
		return fserialNo;
	}

	public void setFserialNo(int fserialNo) {
		this.fserialNo = fserialNo;
	}

	public List<Announcement> getList() {
		return list;
	}

	public void setList(List<Announcement> list) {
		this.list = list;
	}
	
	
}
