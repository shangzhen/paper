package henu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import henu.bean.Check;
import henu.factory.DaoFactory;
import henu.util.AJAX;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

///////////////////////           ���ڼ���                      /////////////////////////////////////////
public class TeacherCheckAction extends ActionSupport {

	private String fno;
	private Check check;
	private List<Check> list;

	private File image;// �ϴ��ļ�

	private String savePath;// �ϴ����ļ�·��

	private String contentType;// �ϴ��ļ�����

	private String imageFileName;// �ϴ��ļ� �� �ļ���

	private String imageContentType;// �ϴ��ļ� �� MIME����

	private String url;
	private AJAX ajax;

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

	public String getSavePath() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public Check getCheck() {
		return check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

	public List<Check> getList() {
		return list;
	}

	public void setList(List<Check> list) {
		this.list = list;
	}

	// //////////////////////////////////////////////////////////////////////////////
	/* ����ѧ�Ų��� */
	public String findByFno() {

		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String f = (String) session.getAttribute("user");

		check = DaoFactory.createCheckDao().find(f);

		// System.out.println(check);
		url = "/student/check_watch.jsp";
		return SUCCESS;
	}

	// //////////////////////////////////////////////////////////////////////////////////
	/* �������� */
	public String findAll() {

		list = DaoFactory.createCheckDao().findAll();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		session.setAttribute("list", list);

		return "findAll";
	}

	// //////////////////////////////////////////////////////////////////////////////////

	public String save() {
		/*
		 * setSavePath("");//���ļ��ϴ��洢·������Ϊ�� //���ϴ��ļ��洢·���ʹ���һ������� String
		 * photoName=getImageFileName(); //����photoName������һ��"."��ȡ�ֶ� String
		 * photoType
		 * =photoName.substring(photoName.lastIndexOf("."),photoName.length());
		 * 
		 * String number =
		 * (String)ServletActionContext.getRequest().getSession()
		 * .getAttribute("user"); try { FileOutputStream fos = new
		 * FileOutputStream(getSavePath()+"/upload/"+number+photoType);
		 * System.out.println(getSavePath()+"/upload/"+number+photoType);
		 * FileInputStream fis = new FileInputStream(getImage());//���ϴ��ļ�����һ��������
		 * byte [] buffer = new byte[1024]; int len = 0;
		 * while((len=fis.read(buffer))>0) {
		 * fos.write(buffer,0,len);//���ϴ��ļ�д�뵽�������Ӧ���ļ��� }
		 * 
		 * String filename ="/paper/upload/"+number+"_zhongqi"+photoType;
		 * check.setFadjunct(filename);
		 */
		int result = DaoFactory.createCheckDao().add(check);
		if (result > 0) {
			System.out.println("��ӳɹ���");
		}
		/*
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
		return "add";
	}

	public String findfno() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String f = (String) session.getAttribute("user");

		check = DaoFactory.createCheckDao().find(f);

		url = "/student/check_watch.jsp";

		return SUCCESS;
	}

	public String findname() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String f = (String) session.getAttribute("user");

		check = DaoFactory.createCheckDao().find(f);

		if (check != null) {

			session.setAttribute("zby", check.getFno());

		} else {

			session.setAttribute("zby", null);
		}

		url = "/student/fopen_report3.jsp";
		return SUCCESS;
	}

	public String findAlll() {

		check = DaoFactory.createCheckDao().find(fno);

		url = "/student/check_update.jsp";
		return SUCCESS;
	}

	public String findfnno() {

		check = DaoFactory.createCheckDao().find(fno);

		url = "/student/check_cha.jsp";

		return SUCCESS;

	}

	public String update() {
		int result = DaoFactory.createCheckDao().update(fno, check);

		ajax = new AJAX();
		if (result > 0) {
			ajax.setStatusCode("200");
			ajax.setMessage("�޸ĳɹ���");
			ajax.setCallbackType("");
			ajax.setNavTabId("w_5");
		} else {
			ajax.setStatusCode("300");
			ajax.setMessage("�޸�ʧ�ܣ�");
			ajax.setCallbackType("");
			ajax.setNavTabId("");
		}

		url = "/student/index.jsp";

		return SUCCESS;
	}

}
