package henu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import henu.bean.Announcement;
import henu.factory.DaoFactory;

public class LoginPageNewsAction extends ActionSupport {
	private Announcement announcement;
	
	//默认转到错误页面
	private String url = "error.jsp";
	
	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public String getNews(){
		List<Announcement> list;
		StringBuffer buffer = new StringBuffer();
		String title;
		String date;
		int id;
		PrintWriter out ;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8"); 
//System.out.println("执行了");
		try {
			out = response.getWriter();
			list = DaoFactory.createAnnouncementDao().findByProperty("ftype", "所有可见", "fpublishMessage", "DESC", 0, 7);
			buffer.append("<ul class='news3'>");
			for (Announcement announcement : list) {
				title = announcement.getFtitle();
				date = announcement.getFpublishMessage();
				id = announcement.getFserialNo();
				buffer.append("<li id='x1'><a href='");
				//添加URL
				buffer.append("/paper/loginPage/singleNew_getSingleNew?fSerialNo=" + id);
				buffer.append("' id='n1'> ");
				buffer.append(">> " + title);
				buffer.append("<span>");
				buffer.append(date);
				buffer.append("</span></a></li>");
			}
			buffer.append("</ul>");
			
//System.out.println(buffer.toString());
			out.println(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	public String getSingleNew(){
		String id = ServletActionContext.getRequest().getParameter("fSerialNo");
		announcement = DaoFactory.createAnnouncementDao().find(Integer.valueOf(id));
		ServletActionContext.getRequest().getSession().setAttribute("login_announcement", announcement);
		announcement.setFbrowseTime(String.valueOf((Integer.valueOf(announcement.getFbrowseTime())+1)));
		DaoFactory.createAnnouncementDao().update(Integer.valueOf(id), announcement);
		url = "/newsPage.jsp";
		return SUCCESS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
