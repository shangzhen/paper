package henu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import com.mysql.jdbc.log.Log;

public class LSFUtils {
	//date yyyy-mm-dd
	
	public static int getBetweenTime(String date){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     try {
			long m = sdf.parse(date).getTime()-System.currentTimeMillis();
			if(m<=0){
				return -1;
			}else{
				return (int) ((m/(1000 * 60 * 60 * 24))+1);
			}
		} catch (ParseException e) {
			System.out.println("错误：时间格式应该为yyyy-mm-dd！");
			e.printStackTrace();
		}
		return 0;
	}
}
