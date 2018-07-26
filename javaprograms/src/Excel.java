import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testngpgm.BasePage;


public class Excel extends BasePage
{	
	
	public static final String EXCELFILELOCATION="./Book1.xlsx";
		private static FileInputStream fis;
		private static XSSFWorkbook wb;
		private static XSSFSheet sheet;
		private static XSSFRow row;
		
		public static void loadfile() throws Throwable
		{
			System.out.println("loading excel data");
			File file=new File(EXCELFILELOCATION);
			fis=new FileInputStream(file);
			wb=new XSSFWorkbook(fis);
			sheet=wb.getSheet("TestData");
			fis.close();
			
			
		}
		public static Map<String, Map<String,String>> getDataMap() throws Throwable
		{
			if(sheet==null)
			{
			loadfile();	
			}
			
			
			
		
		Map<String, Map<String,String>> supermap=new HashMap<String, Map<String,String>>();
		Map<String,String> mymap=new HashMap<String,String>();
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			row=sheet.getRow(i);
			String keycell=row.getCell(0).getStringCellValue();
			
			int colnum=row.getLastCellNum();
			for(int j=0;j<colnum;j++)
			{
				String value=row.getCell(j).getStringCellValue();
				mymap.put(keycell, value);
				
			}
			supermap.put("MASTERDATA ",mymap);
			}
			return supermap;
		}
		

		public static String getValue(String key) throws Throwable
		{
			Map<String,String> myval=getDataMap().get("MASTERDATA");
			String retvalue=myval.get(key);
			return retvalue;
		}
		private static Map<String, Map<String,String>> getDataMap1()
		{
			return null;
		}
		public static void main(String args[]) throws Throwable
		{
		System.out.println(getValue("projecturl"));	
		System.out.println(getValue("username"));
		System.out.println(getValue("pass"));
		}
}

