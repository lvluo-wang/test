package com.zbs.cyclelife;

public class TeacherService {
	
	 private String name;
	 
	    private Integer age;
		
		
		public void setName(String name){
			System.out.println("----����teacherservice��set����----");
			this.name=name;
		}
		
		public TeacherService(Integer age){
			this.age=age;
		}
		

		public void init(){
			System.out.println("--------����teacherservice��init�ķ���-------------");
		}
		
		public void destroy(){
			System.out.println("---------�������٣�destroy������----------");
		}
		
		public void display(){
			System.out.println(this.name+"-----------------"+this.age);
		}

}
