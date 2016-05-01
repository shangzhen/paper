package henu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import henu.bean.Student;
import henu.bean.Teacher;
import henu.bean.ThesisList;
import henu.dao.IStudentDao;
import henu.dao.IThesisListDao;
import henu.factory.DaoFactory;
import henu.util.AJAX;
import henu.util.Md5Token;
import henu.util.Page;

public class AllocationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	private String url;
	private ThesisList stu;
	private List<Student> list;
	List<ThesisList> listtn;
	private String fno;

	public List<ThesisList> getListtn() {
		return listtn;
	}

	public void setListtn(List<ThesisList> listtn) {
		this.listtn = listtn;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ThesisList getStu() {
		return stu;
	}

	public void setStu(ThesisList stu) {
		this.stu = stu;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pwd = (String) request.getAttribute("stu.fno");
		stu.setFpsw(Md5Token.getInstance().getLongToken(pwd));
		stu.setFstate("应届");
		int result = DaoFactory.createIThesisListDao().add(stu);
		ajax = new AJAX();
		if (result != 0) {
			ajax.setStatusCode("200");
			ajax.setMessage("设置成功");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("page3");
		} else {
			ajax.setStatusCode("300");
			ajax.setMessage("设置失败，请重新填写");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("page3");
		}
		url = "/teacher/ajax.jsp";
		return SUCCESS;
	}

	public String delete() {
		int result = DaoFactory.createIStudentDao().delete(fno);
		ajax = new AJAX();
		if (result != 0) {
			ajax.setStatusCode("200");
			ajax.setMessage("删除成功");
			ajax.setNavTabId("page3");
			ajax.setCallbackType("");

		} else {
			ajax.setStatusCode("300");
			ajax.setMessage("删除失败");
			ajax.setCallbackType("");
		}
		url = "/teacher/ajax.jsp";
		return SUCCESS;
	}

	public String update() {
		IThesisListDao dao = DaoFactory.createIThesisListDao();
		ajax = new AJAX();
		int result = dao.update(stu.getFno(), stu);
		if (result != 0) {
			ajax.setStatusCode("200");
			ajax.setMessage("更新成功");
			ajax.setNavTabId("page16");
			ajax.setCallbackType("closeCurrent");
		} else {
			ajax.setStatusCode("300");
			ajax.setMessage("更新失败");
			ajax.setCallbackType("closeCurrent");
		}
		url = "/teacher/ajax.jsp";
		return SUCCESS;
	}

	public String find() {
		IStudentDao dao = DaoFactory.createIStudentDao();
		Student s = dao.find(fno);
		ServletActionContext.getRequest().getSession().setAttribute("student", s);
		url = "/teacher/hand_update.jsp";
		return SUCCESS;
	}

	public String findtl() {
		IThesisListDao dao1 = DaoFactory.createIThesisListDao();
		ThesisList tl = dao1.find(fno);
		ServletActionContext.getRequest().getSession().setAttribute("thesislist", tl);
		url = "/teacher/namelist_update.jsp";
		return SUCCESS;
	}

	public String findAll() {
		page = new Page();
		String sql = "SELECT * FROM t_student WHERE fNo NOT IN(SELECT fNo FROM t_thesislist) AND " + property
				+ " LIKE '%" + key + "%' ";
		if (orderField.equals("") || orderDirection.equals("")) {
			orderField = "fno";
			orderDirection = "asc";
		}
		if (property.equals("") || key.equals("")) {
			property = "-1";
			key = "-1";
		}
		page.setSql(sql, pageNum, numPerPage);
		list = DaoFactory.createIStudentDao().findByProperty1(property, key, orderField, orderDirection,
				page.getStart(), page.getEnd());
		url = "/teacher/hand_allocation.jsp";
		return SUCCESS;
	}

	public String getTeacherName() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("ftid");
		Teacher gt = DaoFactory.createTeacherDao().find(id);
		String name = gt.getFname();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getOutputStream().write(name.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	public String getTeacherFdepartment() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("ftid");
		Teacher gt = DaoFactory.createTeacherDao().find(id);
		String department = gt.getFdepartment();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getOutputStream().write(department.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}

	public String fnList() {
		page = new Page();
		if (orderField.equals("") || orderDirection.equals("")) {
			orderField = "fno";
			orderDirection = "desc";
		}
		if (property.equals("") || key.equals("")) {
			property = "-1";
			key = "-1";
		}
		page.setProperties("t_thesislist", pageNum, numPerPage, property, key);
		listtn = DaoFactory.createIThesisListDao().findByProperty(property, key, "", "", orderField, orderDirection,
				page.getStart(), page.getEnd());
		url = "/teacher/name_list.jsp";
		return SUCCESS;
	}

}
