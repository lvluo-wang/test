package com.zbs.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Java8Tester {
	
	/**
     * 计算两个日期相差天数
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int getIntervalDays(Date fromDate, Date toDate) {
        return Period.between(fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
            toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
            .getDays();

    }
    
    
   public static void main(String args[]){
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");                
	   try {
		Date fromdate = sdf.parse("2016-08-08 12:10:12");
		 Date now = new Date();
		 System.out.println(getIntervalDays(fromdate,now));
	} catch (ParseException e) {
		e.printStackTrace();
	}  
	  
	   Date date1 = new Date(1473054281905L);
	   
	   
      Java8Tester tester = new Java8Tester();
		
      // 类型声明
      MathOperation addition = (int a, int b) -> a + b;
		
      // 不用类型声明
      MathOperation subtraction = (a, b) -> a - b;
		
      // 大括号中的返回语句
      MathOperation multiplication = (int a, int b) -> { return a * b; };
		
      // 没有大括号及返回语句
      MathOperation division = (int a, int b) -> a / b;
		
      System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
      System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
      System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
      System.out.println("10 / 5 = " + tester.operate(10, 5, division));
		
      // 不用括号
      GreetingService greetService1 = message ->
      System.out.println("Hello " + message);
		
      // 用括号
      GreetingService greetService2 = (message) ->
      System.out.println("Hello " + message);
		
      greetService1.sayMessage("Runoob");
      greetService2.sayMessage("Google");
   }
	
   interface MathOperation {
      int operation(int a, int b);
   }
	
   interface GreetingService {
      void sayMessage(String message);
   }
	
   private int operate(int a, int b, MathOperation mathOperation){
      return mathOperation.operation(a, b);
   }
}