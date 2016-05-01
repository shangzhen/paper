package henu.service;

import henu.bean.Teacher;
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

public class ImportExcel {

	public static int readUser(String filepath) {
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
				Teacher tea = new Teacher();
				tea.setFtid(getValue(hssfRow.getCell(0)));
				tea.setFname(getValue(hssfRow.getCell(1)));
				tea.setFdepartment(getValue(hssfRow.getCell(2)));
				tea.setFposition(getValue(hssfRow.getCell(3)));
				tea.setFphone(getValue(hssfRow.getCell(4)));
				tea.setFemail(getValue(hssfRow.getCell(5)));
				tea.setFqq(getValue(hssfRow.getCell(6)));
				tea.setFqgno(getValue(hssfRow.getCell(7)));
				tea.setFtype(getValue(hssfRow.getCell(9)));
				tea.setFcollege(getValue(hssfRow.getCell(10)));
				tea.setFmemo(getValue(hssfRow.getCell(11)));
				tea.setFpsw(getValue(hssfRow.getCell(0)));
				int result = DaoFactory.createTeacherDao().add(tea);
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

	

}
