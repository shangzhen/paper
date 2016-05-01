package henu.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeFactory;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import henu.bean.Acclaim;
import henu.bean.Distribution;
import henu.bean.PaperDetails;
import henu.bean.Review;
import henu.bean.Score;
import henu.bean.Teacher;
import henu.bean.Thesis;
import henu.bean.ThesisList;
import henu.bean.UploadFile;
import henu.factory.DaoFactory;
import henu.util.AJAX;
import henu.util.Page;

public class ReviewPapersAction extends ActionSupport {
	
	// 分页查询
	Page page;
	private int pageNum = 1;
	private int numPerPage = 10;
	// 检索
	private String property  = "fTId";
	
	
	// 声明一个List<Distribution>类型的变量用于存放查询到的记录的存放
	private  List<Distribution> distribution;
	//声明一个公告表的主键来接收前台传的值
	private int fSerialNo;
	//声明一个公告表对象Distribution用于传送到前台
	private Distribution anc;
	private Acclaim acclaim;
	private Score score;
	private Review review;
	private Review review1;
	private PaperDetails pd;
	private String fTId;
	private String downloadfile;
	private List<ThesisList> thesislist;
	private List<PaperDetails> paperlist;
	private ThesisList thesis;
	private ThesisList tl;
	private List<Acclaim> acclaimlist;
	private int fnumber;
	
	public Review getReview1() {
		return review1;
	}
	public void setReview1(Review review1) {
		this.review1 = review1;
	}
	public int getFnumber() {
		return fnumber;
	}
	public void setFnumber(int fnumber) {
		this.fnumber = fnumber;
	}
	public List<Acclaim> getAcclaimlist() {
		return acclaimlist;
	}
	public void setAcclaimlist(List<Acclaim> acclaimlist) {
		this.acclaimlist = acclaimlist;
	}
	public Acclaim getAcclaim() {
		return acclaim;
	}
	public void setAcclaim(Acclaim acclaim) {
		this.acclaim = acclaim;
	}
	public List<PaperDetails> getPaperlist() {
		return paperlist;
	}
	public void setPaperlist(List<PaperDetails> paperlist) {
		this.paperlist = paperlist;
	}
	public ThesisList getTl() {
		return tl;
	}
	public void setTl(ThesisList tl) {
		this.tl = tl;
	}	
	
	public ThesisList getThesis() {
		return thesis;
	}
	public void setThesis(ThesisList thesis) {
		this.thesis = thesis;
	}
	public List<ThesisList> getThesislist() {
		return thesislist;
	}
	public void setThesislist(List<ThesisList> thesislist) {
		this.thesislist = thesislist;
	}
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
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	
	public List<Distribution> getDistribution() {
		return distribution;
	}
	public void setDistribution(List<Distribution> distribution) {
		this.distribution = distribution;
	}
	public int getfSerialNo() {
		return fSerialNo;
	}
	public void setfSerialNo(int fSerialNo) {
		this.fSerialNo = fSerialNo;
	}
	public Distribution getAnc() {
		return anc;
	}
	public void setAnc(Distribution anc) {
		this.anc = anc;
	}
	public PaperDetails getPd() {
		return pd;
	}
	public void setPd(PaperDetails pd) {
		this.pd = pd;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public String getDownloadfile() {
		return downloadfile;
	}
	public void setDownloadfile(String downloadfile) {
		this.downloadfile = downloadfile;
	}

	private List<Distribution> stulist;
	public String getfTId() {
		return fTId;
	}
	public void setfTId(String fTId) {
		this.fTId = fTId;
	}
	
	public List<Distribution> getStulist() {
		return stulist;
	}
	public void setStulist(List<Distribution> stulist) {
		this.stulist = stulist;
	}

	private List<Score> list;
	public String getFTId() {
		return fTId;
	}
	public void setFTId(String fTId) {
		this.fTId = fTId;
	}
	
	public List<Score> getList() {
		return list;
	}
	public void setList(List<Score> list) {
		this.list = list;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public AJAX getAjax() {
		return ajax;
	}
	public void setAjax(AJAX ajax) {
		this.ajax = ajax;
	}
	private String url = "/teacher/ajax.jsp";
	private AJAX ajax;
	public List<Score> scoreList = new ArrayList<Score>();
	
	
	
	public List<Score> getScoreList() {
		return scoreList;
	}
	public void setScoreList(List<Score> scoreList) {
		this.scoreList = scoreList;
	}
	/*老师负责学生*/
	public String ShowStuList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		/**
		 * 从前台获取教师工号
		 * */
		fTId = (String) session.getAttribute("user");
		
		page = new Page();
		if (property.equals("") || fTId.equals("")) {
			property = "fType";
			
		}
		/**
		 * 根据教师工号查出，与之教师工号所对应的学生，查出结果，放到stulist中。
		 * 此查询调用property，供前台分页使用。
		 * */
		page.setProperties("t_distribution", pageNum, numPerPage, property, fTId);
		
		thesislist = DaoFactory.createIThesisListDao().findByProperty("fTId", fTId, null, null, "fNo", "DESC", page.getStart(), page.getEnd());
		
		
		/*stulist = DaoFactory.createDistribution().findByTeahcer(fTId);*/
		/**
		 * 对查到的与之教师工号对应的学生列表进行逐一的遍历，遍历的同时对查到的每一位学生进行，根据学号查找，查找到的
		 * 学生信息，放到scoreList列表中，一块把信息传到前台。
		 * */
		for(int i=0;i<thesislist.size();i++){
			String s = thesislist.get(i).getFno();
			/**
			 * 把在thesislist表中查到的结果，姓名，指导老师，以及专业存到score表中
			 * */
			
			paperlist = DaoFactory.createPaperDetailsDao().findByfnototitle(s);
			
			pd = DaoFactory.createPaperDetailsDao().findByfNoAndTime(s, paperlist.size());
			
			/**
			 * 把t_paperdetails表中的论文题目添加到 score表中
			 * */
			if(pd!=null&&thesislist!=null){
				DaoFactory.createScoreDao().update3(s, pd.getFtitle(),thesislist.get(i).getFtName(),thesislist.get(i).getFprofessional(),thesislist.get(i).getFsName());
			}
			/**
			 *  去score表中差出score中的信息，返回到layout2.jsp中。
			 * */
			score = DaoFactory.createScoreDao().find(s);
			
			scoreList.add(score);
		}
		
		
		/**
		 * 把查询到需要评分的学生数目存到page中，供前台调用。
		 * */
		page.setTotalCount(scoreList.size());
		return "show";
	}
	/*评阅老师给学生打分*/
	public String ShowStuList1(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		/**
		 * 从前台获取教师工号
		 * */
		fTId = (String) session.getAttribute("user");
		
		page = new Page();
		if (property.equals("") || fTId.equals("")) {
			property = "fType";
			fTId = fTId;
		}
		
		page.setProperties("t_distribution", pageNum, numPerPage, property, fTId);
		stulist = DaoFactory.createDistribution().findByProperty(property, fTId, 
				"id", "DESC", page.getStart(), page.getEnd());
		
		
		/*stulist = DaoFactory.createDistribution().findByTeahcer(fTId);*/
		
		for(int i=0;i<stulist.size();i++){
			String s = stulist.get(i).getFno();
			//先去论文状态表中查询，这个学生是否已经评阅老师评过分，如果评过分就不在显示，如果没有评过分就显示到jsp页面。
			Thesis t = DaoFactory.createIThesisDao().findByNo(s);
			//查询state是否为毕业状态。
			tl = DaoFactory.createIThesisListDao().findState(s);
			//if(t!=null && "0".equals(t.getfScore()) && tl!=null){
				paperlist = DaoFactory.createPaperDetailsDao().findByfnototitle(s);
				
				pd = DaoFactory.createPaperDetailsDao().findByfNoAndTime(s, paperlist.size());
				
				/**
				 * 把t_paperdetails表中的论文题目添加到 score表中
				 * */
				if(pd!=null&&thesislist!=null){
					DaoFactory.createScoreDao().update3(s, pd.getFtitle(),thesislist.get(i).getFtName(),thesislist.get(i).getFprofessional(),thesislist.get(i).getFsName());
				}
				/**
				 *  去score表中差出score中的信息，返回到layout2.jsp中。
				 * */
				score = DaoFactory.createScoreDao().find(s);
				scoreList.add(score);
				
			//}
			/**
			 * 把查询到需要评分的学生数目存到page中，供前台调用。
			 * */
				
			page.setTotalCount(scoreList.size());
		}
		return "show";
	}
	/*老师负责学生*/
	public String ShowStuPaperList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		/**
		 * 从前台获取教师工号
		 * */
		fTId = (String) session.getAttribute("user");
		
		page = new Page();
		if (property.equals("") || fTId.equals("")) {
			property = "fType";
			fTId = fTId;
		}
		
		page.setProperties("t_distribution", pageNum, numPerPage, property, fTId);
		thesislist = DaoFactory.createIThesisListDao().findByProperty("fTId", fTId, null, null, "fNo", "DESC", page.getStart(), page.getEnd());
		
		
		/*stulist = DaoFactory.createDistribution().findByTeahcer(fTId);*/
		
		for(int i=0;i<thesislist.size();i++){
			String s = thesislist.get(i).getFno();
			//先去论文状态表中查询，这个学生是否答辩老师已经评过分，如果评过分就不在显示，如果没有评过分就显示到jsp页面。
			Thesis t = DaoFactory.createIThesisDao().findByNo(s);
			//没有评分fmemo的值0;
			
				paperlist = DaoFactory.createPaperDetailsDao().findByfnototitle(s);
				
				pd = DaoFactory.createPaperDetailsDao().findByfNoAndTime(s, paperlist.size());
				
				/**
				 * 把t_paperdetails表中的论文题目添加到 score表中
				 * */
				if(pd!=null&&thesislist!=null){
					DaoFactory.createScoreDao().update3(s, pd.getFtitle(),thesislist.get(i).getFtName(),thesislist.get(i).getFprofessional(),thesislist.get(i).getFsName());
				}
				/**
				 *  去score表中差出score中的信息，返回到layout2.jsp中。
				 * */
				score = DaoFactory.createScoreDao().find(s);
				scoreList.add(score);
			
			/**
			 * 把查询到需要评分的学生数目存到page中，供前台调用。
			 * */
			page.setTotalCount(scoreList.size());
		}
		return "show";
	}
	/*查询学生得分*/
	public String searchscore(){
		
		pd = DaoFactory.createPaperDetailsDao().findByfNo(review.getFno());
		
		score = DaoFactory.createScoreDao().find(review.getFno());
		
		return "searchscore";
	}
	
	
	public String add(){
		ajax = new AJAX();
		
		int result = DaoFactory.createScoreDao().update(score.getFno(), score);
		
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("保存成功");
			ajax.setNavTabId("adviceList");
			ajax.setCallbackType("closeCurrent");
			
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("保存失败");
			ajax.setCallbackType("");
		}
		return "add";
	}
	
	public String add1(){
		ajax = new AJAX();
		//把评阅老师批改的成绩通过学号，update到score表中（成绩表中的学号，直接导入）
		int result = DaoFactory.createScoreDao().update1(score.getFno(), score);
		//评阅老师批改完成绩之后，向论文状态表中添加备注信息（t_Thesis中的fscore字段）
		DaoFactory.createIThesisDao().update1(score.getFno());
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("保存成功");
			ajax.setNavTabId("adviceList");
			ajax.setCallbackType("closeCurrent");
			
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("保存失败");
			ajax.setCallbackType("");
		}
		return "add1";
	}
	
	public String add2(){
		ajax = new AJAX();
		//把答辩老师批改的成绩通过学号，update到review（答辩成绩）表中
		int result = DaoFactory.createReviewDao().update(review.getFno(), review);
		//答辩老师批改完成绩之后，向论文状态表中添加备注信息（t_Thesis中的fSenceRep字段值为1），并且fmemo字段值置为1。
		DaoFactory.createIThesisDao().update2(review.getFno());
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("保存成功");
			ajax.setNavTabId("pagination100");
			ajax.setCallbackType("closeCurrent");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("保存失败");
			ajax.setCallbackType("");
		}
		return "add2";
	}
	
	public String pingyu1(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String sno = request.getParameter("sno");
		score = DaoFactory.createScoreDao().find(sno);
		
		int sum = Integer.parseInt(score.getFscoreSum());
		if(100>=sum && sum>90){
			acclaimlist = DaoFactory.createIAcclaimDao().findbyAgrade("指导老师","优");
		}else if(76<=sum && sum<=89){
			acclaimlist = DaoFactory.createIAcclaimDao().findbyAgrade("指导老师","良");
		}else if(60<=sum && sum<75){
			acclaimlist = DaoFactory.createIAcclaimDao().findbyAgrade("指导老师","中");
		}else if(sum<60){
			acclaimlist = DaoFactory.createIAcclaimDao().findbyAgrade("指导老师","差");
		}
		//System.out.println(acclaimlist.get(1).getFnumber());
		
		if(acclaimlist != null){
			return "pingyu1";
		}else{
			return "error";
		}
	}
	public String pingyu2(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String sno = request.getParameter("sno");
		score = DaoFactory.createScoreDao().find(sno);
		int sum = Integer.parseInt(score.getFcommentScoreSum());
		if(100>=sum && sum>90){
			acclaimlist = DaoFactory.createIAcclaimDao().findbyAgrade("评阅老师","优");
		}else if(76<=sum && sum<=89){
			acclaimlist = DaoFactory.createIAcclaimDao().findbyAgrade("评阅老师","良");
		}else if(60<=sum && sum<75){
			acclaimlist = DaoFactory.createIAcclaimDao().findbyAgrade("评阅老师","中");
		}else if(sum<60){
			acclaimlist = DaoFactory.createIAcclaimDao().findbyAgrade("评阅老师","差");
		}
		if(acclaimlist != null){
			return "pingyu2";
		}else{
			return "error";
		}
		
	}
	
	public String pingyu3(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String sno = request.getParameter("sno");
		//System.out.println("sno:******"+sno);
		review = DaoFactory.createReviewDao().find(sno);
		//把score表中的学号传到前台
		score = DaoFactory.createScoreDao().find(sno);
		if(review != null){
			//System.out.println("review:"+review);
			double s1 = Double.parseDouble(review.getFcontentScore());
			double s2 = Double.parseDouble(review.getFscoreDefense());
			double s3 = Double.parseDouble(review.getFwordScore());
			double s4 = Double.parseDouble(review.getFqualityScore());
			double sum = s1+s2+s3+s4;
			if(100>=sum && sum>90){
				acclaimlist = DaoFactory.createIAcclaimDao().findbyAgrade("答辩老师","优");
			}else if(76<=sum && sum<=89){
				acclaimlist = DaoFactory.createIAcclaimDao().findbyAgrade("答辩老师","良");
			}else if(60<=sum && sum<75){
				acclaimlist = DaoFactory.createIAcclaimDao().findbyAgrade("答辩老师","中");
			}else if(sum<60){
				acclaimlist = DaoFactory.createIAcclaimDao().findbyAgrade("答辩老师","差");
			}
			if(acclaimlist != null){
				//System.out.println("pingyu3");
				return "pingyu3";
			}else{
				return "error";
			}
		}else{
			return "error";
		}
		
	}
	
	public String addpingyu(){
		ajax = new AJAX();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String fNo = request.getParameter("fno");
		int result = DaoFactory.createScoreDao().update4(fNo, score);
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("评论成功");
			ajax.setNavTabId("pagination100");
			ajax.setCallbackType("closeCurrent");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("评论失败");
			ajax.setCallbackType("");
		}
		return "addpingyu";
	}
	//评阅老师，评语
	public String addpingyu1(){
		ajax = new AJAX();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String fNo = request.getParameter("fno");
		System.out.println("fNo:"+fNo+"score:"+score.getFcommentTeacher());
		int result = DaoFactory.createScoreDao().update5(fNo, score);
		if(result!=0){
			ajax.setStatusCode("200");
			ajax.setMessage("评论成功");
			ajax.setNavTabId("pagination100");
			ajax.setCallbackType("closeCurrent");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage("评论失败");
			ajax.setCallbackType("");
		}
		return "addpingyu1";
	}
	//答辩老师，评语
		public String addpingyu2(){
			ajax = new AJAX();
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			String fNo = request.getParameter("fno");
			
			int result = DaoFactory.createReviewDao().update2(fNo, review1);
			if(result!=0){
				ajax.setStatusCode("200");
				ajax.setMessage("评论成功");
				ajax.setNavTabId("pagination100");
				ajax.setCallbackType("closeCurrent");
			}else{
				ajax.setStatusCode("300");
				ajax.setMessage("评论失败");
				ajax.setCallbackType("");
			}
			return "addpingyu2";
		}
	
	public String findmessage1(){
		
		acclaim = DaoFactory.createIAcclaimDao().findByNumber(fnumber);
		
		if(acclaim != null){
			return "findmessage1";
		}else{
			return "error";
		}
	}
	
public String findmessage2(){
		
		acclaim = DaoFactory.createIAcclaimDao().findByNumber(fnumber);
		
		if(acclaim != null){
			return "findmessage2";
		}else{
			return "error";
		}
	}

public String findmessage3(){
	
	acclaim = DaoFactory.createIAcclaimDao().findByNumber(fnumber);
	
	if(acclaim != null){
		return "findmessage3";
	}else{
		return "error";
	}
}
public InputStream getInputStream() {
		
		PaperDetails p = (PaperDetails) DaoFactory.createPaperDetailsDao().findByfNo(downloadfile);
		String path = p.getFthesisAdjunct();
		
		FileInputStream fis = null;
		
			try {
				fis = new FileInputStream(path);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return fis;
	}
	
    public String getDownloadFileName(){ 
    	/*System.out.println("downloadfile:"+downloadfile);*/
    	return downloadfile;
    }

	
}

