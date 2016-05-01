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
 * @author 王飞翔
 * @function 公告信息
 * 
 */
public class NoticeInformationAction extends ActionSupport {
	// 分页查询
	Page page;
	private int pageNum = 1;
	private int numPerPage = 10;

	// 声明一个List<Announcement>类型的变量用于存放查询到的记录的存放
	private List<Announcement> noticeList;

	// 声明一个公告表的主键来接收前台传的值
	private int fSerialNo;
	// 声明一个公告表对象Announcement用于传送到前台
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
	 * 学生端查看公告
	 */
	public String findProperty() throws Exception {

		page = new Page();
		// 获取指导老师工号
		String fPublisher = ((ThesisList) ServletActionContext.getRequest().getSession().getAttribute("Student"))
				.getFtid();
		String sql = "select * from t_announcement where fType='所有可见' or fType='学生可见' or fPublisher='" + fPublisher
				+ "'";
		page.setSql(sql, pageNum, numPerPage);
		noticeList = DaoFactory.createAnnouncementDao().findByProperty(fPublisher, "fSerialNo", "DESC", page.getStart(),
				page.getEnd());
		page.setTotalCount(noticeList.size());
		return SUCCESS;
	}

	/*
	 * 记录公告浏览次数
	 */
	public String find() throws Exception {
		anc = DaoFactory.createAnnouncementDao().find(fSerialNo);
		int count = Integer.parseInt(anc.getFbrowseTime()) + 1;
		DaoFactory.createAnnouncementDao().updateBrowseTime(fSerialNo, count);

		return SUCCESS;
	}

}
