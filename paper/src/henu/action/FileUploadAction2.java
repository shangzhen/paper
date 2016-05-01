package henu.action;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import henu.service.ImportExcel2;
import henu.service.OperateFiles;
import henu.util.AJAX;
import henu.util.RaterGroup;

public class FileUploadAction2 extends ActionSupport {
	/**
	 * 上传文件内容
	 */
	private File files ; 
	/**
	 * 上传文件名
	 */
	private String filesFileName ;
	private String url = "/teacher/ajax.jsp";
	
	@Override
	public String execute() throws Exception {
		String filepath = OperateFiles.uploadFiles(files, filesFileName);
		/**
		 * 导入t_student
		 */
		int count = ImportExcel2.readUser5(filepath);
		int result = 0;
		System.out.println("count:"+count);
		if(count>0){
			result = 1;
		}
		System.out.println("result:"+result);
		AJAX ajax1 = new AJAX();
		if(result!=0){
			ajax1.setStatusCode("200");
			ajax1.setMessage("导入成功");
			ajax1.setNavTabId("noticetList");
			ajax1.setCallbackType("closeCurrent");
			
			/*RaterGroup rg = new RaterGroup();
			rg.mapping();*/

		}else{
			ajax1.setStatusCode("300");
			ajax1.setMessage("导入失败");
			ajax1.setCallbackType("");
		}
		
		AJAX.ajax(ajax1, result, "导入表", "", "");
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("ajax", ajax1);
		File f = new File(filepath);
		f.delete();
		return SUCCESS;
	}

	/*****************************************************************************
	 *                            getter,setter方法                                               				 *
	 *****************************************************************************/
	
	
	public File getFiles() {
		return files;
	}
	public void setFiles(File files) {
		this.files = files;
	}
	public String getFilesFileName() {
		return filesFileName;
	}
	public void setFilesFileName(String filesFileName) {
		this.filesFileName = filesFileName;
	} 
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
