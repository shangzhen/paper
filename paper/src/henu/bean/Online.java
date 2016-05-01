package henu.bean;
/**
 * 在线咨询表t_Online对应的Bean
 * @author 梁胜彬
 * 2015年10月12日
 */
public class Online {

	private int fid;
	private String ftitle;
	private String fcontent;
	/**
	 * 咨询时间
	 */
	private String fqueryTime;
	/**
	 * 咨询学生姓名
	 */
	private String fstudentName;
	/**
	 * 回复时间
	 */
	private String freplyTime;
	private String fisTop;
	private String fanswer;
	private String freply;
	private String fno;
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
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public String getFqueryTime() {
		return fqueryTime;
	}
	public void setFqueryTime(String fqueryTime) {
		this.fqueryTime = fqueryTime;
	}
	public String getFstudentName() {
		return fstudentName;
	}
	public void setFstudentName(String fstudentName) {
		this.fstudentName = fstudentName;
	}
	public String getFreplyTime() {
		return freplyTime;
	}
	public void setFreplyTime(String freplyTime) {
		this.freplyTime = freplyTime;
	}
	public String getFisTop() {
		return fisTop;
	}
	public void setFisTop(String fisTop) {
		this.fisTop = fisTop;
	}
	public String getFanswer() {
		return fanswer;
	}
	public void setFanswer(String fanswer) {
		this.fanswer = fanswer;
	}
	public String getFreply() {
		return freply;
	}
	public void setFreply(String freply) {
		this.freply = freply;
	}
	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	
	
}
