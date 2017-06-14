package com.zbs.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class testTime {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = format.parse("2015-06-10");
		Date toDate = format.parse("2016-09-07");
		System.out.println(getIntervalDays(fromDate, toDate));
		System.out.println(getIntervalDays2(fromDate, toDate));
		System.out.println(getIntervalDays3(fromDate, toDate));
	}
	
	
	/**
     * 计算两个日期相差天数
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int getIntervalDays(Date fromDate, Date toDate) {
    	    Instant instant = fromDate.toInstant();
    	    ZoneId zone = ZoneId.systemDefault();
    	    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
    	    LocalDate localDate = localDateTime.toLocalDate();
    	    Instant instant1 = toDate.toInstant();
    	    ZoneId zone1 = ZoneId.systemDefault();
    	    LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant1, zone1);
    	    LocalDate localDate2 = localDateTime1.toLocalDate();
    	    
    	    Instant instantto1 = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
    	    Instant instantto2 = localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant();

    	    System.out.println(instant);
    	    System.out.println(instant1);
    	    
    	    System.out.println(instantto1);
    	    System.out.println(instantto2);
    	    
    	    System.out.println(Duration.between(instant, instant1).toDays());
    	    System.out.println(Duration.between(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant(), localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant()).toDays());
    	    
    	    return 1;
//    	    return (int)Duration.between(fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//    	            toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
//    	            .toDays();
    	    
//        return Period.between(fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//            toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
//            .getDays();

    }
    
    
    /**
     * 计算两个日期相差天数
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int getIntervalDays2(Date fromDate, Date toDate) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(fromDate);

        int day1 = calendar.get(Calendar.DAY_OF_YEAR);

        calendar.setTime(toDate);

        int day2 = calendar.get(Calendar.DAY_OF_YEAR);

        return day2 - day1;

    }
    
    public static int getIntervalDays3(Date fDate, Date oDate) {

        if (null == fDate || null == oDate) {

            return -1;

        }

        long intervalMilli = oDate.getTime() - fDate.getTime();

        return (int) (intervalMilli / (24 * 60 * 60 * 1000));

     }
}
