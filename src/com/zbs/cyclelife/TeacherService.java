package com.zbs.cyclelife;

public class TeacherService {
	
	 private String name;
	 
	    private Integer age;
		
		
		public void setName(String name){
			System.out.println("----这是teacherservice的set方法----");
			this.name=name;
		}
		
		public TeacherService(Integer age){
			this.age=age;
		}
		

		public void init(){
			System.out.println("--------这是teacherservice的init的方法-------------");
		}
		
		public void destroy(){
			System.out.println("---------这是销毁（destroy）方法----------");
		}
		
		public void display(){
			System.out.println(this.name+"-----------------"+this.age);
		}

}
