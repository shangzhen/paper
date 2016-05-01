package henu.util;

import java.util.HashMap;
import java.util.List;

import henu.bean.Distribution;
import henu.factory.DaoFactory;
/**
 * 
 * 第一步：从ThesisList表中检索出来学生状态为“在校”的所有老师
 * select distinct teacher_id from tThesisList where fStatus = '0';
 * 第二步：把检索的教师列表存入数组tutor中。
 * 第三步：再声明一个数组rator中，错位分配。tutor第i个元素，分配给第length-i-1个rator中。
 * 第四步：遍历两个数组，生成一个Hashmap[key（导师），value(评阅老师)]
 * 第五步：遍历Hashmap，读key对应的学生，然后再该学号和value的值存入 tDistribution表中。
 * @author 梁胜彬
 * 2016年1月12日
 */
public class RaterGroup {

	/**
	 * 导师
	 */
	private String[] teacher;
	/**
	 * 评阅教师
	 */
	private String[] rater;
	
	private HashMap<String,String> map = new HashMap<String,String>();
	/**
	 * 分配算法方法
	 */
	public void mapping()
	{
		//获取 “应届”毕业生的指导教师，0代表 tThesisList表中 fState字段中的应届毕业生
		List<Object[]> tList = DaoFactory.createIThesisListDao().getTeacherList("0");
		//实例化指导教师数组及其长度
		teacher = new String[tList.size()];
		//实例化评阅教师数组及其长度
		rater = new String[tList.size()];
		//初始化指导教师数组
		for(int i=0;i<tList.size();i++)
		{
			Object[] obj = tList.get(i);
			teacher[i] = (String)obj[0];
		}
		//首尾交错分配评阅教师
		for(int i=0;i<teacher.length;i++)
		{
			rater[i] = teacher[teacher.length-i-1];
			map.put(teacher[i], rater[i]);
			
		}
		
		//遍历评阅教师,key对应的指导教师，value对应的是评阅教师
		for(String key:map.keySet())
		{
			//从tThesisList找到导师对应的学生清单，0代表应届毕业生
			List<Object[]> sList = DaoFactory.createIThesisListDao().getStudentList(key, "0");
			//将找到的学生名单存放到student[]中
			String[] student = new String[sList.size()];
			//遍历学生，向tDistribution表中添加记录。
			for(int i=0;i<student.length;i++)
			{
				Object[] obj =  sList.get(i);
				student[i] = (String)obj[0];
				Distribution distribution = new Distribution();
				distribution.setFtid(map.get(key));
				distribution.setFno(student[i]);
				//System.out.println(distribution);
				DaoFactory.createDistribution().add(distribution);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		RaterGroup rg = new RaterGroup();
		rg.mapping();

	}

}
