package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class SqlModify {
	
	
	
	public static void updateSql(String loanId,int totalPeriod) throws IOException, ParseException{
//		File f=new File("e:/test1.txt");
//        f.createNewFile();
//        FileOutputStream fileOutputStream = new FileOutputStream(f);
//        PrintStream printStream = new PrintStream(fileOutputStream);
//        System.setOut(printStream);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = sdf.parse("2016-9-30 08:00:00");
		Date dueDate = sdf.parse("2016-9-30 08:00:00");;
        Calendar cd = Calendar.getInstance();
        cd.setTime(startDate);
       // cd.add(Calendar.MONTH,1);
        
        for(int i=1;i<=totalPeriod;i++){
        	 cd.add(Calendar.MONTH,1);

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dueDate);

			calendar.add(Calendar.MONTH, 1);
			int m = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);   //下月的天数
			int n = getDayOfMonth(startDate);        //起息日为当月第n天

			calendar.set(Calendar.DAY_OF_MONTH, Math.min(m, n));

			dueDate =  calendar.getTime();

        	 
    System.out.println("UPDATE T_REPAYMENT_AMORTIZATION SET REPAYMENT_DATE=TO_DATE('"+sdf.format(dueDate)+"','"+"yyyy-mm-dd,hh24:mi:ss')"
    		+ " WHERE LOAN_ID="+loanId+" AND PERIOD="+i+"; ");
        }
        
	}


	/**
	 * 计算指定日期date为当月的第n天
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static void main(String args[]){
		try {
			//updateSql("10534",24);
			updateSql("10808",24);
			//System.out.println(getDbKey("investmentId"));
//			System.out.println(new Date());
//			System.out.println(new Date().toInstant().toString());
//			Instant instant = new Date().toInstant();
//	        Random random = new Random();
//	        System.out.println(instant.getNano());
//	        String seed = Long.toHexString(random.nextInt() ^ instant.getNano());
//	        System.out.println(seed);
			
//			 if (repaymentTask != null) {                        //非第一期,根据repayment task的due date 推算
//		            lastDueDate = repaymentTask.getDueDate();
//		        }
//
//		        if (repaymentPlan.getDurationUnit() == DurationUnit.M) {
//		            Calendar calendar = Calendar.getInstance();
//		            calendar.setTime(lastDueDate);
//
//		            calendar.add(Calendar.MONTH, 1);
//		            int m = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);   //下月的天数
//		            int n = DateUtil.getDayOfMonth(repaymentPlan.getValueDate());        //起息日为当月第n天
//
//		            calendar.set(Calendar.DAY_OF_MONTH, Math.min(m, n));
//
//		            return calendar.getTime();
//		        }
//		        else {
//		            Calendar cal = Calendar.getInstance();
//		            cal.setTime(lastDueDate);
//		            cal.add(Calendar.DATE, 1);
//
//		            return cal.getTime();
//		        }
//		        
//		        /**
//		         * 计算指定日期date为当月的第n天
//		         * @param date
//		         * @return
//		         */
//		        public static int getDayOfMonth(Date date) {
//		            Calendar calendar = Calendar.getInstance();
//		            calendar.setTime(date);
//		            return calendar.get(Calendar.DAY_OF_MONTH);
//		        }
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static String getDbKey(String key) {
        return key.replaceAll("(?=[A-Z])", "_").toUpperCase();
    }

}
