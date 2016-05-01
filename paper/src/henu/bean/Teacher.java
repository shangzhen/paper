package henu.bean;
/**
 * t_Teacher表对应的Bean
 * @author 梁胜彬
 * 2015年10月12日
 */
public class Teacher {
	/**
	 * 教工号
	 */
	private String ftid;
	private String fname;
	private String fdepartment;
	private String fposition;
	private String fphone;
	private String femail;
	private String fqq;
	private String fqgno;
	private String fpsw;
	private String ftype;
	private String fmemo;
	private String fcollege;
	public String getFtid() {
		return ftid;
	}
	public void setFtid(String ftid) {
		this.ftid = ftid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFdepartment() {
		return fdepartment;
	}
	public void setFdepartment(String fdepartment) {
		this.fdepartment = fdepartment;
	}
	public String getFposition() {
		return fposition;
	}
	public void setFposition(String fposition) {
		this.fposition = fposition;
	}
	public String getFphone() {
		return fphone;
	}
	public void setFphone(String fphone) {
		this.fphone = fphone;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public String getFqq() {
		return fqq;
	}
	public void setFqq(String fqq) {
		this.fqq = fqq;
	}
	public String getFqgno() {
		return fqgno;
	}
	public void setFqgno(String fqgno) {
		this.fqgno = fqgno;
	}
	public String getFpsw() {
		return fpsw;
	}
	public void setFpsw(String fpsw) {
		this.fpsw = fpsw;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public String getFmemo() {
		return fmemo;
	}
	public void setFmemo(String fmemo) {
		this.fmemo = fmemo;
	}
	public String getFcollege() {
		return fcollege;
	}
	public void setFcollege(String fcollege) {
		this.fcollege = fcollege;
	}
	@Override
	public String toString() {
		return "Teacher [ftid=" + ftid + ", fname=" + fname + ", fdepartment=" + fdepartment + ", fposition="
				+ fposition + ", fphone=" + fphone + ", femail=" + femail + ", fqq=" + fqq + ", fqgno=" + fqgno
				+ ", fpsw=" + fpsw + ", ftype=" + ftype + ", fmemo=" + fmemo + ", fcollege=" + fcollege + "]";
	}
	
	
}
