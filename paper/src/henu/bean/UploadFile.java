package henu.bean;

import java.sql.Date;
/**
 * t_File对应的bean
 * @author 梁胜彬
 * 2015年10月12日
 */
public class UploadFile {

	private int fid;
	private String ftitle;
	private String fpublisher;
	private String fupTime;
	private String ffilePath;
	private String  fremark;
	private String fname;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFtitle() {
		return ftitle;
	}


	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}


	public String getFpublisher() {
		return fpublisher;
	}


	public void setFpublisher(String fpublisher) {
		this.fpublisher = fpublisher;
	}


	public String getFupTime() {
		return fupTime;
	}


	public void setFupTime(String fupTime) {
		this.fupTime = fupTime;
	}


	public String getFfilePath() {
		return ffilePath;
	}


	public void setFfilePath(String ffilePath) {
		this.ffilePath = ffilePath;
	}


	public String getFremark() {
		return fremark;
	}


	public void setFremark(String fremark) {
		this.fremark = fremark;
	}

	@Override
	public String toString() {
		return "UploadFile [fid=" + fid + ", ftitle=" + ftitle + ", fpublisher=" + fpublisher + ", fupTime=" + fupTime
				+ ", ffilePath=" + ffilePath + ", fremark=" + fremark + ", fname=" + fname + "]";
	}
	
		
}

