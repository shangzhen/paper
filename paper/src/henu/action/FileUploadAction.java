package henu.action;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import henu.service.ImportExcel;
import henu.service.OperateFiles;
import henu.util.AJAX;

public class FileUploadAction extends ActionSupport {
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
		int count = ImportExcel.readUser(filepath);
		System.out.println("成功了:"+count);
		int result = 0;
		if(count>0){
			result = 1;
		}
		AJAX ajax = new AJAX();
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("保存成功");
			ajax.setNavTabId("noticetList");
			ajax.setCallbackType("closeCurrent");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("保存失败");
			ajax.setCallbackType("");
		}
		AJAX.ajax(ajax, result, "导入表", "", "");
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("ajax", ajax);
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
