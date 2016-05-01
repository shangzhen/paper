package henu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Page {
	private int totalCount=0;
	private int pageNum=1;//当前第几页
	private int numPerPage=10;//每页显示多少条
	private int pageNumShown;//总共显示多少页
	private int start=1;//
	private int end=10;
	private int startPage;  //记住jsp页面显示的起始页码
	private int endPage;  //记往jsp页面显示的结束页码
	//由于多表查询所以万能查询方法如下
		public void setSql(String sql,int pageNum,int numPerPage){
			this.pageNum=pageNum;
			this.numPerPage=numPerPage;
			this.totalCount=this.getTotalDataBySql(sql);
			int flag=this.totalCount%this.numPerPage;
			if(flag==0){
				this.pageNumShown=this.totalCount/this.numPerPage;
			}else{
				this.pageNumShown=this.totalCount/this.numPerPage+1;
			}
			
			this.start = (this.pageNum-1)*this.numPerPage;
			this.end=this.start+this.numPerPage;
			
			//根据用户想看的页pagenum，算出jsp页面的起始和结束页码
					if(this.pageNumShown<=10){
						this.startPage = 1;
						this.endPage = this.pageNumShown;
					}else{
						//20   18
						this.startPage = this.pageNum -4;
						this.endPage = this.pageNum + 5;
						
						if(this.startPage<1){
							this.startPage = 1;
							this.endPage = 10;
						}
						
						if(this.endPage > this.pageNumShown){
							this.endPage = this.pageNumShown;
							this.startPage = this.pageNumShown-9;
						}
						
						
					}
		}
		public int getTotalDataBySql(String sql) {
			// TODO Auto-generated method stub
			int num=0;
			try {
				Connection conn=Dbcp.getConnection();
				PreparedStatement st=conn.prepareStatement(sql);
				ResultSet rs=st.executeQuery();
				if(rs.next()){
					num=rs.getInt(1);
				}
				if(rs!=null){
					try{
						rs.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
					rs = null;

				}
				if(st!=null){
					try{
						st.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(conn!=null){
					try{
						conn.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return num;
		}
	public void setProperties(String table,int pageNum,int numPerPage,String property,String key){
		this.pageNum=pageNum;
		this.numPerPage=numPerPage;
		this.totalCount=this.getTotalData(table,property,key);
		int flag=this.totalCount%this.numPerPage;
		if(flag==0){
			this.pageNumShown=this.totalCount/this.numPerPage;
		}else{
			this.pageNumShown=this.totalCount/this.numPerPage+1;
		}
		
		this.start = (this.pageNum-1)*this.numPerPage;
		this.end=this.start+this.numPerPage;
		
		//根据用户想看的页pagenum，算出jsp页面的起始和结束页码
				if(this.pageNumShown<=10){
					this.startPage = 1;
					this.endPage = this.pageNumShown;
				}else{
					//20   18
					this.startPage = this.pageNum -4;
					this.endPage = this.pageNum + 5;
					
					if(this.startPage<1){
						this.startPage = 1;
						this.endPage = 10;
					}
					
					if(this.endPage > this.pageNumShown){
						this.endPage = this.pageNumShown;
						this.startPage = this.pageNumShown-9;
					}
					
					
				}
	}
	public void setProperties1(String table,int pageNum,int numPerPage,String property,String key,String property1,String key1){
		this.pageNum=pageNum;
		this.numPerPage=numPerPage;
		this.totalCount=this.getTotalData1(table,property,key,property1,key1);
		int flag=this.totalCount%this.numPerPage;
		if(flag==0){
			this.pageNumShown=this.totalCount/this.numPerPage;
		}else{
			this.pageNumShown=this.totalCount/this.numPerPage+1;
		}
		
		this.start = (this.pageNum-1)*this.numPerPage;
		this.end=this.start+this.numPerPage;
		
		//根据用户想看的页pagenum，算出jsp页面的起始和结束页码
				if(this.pageNumShown<=10){
					this.startPage = 1;
					this.endPage = this.pageNumShown;
				}else{
					//20   18
					this.startPage = this.pageNum -4;
					this.endPage = this.pageNum + 5;
					
					if(this.startPage<1){
						this.startPage = 1;
						this.endPage = 10;
					}
					
					if(this.endPage > this.pageNumShown){
						this.endPage = this.pageNumShown;
						this.startPage = this.pageNumShown-9;
					}
					
					
				}
	}
	public int getTotalData(String table,String property,String key){
		int num=0;
		try {
			Connection conn=Dbcp.getConnection();
			String sql="select count(*) from "+table+" where "+property+"='"+key+"'";
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			if(rs.next()){
				num=rs.getInt(1);
			}
			if(rs!=null){
				try{
					rs.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				rs = null;

			}
			if(st!=null){
				try{
					st.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try{
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}
	public int getTotalData1(String table,String property,String key,String property1,String key1){
		int num=0;
		try {
			Connection conn=Dbcp.getConnection();
			String sql="select count(*) from "+table+" where "+property+"='"+key+"' and "+property1+"='"+key1+"'";
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			if(rs.next()){
				num=rs.getInt(1);
			}
			if(rs!=null){
				try{
					rs.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				rs = null;

			}
			if(st!=null){
				try{
					st.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try{
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
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
	public int getPageNumShown() {
		return pageNumShown;
	}
	public void setPageNumShown(int pageNumShown) {
		this.pageNumShown = pageNumShown;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
}
