package henu.bean;
/**
 * 学生表
 * @author
 *2016年3月26日
 */
public class Student {
	/**
	 * fno 主键 学号	
	 */
	private String fno;
	private String fsname;
	private String fmarjor;
	private String fgreade;
	private String fplace;
	private String fclass;
	private String fcnmae;
	private String fcid;
	private String fphone;
	private String femail;
	private String fqq;
	private String ftranning;
	private String fwork;
	private String fstate;
	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	public String getFsname() {
		return fsname;
	}
	public void setFsname(String fsname) {
		this.fsname = fsname;
	}
	public String getFmarjor() {
		return fmarjor;
	}
	public void setFmarjor(String fmarjor) {
		this.fmarjor = fmarjor;
	}
	public String getFgreade() {
		return fgreade;
	}
	public void setFgreade(String fgreade) {
		this.fgreade = fgreade;
	}
	public String getFplace() {
		return fplace;
	}
	public void setFplace(String fplace) {
		this.fplace = fplace;
	}
	public String getFclass() {
		return fclass;
	}
	public void setFclass(String fclass) {
		this.fclass = fclass;
	}
	public String getFcnmae() {
		return fcnmae;
	}
	public void setFcnmae(String fcnmae) {
		this.fcnmae = fcnmae;
	}
	public String getFcid() {
		return fcid;
	}
	public void setFcid(String fcid) {
		this.fcid = fcid;
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
	
	public String getFtranning() {
		return ftranning;
	}
	public void setFtranning(String ftranning) {
		this.ftranning = ftranning;
	}
	public String getFwork() {
		return fwork;
	}
	public void setFwork(String fwork) {
		this.fwork = fwork;
	}
	public String getFstate() {
		return fstate;
	}
	public void setFstate(String fstate) {
		this.fstate = fstate;
	}
	@Override
	public String toString() {
		return "Student [fno=" + fno + ", fsname=" + fsname + ", fmarjor=" + fmarjor + ", fgreade=" + fgreade
				+ ", fplace=" + fplace + ", fclass=" + fclass + ", fcnmae=" + fcnmae + ", fcid=" + fcid + ", fphone="
				+ fphone + ", femail=" + femail + ", fqq=" + fqq + ", ftranning=" + ftranning + ", fwork=" + fwork
				+ ", fstate=" + fstate + "]";
	}
	
	
}
