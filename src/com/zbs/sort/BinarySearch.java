package com.zbs.sort;

import org.junit.Test;

/**
 * Created by zuo on 2017/6/22.
 * 二分查找算法,最大时间复杂度是,出现在第一个和最后一个
 */
public class BinarySearch {


    static int count;

    /**
     * 执行二分递归查找,返回第一次出现值得位置
     * @param arr
     * @param begin
     * @param end
     * @param findValue
     * @return
     */
    public static int searchRecursive(int arr[],int begin ,int end,int findValue){

        if(arr == null){
            return -1;
        }
        count++;
        if(begin <= end){
            //中间位置
            int mid = (begin+end) / 2;
            //中间值
            int midValue = arr[mid];

            if(findValue == midValue){
                return mid;
            }else if(findValue < midValue) {
                //小于中值时,在前面找
                return searchRecursive(arr,begin,mid-1,findValue);
            }else {
                //大于中值,在后面找
                return searchRecursive(arr,mid+1, end,findValue);
            }
        }else {
            //查找失败
            return -1;
        }
    }


    /**
     * 循环二分查找法
     * @param arr
     * @param findValue
     * @return
     */
    public static int searchLoop (int arr[] , int findValue){
        if(arr == null){
            return -1;
        }
        //开始位置
        int start = 0 ;
        //结束位置
        int end = arr.length -1;

        while (start <= end) {
            count++;

            int mid = (start+end) / 2 ;
            int midValue = arr[mid];

            if(findValue == midValue){
                return mid;
            }else if (findValue < midValue){
                end = mid-1;
            }else {
                start = mid +1;
            }
        }

        return -1;

    }



    @Test
    public void test(){
        int arr[] = new int[] {4,5,8,11,32,23,40,7,6};
        QuickSort.quickSort(arr,0,arr.length-1);
        for(int a :arr){
            System.out.print(a+"\t");
        }
        System.out.println();
        System.out.println(searchRecursive(arr,0,arr.length-1,4));
        System.out.println(count);
        count = 0;
        System.out.println(searchLoop(arr,4));
        System.out.println(count);
        count = 0;

    }

}
