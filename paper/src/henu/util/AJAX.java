package henu.util;

public class AJAX {
	private String statusCode="200";
	private String message="�ɹ�";
	private String navTabId;
	private String rel;
	private String callbackType="closeCurrent";
	private String forwardUrl;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNavTabId() {
		return navTabId;
	}
	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getCallbackType() {
		return callbackType;
	}
	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}
	public String getForwardUrl() {
		return forwardUrl;
	}
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}
	public AJAX(String statusCode, String message, String navTabId, String rel,
			String callbackType, String forwardUrl) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.navTabId = navTabId;
		this.rel = rel;
		this.callbackType = callbackType;
		this.forwardUrl = forwardUrl;
	}
	public AJAX(){};
	public static void ajax(AJAX ajax,int result,String message,String navTabId,String callback){
		if(result ==1){
			ajax.setStatusCode("200");
			ajax.setMessage("成功"+message);
			ajax.setNavTabId(navTabId);
			ajax.setCallbackType(callback);
			ajax.setRel("");
			ajax.setForwardUrl("");
		}else{
			ajax.setStatusCode("300");
			ajax.setMessage(message+"失败"+"（可能添加或导入表时数据重复）");
			ajax.setNavTabId(navTabId);
			ajax.setCallbackType(callback);
			ajax.setRel("");
			ajax.setForwardUrl("");
		}
	}

}
