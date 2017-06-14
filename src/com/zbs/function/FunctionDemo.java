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
		  list.add("��������");     //���б����������
//		  list.add("��������");     //���б����������
//		  list.add("��������");        //���б����������
//		  list.add(1,"��������");     //�ڵ�1+1��Ԫ�ص�λ���������
		  //ͨ��ѭ������б��е�����
		  for(int i=0;i<list.size();i++){
		   System.out.println(i+":"+list.get(i));
		  }
		  String regIds = list.stream()
	                .collect(Collectors.joining(","));
		  System.out.println(regIds);
	}
}
