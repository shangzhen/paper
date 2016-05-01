package henu.bean;

import java.sql.Date;
/**
 * t_Check�������ڼ���Ӧ��Bean
 * @author ��ʤ��
 * 2015��10��12��
 */
public class Check {

	/**
	 * ѧ��
	 */
	private String fno;
	private String ftitle;
	private String fcollege;
	private String fname;
	private String fmajor;
	private String ffare;
	private String fproblem;
	private String fselfEvaluation;
	private String ftutorEvaluation;
	private String ftutorTime;
	private String fcheck;
	private String fadjunct;
	private String fmemo;
	private String ftime;
	
	public String getFtime() {
		return ftime;
	}
	public void setFtime(String ftime) {
		this.ftime = ftime;
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
	public String getFfare() {
		return ffare;
	}
	public void setFfare(String ffare) {
		this.ffare = ffare;
	}
	public String getFproblem() {
		return fproblem;
	}
	public void setFproblem(String fproblem) {
		this.fproblem = fproblem;
	}
	public String getFselfEvaluation() {
		return fselfEvaluation;
	}
	public void setFselfEvaluation(String fselfEvaluation) {
		this.fselfEvaluation = fselfEvaluation;
	}
	public String getFtutorEvaluation() {
		return ftutorEvaluation;
	}
	public void setFtutorEvaluation(String ftutorEvaluation) {
		this.ftutorEvaluation = ftutorEvaluation;
	}
	public String getFtutorTime() {
		return ftutorTime;
	}
	public void setFtutorTime(String ftutorTime) {
		this.ftutorTime = ftutorTime;
	}
	public String getFcheck() {
		return fcheck;
	}
	public void setFcheck(String fcheck) {
		this.fcheck = fcheck;
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
		return "Check [fno=" + fno + ", ftitle=" + ftitle + ", fcollege="
				+ fcollege + ", fname=" + fname + ", fmajor=" + fmajor
				+ ", ffare=" + ffare + ", fproblem=" + fproblem
				+ ", fselfEvaluation=" + fselfEvaluation
				+ ", ftutorEvaluation=" + ftutorEvaluation + ", ftutorTime="
				+ ftutorTime + ", fcheck=" + fcheck + ", fadjunct=" + fadjunct
				+ ", fmemo=" + fmemo + ", ftime=" + ftime + "]";
	}
}
