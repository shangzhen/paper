package henu.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import henu.bean.UploadFile;
import henu.factory.DaoFactory;
import henu.util.AJAX;
import henu.util.Page;

public class FileManageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String url = "/teacher/ajax.jsp";
	private AJAX ajax;
	private File upload;
	// 上传文件 的 文件名
	private String uploadFileName;
	// 上传文件 的 MIME类型
	private String uploadContentType;

	// 分页查询
	Page page;
	private int pageNum = 1;
	private int numPerPage = 10;

	private String orderField = "fId";

	private String orderDirection = "desc";

	// 检索
	private String property = "-1";
	private String key = "-1";

	// 声明一个List<Model>类型的变量用于存放查询到的记录的存放
	private List<UploadFile> uploadfileList;

	// 表单封装的Bean
	private UploadFile file;

	// 常用文件的主键
	private int fid;

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

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
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

	public List<UploadFile> getUploadfileList() {
		return uploadfileList;
	}

	public void setUploadfileList(List<UploadFile> uploadfileList) {
		this.uploadfileList = uploadfileList;
	}

	public UploadFile getFile() {
		return file;
	}

	public void setFile(UploadFile file) {
		this.file = file;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 教师新增一个常用文件记录，但文件不在这个方法中上传
	 * 
	 * @return
	 */
	public String add() {
		// 获取教师工号
		String fTid = (String) ServletActionContext.getRequest().getSession().getAttribute("user");
		// 获取教师姓名
		String fName = DaoFactory.createTeacherDao().find(fTid).getFname();
		// 设置提交时间
		file.setFupTime(new Date().toLocaleString());
		file.setFpublisher(fTid);
		file.setFname(fName);

		int result = DaoFactory.createIUploadFileDao().add(file);

		ajax = new AJAX();
		if (result != 0) {
			ajax.setStatusCode("200");
			ajax.setMessage("保存成功");
			ajax.setNavTabId("page5");
			ajax.setCallbackType("closeCurrent");
		} else {
			ajax.setStatusCode("300");
			ajax.setMessage("保存失败");
			ajax.setCallbackType("");
		}
		url = "/teacher/ajax.jsp";
		// url="/teacher/index.jsp";
		return SUCCESS;
	}
	/**
	 * 此方法用于常用文件的上传
	 * @return
	 */
	public String uploadFile() {
		file = DaoFactory.createIUploadFileDao().find(fid);
		// 获取系统时间
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String curDate = simpleDateFormat.format(date);
		// 上传的文件路径 realpath
		String realpath = "commonfile\\";
		if (upload != null) {
			File saveDir = new File(realpath);
			// 判断saveDir目录是否存在
			if (!saveDir.exists()) {
				// 不存在时，创建该目录
				saveDir.mkdirs();
			}
			uploadFileName = curDate
					+ uploadFileName.substring(uploadFileName.lastIndexOf("."), uploadFileName.length());
			// 创建上传文件对象
			File saveFile = new File(saveDir, uploadFileName);
			try {
				// 上传文件
				FileUtils.copyFile(upload, saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String ffilePath = realpath + uploadFileName;
		System.out.println("文件上传路径：" + ffilePath);
		file.setFfilePath(ffilePath);
		int result = DaoFactory.createIUploadFileDao().update(file.getFid(), file);
		if (result > 0) {
			System.out.println("上传成功！");
		} else {
			System.out.println("上传失败！！");
		}
		url = "/teacher/index.jsp";
		return SUCCESS;
	}

	/**
	 * 教师端在常用文件页面删除一条记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		ajax = new AJAX();
		UploadFile file = DaoFactory.createIUploadFileDao().find(fid);
		File fl = new File(file.getFfilePath());
		if (fl.exists()) {
			fl.delete();			
		}
		int result = DaoFactory.createIUploadFileDao().delete(fid);

		if (result != 0) {
			ajax.setStatusCode("200");
			ajax.setMessage("删除成功");
			ajax.setNavTabId("page5");
			ajax.setCallbackType("");
		} else {
			ajax.setStatusCode("300");
			ajax.setMessage("删除失败");
			ajax.setCallbackType("");
		}
		url = "/teacher/file_manage.jsp";
		return "delete";
	}

	/**
	 * 在教师端显示所有常用文件信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findAll() throws Exception {
		page = new Page();
		if (orderField.equals("") || orderDirection.equals("")) {
			orderField = "fId";
			orderDirection = "desc";
		}
		if (property.equals("") || key.equals("")) {
			property = "-1";
			key = "-1";
		}
		page.setProperties("t_file", pageNum, numPerPage, property, key);
		uploadfileList = DaoFactory.createIUploadFileDao().findByProperty(property, key, orderField, orderDirection,
				page.getStart(), page.getNumPerPage());
		url = "/teacher/file_manage.jsp";
		return SUCCESS;
	}

	/**
	 * 教师端在常用文件页面按查询类型和关键字进行精确查找
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findProperty() throws Exception {
		page = new Page();
		if (orderField.equals("") || orderDirection.equals("")) {
			orderField = "fId";
			orderDirection = "desc";
		}
		if (property.equals("") || key.equals("")) {
			property = "-1";
			key = "-1";
		}
		page.setProperties("t_file", pageNum, numPerPage, property, key);
		uploadfileList = DaoFactory.createIUploadFileDao().findByProperty(property, key, orderField, orderDirection,
				page.getStart(), page.getEnd());

		url = "/teacher/file_manage.jsp";
		return SUCCESS;
	}

	/**
	 * 点击上传文件时跳转到上传页面，并将file对象传送到该页面
	 * @return
	 */
	public String getFile1() {
		url = "/teacher/upload.jsp";
		return SUCCESS;
	}
}
