package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public final class ReadExcel {
	
	public static void main(String[] args) throws IOException {
		//String a = "10012.0";
		//readExcel();
		//readTxt();
		readExcel2();
//		String str = "loanId=10001";
//		System.out.println(str.indexOf("loanId="));
//		System.out.println(str.substring(str.indexOf("loanId="),str.length()));
//		if(str.indexOf("loanId=")>=0){
//			 String[] loanIds = str.split("=");
//			 System.out.println(loanIds[1]);
//		}
	}
	
	public static List<DealResult> readTxt(){
		List<DealResult> list = new ArrayList<DealResult>(50);
		 FileInputStream fis = null;
		 InputStreamReader isr = null;
		  BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
		  try {
		   String str = "";
		   String str1 = "";
		   fis = new FileInputStream("e:\\34.txt");// FileInputStream
		   // 从文件系统中的某个文件中获取字节
		    isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
		    br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
		    int i=0;
		   while ((str = br.readLine()) != null) {
			   i++;
		    String[] arr = str.split("	");
		    DealResult result = new DealResult();
		    result.setLoanId(arr[0]);
		    result.setPlanId((arr[1]));
		    result.setAmount(new BigDecimal(arr[2]));
		    Date valueDate = stringToDate(arr[3],"yyyy-MM-dd");
    		result.setValueDate(valueDate);
		    list.add(result);
		   }
		   System.out.flush();
		   System.out.println(i);
		  }  catch (IOException e) {
		   System.out.println("读取文件失败");
		
		  } finally {
		   try {
		     br.close();
		     isr.close();
		     fis.close();
		     return list;
		    // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
		   } catch (IOException e) {
		    e.printStackTrace();
		    return list;
		   }
		  }
	}
	
	
	// string类型转换为date类型
    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public static Date stringToDate(String strTime, String formatType)
    throws Exception {
    SimpleDateFormat formatter = new SimpleDateFormat(formatType);
    Date date = null;
    date = formatter.parse(strTime);
    return date;
    }
	
	
	/** 
	 * 读取Excel测试，兼容 Excel 2003/2007/2010 
	 */  
	public static List<DealResult> readExcel()  
	{  
		List<DealResult> list = new ArrayList<DealResult>(50);
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
	    try {  
	        //同时支持Excel 2003、2007  
	        File excelFile = new File("e:\\123.xlsx"); //创建文件对象  
	        FileInputStream is = new FileInputStream(excelFile); //文件流  
	        Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的  
	        int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量  
	        //遍历每个Sheet  
	        for (int s = 0; s < 1; s++) {
	            Sheet sheet = workbook.getSheetAt(s);  
	            int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数  
	            //遍历每一行  
	            for (int r = 1; r < rowCount; r++) {  
	            	 DealResult result = new DealResult();
	                Row row = sheet.getRow(r);  
	                int cellCount = row.getPhysicalNumberOfCells(); //获取总列数  
	                //遍历每一列  
	                int c;
	                for ( c = 0; c < cellCount; c++) {  
	                    Cell cell = row.getCell(c);  
	                    int cellType = cell.getCellType();  
	                    String cellValue = null;  
	                    switch(cellType) {  
	                        case Cell.CELL_TYPE_STRING: //文本  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_NUMERIC: //数字、日期  
	                            if(DateUtil.isCellDateFormatted(cell)) {  
	                                cellValue = fmt.format(cell.getDateCellValue()); //日期型  
	                            }  
	                            else {  
	                                cellValue = String.valueOf(cell.getNumericCellValue()); //数字  
	                            }  
	                            break;  
	                        case Cell.CELL_TYPE_BOOLEAN: //布尔型  
	                            cellValue = String.valueOf(cell.getBooleanCellValue());  
	                            break;  
	                        case Cell.CELL_TYPE_BLANK: //空白  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_ERROR: //错误  
	                            cellValue = "错误";  
	                            break;  
	                        case Cell.CELL_TYPE_FORMULA: //公式  
	                            cellValue = "错误";  
	                            break;  
	                        default:  
	                            cellValue = "错误";  
	                    }  
	                    System.out.print(cellValue + "    ");  
	                    if(c==0){//loanId
	                    	result.setLoanId((cellValue));
	                    }else if(c==1){//planId
	                    	result.setPlanId((cellValue));
	                    }else if(c==2){//amount
	                    	result.setAmount(new BigDecimal(cellValue));
	                    }else if(c==3){//date
	                    	 Date valueDate = stringToDate(cellValue,"yyyy-MM-dd");
	                    	result.setValueDate(valueDate);
	                    }
	                }  
	                list.add(result);
	                System.out.println();  
	            }  
	        }  
	    }  
	    catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    return list;

}
	
	
	/** 
	 * 读取Excel测试，兼容 Excel 2003/2007/2010 
	 * @throws IOException 
	 */  
	public static List<DealResult> readExcel1() throws IOException  
	{  
		File f=new File("e:/2016-8-2.sql");
        f.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        PrintStream printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);
        
		List<DealResult> list = new ArrayList<DealResult>(50);
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd"); 
	    String loanIds="";
	    try {  
	        //同时支持Excel 2003、2007  
	        File excelFile = new File("e:\\8-2.xlsx"); //创建文件对象  
	        FileInputStream is = new FileInputStream(excelFile); //文件流  
	        Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的  
	        int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量  
	        String loanId="";
	        String subType="";
	        //遍历每个Sheet  
	        for (int s = 0; s < 1; s++) {
	            Sheet sheet = workbook.getSheetAt(s);  
	            int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数  
	            //遍历每一行  
	           
	            for (int r = 1; r <= rowCount; r++) {  
	            	 DealResult result = new DealResult();
	                Row row = sheet.getRow(r);  
	                int cellCount = row.getPhysicalNumberOfCells(); //获取总列数  
	                //遍历每一列  
	                int c;
	                for ( c = 0; c < cellCount; c++) {  
	                    Cell cell = row.getCell(c);  
	                    int cellType = cell.getCellType();  
	                    String cellValue = null;  
	                    switch(cellType) {  
	                        case Cell.CELL_TYPE_STRING: //文本  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_NUMERIC: //数字、日期  
	                            if(DateUtil.isCellDateFormatted(cell)) {  
	                                cellValue = fmt.format(cell.getDateCellValue()); //日期型  
	                            }  
	                            else {  
	                                cellValue = String.valueOf(cell.getNumericCellValue()); //数字  
	                            }  
	                            break;  
	                        case Cell.CELL_TYPE_BOOLEAN: //布尔型  
	                            cellValue = String.valueOf(cell.getBooleanCellValue());  
	                            break;  
	                        case Cell.CELL_TYPE_BLANK: //空白  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_ERROR: //错误  
	                            cellValue = "错误";  
	                            break;  
	                        case Cell.CELL_TYPE_FORMULA: //公式  
	                            cellValue = "错误";  
	                            break;  
	                        default:  
	                            cellValue = "错误";  
	                    }  
	                    if(c==0){//loanId
	                    	loanId=cellValue.substring(0, cellValue.indexOf("."));
	                    	loanIds=loanIds+","+cellValue.substring(0, cellValue.indexOf("."));
	                    }else if(c==3){//subType
	                    	subType=cellValue;
//	                    	if(subType.equals("私家车-质押")){
//	                    		subType="LJ_MORTGAGE_CAR";
//	                    	}else if(subType.equals("工程车贷")){
//	                    		subType="LJ_ENGINEERING_TRUCK";
//	                    	}else if(subType.equals("工程车-按揭")){
//	                    		subType="LJ_ENGINEERING_TRUCK_MORTGAGE";
//	                    	}else if(subType.equals("工程车-抵押")){
//	                    		subType="LJ_ENGINEERING_TRUCK_MORTGAGING";
//	                    	}
	                    }
	                }  
	                System.out.println("INSERT INTO T_LOAN_DETAIL (LOAN_ID,FROM_DISTRICT) VALUES ("+loanId+",'"+subType+"');");  
	            } 
	        }  
	    }  
	    catch (Exception e) {
	    	//System.out.println("select * from lvjinsuo.T_LOAN_DETAIL where loan_id in("+loanIds+")");
	        e.printStackTrace();  
	    }  
	    return list;

}
	
	/** 
	 * 读取Excel测试，兼容 Excel 2003/2007/2010 
	 * @throws IOException 
	 */  
	public static List<DealResult> readExcel2() throws IOException  
	{  
		File f=new File("e:/2016-8-18.sql");
        f.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        PrintStream printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);
        
		List<DealResult> list = new ArrayList<DealResult>(50);
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd"); 
	    String loanIds="";
	    try {  
	        //同时支持Excel 2003、2007  
	        File excelFile = new File("e:\\818.xlsx"); //创建文件对象  
	        FileInputStream is = new FileInputStream(excelFile); //文件流  
	        Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的  
	        int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量  
	        String investmentId="";
	        String ei="";
	        //遍历每个Sheet  
	        for (int s = 0; s < 1; s++) {
	            Sheet sheet = workbook.getSheetAt(s);  
	            int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数  
	            //遍历每一行  
	           
	            for (int r = 1; r <= rowCount; r++) {  
	            	 DealResult result = new DealResult();
	                Row row = sheet.getRow(r);  
	                int cellCount = row.getPhysicalNumberOfCells(); //获取总列数  
	                //遍历每一列  
	                int c;
	                for ( c = 0; c < cellCount; c++) {  
	                    Cell cell = row.getCell(c);  
	                    int cellType = cell.getCellType();  
	                    String cellValue = null;  
	                    switch(cellType) {  
	                        case Cell.CELL_TYPE_STRING: //文本  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_NUMERIC: //数字、日期  
	                            if(DateUtil.isCellDateFormatted(cell)) {  
	                                cellValue = fmt.format(cell.getDateCellValue()); //日期型  
	                            }  
	                            else {  
	                                cellValue = String.valueOf(cell.getNumericCellValue()); //数字  
	                            }  
	                            break;  
	                        case Cell.CELL_TYPE_BOOLEAN: //布尔型  
	                            cellValue = String.valueOf(cell.getBooleanCellValue());  
	                            break;  
	                        case Cell.CELL_TYPE_BLANK: //空白  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_ERROR: //错误  
	                            cellValue = "错误";  
	                            break;  
	                        case Cell.CELL_TYPE_FORMULA: //公式  
	                            cellValue = "错误";  
	                            break;  
	                        default:  
	                            cellValue = "错误";  
	                    }  
	                    if(c==0){//loanId
	                    	investmentId=cellValue.substring(0, cellValue.indexOf("."));
	                    	loanIds=loanIds+","+cellValue.substring(0, cellValue.indexOf("."));
	                    }else if(c==5){//subType
	                    	ei=cellValue;
	                    }
	                }  
	                
	                System.out.println("UPDATE T_INVESTMENT SET EXPECT_INTEREST="+ei+",LAST_UPDATE_TIME=SYSDATE WHERE INVESTMENT_ID="+investmentId+";");  
	            } 
	        }  
	    }  
	    catch (Exception e) {
	    	//System.out.println("select * from lvjinsuo.T_LOAN_DETAIL where loan_id in("+loanIds+")");
	        e.printStackTrace();  
	    }  
	    return list;

}
	
}
