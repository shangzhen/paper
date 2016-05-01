package henu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import henu.bean.Distribution;
import henu.bean.OpeningReport;
import henu.bean.ThesisList;
import henu.factory.DaoFactory;
import henu.util.AJAX;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

///////////////////////        开题报告                 ///////////////////////////////
public class TeacherOpenReportAction extends ActionSupport {
	// OpeningRepor
	private OpeningReport opening;

	private String fno;

	private List<OpeningReport> list;

	private String url;

	private ThesisList thesis;

	/*
	 * private File image;//上传文件
	 * 
	 * private String savePath;//上传的文件路径
	 * 
	 * private String contentType;//上传文件类型
	 * 
	 * 
	 * private String imageFileName;//上传文件 的 文件名
	 * 
	 * 
	 * private String imageContentType;//上传文件 的 MIME类型
	 */

	/* 文件上传 */
	private File img;
	private String imgFileName;
	private String imgContentType;

	private AJAX ajax;

	// 文件修改时上传
	private String upload;
	private String uploadFileName;
	private String uploadContentType;

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public String getUploadType() {
		return uploadFileName;
	}

	public void setUploadType(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
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

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public ThesisList getThesis() {
		return thesis;
	}

	public void setThesis(ThesisList thesis) {
		this.thesis = thesis;
	}

	public String getFNo() {
		return fno;
	}

	public void setFNo(String fNo) {
		this.fno = fNo;
	}

	public OpeningReport getOpening() {
		return opening;
	}

	public void setOpening(OpeningReport opening) {
		this.opening = opening;
	}

	public List<OpeningReport> getList() {
		return list;
	}

	public void setList(List<OpeningReport> list) {
		this.list = list;
	}

	// //////////////////////////////////////////////////////////////////

	public String findByFno() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		HttpSession session = request.getSession();

		opening = DaoFactory.createOpeningReportDAO().find(fno);

		String open = opening.getFtopicSource();

		session.setAttribute("list", open);

		System.out.println("list=" + open);

		ThesisList thesis = DaoFactory.createIThesisListDao().find(fno);

		String name = thesis.getFsName();

		session.setAttribute("fname", name);

		System.out.println("name=" + name);

		return "findByFno";
	}

	// ///////////////////////////////////////////////////////////////////////////

	public String findAll() {

		list = DaoFactory.createOpeningReportDAO().findAll();

		return "findAll";

	}

	// ///////////////////////////////////////////////////////////////////////////

	public String save() {
		/*
		 * setSavePath("");//将文件上传存储路径设置为空 //已上传文件存储路径和创建一个输出流 String
		 * photoName=getImageFileName(); //根据photoName里的最后一个"."截取字段 String
		 * photoType
		 * =photoName.substring(photoName.lastIndexOf("."),photoName.length());
		 * 
		 * String number =
		 * (String)ServletActionContext.getRequest().getSession()
		 * .getAttribute("user"); try { FileOutputStream fos = new
		 * FileOutputStream(getSavePath()+"/upload/"+number+photoType);
		 * System.out.println(getSavePath()+"/upload/"+number+photoType);
		 * FileInputStream fis = new FileInputStream(getImage());//已上传文件建立一个输入流
		 * byte [] buffer = new byte[1024]; int len = 0;
		 * while((len=fis.read(buffer))>0) {
		 * fos.write(buffer,0,len);//将上传文件写入到输出流对应的文件中 }
		 * 
		 * String filename ="/upload/"+number+"_kaiti"+photoType;
		 * opening.setFadjunct(filename); int result =
		 * DaoFactory.createOpeningReportDAO().add(opening);
		 * 
		 * if (result>0) { System.out.println("添加成功！"); } else {
		 * System.out.println("添加失败！");
		 * 
		 * } } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */

		/* 获取学号 */
		// fno =
		// (String)ServletActionContext.getRequest().getSession().getAttribute("user");
		/* 获取系统时间 */
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd_HH-mm-ss");
		String curDate = simpleDateFormat.format(date);

		/* 设置上传路径 */
		String uploadPath = "upload\\";

		if (img != null) {
			File saveDir = new File(uploadPath);
			// 判断saveDir目录是否存在
			if (!saveDir.exists()) {
				// 不存在时，创建该目录
				saveDir.mkdirs();
			}

			// 创建论文上传文件对象
			imgFileName = curDate
					+ imgFileName.substring(imgFileName.lastIndexOf("."),
							imgFileName.length());
			File saveFile = new File(saveDir, imgFileName);
			System.out.println("文件1 ：" + saveFile.getName());

			String file3Path = uploadPath + "_kaiti" + imgFileName;

			System.out.println("文件名称=" + file3Path);

			opening.setFadjunct(file3Path);
			int result = DaoFactory.createOpeningReportDAO().add(opening);

			if (result > 0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");

			}

		}

		url = "/student/index.jsp";

		return SUCCESS;
	}

	public String findname() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String f = (String) session.getAttribute("user");

		opening = DaoFactory.createOpeningReportDAO().find(f);
		if (opening != null) {

			session.setAttribute("zby", opening.getFno());

		} else {

			session.setAttribute("zby", null);
		}

		url = "/student/fopen_report1.jsp";

		return SUCCESS;
	}

	public String findfno() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String f = (String) session.getAttribute("user");

		opening = DaoFactory.createOpeningReportDAO().find(f);

		url = "/student/open_report.jsp";

		return SUCCESS;
	}

	public String update() {

		int result = DaoFactory.createOpeningReportDAO().update(fno, opening);

		ajax = new AJAX();
		if (result > 0) {
			ajax.setStatusCode("200");
			ajax.setMessage("修改成功！");
			ajax.setCallbackType("");
			ajax.setNavTabId("w_5");
		} else {
			ajax.setStatusCode("300");
			ajax.setMessage("修改失败！");
			ajax.setCallbackType("");
			ajax.setNavTabId("");
		}

		url = "/student/index.jsp";

		return SUCCESS;
	}

	public String findAlll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		System.out.println("前台得到的fno"+fno);
		
		opening = DaoFactory.createOpeningReportDAO().find(fno);
		System.out.println("------------"+opening.getFtopicSource());
		
		String source = opening.getFtopicSource();
		
		System.out.println("开题报告的课题来源="+source);
		
		/*将获取的开题报告来源储存在session为source中。*/
		session.setAttribute("source", source);
		
		url="/student/open_update.jsp";
		
		return SUCCESS;
	}

	public String upload1() {

		System.out.println("前台得到的fno" + fno);
		opening = DaoFactory.createOpeningReportDAO().find(fno);

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		session.setAttribute("up", opening.getFno());

		url = "/student/open_upload.jsp";

		return SUCCESS;
	}

	/*
	 * public String upload11() { System.out.println("前台得到的fno"+fno);
	 * HttpServletRequest request = ServletActionContext.getRequest();
	 * HttpSession session = request.getSession(); String fno =
	 * (String)session.getAttribute("up"); opening =
	 * DaoFactory.createOpeningReportDAO().find(fno);
	 * 
	 * 获取系统时间 Date date = new Date(); SimpleDateFormat simpleDateFormat = new
	 * SimpleDateFormat("yyyy-MM-dd_HH-mm-ss"); String curDate =
	 * simpleDateFormat.format(date);
	 * 
	 * 设置上传路径 String uploadPath = "upload\\";
	 * 
	 * if (upload!=null){ File saveDir = new File(uploadPath); //
	 * 判断saveDir目录是否存在 if (!saveDir.exists()) { // 不存在时，创建该目录 saveDir.mkdirs();
	 * }
	 * 
	 * // 创建论文上传文件对象 uploadFileName = curDate +
	 * uploadFileName.substring(uploadFileName.lastIndexOf("."),
	 * uploadFileName.length()); File saveFile = new File(saveDir,
	 * uploadFileName); System.out.println("文件1 ：" + saveFile.getName());
	 * 
	 * String filePath = uploadPath +"_kaiti"+ uploadFileName;
	 * 
	 * System.out.println("文件名称="+filePath);
	 * 
	 * opening.setFadjunct(filePath);
	 * 
	 * int result = DaoFactory.createOpeningReportDAO().update(fno, opening);
	 * 
	 * if (result>0) { System.out.println("添加成功！"); } else {
	 * System.out.println("添加失败！");
	 * 
	 * }
	 * 
	 * } url="/student/open_update.jsp"; return SUCCESS;
	 * 
	 * }
	 */

	public String findByid() {

		System.out.println("前台得到的fno" + fno);
		opening = DaoFactory.createOpeningReportDAO().find(fno);

		url = "/student/open_cha.jsp";
		return SUCCESS;
	}

}