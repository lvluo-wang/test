package com.zbs.sort;

import org.junit.Test;

/**
 * Created by zuo on 2017/6/22.
 * ���ֲ����㷨,���ʱ�临�Ӷ���,�����ڵ�һ�������һ��
 */
public class BinarySearch {


    static int count;

    /**
     * ִ�ж��ֵݹ����,���ص�һ�γ���ֵ��λ��
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
            //�м�λ��
            int mid = (begin+end) / 2;
            //�м�ֵ
            int midValue = arr[mid];

            if(findValue == midValue){
                return mid;
            }else if(findValue < midValue) {
                //С����ֵʱ,��ǰ����
                return searchRecursive(arr,begin,mid-1,findValue);
            }else {
                //������ֵ,�ں�����
                return searchRecursive(arr,mid+1, end,findValue);
            }
        }else {
            //����ʧ��
            return -1;
        }
    }


    /**
     * ѭ�����ֲ��ҷ�
     * @param arr
     * @param findValue
     * @return
     */
    public static int searchLoop (int arr[] , int findValue){
        if(arr == null){
            return -1;
        }
        //��ʼλ��
        int start = 0 ;
        //����λ��
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
