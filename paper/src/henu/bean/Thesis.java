package henu.bean;
/**
 * t_Thesis���ı��Ӧ��Bean
 * @author ��ʤ��
 * 2015��10��12��
 */
public class Thesis {
	/**
	 * ѧ��
	 */
	private String fNo;
	private String fTid;
	public String getfTid() {
		return fTid;
	}
	public void setfTid(String fTid) {
		this.fTid = fTid;
	}
	private String fThePro;
	private String fTask;
	private String fMidCheck;
	private String fFinalDraft;
	private String fScore;
	private String fSenceRep;
	private String fEvaluate;
	private String fRepeat;
	private String fMemo;
	public String getfNo() {
		return fNo;
	}
	public void setfNo(String fNumber) {
		this.fNo = fNumber;
	}
	public String getfThePro() {
		return fThePro;
	}
	public void setfThePro(String fThePro) {
		this.fThePro = fThePro;
	}
	public String getfTask() {
		return fTask;
	}
	public void setfTask(String fTask) {
		this.fTask = fTask;
	}
	public String getfMidCheck() {
		return fMidCheck;
	}
	public void setfMidCheck(String fMidCheck) {
		this.fMidCheck = fMidCheck;
	}
	public String getfFinalDraft() {
		return fFinalDraft;
	}
	public void setfFinalDraft(String fFinalDraft) {
		this.fFinalDraft = fFinalDraft;
	}
	public String getfScore() {
		return fScore;
	}
	public void setfScore(String fScore) {
		this.fScore = fScore;
	}
	public String getfSenceRep() {
		return fSenceRep;
	}
	public void setfSenceRep(String fSenceRep) {
		this.fSenceRep = fSenceRep;
	}
	public String getfEvaluate() {
		return fEvaluate;
	}
	public void setfEvaluate(String fEvaluate) {
		this.fEvaluate = fEvaluate;
	}
	public String getfRepeat() {
		return fRepeat;
	}
	public void setfRepeat(String fRepeat) {
		this.fRepeat = fRepeat;
	}
	public String getfMemo() {
		return fMemo;
	}
	public void setfMemo(String fMemo) {
		this.fMemo = fMemo;
	}
	@Override
	public String toString() {
		return "Thesis [fNo=" + fNo + ", fTid=" + fTid + ", fThePro=" + fThePro
				+ ", fTask=" + fTask + ", fMidCheck=" + fMidCheck
				+ ", fFinalDraft=" + fFinalDraft + ", fScore=" + fScore
				+ ", fSenceRep=" + fSenceRep + ", fEvaluate=" + fEvaluate
				+ ", fRepeat=" + fRepeat + ", fMemo=" + fMemo + "]";
	}
	
	
	
}
