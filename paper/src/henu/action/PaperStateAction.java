package henu.action;

import henu.bean.Announcement;
import henu.bean.Paperstate;
import henu.factory.DaoFactory;
import henu.util.AJAX;
import henu.util.Page;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 论文状态
 * @author 王飞翔
 *
 */
public class PaperStateAction extends ActionSupport {

	// 分页
	Page page;
	private int pageNum = 1;
	private int numPerPage = 10;

	private String orderField = "fNo";
	private String orderDirection = "desc";

	// 检索
	private String property = "-1";
	private String key = "-1";

	private AJAX ajax;
	//paperstate 用来接收一条状态信息
	private Paperstate paperstate;
	private List<Paperstate> list;
	private String url;
	//fno为一条状态的主键
	private String fno;
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
	public Paperstate getPaperstate() {
		return paperstate;
	}
	public void setPaperstate(Paperstate paperstate) {
		this.paperstate = paperstate;
	}
	public List<Paperstate> getList() {
		return list;
	}
	public void setList(List<Paperstate> list) {
		this.list = list;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}

	/**
	 * 导师查看自己所带学生的论文状态信息
	 * @return
	 */
	public String findAll()
	{
		String ftid = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
		page = new Page();
		String sql = "SELECT * FROM t_paperstate WHERE fNo IN (SELECT fNo FROM t_thesislist WHERE fTid = "+ftid+")";
   		page.setSql(sql, pageNum, numPerPage);

		list = DaoFactory.createIPaperstateDao().findAll(ftid, page.getStart(),page.getEnd());
		url="/teacher/paperstate.jsp";
		page.setTotalCount(list.size());
		return SUCCESS;
	}
	/**
	 * 按属性进行查找学生论文状态信息
	 * @return
	 */
	public String findByProperty(){
		page = new Page();
		if(property.equals("")||key.equals(""))
		{
			property="-1";
			key="-1";
		}
		
		page.setProperties("t_paperstate", pageNum, numPerPage, property, key);
		list = DaoFactory.createIPaperstateDao().findByProperty(property, key, page.getStart(), page.getEnd());
		url = "/teacher/paperstate.jsp";
		return SUCCESS;
	}
	/**
	 * 教师获取一条学生状态信息，传输到修改页面
	 * @return
	 */
	public String findByfno(){
		paperstate = DaoFactory.createIPaperstateDao().find(fno);
		url = "/teacher/paperstate_update.jsp";
		return SUCCESS;
	}
	/**
	 * 教师修改一条学生状态信息
	 * @return
	 */
	public String update(){
		ajax=new AJAX();
		int result  = DaoFactory.createIPaperstateDao().update(fno, paperstate);		
   		if(result!=0){
   			ajax.setStatusCode("200");
   			ajax.setMessage("修改成功");
   			ajax.setNavTabId("page16");
   			ajax.setCallbackType("closeCurrent");
   			
   		}else{
   			ajax.setStatusCode("300");
   			ajax.setMessage("修改失败");
   			ajax.setCallbackType("");
   		}
   		url = "/teacher/ajax.jsp";
		return SUCCESS;
	}
}
