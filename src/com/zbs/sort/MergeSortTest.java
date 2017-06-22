package com.zbs.sort;

import java.util.*;
 
public class MergeSortTest{
 
 
 
 public static void main(String[] args){
 int arr[]  = new int[]{10,9,12,4,11,7,8,3};
 Sort(arr);
 System.out.println(Arrays.toString(arr));  //����������ת��ΪString����ӡ���� 
 
 }
 
 
 
 
 
 public static void Sort(int  arr[]){
 int tmpArray[] = new int[arr.length]; //����һ����ʱ�������������ʱ��������� 
 mergeSort(arr,tmpArray, 0 ,arr.length-1); //��ʼ������鲢���� 
 
 
 }
 //�õݹ�ķ�������������й鲢����    
 private static void mergeSort(int arr[],int tmpArray[],int first ,int last){
 if(first<last){ //   ȷ�����鲻�ǿյ� 
 int mid =(first+last)/2;   //������ֳ�����  
 //�������õݹ�ķ��������Ϸָ����顣��1��2��2��4���Դ����ơ�ֱ��ÿ�����鶼ֻʣ��2��Ԫ�ء�
 mergeSort(arr,tmpArray,first,mid);
 mergeSort(arr,tmpArray,mid+1,last);
 // ������������ʱ����tmpArray[] �Էָ�����������͹鲢
 merge(arr,tmpArray,first,mid,last);
 System.out.println(Arrays.toString(arr)); 
 }
 }
 
 private static  void merge(int a[],int tmpArray[],int first,int mid,int last){
 int beginHalf1 = first; //   ��һ���������ʼԪ���±� 
 int endHalf1 = mid; //   ��һ�������ĩβԪ���±� 
 int beginHalf2 = mid+1; //   �ڶ����������ʼԪ���±� 
 int endHalf2 = last; //   �ڶ��������ĩβԪ���±� 
 int index = beginHalf1;  //   ��ʱ��������� 
 int num = last - first+1; //   ����ʱ����tmpArray���Ѿ��ź�˳���Ԫ�ؿ���������arr[]��Ҫ�Ĵ����� (����û���ź�˳���Ԫ����Ȼ�Ͳ��ø��ƹ�ȥ������arr��Щû�������Ԫ�ػ���ԭ����
 
 while((beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2)){ // ȷ�Ϸָ������������Ƿ�ȡ�������һ��Ԫ��
 if(a[beginHalf1] <= a[beginHalf2]){ //   �ֱ����������г�ȡ����Ԫ�ص�ֵ���бȽ� 
 //���Ǹ�Ԫ��ֵС���͸��Ƶ���ʱ����tmpArray��Ӧ��λ���У�Ȼ��index++��ͬʱ���Ƕ�������ȥ��һ��Ԫ��
 
 tmpArray[index++] = a[beginHalf1++];
 }
 else{
 tmpArray[index++] = a[beginHalf2++];
 
 }
 
 }
 //���������whileѭ�����ض��ж������Ԫ�ض�ȡ����,���϶�����һ��������û��ȡ��ģ�����ûȡ�⣬����ʣ�µ�Ԫ�ػ��Ѿ��������ˡ�������������whileֻ��һ����ִ�У����ǽ�ʣ�µ��Ƕ�������Ѿ��ź�˳���Ԫ�ض���������ʱ����tmpArray[]�ж�Ӧ��λ�á� 
 
 while(beginHalf1 <= endHalf1){
 tmpArray[index++] = a[beginHalf1++];
 }
 while(beginHalf2 <= endHalf2){
 tmpArray[index++] = a[beginHalf2++];
 }
 //   ����ʱ����tmpArray[]�е��Ѿ��ź�˳���Ԫ��ȫ��������ԭ��������arr[]��
 for(int i = 0 ; i < num ;i++,endHalf2--){
 a[endHalf2] = tmpArray[endHalf2];
 }
 
 
 }
 
}