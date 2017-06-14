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
		  BufferedReader br = null; //���ڰ�װInputStreamReader,��ߴ������ܡ���ΪBufferedReader�л���ģ���InputStreamReaderû�С�
		  try {
		   String str = "";
		   String str1 = "";
		   fis = new FileInputStream("e:\\34.txt");// FileInputStream
		   // ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
		    isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
		    br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
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
		   System.out.println("��ȡ�ļ�ʧ��");
		
		  } finally {
		   try {
		     br.close();
		     isr.close();
		     fis.close();
		     return list;
		    // �رյ�ʱ����ð����Ⱥ�˳��ر���󿪵��ȹر������ȹ�s,�ٹ�n,����m
		   } catch (IOException e) {
		    e.printStackTrace();
		    return list;
		   }
		  }
	}
	
	
	// string����ת��Ϊdate����
    // strTimeҪת����string���͵�ʱ�䣬formatTypeҪת���ĸ�ʽyyyy-MM-dd HH:mm:ss//yyyy��MM��dd��
    // HHʱmm��ss�룬
    // strTime��ʱ���ʽ����Ҫ��formatType��ʱ���ʽ��ͬ
    public static Date stringToDate(String strTime, String formatType)
    throws Exception {
    SimpleDateFormat formatter = new SimpleDateFormat(formatType);
    Date date = null;
    date = formatter.parse(strTime);
    return date;
    }
	
	
	/** 
	 * ��ȡExcel���ԣ����� Excel 2003/2007/2010 
	 */  
	public static List<DealResult> readExcel()  
	{  
		List<DealResult> list = new ArrayList<DealResult>(50);
	    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
	    try {  
	        //ͬʱ֧��Excel 2003��2007  
	        File excelFile = new File("e:\\123.xlsx"); //�����ļ�����  
	        FileInputStream is = new FileInputStream(excelFile); //�ļ���  
	        Workbook workbook = WorkbookFactory.create(is); //���ַ�ʽ Excel 2003/2007/2010 ���ǿ��Դ����  
	        int sheetCount = workbook.getNumberOfSheets();  //Sheet������  
	        //����ÿ��Sheet  
	        for (int s = 0; s < 1; s++) {
	            Sheet sheet = workbook.getSheetAt(s);  
	            int rowCount = sheet.getPhysicalNumberOfRows(); //��ȡ������  
	            //����ÿһ��  
	            for (int r = 1; r < rowCount; r++) {  
	            	 DealResult result = new DealResult();
	                Row row = sheet.getRow(r);  
	                int cellCount = row.getPhysicalNumberOfCells(); //��ȡ������  
	                //����ÿһ��  
	                int c;
	                for ( c = 0; c < cellCount; c++) {  
	                    Cell cell = row.getCell(c);  
	                    int cellType = cell.getCellType();  
	                    String cellValue = null;  
	                    switch(cellType) {  
	                        case Cell.CELL_TYPE_STRING: //�ı�  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_NUMERIC: //���֡�����  
	                            if(DateUtil.isCellDateFormatted(cell)) {  
	                                cellValue = fmt.format(cell.getDateCellValue()); //������  
	                            }  
	                            else {  
	                                cellValue = String.valueOf(cell.getNumericCellValue()); //����  
	                            }  
	                            break;  
	                        case Cell.CELL_TYPE_BOOLEAN: //������  
	                            cellValue = String.valueOf(cell.getBooleanCellValue());  
	                            break;  
	                        case Cell.CELL_TYPE_BLANK: //�հ�  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_ERROR: //����  
	                            cellValue = "����";  
	                            break;  
	                        case Cell.CELL_TYPE_FORMULA: //��ʽ  
	                            cellValue = "����";  
	                            break;  
	                        default:  
	                            cellValue = "����";  
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
	 * ��ȡExcel���ԣ����� Excel 2003/2007/2010 
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
	        //ͬʱ֧��Excel 2003��2007  
	        File excelFile = new File("e:\\8-2.xlsx"); //�����ļ�����  
	        FileInputStream is = new FileInputStream(excelFile); //�ļ���  
	        Workbook workbook = WorkbookFactory.create(is); //���ַ�ʽ Excel 2003/2007/2010 ���ǿ��Դ����  
	        int sheetCount = workbook.getNumberOfSheets();  //Sheet������  
	        String loanId="";
	        String subType="";
	        //����ÿ��Sheet  
	        for (int s = 0; s < 1; s++) {
	            Sheet sheet = workbook.getSheetAt(s);  
	            int rowCount = sheet.getPhysicalNumberOfRows(); //��ȡ������  
	            //����ÿһ��  
	           
	            for (int r = 1; r <= rowCount; r++) {  
	            	 DealResult result = new DealResult();
	                Row row = sheet.getRow(r);  
	                int cellCount = row.getPhysicalNumberOfCells(); //��ȡ������  
	                //����ÿһ��  
	                int c;
	                for ( c = 0; c < cellCount; c++) {  
	                    Cell cell = row.getCell(c);  
	                    int cellType = cell.getCellType();  
	                    String cellValue = null;  
	                    switch(cellType) {  
	                        case Cell.CELL_TYPE_STRING: //�ı�  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_NUMERIC: //���֡�����  
	                            if(DateUtil.isCellDateFormatted(cell)) {  
	                                cellValue = fmt.format(cell.getDateCellValue()); //������  
	                            }  
	                            else {  
	                                cellValue = String.valueOf(cell.getNumericCellValue()); //����  
	                            }  
	                            break;  
	                        case Cell.CELL_TYPE_BOOLEAN: //������  
	                            cellValue = String.valueOf(cell.getBooleanCellValue());  
	                            break;  
	                        case Cell.CELL_TYPE_BLANK: //�հ�  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_ERROR: //����  
	                            cellValue = "����";  
	                            break;  
	                        case Cell.CELL_TYPE_FORMULA: //��ʽ  
	                            cellValue = "����";  
	                            break;  
	                        default:  
	                            cellValue = "����";  
	                    }  
	                    if(c==0){//loanId
	                    	loanId=cellValue.substring(0, cellValue.indexOf("."));
	                    	loanIds=loanIds+","+cellValue.substring(0, cellValue.indexOf("."));
	                    }else if(c==3){//subType
	                    	subType=cellValue;
//	                    	if(subType.equals("˽�ҳ�-��Ѻ")){
//	                    		subType="LJ_MORTGAGE_CAR";
//	                    	}else if(subType.equals("���̳���")){
//	                    		subType="LJ_ENGINEERING_TRUCK";
//	                    	}else if(subType.equals("���̳�-����")){
//	                    		subType="LJ_ENGINEERING_TRUCK_MORTGAGE";
//	                    	}else if(subType.equals("���̳�-��Ѻ")){
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
	 * ��ȡExcel���ԣ����� Excel 2003/2007/2010 
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
	        //ͬʱ֧��Excel 2003��2007  
	        File excelFile = new File("e:\\818.xlsx"); //�����ļ�����  
	        FileInputStream is = new FileInputStream(excelFile); //�ļ���  
	        Workbook workbook = WorkbookFactory.create(is); //���ַ�ʽ Excel 2003/2007/2010 ���ǿ��Դ����  
	        int sheetCount = workbook.getNumberOfSheets();  //Sheet������  
	        String investmentId="";
	        String ei="";
	        //����ÿ��Sheet  
	        for (int s = 0; s < 1; s++) {
	            Sheet sheet = workbook.getSheetAt(s);  
	            int rowCount = sheet.getPhysicalNumberOfRows(); //��ȡ������  
	            //����ÿһ��  
	           
	            for (int r = 1; r <= rowCount; r++) {  
	            	 DealResult result = new DealResult();
	                Row row = sheet.getRow(r);  
	                int cellCount = row.getPhysicalNumberOfCells(); //��ȡ������  
	                //����ÿһ��  
	                int c;
	                for ( c = 0; c < cellCount; c++) {  
	                    Cell cell = row.getCell(c);  
	                    int cellType = cell.getCellType();  
	                    String cellValue = null;  
	                    switch(cellType) {  
	                        case Cell.CELL_TYPE_STRING: //�ı�  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_NUMERIC: //���֡�����  
	                            if(DateUtil.isCellDateFormatted(cell)) {  
	                                cellValue = fmt.format(cell.getDateCellValue()); //������  
	                            }  
	                            else {  
	                                cellValue = String.valueOf(cell.getNumericCellValue()); //����  
	                            }  
	                            break;  
	                        case Cell.CELL_TYPE_BOOLEAN: //������  
	                            cellValue = String.valueOf(cell.getBooleanCellValue());  
	                            break;  
	                        case Cell.CELL_TYPE_BLANK: //�հ�  
	                            cellValue = cell.getStringCellValue();  
	                            break;  
	                        case Cell.CELL_TYPE_ERROR: //����  
	                            cellValue = "����";  
	                            break;  
	                        case Cell.CELL_TYPE_FORMULA: //��ʽ  
	                            cellValue = "����";  
	                            break;  
	                        default:  
	                            cellValue = "����";  
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
