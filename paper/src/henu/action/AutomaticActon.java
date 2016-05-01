package henu.action;

import henu.bean.Student;
import henu.bean.Teacher;
import henu.bean.ThesisList;
import henu.factory.DaoFactory;
import henu.util.AJAX;
import henu.util.Md5Token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author 王飞翔
 *
 */
public class AutomaticActon extends ActionSupport {
	/**
	 * 年级
	 */
	private String fgreade;
	/**
	 * 要分配的学生名单
	 */
	private List<Student> listStudent;
	/**
	 * 指导教师名单
	 */
	private List<Teacher> listTeacher;
	/**
	 * 分配名单
	 */
	private List<ThesisList> thesisList;
	private String url = "/teacher/ajax.jsp";
	AJAX ajax;

	private int number = 0;

	public String getFgreade() {
		return fgreade;
	}

	public void setFgreade(String fgreade) {
		this.fgreade = fgreade;
	}

	public List<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}

	public List<Teacher> getListTeacher() {
		return listTeacher;
	}

	public void setListTeacher(List<Teacher> listTeacher) {
		this.listTeacher = listTeacher;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public AJAX getAjax() {
		return ajax;
	}

	public void setAjax(AJAX ajax) {
		this.ajax = ajax;
	}
	
	
	
	public String predistribution() {
		ajax = new AJAX();
		thesisList = new ArrayList<ThesisList>();
		String[] listftid = ServletActionContext.getRequest()
				.getParameterValues("teacher");
		if (listftid != null && number != 0) {
			listTeacher = new ArrayList<Teacher>();
			for (String tid : listftid) {
				Teacher t = DaoFactory.createTeacherDao().find(tid);
				listTeacher.add(t);
			}
			listStudent = DaoFactory.createIStudentDao().findByProperty2(
					"fGreade", fgreade);
			int startnumber = 0;
			int endnumber = listTeacher.size() - 1;
			for (Student stu : listStudent) {
				if (startnumber > endnumber) {
					startnumber = 0;
				}
				Teacher t = listTeacher.get(startnumber);
				ThesisList thesislist = new ThesisList();
				thesislist.setFno(stu.getFno());
				thesislist.setFsName(stu.getFsname());
				thesislist.setFprofessional(stu.getFclass());
				thesislist.setFtid(t.getFtid());
				thesislist.setFtName(t.getFname());
				thesislist.setFstate("应届");	
				thesislist.setFgrade(stu.getFgreade());
				thesislist.setFpsw(Md5Token.getInstance().getLongLongToken(
						stu.getFno()));
				thesislist.setFdepartment(stu.getFmarjor());
				thesisList.add(thesislist);
				startnumber++;
			}
			ServletActionContext.getRequest().getSession().setAttribute("thesisList",thesisList);
			ajax.setStatusCode("200");
			ajax.setMessage("");
			ajax.setCallbackType("forward");
			ajax.setForwardUrl("/paper/teacher/automatic_papertwo.jsp");
			ajax.setNavTabId("");
		}
		else{
			ajax.setStatusCode("300");
   			ajax.setMessage("预分配失败");
   			ajax.setCallbackType("");
		}
		url = "/teacher/ajax.jsp";
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String distribution() {
		ajax = new AJAX();
		int result=0;
		boolean state = false;
		thesisList = (List<ThesisList>) ServletActionContext.getRequest().getSession().getAttribute("thesisList");
		if(thesisList!=null){
			state = true;
			for(ThesisList t:thesisList)
			{
				result = DaoFactory.createIThesisListDao().add(t) + result;
			}
		}
		if(state&&result!=0)
		{
			ServletActionContext.getRequest().getSession().removeAttribute("thesisList");
			ajax.setStatusCode("200");
   			ajax.setMessage("分配成功");
   			ajax.setNavTabId("page16");
   			ajax.setCallbackType("closeCurrent");
			
		}
		else{
			ajax.setStatusCode("300");
			ajax.setMessage("分配失败");
			ajax.setCallbackType("");
		}
		url = "/teacher/ajax.jsp";
		return SUCCESS;
	}

	/**
	 * 获取所有教师
	 * 
	 * @return
	 */
	public String findTeacher() {
		listTeacher = DaoFactory.createTeacherDao().findAll();
		url = "/teacher/automatic_paper.jsp";
		return SUCCESS;
	}

	/**
	 * 获取分配的学生人数
	 * 
	 * @return
	 */
	public String findStuNumber() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String greade = request.getParameter("stufgreade");
		String stuNumber = String.valueOf(DaoFactory.createIStudentDao()
				.findByProperty2("fGreade", greade).size());
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getOutputStream().write(stuNumber.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<ThesisList> getThesisList() {
		return thesisList;
	}

	public void setThesisList(List<ThesisList> thesisList) {
		this.thesisList = thesisList;
	}

}
