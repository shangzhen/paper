package henu.bean;

import java.sql.Date;
/**
 * t_Announcement公告表对应的Bean
 * @author 梁胜彬
 * 2015年10月12日
 */
public class Announcement {
	
	private int fserialNo;
	private String ftitle;
	private String fpublisher;
	private String fpublishMessage;
	private String ftype;
	private String fcontent;
	private String fbrowseTime;
	private String fadjunct;
	public int getFserialNo() {
		return fserialNo;
	}
	public void setFserialNo(int fserialNo) {
		this.fserialNo = fserialNo;
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
	
	public String getFpublishMessage() {
		return fpublishMessage;
	}
	public void setFpublishMessage(String fpublishMessage) {
		this.fpublishMessage = fpublishMessage;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public String getFbrowseTime() {
		return fbrowseTime;
	}
	public void setFbrowseTime(String fbrowseTime) {
		this.fbrowseTime = fbrowseTime;
	}
	public String getFadjunct() {
		return fadjunct;
	}
	public void setFadjunct(String fadjunct) {
		this.fadjunct = fadjunct;
	}
	@Override
	public String toString() {
		return "Announcement [fserialNo=" + fserialNo + ", ftitle=" + ftitle + ", fpublisher=" + fpublisher
				+ ", fpublishMessage=" + fpublishMessage + ", ftype=" + ftype + ", fcontent=" + fcontent
				+ ", fbrowseTime=" + fbrowseTime + ", fadjunct=" + fadjunct + "]";
	}
	
	
	
	
	
	
}
