package henu.bean;

import java.sql.Date;
/**
 * t_registration��籨����Ӧ��Bean
 * @author ��ʤ��
 * 2015��10��12��
 */
public class Registration {
	/**
	 * ���һ������������
	 */
	private int fId;
	/**
	 * ѧ��
	 */
	private String fNo;
	/**
	 * ��繫����
	 */
	private int fNoticeId;
	private String fName;
	private String fDefencePlace;
	private String fThesisTopic;
	private String fReleaseTime;
	private String fGuideTeacher;
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	
	public int getfNoticeId() {
		return fNoticeId;
	}
	public void setfNoticeId(int fNoticeId) {
		this.fNoticeId = fNoticeId;
	}
	public String getfNo() {
		return fNo;
	}
	public void setfNo(String fNo) {
		this.fNo = fNo;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfDefencePlace() {
		return fDefencePlace;
	}
	public void setfDefencePlace(String fDefencePlace) {
		this.fDefencePlace = fDefencePlace;
	}
	public String getfThesisTopic() {
		return fThesisTopic;
	}
	public void setfThesisTopic(String fThesisTopic) {
		this.fThesisTopic = fThesisTopic;
	}
	public String getfReleaseTime() {
		return fReleaseTime;
	}
	public void setfReleaseTime(String fReleaseTime) {
		this.fReleaseTime = fReleaseTime;
	}
	public String getfGuideTeacher() {
		return fGuideTeacher;
	}
	public void setfGuideTeacher(String fGuideTeacher) {
		this.fGuideTeacher = fGuideTeacher;
	}
	@Override
	public String toString() {
		return "Registration [fId=" + fId + ", fName=" + fName + ", fDefencePlace=" + fDefencePlace + ", fThesisTopic="
				+ fThesisTopic + ", fReleaseTime=" + fReleaseTime + ", fGuideTeacher=" + fGuideTeacher + "]";
	}
	

}
