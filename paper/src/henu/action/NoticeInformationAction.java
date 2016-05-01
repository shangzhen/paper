package henu.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import henu.bean.Announcement;
import henu.bean.ThesisList;
import henu.factory.DaoFactory;
import henu.util.Page;

/**
 * 
 * @author ������
 * @function ������Ϣ
 * 
 */
public class NoticeInformationAction extends ActionSupport {
	// ��ҳ��ѯ
	Page page;
	private int pageNum = 1;
	private int numPerPage = 10;

	// ����һ��List<Announcement>���͵ı������ڴ�Ų�ѯ���ļ�¼�Ĵ��
	private List<Announcement> noticeList;

	// ����һ������������������ǰ̨����ֵ
	private int fSerialNo;
	// ����һ����������Announcement���ڴ��͵�ǰ̨
	private Announcement anc;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public List<Announcement> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<Announcement> noticeList) {
		this.noticeList = noticeList;
	}

	public int getFSerialNo() {
		return fSerialNo;
	}

	public void setFSerialNo(int fSerialNo) {
		this.fSerialNo = fSerialNo;
	}

	public Announcement getAnc() {
		return anc;
	}

	public void setAnc(Announcement anc) {
		this.anc = anc;
	}

	/**
	 * 
	 * ѧ���˲鿴����
	 */
	public String findProperty() throws Exception {

		page = new Page();
		// ��ȡָ����ʦ����
		String fPublisher = ((ThesisList) ServletActionContext.getRequest().getSession().getAttribute("Student"))
				.getFtid();
		String sql = "select * from t_announcement where fType='���пɼ�' or fType='ѧ���ɼ�' or fPublisher='" + fPublisher
				+ "'";
		page.setSql(sql, pageNum, numPerPage);
		noticeList = DaoFactory.createAnnouncementDao().findByProperty(fPublisher, "fSerialNo", "DESC", page.getStart(),
				page.getEnd());
		page.setTotalCount(noticeList.size());
		return SUCCESS;
	}

	/*
	 * ��¼�����������
	 */
	public String find() throws Exception {
		anc = DaoFactory.createAnnouncementDao().find(fSerialNo);
		int count = Integer.parseInt(anc.getFbrowseTime()) + 1;
		DaoFactory.createAnnouncementDao().updateBrowseTime(fSerialNo, count);

		return SUCCESS;
	}

}
