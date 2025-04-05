 package common_functions_package;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
  
public class Utility_common_function {
	 
	@AfterTest
	public static void evidence_file_creator(String filename, String requestbody, String responsebody) throws IOException 
	{
		//create File (class)object to create & manupulate text file, here File is class and in that we create newfile object
		
		File newfile = new File("D:\\Software Testing\\REST ASSURED\\EvidenceFileStorage " +filename+ ".txt");
		System.out.println("A new text file is created to record request and response of API :" +newfile.getName());
		
		//for writing in created file we create Filewriter (class) object in that create datawriter object
		FileWriter datawrite = new FileWriter(newfile);
		datawrite.write("request body :" +requestbody+"\n\n");
		datawrite.write("response body :" +responsebody);
		datawrite.close();
		System.out.println("request body and response body are saved in :" +newfile.getName());
  } 
	
	//for  read excel file or test data we create one method
	public static ArrayList<String> Read_data_from_excel(String sheet_name, String testcasename) throws IOException 
	{   
		
		//create assaylist (class) object to read the file
		ArrayList<String> Array_data = new ArrayList<String>();
		
		//step-1 create the object of fileinputstream (class) for accessing the excel file & locate the excel file
		FileInputStream fis = new FileInputStream("D:\\Software Testing\\REST ASSURED\\post_Excel.xlsx");
		
		//step-2 till we find the file now we access the workbook inside the excel file
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//step-3 access or open the sheet name first we count total sheets
		int countofsheet = workbook.getNumberOfSheets();
		
		for(int i=0; i<countofsheet; i++)
		 {
			String sheetname = workbook.getSheetName(i);
			if(sheetname.equalsIgnoreCase(sheet_name)) 
			 {
			  	
		  //step-4 for accesing the sheet we store that sheet in one variable
			XSSFSheet sheet = workbook.getSheetAt(i);
			
			// for moving from first row we need Iterator class object
			Iterator<Row> rows = sheet.iterator();
			//Row r = rows.next();
			//we use while loop becoz if that, till sheet having rows with data whileloop  perform inside code 
			//for that we give condition as rows.hasNext()
			while(rows.hasNext()) {
				//if rows hasnext, then go or move next row so for moving next row we use rows.next() method
				Row row = rows.next();
				//Now we fetch the test case name and compare it
				if(row.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename)) {
					//Apply Iterator on cells Now we read the all rows data having that cell
					Iterator<Cell> cells = row.cellIterator();
					//now we read that row having cell values until that have the data
					   while(cells.hasNext()) {
					//if cells has next then move to next cell for that wo use cells.next() method   
				     Cell cellvalue = cells.next();
						String testdata = cellvalue.getStringCellValue();
						//System.out.println(testdata);
						Array_data.add(testdata);
						
					
					}
				}
				
			}
			
			}
			
	}
		workbook.close();
		return Array_data;
		
	}
	 
	
	private String kk = "kkk";
	
	 private String dd()
	{
		String kk = "dd";
		return kk;
	}
	 String kd = "kkk";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
