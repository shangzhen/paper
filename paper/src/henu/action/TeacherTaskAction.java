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

////////         ������                    /////////


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
	private File image;//�ϴ��ļ�
	
	private String savePath;//�ϴ����ļ�·��
	
	private String contentType;//�ϴ��ļ�����
	
	
	private String imageFileName;//�ϴ��ļ� �� �ļ���
		
	
	private String imageContentType;//�ϴ��ļ� �� MIME���� 
	
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
	/*����ѧ�Ų�������*/
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
	/*��������*/
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
		/*setSavePath("");//���ļ��ϴ��洢·������Ϊ��
		//���ϴ��ļ��洢·���ʹ���һ�������
		String photoName=getImageFileName();
		//����photoName������һ��"."��ȡ�ֶ�
		String photoType=photoName.substring(photoName.lastIndexOf("."),photoName.length());
		
		String number = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
		try {
			FileOutputStream fos = new FileOutputStream(getSavePath()+"/upload/"+number+photoType);
			System.out.println(getSavePath()+"/upload/"+number+photoType);
			FileInputStream fis = new FileInputStream(getImage());//���ϴ��ļ�����һ��������
			byte [] buffer = new byte[1024];
			int len = 0;
			while((len=fis.read(buffer))>0)
			{
				fos.write(buffer,0,len);//���ϴ��ļ�д�뵽�������Ӧ���ļ���
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

		
		/*//����session����
				ActionContext act = ActionContext.getContext();
				//��ȡ�ϴ����ļ�·�� application
				String realpath = ServletActionContext.getServletContext().getRealPath("/upload3");
				System.out.println("·�� ��" + realpath);
				if(image!=null)
				{
					
					System.out.println("image="+image);
					
					File saveDir = new File(realpath);
					//�ж�saveDirĿ¼�Ƿ����
					if(!saveDir.exists())
					{
						//������ʱ��������Ŀ¼ 
						saveDir.mkdirs();
					}	
					//�����ϴ��ļ�����
						File saveFile = new File(saveDir,imageFileName);
						String ss=saveFile.getName();
						System.out.println("�ļ� ��" + ss);
						try{
							//�ϴ��ļ�
							FileUtils.copyFile(image, saveFile);
							
						}catch(Exception e)
						{
							
						}
					
						act.put("statuss",ss);
					
				
				}
				act.put("status", "�ļ��ϴ��ɹ�");
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

		System.out.println("ǰ̨�õ���fno"+fno);
		
		task = DaoFactory.createTaskDao().find(fno);
		
		url="/student/task_update.jsp";
		return SUCCESS;
	}
	
	
	public String findfno() {
		
		System.out.println("ǰ̨�õ���fno"+fno);
		task = DaoFactory.createTaskDao().find(fno);
		
		url="/student/task_cha.jsp";
		return SUCCESS;
	}
	public String update() {
	      
		int result = DaoFactory.createTaskDao().update(fno, task);
		
		ajax = new AJAX();
			if(result>0){
				ajax.setStatusCode("200");
				ajax.setMessage("�޸ĳɹ���");
				ajax.setCallbackType("");
				ajax.setNavTabId("w_5");
			}else{
				ajax.setStatusCode("300");
				ajax.setMessage("�޸�ʧ�ܣ�");
				ajax.setCallbackType("");
				ajax.setNavTabId("");
			}
			
	    url="/student/index.jsp";
	    
		return SUCCESS;
	}
}
