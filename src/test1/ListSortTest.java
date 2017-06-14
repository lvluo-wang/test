package test1;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ListSortTest {
	
	public static List<InvestmentDetail> getInvestmentList() throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<InvestmentDetail> list = new ArrayList<InvestmentDetail>(); 
		InvestmentDetail inv1 = new InvestmentDetail();
		inv1.setAmount(new BigDecimal(1500));
		inv1.setCreateTime(dateFormat.parse("2016-7-10"));
		inv1.setDueDate(dateFormat.parse("2016-8-10"));
		InvestmentDetail inv2 = new InvestmentDetail();
		inv2.setAmount(new BigDecimal(2000));
		inv2.setCreateTime(dateFormat.parse("2016-7-11"));
		//inv2.setDueDate(dateFormat.parse("2016-9-11"));
		inv2.setDueDate(null);
		InvestmentDetail inv3 = new InvestmentDetail();
		inv3.setAmount(new BigDecimal(5000));
		inv3.setCreateTime(dateFormat.parse("2016-8-10"));
		inv3.setDueDate(dateFormat.parse("2016-7-10"));
		
		list.add(inv1);
		list.add(inv2);
		list.add(inv3);
		return list;
	}
	
	public static List<PageOrder> getPageOrder(){
		List<PageOrder> orders = new ArrayList<>();
		PageOrder order1 = new PageOrder();
		order1.setProperty("AMOUNT");
		order1.setDirection("DESC");
		PageOrder order2 = new PageOrder();
		order2.setProperty("DUE_DATE");
		order2.setDirection("DESC");
		orders.add(order1);
		orders.add(order2);
		return orders;
	}
	
	//Ͷ���б�����
    public static void sortByPageOrder(List<InvestmentDetail> list,List<PageOrder> orders) {
            for (PageOrder order : orders) {
                //Collections.sort(list, new Comparator<InvestmentDetail>() {
                    //public int compare(InvestmentDetail o1, InvestmentDetail o2) {
                    	list.sort((o1,o2)->{
                    		
                        int flag = -1;
                        if (order.getProperty().equals("AMOUNT")) {
                            //��Ͷ�ʽ������
                            if (order.getDirection() == "ASC") {
                                if (o1.getAmount().compareTo(o2.getAmount()) > 0) {
                                    flag = 1;
                                }
                            }
                            //��Ͷ�ʽ���
                            if (order.getDirection() == "DESC") {
                                if (o1.getAmount().compareTo(o2.getAmount()) < 0) {
                                    flag = 1;
                                }
                            }
                            if (o1.getAmount().compareTo(o2.getAmount()) == 0) {
                                flag = 0;
                            }
                        } else if (order.getProperty().equals("CREATE_TIME")) {
                            //��Ͷ��ʱ������
                            if (orders.get(0).getDirection() == "ASC") {
                                if (o1.getCreateTime().after(o2.getCreateTime())) {
                                    flag = 1;
                                }
                            }
                            //��Ͷ��ʱ�併��
                            if (order.getDirection() == "DESC") {
                                if (o1.getCreateTime().before(o2.getCreateTime())) {
                                    flag = 1;
                                }
                            }
                            if (o1.getCreateTime().equals(o2.getCreateTime())) {
                                flag = 0;
                            }
                        } else if (order.getProperty().equals("DUE_DATE")) {
                            //if (o1.getDueDate() != null && o2.getDueDate() != null) {
                        	
                                //Ͷ�ʵ���ʱ������
                                if (order.getDirection() == "ASC") {
                                	if (o1.getDueDate()== null) {
                                        return  -1;
                                    }
                                	if (o2.getDueDate()== null) {
                                        return  1;
                                    }
                                    if (o1.getDueDate().after(o2.getDueDate())) {
                                        flag = 1;
                                    }
                                }
                                //Ͷ�ʵ���ʱ�併��
                                if (order.getDirection() == "DESC") {
                                	if (o1.getDueDate()== null) {
                                        return  1;
                                    }
                                	if (o2.getDueDate()== null) {
                                        return  -1;
                                    }
                                    if (o1.getDueDate().before(o2.getDueDate())) {
                                        flag = 1;
                                    }
                                }
                                if (o1.getDueDate().equals(o2.getDueDate())) {
                                    flag = 0;
                                }
                            //}
                        }
                        return flag;
                    	});
                    //}
                    	
                //});
            }
        }
	
	public static void testInvestment() throws ParseException{
		List<InvestmentDetail> list = getInvestmentList();
		System.out.println("����ǰ��");
		for(InvestmentDetail investmentDetail :list){
			System.out.println(investmentDetail);
		}
		List<PageOrder> orders = getPageOrder();
		sortByPageOrder(list,orders);
		System.out.println("�����");
		for(InvestmentDetail investmentDetail :list){
			System.out.println(investmentDetail);
		}
		
	}

	    public static void main(String[] args) throws ParseException {  
	    	testInvestment();
	    	
	          
	        List<Student> list = new ArrayList<Student>();  
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = dateFormat.parse("2016-7-10");
	       
	        //����3��ѧ����������ֱ���20��19��21�������������η���List��  
	        Student s1 = new Student();  
	        s1.setAge(20);  
	        s1.setCreateTime(dateFormat.parse("2016-7-10"));
	        Student s2 = new Student();  
	        s2.setAge(19);  
	        s2.setCreateTime(dateFormat.parse("2016-8-10"));
	        Student s3 = new Student();  
	        s3.setAge(21);  
	        s3.setCreateTime(dateFormat.parse("2016-9-10"));
	     
	        list.add(s1);  
	        list.add(s2);  
	        list.add(s3);  
	          
	        //System.out.println("����ǰ��"+list);  
	        list.sort(( o1,o2) ->{
	        	if(o1.getAge() >o2.getAge()){
	        		return 1;
	        	}else{
	        		return -1;
	        	}
	        }
	        	
	        	 
	        );
	          
//	        Collections.sort(list, new Comparator<Student>(){  
//	  
//	            /*  
//	             * int compare(Student o1, Student o2) ����һ���������͵����ͣ�  
//	             * ���ظ�����ʾ��o1 С��o2��  
//	             * ����0 ��ʾ��o1��o2��ȣ�  
//	             * ����������ʾ��o1����o2��  
//	             */  
//	            public int compare(Student o1, Student o2) {  
//	            	int flag = -1;
//	              
//	                //����ѧ�������������������  
////	                if(o1.getAge() > o2.getAge()){  
////	                    return 1;  
////	                }  
////	                if(o1.getAge() == o2.getAge()){  
////	                    return 0;  
////	                }  
////	                return -1;
//	            	//����ѧ����������н�������  
////	                if(o1.getAge() < o2.getAge()){  
////	                    flag = 1;  
////	                }  
////	                if(o1.getAge() == o2.getAge()){  
////	                	flag =  0;  
////	                }  
//	            	if(o1.getCreateTime().after(o2.getCreateTime())){
//	            		flag=1;
//	            	}
//	            	if(o1.getCreateTime() == o2.getCreateTime()){
//                        flag = 0;
//                    }
//	                return flag;  
//	            }  
//	        });   
	        //System.out.println("�����"+list);  
	    }  
	}  
	class Student{  
	      
	    private int age;  
	    private Date createTime;
	    
	    
	  
	    public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public int getAge() {  
	        return age;  
	    }  
	  
	    public void setAge(int age) {  
	        this.age = age;  
	    }  
	    @Override  
	    public String toString() {  
	        return getAge()+"";  
	    }  
	}  

