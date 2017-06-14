package com.zbs.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class FunctionDemo {
	
	public static void m(String t,Predicate<String> p, Supplier<String> producer) {  
	    if (p.test(t)) {  
	        System.out.println("ok"); 
	        String string = producer.get();
	        System.out.println(string);
	    }  
	}  
	public  boolean check(String check){
		if(check.equals("aab")){
			return true;
		}
		return false;
	}
	
	public String  getStr(){
		return "test";
	}
	public  void test2(){  
		m("aab",this::check,this::getStr);  
	}  
	public static void main(String[] args) {
		FunctionDemo demo = new FunctionDemo();
		demo.test2();
		List<String> list=new ArrayList<String>();
		  list.add("保护环境");     //向列表中添加数据
//		  list.add("爱护地球");     //向列表中添加数据
//		  list.add("从我做起");        //向列表中添加数据
//		  list.add(1,"从我做起");     //在第1+1个元素的位置添加数据
		  //通过循环输出列表中的内容
		  for(int i=0;i<list.size();i++){
		   System.out.println(i+":"+list.get(i));
		  }
		  String regIds = list.stream()
	                .collect(Collectors.joining(","));
		  System.out.println(regIds);
	}
}
