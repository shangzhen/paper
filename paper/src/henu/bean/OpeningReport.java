package henu.bean;

import java.sql.Date;
/**
 * t_report���ⱨ���Ӧ��Bean
 * @author ��ʤ��
 * 2015��10��12��
 */
public class OpeningReport {

	private String fno;
	private String fopeningTime;
	private String ftopicTitle;
	private String ftopicSource;
	private String fsubjectPurpose;
	private String fresearchObject;
	private String fuseWay;
	private String fexpectedResults;
	private String fprogressPlan;
	private String freference;
	private String fmentorOpinion;
	private String fadjunct;
	private String fmemo;
	private String ftid;
	private String freviewTime;
	
	public String getFreviewTime() {
		return freviewTime;
	}
	public void setFreviewTime(String freviewTime) {
		this.freviewTime = freviewTime;
	}
	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	public String getFopeningTime() {
		return fopeningTime;
	}
	public void setFopeningTime(String fopeningTime) {
		this.fopeningTime = fopeningTime;
	}
	public String getFtopicTitle() {
		return ftopicTitle;
	}
	public void setFtopicTitle(String ftopicTitle) {
		this.ftopicTitle = ftopicTitle;
	}
	public String getFtopicSource() {
		return ftopicSource;
	}
	public void setFtopicSource(String ftopicSource) {
		this.ftopicSource = ftopicSource;
	}
	public String getFsubjectPurpose() {
		return fsubjectPurpose;
	}
	public void setFsubjectPurpose(String fsubjectPurpose) {
		this.fsubjectPurpose = fsubjectPurpose;
	}
	public String getFresearchObject() {
		return fresearchObject;
	}
	public void setFresearchObject(String fresearchObject) {
		this.fresearchObject = fresearchObject;
	}
	public String getFuseWay() {
		return fuseWay;
	}
	public void setFuseWay(String fuseWay) {
		this.fuseWay = fuseWay;
	}
	public String getFexpectedResults() {
		return fexpectedResults;
	}
	public void setFexpectedResults(String fexpectedResults) {
		this.fexpectedResults = fexpectedResults;
	}
	public String getFprogressPlan() {
		return fprogressPlan;
	}
	public void setFprogressPlan(String fprogressPlan) {
		this.fprogressPlan = fprogressPlan;
	}
	public String getFreference() {
		return freference;
	}
	public void setFreference(String freference) {
		this.freference = freference;
	}
	public String getFmentorOpinion() {
		return fmentorOpinion;
	}
	public void setFmentorOpinion(String fmentorOpinion) {
		this.fmentorOpinion = fmentorOpinion;
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
	public String getFtid() {
		return ftid;
	}
	public void setFtid(String ftid) {
		this.ftid = ftid;
	}
	@Override
	public String toString() {
		return "OpeningReport [fno=" + fno + ", fopeningTime=" + fopeningTime
				+ ", ftopicTitle=" + ftopicTitle + ", ftopicSource="
				+ ftopicSource + ", fsubjectPurpose=" + fsubjectPurpose
				+ ", fresearchObject=" + fresearchObject + ", fuseWay="
				+ fuseWay + ", fexpectedResults=" + fexpectedResults
				+ ", fprogressPlan=" + fprogressPlan + ", freference="
				+ freference + ", fmentorOpinion=" + fmentorOpinion
				+ ", fadjunct=" + fadjunct + ", fmemo=" + fmemo + ", ftid="
				+ ftid + ", freviewTime=" + freviewTime + "]";
	}
	
}
