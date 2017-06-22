package com.zbs.sort;

import java.util.LinkedList;
import java.util.List;  
  
  
public class Qpl {  
  
    public static void main(String[] args) {  
        // TODO �Զ����ɵķ������  
  
        List<String> data = new LinkedList<String>();  
        data.add("1");  
        data.add("2");  
        data.add("3");  
        data.add("4");  
          
        List<List<String>> result = pl(data);  
        for(int i=0;i<result.size();i++){  
            System.out.println(result.get(i));  
        }  
    }  
  
    /** 
     * �õ�ȫ���еķ��� 
     * @param data  ���Ҫ���еĸ���Ԫ�� 
     * @return List<List<String>> ����е�ÿһ��List����һ�ֿ��ܵ����� 
     */  
    public static List<List<String>> pl(List<String> data){  
          
        if(data.size()==1){  
            // ���data��ֻ��һ��Ԫ�أ���ôֱ�ӵõ�����ȫ����  
            List<List<String>>  result= new LinkedList<List<String>>();  
            List<String> p = new LinkedList<>();  
            p.add(data.get(0));  
            result.add(p);  
            return result;  
        }else{  
            // ����ȥ����һ��Ԫ�أ�Ȼ��õ�ʣ�µ� n-1 ��Ԫ�ص�ȫ���У���һ��Ԫ�ز��뵽ÿһ�������е���Ӧλ���ϾͿ��Եõ�����Ԫ�ص�ȫ������  
            // Ҳ����˵�� n-1 ��Ԫ�ص�ȫ�����е�ÿһ�������ֿ��������� n ������  
            String first = data.get(0);  
            List<String> remainList = data.subList(1, data.size());  
            List<List<String>> remainPl = pl(remainList);  
              
            List<List<String>>  result= new LinkedList<List<String>>();  
            for(int i=0;i<remainPl.size();i++){  
                  
                List<String> thisOne = remainPl.get(i);         
                for(int j=0;j<=thisOne.size();j++){  
                      
                     List<String> copyOne = new LinkedList<>(thisOne);  
                     copyOne.add(j,first);  
                     result.add(copyOne);  
                }  
            }  
            return result;  
        }  
    }  
}  