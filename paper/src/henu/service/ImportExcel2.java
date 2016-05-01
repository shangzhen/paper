package henu.service;

import henu.bean.Distribution;
import henu.bean.Review;
import henu.bean.Score;
import henu.bean.Student;
import henu.bean.Thesis;
import henu.bean.ThesisList;
import henu.factory.DaoFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ImportExcel2 {
/**
 * 导入t_thesisList
 * @param filepath
 * @return
 */
	public static int readUser1(String filepath) {
		int count = 0;
		InputStream is = null;
		HSSFWorkbook hssfWorkbook = null;
		try {
			is = new FileInputStream(filepath);
			hssfWorkbook = new HSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
		
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {

				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}
	
				ThesisList t = new ThesisList();
				t.setFno(getValue(hssfRow.getCell(0)));
				t.setFsName(getValue(hssfRow.getCell(1)));
				t.setFprofessional(getValue(hssfRow.getCell(2)));
				t.setFtid(getValue(hssfRow.getCell(3)));
				t.setFtName(getValue(hssfRow.getCell(4)));
				t.setFstate("0");
				
				int result = DaoFactory.createIThesisListDao().add(t);
				if (result > 0) {
					count++;
				}
			}
		}
		
		
		return count;
	}


	private static String getValue(HSSFCell hssfCell) {
		if (hssfCell == null)
			return "Null";
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			
			NumberFormat df = new DecimalFormat("#0");
			return df.format(hssfCell.getNumericCellValue());
		} else {
			
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

	
	public static String doString(String Str) {
		int lIndex = Str.lastIndexOf(".");
		if (lIndex == -1)
			return Str;
		Str = Str.substring(0, Str.lastIndexOf("."));

		return Str;

	}

	/**
	 * 导入t_score
	 * @param filepath
	 * @return
	 */
	public static int readUser2(String filepath) {
		int count = 0;
		InputStream is = null;
		HSSFWorkbook hssfWorkbook = null;
		try {
			is = new FileInputStream(filepath);
			hssfWorkbook = new HSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		for (int numSheet1 = 0; numSheet1 < hssfWorkbook.getNumberOfSheets(); numSheet1++) {
			HSSFSheet hssfSheet1 = hssfWorkbook.getSheetAt(numSheet1);
			if (hssfSheet1 == null) {
				continue;
			}
		
			for (int rowNum = 1; rowNum <= hssfSheet1.getLastRowNum(); rowNum++) {
	
				HSSFRow hssfRow = hssfSheet1.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}
				Score s = new Score();
				s.setFno(getValue(hssfRow.getCell(0)));
				s.setFname(getValue(hssfRow.getCell(1)));
				s.setFmajor(getValue(hssfRow.getCell(2)));
				s.setFtutorName(getValue(hssfRow.getCell(4)));
				int result = DaoFactory.createScoreDao().add(s);
				if (result > 0) {
					count++;
				}
			}
		}
		return count;
		}
	/**
	 * 导入t_thesis
	 * @param filepath
	 * @return
	 */
	public static int readUser3(String filepath) {
		int count = 0;
		InputStream is = null;
		HSSFWorkbook hssfWorkbook = null;
		try {
			is = new FileInputStream(filepath);
			hssfWorkbook = new HSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		for (int numSheet1 = 0; numSheet1 < hssfWorkbook.getNumberOfSheets(); numSheet1++) {
			HSSFSheet hssfSheet1 = hssfWorkbook.getSheetAt(numSheet1);
			if (hssfSheet1 == null) {
				continue;
			}
		
			for (int rowNum = 1; rowNum <= hssfSheet1.getLastRowNum(); rowNum++) {
	
				HSSFRow hssfRow = hssfSheet1.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}
				Thesis t = new Thesis();
				t.setfNo(getValue(hssfRow.getCell(0)));
				t.setfTid(getValue(hssfRow.getCell(3)));
				t.setfEvaluate("0");
				t.setfFinalDraft("0");
				t.setfMidCheck("0");
				t.setfRepeat("0");
				t.setfScore("0");
				t.setfSenceRep("0");
				t.setfTask("0");
				t.setfThePro("0");
			    

				int result = DaoFactory.createIThesisDao().add(t);
				if (result > 0) {
					count++;
				}
			}
		}
		return count;
		}
	
	/**
	 * 导入t_review
	 * @param filepath
	 * @return
	 */
	public static int readUser4(String filepath) {
		int count = 0;
		InputStream is = null;
		HSSFWorkbook hssfWorkbook = null;
		try {
			is = new FileInputStream(filepath);
			hssfWorkbook = new HSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		for (int numSheet1 = 0; numSheet1 < hssfWorkbook.getNumberOfSheets(); numSheet1++) {
			HSSFSheet hssfSheet1 = hssfWorkbook.getSheetAt(numSheet1);
			if (hssfSheet1 == null) {
				continue;
			}
		
			for (int rowNum = 1; rowNum <= hssfSheet1.getLastRowNum(); rowNum++) {
	
				HSSFRow hssfRow = hssfSheet1.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}
				Review r = new Review();
				r.setFno(getValue(hssfRow.getCell(0)));

				int result = DaoFactory.createReviewDao().add(r);
				if (result > 0) {
					count++;
				}
			}
		}
		return count;
		}
	
	/**
	 * 
	 * 学生名单导入
	 * @param filepath
	 * @return
	 */
	public static int readUser5(String filepath) {
		int count = 0;
		InputStream is = null;
		HSSFWorkbook hssfWorkbook = null;
		try {
			is = new FileInputStream(filepath);
			hssfWorkbook = new HSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
		
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {

				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}
	
				Student s = new Student();
				s.setFno(getValue(hssfRow.getCell(0)));
				s.setFsname(getValue(hssfRow.getCell(1)));
				s.setFmarjor(getValue(hssfRow.getCell(2)));
				s.setFgreade(getValue(hssfRow.getCell(3)));
				s.setFplace(getValue(hssfRow.getCell(4)));
				s.setFclass(getValue(hssfRow.getCell(5)));
				s.setFcnmae(getValue(hssfRow.getCell(6)));
				s.setFcid(getValue(hssfRow.getCell(7)));
				s.setFphone(getValue(hssfRow.getCell(8)));
				s.setFemail(getValue(hssfRow.getCell(9)));
				s.setFqq(getValue(hssfRow.getCell(10)));
				s.setFtranning(getValue(hssfRow.getCell(11)));
				s.setFwork(getValue(hssfRow.getCell(12)));
				s.setFstate(getValue(hssfRow.getCell(13)));
				
				
				
				int result = DaoFactory.createIStudentDao().add(s);
				if (result > 0) {
					count++;
				}
			}
		}
		
		
		return count;
	}
	}

