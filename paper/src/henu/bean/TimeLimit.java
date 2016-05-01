package henu.bean;

import java.sql.Date;
/**
 * t_TimeLimitʱ�����Ʊ��Ӧ��Bean
 * @author ��ʤ��
 * 2015��10��12��
 */
public class TimeLimit {
	/**
	 * ����
	 */
	private int fid;
	private String fjobTasks;
	private String ftimeRequirement;
	private String fremindContent;
	private int fremindTime;
	/**
	 * �̹���
	 */
	private String ftid;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFjobTasks() {
		return fjobTasks;
	}
	public void setFjobTasks(String fjobTasks) {
		this.fjobTasks = fjobTasks;
	}
	public String getFtimeRequirement() {
		return ftimeRequirement;
	}
	public void setFtimeRequirement(String ftimeRequirement) {
		this.ftimeRequirement = ftimeRequirement;
	}
	public String getFremindContent() {
		return fremindContent;
	}
	public void setFremindContent(String fremindContent) {
		this.fremindContent = fremindContent;
	}
	public int getFremindTime() {
		return fremindTime;
	}
	public void setFremindTime(int fremindTime) {
		this.fremindTime = fremindTime;
	}
	public String getFtid() {
		return ftid;
	}
	public void setFtid(String ftid) {
		this.ftid = ftid;
	}
	@Override
	public String toString() {
		return "TimeLimit [fid=" + fid + ", fjobTasks=" + fjobTasks + ", ftimeRequirement=" + ftimeRequirement
				+ ", fremindContent=" + fremindContent + ", fremindTime=" + fremindTime + ", ftid=" + ftid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fid;
		result = prime * result + ((fjobTasks == null) ? 0 : fjobTasks.hashCode());
		result = prime * result + ((fremindContent == null) ? 0 : fremindContent.hashCode());
		result = prime * result + fremindTime;
		result = prime * result + ((ftid == null) ? 0 : ftid.hashCode());
		result = prime * result + ((ftimeRequirement == null) ? 0 : ftimeRequirement.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeLimit other = (TimeLimit) obj;
		if (fid != other.fid)
			return false;
		if (fjobTasks == null) {
			if (other.fjobTasks != null)
				return false;
		} else if (!fjobTasks.equals(other.fjobTasks))
			return false;
		if (fremindContent == null) {
			if (other.fremindContent != null)
				return false;
		} else if (!fremindContent.equals(other.fremindContent))
			return false;
		if (fremindTime != other.fremindTime)
			return false;
		if (ftid == null) {
			if (other.ftid != null)
				return false;
		} else if (!ftid.equals(other.ftid))
			return false;
		if (ftimeRequirement == null) {
			if (other.ftimeRequirement != null)
				return false;
		} else if (!ftimeRequirement.equals(other.ftimeRequirement))
			return false;
		return true;
	}
	
	
	
	
}
