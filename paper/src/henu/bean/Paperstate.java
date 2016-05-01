package henu.bean;
/**
 * 学生论文状态表
 * @author 
 *2016年3月6日
 */
public class Paperstate {
	/**
	 * fno 主键 学号	
	 */
	private String fno;
	private String fopenReport;
	private String ftaskBook;
	private String fmidInspect;
	private String ffirstDraft;
	private String ffinalDraft;
	private String fcheck;
	private String fjoinDefence;
	private String fscoreJudge;
	private String fmemo;
	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	public String getFopenReport() {
		return fopenReport;
	}
	public void setFopenReport(String fopenReport) {
		this.fopenReport = fopenReport;
	}
	public String getFtaskBook() {
		return ftaskBook;
	}
	public void setFtaskBook(String ftaskBook) {
		this.ftaskBook = ftaskBook;
	}
	public String getFmidInspect() {
		return fmidInspect;
	}
	public void setFmidInspect(String fmidInspect) {
		this.fmidInspect = fmidInspect;
	}
	public String getFfirstDraft() {
		return ffirstDraft;
	}
	public void setFfirstDraft(String ffirstDraft) {
		this.ffirstDraft = ffirstDraft;
	}
	public String getFfinalDraft() {
		return ffinalDraft;
	}
	public void setFfinalDraft(String ffinalDraft) {
		this.ffinalDraft = ffinalDraft;
	}
	public String getFcheck() {
		return fcheck;
	}
	public void setFcheck(String fcheck) {
		this.fcheck = fcheck;
	}
	public String getFjoinDefence() {
		return fjoinDefence;
	}
	public void setFjoinDefence(String fjoinDefence) {
		this.fjoinDefence = fjoinDefence;
	}
	public String getFscoreJudge() {
		return fscoreJudge;
	}
	public void setFscoreJudge(String fscoreJudge) {
		this.fscoreJudge = fscoreJudge;
	}
	public String getFmemo() {
		return fmemo;
	}
	public void setFmemo(String fmemo) {
		this.fmemo = fmemo;
	}
	@Override
	public String toString() {
		return "Paperstate [fno=" + fno + ", fopenReport=" + fopenReport
				+ ", ftaskBook=" + ftaskBook + ", fmidInspect=" + fmidInspect
				+ ", ffirstDraft=" + ffirstDraft + ", ffinalDraft="
				+ ffinalDraft + ", fcheck=" + fcheck + ", fjoinDefence="
				+ fjoinDefence + ", fscoreJudge=" + fscoreJudge + ", fmemo="
				+ fmemo + "]";
	}
	
	
	
}
