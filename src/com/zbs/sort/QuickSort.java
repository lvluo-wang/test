package com.zbs.sort;

import org.junit.Test;

/**
 * Created by zuo on 2017/6/22.
 * ����
 */
public class QuickSort {

    public  static void quickSort(int arr[],int begin,int end){
        if(arr == null){
            return;
        }
        if(arr.length == 1){
            return;
        }
        if(begin < end) {
            //�����һ����ʼ�Ƚ�ֵ
            int x = arr[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                //���������ҵ���һ����xС��ֵ
                while (i < j && arr[j] >= x) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                //���������ҵ���һ����x���ֵ
                while (i < j && arr[i] < x) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = x;

            quickSort(arr, begin, i - 1);
            quickSort(arr, i + 1, end);
        }
    }

    @Test
    public  void test (){
        int arr[] = new int[] {4,5,8,7,32,4,6,7,6};
        quickSort(arr,0,arr.length-1);
        for(int a :arr){
            System.out.print(a+"\t");
        }
    }
}
