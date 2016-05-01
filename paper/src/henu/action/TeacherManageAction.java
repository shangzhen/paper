package henu.action;

import henu.bean.Distribution;
import henu.bean.ThesisList;
import henu.factory.DaoFactory;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jspsmart.upload.Request;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherManageAction extends ActionSupport {
    private String ftid;
	private List<Distribution> list;
	private Distribution  distribution;
	
	public String getFtid() {
		return ftid;
	}


	public void setFtid(String ftid) {
		this.ftid = ftid;
	}


	public List<Distribution> getList() {
		return list;
	}


	public void setList(List<Distribution> list) {
		this.list = list;
	}

	public Distribution getDistribution() {
		return distribution;
	}

	public void setDistribution(Distribution distribution) {
		this.distribution = distribution;
	}

	public String findByTeacher(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		ftid = (String)session.getAttribute("user");

		
		
		list=DaoFactory.createDistribution().findByTeahcer(ftid);
		
		
		return "findByTeacher";
		
	}
	


	}
	
