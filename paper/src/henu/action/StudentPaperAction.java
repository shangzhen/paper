package henu.action;

import henu.bean.PaperDetails;
import henu.factory.DaoFactory;
import henu.util.AJAX;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class StudentPaperAction extends ActionSupport {

	private PaperDetails paperDetails;
	private PaperDetails paperdetail;
	private List<PaperDetails> list;
	private String fno;
	private String url;
	private String fteacherid;
	private AJAX ajax;
	private int id;
	private int fid;
	
	private File upload;
    private String uploadFileName;
    private String uploadContentType;

    private File file;
    private String fileFileName;
    private String fileContentType;
    
    private File web;
    private String webFileName;
    private String webContentType;
    
    private File img;
    private String imgFileName;
    private String imgContentType;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public PaperDetails getPaperdetail() {
		return paperdetail;
	}
	public void setPaperdetail(PaperDetails paperdetail) {
		this.paperdetail = paperdetail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public File getWeb() {
		return web;
	}
	public void setWeb(File web) {
		this.web = web;
	}
	public String getWebFileName() {
		return webFileName;
	}
	public void setWebFileName(String webFileName) {
		this.webFileName = webFileName;
	}
	public String getWebContentType() {
		return webContentType;
	}
	public void setWebContentType(String webContentType) {
		this.webContentType = webContentType;
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
	public PaperDetails getPaperDetails() {
		return paperDetails;
	}
	public void setPaperDetails(PaperDetails paperDetails) {
		this.paperDetails = paperDetails;
	}
	public List<PaperDetails> getList() {
		return list;
	}
	public void setList(List<PaperDetails> list) {
		this.list = list;
	}
	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFteacherid() {
		return fteacherid;
	}
	public void setFteacherid(String fteacherid) {
		this.fteacherid = fteacherid;
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
	public String save() {
		
		/*获取学生学号*/
		fno = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
        System.out.println("学生学号："+fno);
       /* 查找该学生提交了几次记录 	*/	
        list =  DaoFactory.createIPaperDetailsDao().findByfffo(fno);
        /*定义result，得到学生条数*/
        int result1 = list.size();
	    System.out.println("学生提交的记录条数："+result1);
	    /*该记录就是版次数，存到数据库*/
	    if(result1==0){
	    	paperDetails.setFrevision(0+1);
	    }
	    else {
	    	
	    	 paperDetails.setFrevision(result1+1);	
	    }
		int result = DaoFactory.createIPaperDetailsDao().add(paperDetails);
		
	    ajax = new AJAX();
		if(result>0){
			ajax.setStatusCode("200");
			ajax.setMessage("添加成功！");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("studentMessage");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("添加失败！");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("teacherInf");
		}
		return "add";
	}
	/*查找所有*/
	public String findAll() {
		list= DaoFactory.createIPaperDetailsDao().findAll();
		System.out.println("查找所有的list="+list);
		
		return "findAll";
	}

	//根据学生id查找
	public String findByFno() {
		/*获取学生学号*/
		fno = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
        System.out.println("学生学号："+fno);
	    /*根据学号查找所有*/
        list = DaoFactory.createIPaperDetailsDao().findByfffo(fno);
		/*将查找的信息存到session中*/
		ServletActionContext.getRequest().getSession().setAttribute("paperDatails", list);
		
		if (list != null) {
			System.out.println("论文详细表：SUCCESS！");
		} else {
			System.out.println("论文详细表失败！");
		}
		
		return "findByFno";
	}
	/*删除*/
	public String delete() {

		int result = DaoFactory.createIPaperDetailsDao().deletee(id);
		
		ajax = new AJAX();
		if(result>0){
			ajax.setStatusCode("200");
			ajax.setMessage("删除成功");
			ajax.setCallbackType("");
			ajax.setNavTabId("w_alert");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("删除失败！");
			ajax.setCallbackType("");
		}
		
		return "delete";
	}
	/*根据指导老师工号查找*/
	public String findBuTeacherId() {

		paperDetails = DaoFactory.createIPaperDetailsDao().findByTeacher(fteacherid);
		
		return "findByTeacher";
	}
	/*获取id，中转站*/
    public String upload11() {

    	System.out.println("获取的id="+id);
    	ServletActionContext.getRequest().getSession().setAttribute("idd", id);
    	
    	
    	return "upload11";
	}
    public String upload12() {

    	System.out.println("获取的id="+id);
    	ServletActionContext.getRequest().getSession().setAttribute("idd", id);
    	
    	
    	return "upload12";
	}
    public String upload13() {

    	System.out.println("获取的id="+id);
    	ServletActionContext.getRequest().getSession().setAttribute("idd", id);
    	
    	
    	return "upload13";
	}
    public String upload14() {

    	System.out.println("获取的id="+id);
    	ServletActionContext.getRequest().getSession().setAttribute("idd", id);
    	
    	
    	return "upload14";
	}
	public String upload1()  {
		
		   /*获取主键id的值*/
		   int id =(int) ServletActionContext.getRequest().getSession().getAttribute("idd");
		    System.out.println("通过session得到的id="+id);
		
		    /*获取学生学号*/
		    fno = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
			/*获取系统时间*/
		    Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			String curDate = simpleDateFormat.format(date);
			
			/*设置上传路径*/
			String uploadPath = "upload\\";

		        if (upload!=null){
				File saveDir = new File(uploadPath);
				// 判断saveDir目录是否存在
				if (!saveDir.exists()) {
					// 不存在时，创建该目录
					saveDir.mkdirs();
				}
			
		        // 创建论文上传文件对象
				uploadFileName = curDate
						+ uploadFileName.substring(uploadFileName.lastIndexOf("."), uploadFileName.length());
				File saveFile = new File(saveDir, uploadFileName);
				System.out.println("文件1 ：" + saveFile.getName());	
				
				String filePath = uploadPath +"_lunwen"+ uploadFileName;
				
				System.out.println("文件名称="+filePath);
				
				paperDetails = DaoFactory.createIPaperDetailsDao().find(id);
				paperDetails.setFthesisAdjunct(filePath);
		 
			int result = DaoFactory.createIPaperDetailsDao().updatee(id, paperDetails);
			
			if (result>0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");

			}
 
	    }
	return "upload1";
   }
	/*file   PPT上传*/
	public String upload2()  {
		
		   /*获取主键id的值*/
		   int id =(int) ServletActionContext.getRequest().getSession().getAttribute("idd");
		    System.out.println("通过session得到的id="+id);
		
		    /*获取学生学号*/
		    fno = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
			/*获取系统时间*/
		    Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			String curDate = simpleDateFormat.format(date);
			
			/*设置上传路径*/
			String uploadPath = "upload\\";

		        if (file!=null){
				File saveDir = new File(uploadPath);
				// 判断saveDir目录是否存在
				if (!saveDir.exists()) {
					// 不存在时，创建该目录
					saveDir.mkdirs();
				}
			
		        // 创建论文上传文件对象
				fileFileName = curDate
						+ fileFileName.substring(fileFileName.lastIndexOf("."), fileFileName.length());
				File saveFile = new File(saveDir, fileFileName);
				System.out.println("文件1 ：" + saveFile.getName());	
				
				String file1Path = uploadPath +"_PPT"+ fileFileName;
				
				System.out.println("文件名称="+file1Path);
				
				paperDetails = DaoFactory.createIPaperDetailsDao().find(id);
				paperDetails.setFpptAdjunct(file1Path);
		 
			int result = DaoFactory.createIPaperDetailsDao().updatee(id, paperDetails);
			
			if (result>0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");

			}

	    }
	return "upload2";
}
	
	/*web   源程序*/
	public String upload3()  {
		
		 /*获取主键id的值*/
		   int id =(int) ServletActionContext.getRequest().getSession().getAttribute("idd");
		    System.out.println("通过session得到的id="+id);
		
		    /*获取学生学号*/
		    fno = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
			/*获取系统时间*/
		    Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			String curDate = simpleDateFormat.format(date);
			
			/*设置上传路径*/
			String uploadPath = "upload\\";

		        if (web!=null){
				File saveDir = new File(uploadPath);
				// 判断saveDir目录是否存在
				if (!saveDir.exists()) {
					// 不存在时，创建该目录
					saveDir.mkdirs();
				}
			
		        // 创建论文上传文件对象
				webFileName = curDate
						+ webFileName.substring(webFileName.lastIndexOf("."), webFileName.length());
				File saveFile = new File(saveDir, webFileName);
				System.out.println("文件1 ：" + saveFile.getName());	
				
				String file2Path = uploadPath +"_PPT"+ webFileName;
				
				System.out.println("文件名称="+file2Path);
				
				paperDetails = DaoFactory.createIPaperDetailsDao().find(id);
				paperDetails.setFsourceCodeAdjunct(file2Path);
		 
			int result = DaoFactory.createIPaperDetailsDao().updatee(id, paperDetails);
			
			if (result>0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");

			}

	    }
	return "upload3";
}
	
	
	/*img   查重附件*/
	public String upload4()  {
		
		   /*获取主键id的值*/
		   int id =(int) ServletActionContext.getRequest().getSession().getAttribute("idd");
		    System.out.println("通过session得到的id="+id);
		
		    /*获取学生学号*/
		    fno = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
			/*获取系统时间*/
		    Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			String curDate = simpleDateFormat.format(date);
			
			/*设置上传路径*/
			String uploadPath = "upload\\";

		        if (img!=null){
				File saveDir = new File(uploadPath);
				// 判断saveDir目录是否存在
				if (!saveDir.exists()) {
					// 不存在时，创建该目录
					saveDir.mkdirs();
				}
			
		        // 创建论文上传文件对象
				imgFileName = curDate
						+imgFileName.substring(imgFileName.lastIndexOf("."), imgFileName.length());
				File saveFile = new File(saveDir, imgFileName);
				System.out.println("文件1 ：" + saveFile.getName());	
				
				String file3Path = uploadPath +"_chachong"+ imgFileName;
				
				System.out.println("文件名称="+file3Path);
				
				paperDetails = DaoFactory.createIPaperDetailsDao().find(id);
				paperDetails.setFcheckAdjunct(file3Path);
		 
			int result = DaoFactory.createIPaperDetailsDao().updatee(id, paperDetails);
			
			if (result>0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");

			}

	    }
	return "upload4";
}
	
	public String findByid() {

		paperDetails = DaoFactory.createIPaperDetailsDao().find(id);
		
		if (paperDetails!=null) {
			System.out.println("根据id查找出来的结果是："+paperDetails);
		} else {

			System.out.println("查找失败！");
		}
		
		return "findByid";
	}
	
	public String findfno() {

		/*获取学生学号*/
	    fno = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
	    System.out.println(fno);
	    ServletActionContext.getRequest().getSession().setAttribute("fff", fno);
	    
	    
		return "findfno";
	}
	
public String findByfNo(){
		
		list =  DaoFactory.createIPaperDetailsDao().findByFnoDesc(fno);
		
		return "findByfNoDesc";
	}
	
	public String paperdelete(){
		
		int result = 0;
		result = DaoFactory.createPaperDetailsDao().deleteByfId(fid);
		
		ajax=new AJAX();
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("删除成功");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("jbsxBox3");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("删除失败");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("jbsxBox3");
		}
		url="/teacher/ajax.jsp";
		return "paperdelete";
	}
	public String papersearch(){
		paperDetails = DaoFactory.createPaperDetailsDao().findByfId(fid);
		
		ServletActionContext.getRequest().getSession().setAttribute("paperDetails",paperDetails );
		return "papersearch";
	}
	public String paperupload(){
		System.out.println("fid:"+fid);
		System.out.println("upload2:"+upload);
		System.out.println("uploadFileName2:"+uploadFileName);
		/*获取系统时间*/
	    Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String curDate = simpleDateFormat.format(date);
		/*设置上传路径*/
		String uploadPath2 = "upload\\";
		
		/*if ((upload || file || text || web) != null) {*/
		if (upload!=null){
			File saveDir = new File(uploadPath2);
			// 判断saveDir目录是否存在
			if (!saveDir.exists()) {
				// 不存在时，创建该目录
				saveDir.mkdirs();
			}
			 // 创建论文上传文件对象
			uploadFileName = curDate
					+ uploadFileName.substring(uploadFileName.lastIndexOf("."), uploadFileName.length());
			File saveFile = new File(saveDir, uploadFileName);
			//System.out.println("文件1 ：" + saveFile.getName());	
			
			String filePath = uploadPath2 +"_doc"+ uploadFileName;
			paperdetail.setFreviewAdjunct(filePath);
			
			int result = DaoFactory.createIPaperDetailsDao().update1(fid, paperdetail);
			ajax=new AJAX();
			if(result!=0){
				ajax.setStatusCode("200");
				ajax.setMessage("上传成功");
				ajax.setCallbackType("closeCurrent");
				ajax.setNavTabId("");
			}else{
				ajax.setStatusCode("300");
				ajax.setMessage("上传失败");
				ajax.setCallbackType("closeCurrent");
				ajax.setNavTabId("");
			}
			}else{
				ajax=new AJAX();
				ajax.setStatusCode("300");
				ajax.setMessage("上传失败");
				ajax.setCallbackType("closeCurrent");
				ajax.setNavTabId("");
			}
		return "paperupload";
	}
	public String paperadd(){
		/*System.out.println(fid);
		System.out.println("prper:sdfsdf"+paperdetail);
		System.out.println("paper:"+paperdetail.getFreviewComment());
		System.out.println("papertime:"+paperdetail.getFreviewTime());*/
		int result = DaoFactory.createIPaperDetailsDao().update2(fid, paperdetail);
		ajax=new AJAX();
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("添加成功");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("paperadd");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("添加失败");
			ajax.setCallbackType("closeCurrent");
			ajax.setNavTabId("paperadd");
		}
		return "paperadd";
	}
	
}

	

