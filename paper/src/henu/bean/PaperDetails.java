package henu.bean;

import java.sql.Date;
/**
 * t_PaperDetails������ϸ���Ӧ��Bean
 * @author ��ʤ��
 * 2015��10��12��
 */
public class PaperDetails {

	private String fno;
	private int fid;
	private int frevision;
	private String ftitle;
	private String fmodifyContent;
	private String fthesisAdjunct;
	private String fpptAdjunct;
	private String fsourceCodeAdjunct;
	private String fcheckAdjunct;
	private String fuploadTime;
	private String freviewComment;
	private String freviewTime;
	private String freviewAdjunct;
	private String freviewTeacher;
	private String fidentification;
	private String frepetitionRate;
	private String fmemo;
	private String fteacherId;
	

	public String getFteacherId() {
		return fteacherId;
	}
	public void setFteacherId(String fteacherId) {
		this.fteacherId = fteacherId;
	}
	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getFrevision() {
		return frevision;
	}
	public void setFrevision(int frevision) {
		this.frevision = frevision;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFmodifyContent() {
		return fmodifyContent;
	}
	public void setFmodifyContent(String fmodifyContent) {
		this.fmodifyContent = fmodifyContent;
	}
	public String getFthesisAdjunct() {
		return fthesisAdjunct;
	}
	public void setFthesisAdjunct(String fthesisAdjunct) {
		this.fthesisAdjunct = fthesisAdjunct;
	}
	public String getFpptAdjunct() {
		return fpptAdjunct;
	}
	public void setFpptAdjunct(String fpptAdjunct) {
		this.fpptAdjunct = fpptAdjunct;
	}
	public String getFsourceCodeAdjunct() {
		return fsourceCodeAdjunct;
	}
	public void setFsourceCodeAdjunct(String fsourceCodeAdjunct) {
		this.fsourceCodeAdjunct = fsourceCodeAdjunct;
	}
	public String getFcheckAdjunct() {
		return fcheckAdjunct;
	}
	public void setFcheckAdjunct(String fcheckAdjunct) {
		this.fcheckAdjunct = fcheckAdjunct;
	}
	public String getFuploadTime() {
		return fuploadTime;
	}
	public void setFuploadTime(String fuploadTime) {
		this.fuploadTime = fuploadTime;
	}
	public String getFreviewComment() {
		return freviewComment;
	}
	public void setFreviewComment(String freviewComment) {
		this.freviewComment = freviewComment;
	}
	public String getFreviewTime() {
		return freviewTime;
	}
	public void setFreviewTime(String freviewTime) {
		this.freviewTime = freviewTime;
	}
	public String getFreviewAdjunct() {
		return freviewAdjunct;
	}
	public void setFreviewAdjunct(String freviewAdjunct) {
		this.freviewAdjunct = freviewAdjunct;
	}
	public String getFreviewTeacher() {
		return freviewTeacher;
	}
	public void setFreviewTeacher(String freviewTeacher) {
		this.freviewTeacher = freviewTeacher;
	}
	public String getFidentification() {
		return fidentification;
	}
	public void setFidentification(String fidentification) {
		this.fidentification = fidentification;
	}
	public String getFrepetitionRate() {
		return frepetitionRate;
	}
	public void setFrepetitionRate(String frepetitionRate) {
		this.frepetitionRate = frepetitionRate;
	}
	public String getFmemo() {
		return fmemo;
	}
	public void setFmemo(String fmemo) {
		this.fmemo = fmemo;
	}
	@Override
	public String toString() {
		return "PaperDetails [fno=" + fno + ", fid=" + fid + ", frevision="
				+ frevision + ", ftitle=" + ftitle + ", fmodifyContent="
				+ fmodifyContent + ", fthesisAdjunct=" + fthesisAdjunct
				+ ", fpptAdjunct=" + fpptAdjunct + ", fsourceCodeAdjunct="
				+ fsourceCodeAdjunct + ", fcheckAdjunct=" + fcheckAdjunct
				+ ", fuploadTime=" + fuploadTime + ", freviewComment="
				+ freviewComment + ", freviewTime=" + freviewTime
				+ ", freviewAdjunct=" + freviewAdjunct + ", freviewTeacher="
				+ freviewTeacher + ", fidentification=" + fidentification
				+ ", frepetitionRate=" + frepetitionRate + ", fmemo=" + fmemo
				+ ", fteacherId=" + fteacherId + "]";
	}
}
