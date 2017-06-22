package com.zbs.sort;

import java.util.LinkedList;
import java.util.List;  
  
  
public class Qpl {  
  
    public static void main(String[] args) {  
        // TODO 自动生成的方法存根  
  
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
     * 得到全排列的方法 
     * @param data  存放要排列的各个元素 
     * @return List<List<String>> 结果中的每一个List就是一种可能的排列 
     */  
    public static List<List<String>> pl(List<String> data){  
          
        if(data.size()==1){  
            // 如果data中只有一个元素，那么直接得到它的全排列  
            List<List<String>>  result= new LinkedList<List<String>>();  
            List<String> p = new LinkedList<>();  
            p.add(data.get(0));  
            result.add(p);  
            return result;  
        }else{  
            // 否则，去除第一个元素，然后得到剩下的 n-1 个元素的全排列，第一个元素插入到每一种排列中的相应位置上就可以得到所有元素的全排列了  
            // 也就是说， n-1 个元素的全排列中的每一种排列又可以衍生出 n 种排列  
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