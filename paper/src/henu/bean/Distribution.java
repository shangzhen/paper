package henu.bean;
/**
 * �������Ľ�ʦ������Ӧ��Bean
 * @author ��ʤ��
 * 2015��10��12��
 */
public class Distribution {

	/**
	 * ����
	 */
	private int id;
	/**
	 * ����
	 */
	private String ftid;
	/**
	 * ѧ��
	 */
	private String fno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFtid() {
		return ftid;
	}
	public void setFtid(String ftid) {
		this.ftid = ftid;
	}
	public String getFno() {
		return fno;
	}
	public void setFno(String fno) {
		this.fno = fno;
	}
	@Override
	public String toString() {
		return "Distribution [id=" + id + ", ftid=" + ftid + ", fno=" + fno + "]";
	}
	
}
