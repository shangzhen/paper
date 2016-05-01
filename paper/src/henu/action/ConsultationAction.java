package henu.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import henu.bean.Online;
import henu.bean.ThesisList;
import henu.dao.IOnlineDao;
import henu.factory.DaoFactory;
import henu.util.AJAX;
import henu.util.Page;
/**
 * 
 * @author 王飞翔
 * @function 在线咨询
 * 
 */
public class ConsultationAction extends ActionSupport {

	// 分页查询
	Page page;
	private int pageNum = 1;
	private int numPerPage = 10;

	// 检索
	private String property;
	private String key;

	// 声明一个List<Online>类型的变量用于存放查询到的记录的存放
	private List<Online> list;
	
	//咨询信息的主键
	private int fid;
	
	//声明一个Online对象用于接收
	private Online online;
	
	//声明一个ThesisList对象，向前台传送信息
	private ThesisList student;
	
	AJAX ajax;
	
	//声明一个fanswer用来存放教师姓名
	private String fanswer;
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Online> getList() {
		return list;
	}

	public void setList(List<Online> list) {
		this.list = list;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public Online getOnline() {
		return online;
	}

	public void setOnline(Online online) {
		this.online = online;
	}

	public ThesisList getStudent() {
		return student;
	}

	public void setStudent(ThesisList student) {
		this.student = student;
	}

	public AJAX getAjax() {
		return ajax;
	}

	public void setAjax(AJAX ajax) {
		this.ajax = ajax;
	}

	public String getFanswer() {
		return fanswer;
	}

	public void setFanswer(String fanswer) {
		this.fanswer = fanswer;
	}
	/**
	 * 学生端根据session中的学号查看自己的咨询情况
	 */
    public String findListBySid()throws Exception{
    	String fNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");   	
		page=new Page();		
		property="fNo";
		key = fNo;
		page.setProperties("t_online",pageNum,numPerPage,property,key);
		list=DaoFactory.createOnlineDAO().findByProperty(property, key, "fId", "DESC", page.getStart(), page.getEnd());		
		return SUCCESS;
	}

    /**
   	 * 学生在管理员未回复前自己删除的
   	 */
   	public String delete()throws Exception{   		
   		int result=DaoFactory.createOnlineDAO().delete(fid);   		
   		ajax=new AJAX();
   		if(result!=0){
   			ajax.setStatusCode("200");
   			ajax.setMessage("删除成功");
   			ajax.setNavTabId("page12");
   			ajax.setCallbackType("");
   			
   		}else{
   			ajax.setStatusCode("300");
   			ajax.setMessage("删除失败");
   			ajax.setCallbackType("");
   		}
   		
   		return SUCCESS;
   	}

   	
    /**
   	 * 学生询问一条信息
   	 */
       public String add()throws Exception{
   	    	String fContent=ServletActionContext.getRequest().getParameter("fContent");
   	    	ajax=new AJAX();
   	    	//咨询内容不能为空
   	    	if(fContent==null||fContent.equals("")){
   	    		ajax.setStatusCode("300");
   				ajax.setMessage("内容不能为空");
   	    	}else{
   	    		int result;
   	    		//时间就获取当前时间
   	    		online.setFqueryTime(new Date().toLocaleString());
   	    		online.setFcontent(fContent);
   	    		//默认设置不置顶
   	    		online.setFisTop("0"); 
   	    		
   	    		result=DaoFactory.createOnlineDAO().add(online);
   	    		if(result!=0){
   	    			ajax.setStatusCode("200");
   	    			ajax.setMessage("咨询成功，等待回复");
   	    			ajax.setCallbackType("closeCurrent");
   	    			ajax.setNavTabId("page12");
   	    		}else{
   	    			ajax.setStatusCode("300");
   	    			ajax.setMessage("咨询失败，请重新咨询");
   	    		}
   	    	}
   		return SUCCESS;
   	}
       
       /**
   	 * 找到所有已经回复的信息，在学生端上查看
   	 */
       public String findAllOut()throws Exception{
   		page=new Page();   		
   		String sql = "SELECT * FROM t_online WHERE fReply is not null ORDER BY fId DESC";
   		page.setSql(sql, pageNum, numPerPage);
   		list = DaoFactory.createOnlineDAO().findByOut("fId", "DESC", page.getStart(),page.getEnd() );
   		page.setTotalCount(list.size());
   		return SUCCESS;
   	}
       /**
        * 根据学号查询学生信息
        * @return
        */
       public String findByfNo(){
    	   String fNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
    	   student = DaoFactory.createIThesisListDao().find(fNo);
    	   return SUCCESS;
       }
       /**
        * 教师查看自己所带学生的未回复问题
        * @return
        */
       public String findByTeacherProperty(){
    	String  fTNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");  
    	page=new Page();
   		String sql = "SELECT DISTINCT * FROM  t_online where fReply is  null AND fNo in (SELECT fNo FROM t_thesislist WHERE fTid='"+fTNo+"' )";
   		page.setSql(sql, pageNum, numPerPage); 
   		list=DaoFactory.createOnlineDAO().findByTeacher(fTNo, "fId", "DESC", page.getStart(), page.getEnd());
   		//获取查询的条数显示在前台页面
   		page.setTotalCount(list.size());
   		return SUCCESS;
       }
       /**
        * 教师找到一条未回复留言进行回复
        * @return
        */
       public String findByTeacherFid(){
    	   String  fTNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
    	   fanswer = DaoFactory.createTeacherDao().find(fTNo).getFname();
    	   online = DaoFactory.createOnlineDAO().find(fid);
    	   return SUCCESS;
       }
       /**
        * 教师回复学生留言
        * @return
        */
       public String updateMessage(){
    	   
    	   String rContents=ServletActionContext.getRequest().getParameter("rContents");
	    	String mid=ServletActionContext.getRequest().getParameter("mId");
	    	ajax=new AJAX();
	    	if(rContents==null||rContents.equals("")){
	    		ajax.setStatusCode("300");
	    		ajax.setMessage("内容不能为空");
	    	}else{
	    		int result;
	    		//回复时间为当前时间
	    		online.setFreplyTime(new Date().toLocaleString());
	    		online.setFreply(rContents);
	    		result = DaoFactory.createOnlineDAO().reply(online.getFid(), online);
	    		
	    		if(result!=0){
	    			ajax.setStatusCode("200");
	    			ajax.setMessage("回复成功");
	    			ajax.setCallbackType("closeCurrent");
	    			ajax.setNavTabId("page9");
	    		}else{
	    			ajax.setStatusCode("300");
	    			ajax.setMessage("回复失败");
	    		}
	    	}
    	   return SUCCESS;
       }
       /**
        * 教师删除一条未回复的认为需要删除的留言
        * @return
        */
       public String deleteMessage(){
    	   int result=DaoFactory.createOnlineDAO().delete(fid);   		
      		ajax=new AJAX();
      		if(result!=0){
      			ajax.setStatusCode("200");
      			ajax.setMessage("删除成功");
      			ajax.setNavTabId("page9");
      			ajax.setCallbackType("");
      			
      		}else{
      			ajax.setStatusCode("300");
      			ajax.setMessage("删除失败");
      			ajax.setCallbackType("");
      		}
      		
      		return SUCCESS;
       }
       /**
        * 教师查看自己已回复的咨询问题
        * @return
        */
       public String findTeacherAllOut(){
    	   	String  fTNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");  
       		page=new Page();
      		String sql = "SELECT DISTINCT * FROM  t_online where fReply is not null AND fNo in (SELECT fNo FROM t_thesislist WHERE fTid='"+fTNo+"' )";
      		page.setSql(sql, pageNum, numPerPage); 
      		list=DaoFactory.createOnlineDAO().findByTeacherOut(fTNo, "fId", "DESC", page.getStart(), page.getEnd());
      		//获取查询的条数显示在前台页面
      		page.setTotalCount(list.size());
    	    return SUCCESS;
       }
       /**
        * 教师找到一条已经回复的咨询
        * @return
        */
       public String findByTeacherFidAlready(){
    	   String  fTNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
    	   fanswer = DaoFactory.createTeacherDao().find(fTNo).getFname();
    	   online = DaoFactory.createOnlineDAO().find(fid);
    	   return SUCCESS;
       }
       /**
        * 教师回复咨询后发现内容不合适，可以进行修改
        * @return
        */
       public String changeMessage(){
    	   
	    	   String rContents=ServletActionContext.getRequest().getParameter("rContents");
	    	   String mid=ServletActionContext.getRequest().getParameter("mId");
		    	ajax=new AJAX();
		    	if(rContents==null||rContents.equals("")){
		    		ajax.setStatusCode("300");
		    		ajax.setMessage("内容不能为空");
		    	}else{
		    		int result;
		    		//回复时间为当前时间
		    		online.setFreplyTime(new Date().toLocaleString());
		    		online.setFreply(rContents);
		    		result = DaoFactory.createOnlineDAO().reply(online.getFid(), online);
		    		
		    		if(result!=0){
		    			ajax.setStatusCode("200");
		    			ajax.setMessage("回复成功");
		    			ajax.setCallbackType("closeCurrent");
		    			ajax.setNavTabId("findTeacherAllOut");
		    		}else{
		    			ajax.setStatusCode("300");
		    			ajax.setMessage("回复失败");
		    		}
		    	}
	    	   return SUCCESS;
       }
       /**
        * 教师在已回复咨询问题中删除认为该删除的问题
        * @return
        */
       public String deleteMessageAlready(){
    	   
    	   int result=DaoFactory.createOnlineDAO().delete(fid);   		
     		ajax=new AJAX();
     		if(result!=0){
     			ajax.setStatusCode("200");
     			ajax.setMessage("删除成功");
     			ajax.setNavTabId("findTeacherAllOut");
     			ajax.setCallbackType("");
     			
     		}else{
     			ajax.setStatusCode("300");
     			ajax.setMessage("删除失败");
     			ajax.setCallbackType("");
     		}
     		
    	   return SUCCESS;
       }
}
