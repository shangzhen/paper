package henu.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
/**
 * 文件操作类
 * @author narey
 *
 */
public class OperateFiles {

	/**
	 * 上传文件
	 * @param files  //上传的文件内容
	 * @param filesFileName// 上传的文件名
	 * @return 返回上传文件的保存路径
	 */
	public static  String uploadFiles(File files,String filesFileName){
		BufferedInputStream bis = null ; //输入流
		BufferedOutputStream bos = null ; //输出流
		String savePath = null;//文件保存的路径
		savePath = ServletActionContext.getServletContext().getRealPath("/") ;
		System.out.println(savePath);
		try{
			savePath = savePath+"\\" +UUID.randomUUID().toString() +filesFileName ;
			bis = new BufferedInputStream(new FileInputStream(files)) ;
			bos = new BufferedOutputStream(new FileOutputStream(savePath));
			int temp = 0 ; 
			byte[] buffer = new byte[1024] ;//缓冲区间
			while((temp = bis.read(buffer))>0){
				bos.write(buffer,0,temp);
			}
		bos.flush();
		bis.close();
		bos.close();
		}catch(IOException e){
			e.printStackTrace();
		}	
		System.out.println("savepath>>>>"+savePath);
		return savePath;
	}	
}
