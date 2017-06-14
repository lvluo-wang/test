package test1;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Strings;
import com.itextpdf.awt.geom.misc.RenderingHints.Key;

public class Test {
	public static void test1(Object s){
	
		//System.out.println(s.toString().equals(""));
		//System.out.println(Strings.isNullOrEmpty("dd"));
		//System.out.println(new BigDecimal(-100).negate());
		
	}
	
	/** 
	 * 传入Data类型日期，返回字符串类型时间（ISO8601标准时间） 
	 * @param date 
	 * @return 
	 */  
	public static String getISO8601Timestamp(Date date){  
	    TimeZone tz = TimeZone.getTimeZone("UTC");  
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+08:00");  
	    df.setTimeZone(tz);  
	    String nowAsISO = df.format(date);  
	    return nowAsISO;  
	}  
	
	/**
     * 计算两个日期相差天数
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int getIntervalDays(Date fromDate, Date toDate) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(fromDate);

        int day1 = calendar.get(Calendar.DAY_OF_YEAR);

        calendar.setTime(toDate);

        int day2 = calendar.get(Calendar.DAY_OF_YEAR);

        return day2 - day1;

    }
	
	public static void main(String[] args) {
		
		
		
		System.out.println(getISO8601Timestamp(new Date()));
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fromDate=dateFormat.parse("2016-6-25");
			Date toDate = new Date();
			System.out.println(getIntervalDays(fromDate,toDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<String> list  = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(list.get(list.size()-1));
		test1("aa");
//		Parent p = new Parent();
//		if(p instanceof Son){
//			System.out.println("===");
//		}
//		
//		//test(null);
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("investing", null);
//		Object o = map.get("investing");
//		if(o==null){
//			System.out.println("null");
//		}
		 String transactionTypeStr = null;
		 System.out.println(transactionTypeStr==null);
		
		StringBuffer queryStatusStr = new StringBuffer();
		System.out.println(queryStatusStr.toString().equals(""));
		System.out.println(StringUtils.isEmpty(queryStatusStr));
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("2", "");
		Object o2 = map.get("2");
		
		System.out.println(o2!=null);
		map.put("1", queryStatusStr);
		Object o = map.get("1");
		System.out.println(o.toString().equals("1"));
		
		ExperienceGoldStatus[] sts = {ExperienceGoldStatus.ACTIVE,ExperienceGoldStatus.NEW};
		for(ExperienceGoldStatus s : sts){
			System.out.println(s.name());
		}
		 StringBuffer statusSql = new StringBuffer();
         for(ExperienceGoldStatus st :sts){
             statusSql.append("'").append(st.name()).append("',");
         }
         statusSql.deleteCharAt(statusSql.length()-1);
         System.out.println(statusSql.toString());
	}
	
	public static void test(Object t){
		if((Boolean)t){
			System.out.println("true");
		}else if(!(Boolean)t){
			System.out.println("false");
		}else{
			System.out.println("null");
		}
	}
	
	public static void foreachMap(){
		List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();
		Map<String,Integer> map = new HashMap<>();
		map.put("t1_repayment", 10);
		Map<String,Integer> map2 = new HashMap<>();
		map2.put("t1_deposit", 10);
		list.add(map);
		list.add(map2);
		int count=0;
		for(Map<String,Integer> m : list){
			
			
		}
	}

}
