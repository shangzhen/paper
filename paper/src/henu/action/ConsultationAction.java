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
 * @author ������
 * @function ������ѯ
 * 
 */
public class ConsultationAction extends ActionSupport {

	// ��ҳ��ѯ
	Page page;
	private int pageNum = 1;
	private int numPerPage = 10;

	// ����
	private String property;
	private String key;

	// ����һ��List<Online>���͵ı������ڴ�Ų�ѯ���ļ�¼�Ĵ��
	private List<Online> list;
	
	//��ѯ��Ϣ������
	private int fid;
	
	//����һ��Online�������ڽ���
	private Online online;
	
	//����һ��ThesisList������ǰ̨������Ϣ
	private ThesisList student;
	
	AJAX ajax;
	
	//����һ��fanswer������Ž�ʦ����
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
	 * ѧ���˸���session�е�ѧ�Ų鿴�Լ�����ѯ���
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
   	 * ѧ���ڹ���Աδ�ظ�ǰ�Լ�ɾ����
   	 */
   	public String delete()throws Exception{   		
   		int result=DaoFactory.createOnlineDAO().delete(fid);   		
   		ajax=new AJAX();
   		if(result!=0){
   			ajax.setStatusCode("200");
   			ajax.setMessage("ɾ���ɹ�");
   			ajax.setNavTabId("page12");
   			ajax.setCallbackType("");
   			
   		}else{
   			ajax.setStatusCode("300");
   			ajax.setMessage("ɾ��ʧ��");
   			ajax.setCallbackType("");
   		}
   		
   		return SUCCESS;
   	}

   	
    /**
   	 * ѧ��ѯ��һ����Ϣ
   	 */
       public String add()throws Exception{
   	    	String fContent=ServletActionContext.getRequest().getParameter("fContent");
   	    	ajax=new AJAX();
   	    	//��ѯ���ݲ���Ϊ��
   	    	if(fContent==null||fContent.equals("")){
   	    		ajax.setStatusCode("300");
   				ajax.setMessage("���ݲ���Ϊ��");
   	    	}else{
   	    		int result;
   	    		//ʱ��ͻ�ȡ��ǰʱ��
   	    		online.setFqueryTime(new Date().toLocaleString());
   	    		online.setFcontent(fContent);
   	    		//Ĭ�����ò��ö�
   	    		online.setFisTop("0"); 
   	    		
   	    		result=DaoFactory.createOnlineDAO().add(online);
   	    		if(result!=0){
   	    			ajax.setStatusCode("200");
   	    			ajax.setMessage("��ѯ�ɹ����ȴ��ظ�");
   	    			ajax.setCallbackType("closeCurrent");
   	    			ajax.setNavTabId("page12");
   	    		}else{
   	    			ajax.setStatusCode("300");
   	    			ajax.setMessage("��ѯʧ�ܣ���������ѯ");
   	    		}
   	    	}
   		return SUCCESS;
   	}
       
       /**
   	 * �ҵ������Ѿ��ظ�����Ϣ����ѧ�����ϲ鿴
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
        * ����ѧ�Ų�ѯѧ����Ϣ
        * @return
        */
       public String findByfNo(){
    	   String fNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
    	   student = DaoFactory.createIThesisListDao().find(fNo);
    	   return SUCCESS;
       }
       /**
        * ��ʦ�鿴�Լ�����ѧ����δ�ظ�����
        * @return
        */
       public String findByTeacherProperty(){
    	String  fTNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");  
    	page=new Page();
   		String sql = "SELECT DISTINCT * FROM  t_online where fReply is  null AND fNo in (SELECT fNo FROM t_thesislist WHERE fTid='"+fTNo+"' )";
   		page.setSql(sql, pageNum, numPerPage); 
   		list=DaoFactory.createOnlineDAO().findByTeacher(fTNo, "fId", "DESC", page.getStart(), page.getEnd());
   		//��ȡ��ѯ��������ʾ��ǰ̨ҳ��
   		page.setTotalCount(list.size());
   		return SUCCESS;
       }
       /**
        * ��ʦ�ҵ�һ��δ�ظ����Խ��лظ�
        * @return
        */
       public String findByTeacherFid(){
    	   String  fTNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
    	   fanswer = DaoFactory.createTeacherDao().find(fTNo).getFname();
    	   online = DaoFactory.createOnlineDAO().find(fid);
    	   return SUCCESS;
       }
       /**
        * ��ʦ�ظ�ѧ������
        * @return
        */
       public String updateMessage(){
    	   
    	   String rContents=ServletActionContext.getRequest().getParameter("rContents");
	    	String mid=ServletActionContext.getRequest().getParameter("mId");
	    	ajax=new AJAX();
	    	if(rContents==null||rContents.equals("")){
	    		ajax.setStatusCode("300");
	    		ajax.setMessage("���ݲ���Ϊ��");
	    	}else{
	    		int result;
	    		//�ظ�ʱ��Ϊ��ǰʱ��
	    		online.setFreplyTime(new Date().toLocaleString());
	    		online.setFreply(rContents);
	    		result = DaoFactory.createOnlineDAO().reply(online.getFid(), online);
	    		
	    		if(result!=0){
	    			ajax.setStatusCode("200");
	    			ajax.setMessage("�ظ��ɹ�");
	    			ajax.setCallbackType("closeCurrent");
	    			ajax.setNavTabId("page9");
	    		}else{
	    			ajax.setStatusCode("300");
	    			ajax.setMessage("�ظ�ʧ��");
	    		}
	    	}
    	   return SUCCESS;
       }
       /**
        * ��ʦɾ��һ��δ�ظ�����Ϊ��Ҫɾ��������
        * @return
        */
       public String deleteMessage(){
    	   int result=DaoFactory.createOnlineDAO().delete(fid);   		
      		ajax=new AJAX();
      		if(result!=0){
      			ajax.setStatusCode("200");
      			ajax.setMessage("ɾ���ɹ�");
      			ajax.setNavTabId("page9");
      			ajax.setCallbackType("");
      			
      		}else{
      			ajax.setStatusCode("300");
      			ajax.setMessage("ɾ��ʧ��");
      			ajax.setCallbackType("");
      		}
      		
      		return SUCCESS;
       }
       /**
        * ��ʦ�鿴�Լ��ѻظ�����ѯ����
        * @return
        */
       public String findTeacherAllOut(){
    	   	String  fTNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");  
       		page=new Page();
      		String sql = "SELECT DISTINCT * FROM  t_online where fReply is not null AND fNo in (SELECT fNo FROM t_thesislist WHERE fTid='"+fTNo+"' )";
      		page.setSql(sql, pageNum, numPerPage); 
      		list=DaoFactory.createOnlineDAO().findByTeacherOut(fTNo, "fId", "DESC", page.getStart(), page.getEnd());
      		//��ȡ��ѯ��������ʾ��ǰ̨ҳ��
      		page.setTotalCount(list.size());
    	    return SUCCESS;
       }
       /**
        * ��ʦ�ҵ�һ���Ѿ��ظ�����ѯ
        * @return
        */
       public String findByTeacherFidAlready(){
    	   String  fTNo = (String)ServletActionContext.getRequest().getSession().getAttribute("user");
    	   fanswer = DaoFactory.createTeacherDao().find(fTNo).getFname();
    	   online = DaoFactory.createOnlineDAO().find(fid);
    	   return SUCCESS;
       }
       /**
        * ��ʦ�ظ���ѯ�������ݲ����ʣ����Խ����޸�
        * @return
        */
       public String changeMessage(){
    	   
	    	   String rContents=ServletActionContext.getRequest().getParameter("rContents");
	    	   String mid=ServletActionContext.getRequest().getParameter("mId");
		    	ajax=new AJAX();
		    	if(rContents==null||rContents.equals("")){
		    		ajax.setStatusCode("300");
		    		ajax.setMessage("���ݲ���Ϊ��");
		    	}else{
		    		int result;
		    		//�ظ�ʱ��Ϊ��ǰʱ��
		    		online.setFreplyTime(new Date().toLocaleString());
		    		online.setFreply(rContents);
		    		result = DaoFactory.createOnlineDAO().reply(online.getFid(), online);
		    		
		    		if(result!=0){
		    			ajax.setStatusCode("200");
		    			ajax.setMessage("�ظ��ɹ�");
		    			ajax.setCallbackType("closeCurrent");
		    			ajax.setNavTabId("findTeacherAllOut");
		    		}else{
		    			ajax.setStatusCode("300");
		    			ajax.setMessage("�ظ�ʧ��");
		    		}
		    	}
	    	   return SUCCESS;
       }
       /**
        * ��ʦ���ѻظ���ѯ������ɾ����Ϊ��ɾ��������
        * @return
        */
       public String deleteMessageAlready(){
    	   
    	   int result=DaoFactory.createOnlineDAO().delete(fid);   		
     		ajax=new AJAX();
     		if(result!=0){
     			ajax.setStatusCode("200");
     			ajax.setMessage("ɾ���ɹ�");
     			ajax.setNavTabId("findTeacherAllOut");
     			ajax.setCallbackType("");
     			
     		}else{
     			ajax.setStatusCode("300");
     			ajax.setMessage("ɾ��ʧ��");
     			ajax.setCallbackType("");
     		}
     		
    	   return SUCCESS;
       }
}
