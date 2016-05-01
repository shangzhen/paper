package henu.bean;

import java.sql.Date;
/**
 * t_Review������ı��Ӧ��Bean
 * @author ��ʤ��
 * 2015��10��12��
 */
public class Review {
	/**
	 * ѧ��
	 */
	private String fno;
	private String fdefenceTime;
	private String fcomment;
	private String fpersonnel;
	private String fdirector;
	private String fcontentScore;
	private String fscoreDefense;
	private String fwordScore;
	private String fqualityScore;
	private String fcomprehensiveScore;
	private String frating;
	private String fadjunct;
	private String fmemo;
	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	public String getFdefenceTime() {
		return fdefenceTime;
	}
	public void setFdefenceTime(String fdefenceTime) {
		this.fdefenceTime = fdefenceTime;
	}
	public String getFcomment() {
		return fcomment;
	}
	public void setFcomment(String fcomment) {
		this.fcomment = fcomment;
	}
	public String getFpersonnel() {
		return fpersonnel;
	}
	public void setFpersonnel(String fpersonnel) {
		this.fpersonnel = fpersonnel;
	}
	public String getFdirector() {
		return fdirector;
	}
	public void setFdirector(String fdirector) {
		this.fdirector = fdirector;
	}
	public String getFcontentScore() {
		return fcontentScore;
	}
	public void setFcontentScore(String fcontentScore) {
		this.fcontentScore = fcontentScore;
	}
	public String getFscoreDefense() {
		return fscoreDefense;
	}
	public void setFscoreDefense(String fscoreDefense) {
		this.fscoreDefense = fscoreDefense;
	}
	public String getFwordScore() {
		return fwordScore;
	}
	public void setFwordScore(String fwordScore) {
		this.fwordScore = fwordScore;
	}
	public String getFqualityScore() {
		return fqualityScore;
	}
	public void setFqualityScore(String fqualityScore) {
		this.fqualityScore = fqualityScore;
	}
	public String getFcomprehensiveScore() {
		return fcomprehensiveScore;
	}
	public void setFcomprehensiveScore(String fcomprehensiveScore) {
		this.fcomprehensiveScore = fcomprehensiveScore;
	}
	public String getFrating() {
		return frating;
	}
	public void setFrating(String frating) {
		this.frating = frating;
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
		return "Review [fno=" + fno + ", fdefenceTime=" + fdefenceTime + ", fcomment=" + fcomment + ", fpersonnel="
				+ fpersonnel + ", fdirector=" + fdirector + ", fcontentScore=" + fcontentScore + ", fscoreDefense="
				+ fscoreDefense + ", fwordScore=" + fwordScore + ", fqualityScore=" + fqualityScore
				+ ", fcomprehensiveScore=" + fcomprehensiveScore + ", frating=" + frating + ", fadjunct=" + fadjunct
				+ ", fmemo=" + fmemo + "]";
	}
	
}
