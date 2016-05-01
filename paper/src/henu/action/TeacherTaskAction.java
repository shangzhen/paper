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

import henu.bean.Task;
import henu.factory.DaoFactory;
import henu.util.AJAX;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

////////         任务书                    /////////


public class TeacherTaskAction extends ActionSupport {

	private Task task;
	private String fno;
	private List<Task> list;
	private AJAX ajax;
    public AJAX getAjax() {
		return ajax;
	}

	public void setAjax(AJAX ajax) {
		this.ajax = ajax;
	}
	private File image;//上传文件
	
	private String savePath;//上传的文件路径
	
	private String contentType;//上传文件类型
	
	
	private String imageFileName;//上传文件 的 文件名
		
	
	private String imageContentType;//上传文件 的 MIME类型 
	
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSavePath() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return  request.getRealPath(savePath);
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
	
	
	
	
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public List<Task> getList() {
		return list;
	}
	public void setList(List<Task> list) {
		this.list = list;
	}
	//////////////////////////////////////////////////////////////////////////////
	/*根据学号查找所有*/
	public String findByfid() {

	    HttpServletResponse response=ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session= request.getSession();
		
        String f=(String)session.getAttribute("user");		
		
		task=DaoFactory.createTaskDao().find(f);
		
		url="/student/task_books.jsp";
		return SUCCESS;
	}
	
	///////////////////////////////////////////////////////////////////////////////
	/*查找所有*/
	public String findAll() {
	    list= DaoFactory.createTaskDao().findAll();
	   
	    HttpServletResponse response=ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session= request.getSession();
		
		session.setAttribute("list", list);
		
		url="/student/task_books.jsp";
        return SUCCESS;
	}
	
	////////////////////////////////////////////////////////////////////////////////
	
	public String save(){
		/*setSavePath("");//将文件上传存储路径设置为空
		//已上传文件存储路径和创建一个输出流
		String photoName=getImageFileName();
		//根据photoName里的最后一个"."截取字段
		String photoType=photoName.substring(photoName.lastIndexOf("."),photoName.length());
		
		String number = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
		try {
			FileOutputStream fos = new FileOutputStream(getSavePath()+"/upload/"+number+photoType);
			System.out.println(getSavePath()+"/upload/"+number+photoType);
			FileInputStream fis = new FileInputStream(getImage());//已上传文件建立一个输入流
			byte [] buffer = new byte[1024];
			int len = 0;
			while((len=fis.read(buffer))>0)
			{
				fos.write(buffer,0,len);//将上传文件写入到输出流对应的文件中
			}
			
			String filename ="/paper/upload/"+number+"_renwu"+photoType;
			task.setFadjunct(filename);
			
			int result = DaoFactory.createTaskDao().add(task);
			if(result>0){
				System.out.println("SUCCESS!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		
		/*//创建session对象
				ActionContext act = ActionContext.getContext();
				//获取上传的文件路径 application
				String realpath = ServletActionContext.getServletContext().getRealPath("/upload3");
				System.out.println("路径 ：" + realpath);
				if(image!=null)
				{
					
					System.out.println("image="+image);
					
					File saveDir = new File(realpath);
					//判断saveDir目录是否存在
					if(!saveDir.exists())
					{
						//不存在时，创建该目录 
						saveDir.mkdirs();
					}	
					//创建上传文件对象
						File saveFile = new File(saveDir,imageFileName);
						String ss=saveFile.getName();
						System.out.println("文件 ：" + ss);
						try{
							//上传文件
							FileUtils.copyFile(image, saveFile);
							
						}catch(Exception e)
						{
							
						}
					
						act.put("statuss",ss);
					
				
				}
				act.put("status", "文件上传成功");
				act.put("statu", realpath);
				
			int result = DaoFactory.createTaskDao().add(task);
			if(result>0){
				System.out.println("SUCCESS!");
			}*/
		int result = DaoFactory.createTaskDao().add(task);
		if(result>0){
			System.out.println("SUCCESS!");
		}else{
			System.out.println("error!");
		}
		
		url="/student/task_books.jsp";	
	
		return "add";
	 
	}
	
	public String findname() {
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session= request.getSession();
		
		String fno=(String)session.getAttribute("user");
		
		task = DaoFactory.createTaskDao().find(fno);
		
	   if (task!=null) {
		 session.setAttribute("zby", task.getFno());
		}
		else {
			session.setAttribute("zby", null);
		}
		url="/student/fopen_report2.jsp";
		return SUCCESS;
	}
	public String findAlll() {

		System.out.println("前台得到的fno"+fno);
		
		task = DaoFactory.createTaskDao().find(fno);
		
		url="/student/task_update.jsp";
		return SUCCESS;
	}
	
	
	public String findfno() {
		
		System.out.println("前台得到的fno"+fno);
		task = DaoFactory.createTaskDao().find(fno);
		
		url="/student/task_cha.jsp";
		return SUCCESS;
	}
	public String update() {
	      
		int result = DaoFactory.createTaskDao().update(fno, task);
		
		ajax = new AJAX();
			if(result>0){
				ajax.setStatusCode("200");
				ajax.setMessage("修改成功！");
				ajax.setCallbackType("");
				ajax.setNavTabId("w_5");
			}else{
				ajax.setStatusCode("300");
				ajax.setMessage("修改失败！");
				ajax.setCallbackType("");
				ajax.setNavTabId("");
			}
			
	    url="/student/index.jsp";
	    
		return SUCCESS;
	}
}
