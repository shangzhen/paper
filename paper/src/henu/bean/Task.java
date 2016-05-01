package henu.bean;

import java.sql.Date;
/**
 * t_task����������Ӧ��Bean
 * @author ��ʤ��
 * 2015��10��12��
 */
public class Task {

	
	private String fno;
	private String ftitle;
	private String fcollege;
	private String fname;
	private String fmajor;
	private String frequire;
	private String ftime;
	private String ftutorName;
	private String fadjunct;
	private String fmemo;
	private String freviewTime;
	private String fmentorOpinion;
	
	public String getFreviewTime() {
		return freviewTime;
	}
	public void setFreviewTime(String freviewTime) {
		this.freviewTime = freviewTime;
	}
	public String getFmentorOpinion() {
		return fmentorOpinion;
	}
	public void setFmentorOpinion(String fmentorOpinion) {
		this.fmentorOpinion = fmentorOpinion;
	}
	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFcollege() {
		return fcollege;
	}
	public void setFcollege(String fcollege) {
		this.fcollege = fcollege;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFmajor() {
		return fmajor;
	}
	public void setFmajor(String fmajor) {
		this.fmajor = fmajor;
	}
	public String getFrequire() {
		return frequire;
	}
	public void setFrequire(String frequire) {
		this.frequire = frequire;
	}
	public String getFtime() {
		return ftime;
	}
	public void setFtime(String ftime) {
		this.ftime = ftime;
	}
	public String getFtutorName() {
		return ftutorName;
	}
	public void setFtutorName(String ftutorName) {
		this.ftutorName = ftutorName;
	}
	public String getFadjunct() {
		return fadjunct;
	}
	public void setFadjunct(String fadjunct) {
		this.fadjunct = fadjunct;
	}
	public String getFmemo() {
		return fmemo;
	}
	public void setFmemo(String fmemo) {
		this.fmemo = fmemo;
	}
	@Override
	public String toString() {
		return "Task [fno=" + fno + ", ftitle=" + ftitle + ", fcollege="
				+ fcollege + ", fname=" + fname + ", fmajor=" + fmajor
				+ ", frequire=" + frequire + ", ftime=" + ftime
				+ ", ftutorName=" + ftutorName + ", fadjunct=" + fadjunct
				+ ", fmemo=" + fmemo + ", freviewTime=" + freviewTime
				+ ", fmentorOpinion=" + fmentorOpinion + ", getFreviewTime()="
				+ getFreviewTime() + ", getFmentorOpinion()="
				+ getFmentorOpinion() + ", getFno()=" + getFno()
				+ ", getFtitle()=" + getFtitle() + ", getFcollege()="
				+ getFcollege() + ", getFname()=" + getFname()
				+ ", getFmajor()=" + getFmajor() + ", getFrequire()="
				+ getFrequire() + ", getFtime()=" + getFtime()
				+ ", getFtutorName()=" + getFtutorName() + ", getFadjunct()="
				+ getFadjunct() + ", getFmemo()=" + getFmemo()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
