package com.zbs.sort;

import java.util.*;
 
public class MergeSortTest{
 
 
 
 public static void main(String[] args){
 int arr[]  = new int[]{10,9,12,4,11,7,8,3};
 Sort(arr);
 System.out.println(Arrays.toString(arr));  //将整型数组转换为String，打印出来 
 
 }
 
 
 
 
 
 public static void Sort(int  arr[]){
 int tmpArray[] = new int[arr.length]; //创建一个临时的数组来存放临时排序的数组 
 mergeSort(arr,tmpArray, 0 ,arr.length-1); //开始对数组归并排序 
 
 
 }
 //用递归的方法，对数组进行归并排序    
 private static void mergeSort(int arr[],int tmpArray[],int first ,int last){
 if(first<last){ //   确定数组不是空的 
 int mid =(first+last)/2;   //将数组分成两段  
 //下面是用递归的方法，不断分割数组。即1分2，2分4，以此类推。直到每个数组都只剩下2个元素。
 mergeSort(arr,tmpArray,first,mid);
 mergeSort(arr,tmpArray,mid+1,last);
 // 下面是利用临时数组tmpArray[] 对分割后的数组排序和归并
 merge(arr,tmpArray,first,mid,last);
 System.out.println(Arrays.toString(arr)); 
 }
 }
 
 private static  void merge(int a[],int tmpArray[],int first,int mid,int last){
 int beginHalf1 = first; //   第一段数组的起始元素下标 
 int endHalf1 = mid; //   第一段数组的末尾元素下表 
 int beginHalf2 = mid+1; //   第二段数组的起始元素下标 
 int endHalf2 = last; //   第二段数组的末尾元素下标 
 int index = beginHalf1;  //   临时数组的索引 
 int num = last - first+1; //   将临时数组tmpArray中已经排好顺序的元素拷贝到数组arr[]需要的次数， (其中没有排好顺序的元素自然就不用复制过去，所以arr那些没有排序的元素还是原样。
 
 while((beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2)){ // 确认分割后的两段数组是否都取到了最后一个元素
 if(a[beginHalf1] <= a[beginHalf2]){ //   分别到两段数组中抽取两个元素的值进行比较 
 //哪那个元素值小，就复制到临时数组tmpArray对应的位置中，然后index++，同时将那段数组再去下一个元素
 
 tmpArray[index++] = a[beginHalf1++];
 }
 else{
 tmpArray[index++] = a[beginHalf2++];
 
 }
 
 }
 //经过上面的while循环，必定有段数组的元素都取光了,即肯定还有一段数组是没有取光的，不但没取光，而且剩下的元素还已经排完序了。所以下面两个while只有一个会执行，就是将剩下的那段数组的已经排好顺序的元素都拷贝到临时数组tmpArray[]中对应的位置。 
 
 while(beginHalf1 <= endHalf1){
 tmpArray[index++] = a[beginHalf1++];
 }
 while(beginHalf2 <= endHalf2){
 tmpArray[index++] = a[beginHalf2++];
 }
 //   将临时数组tmpArray[]中的已经排好顺序的元素全都拷贝到原来的数组arr[]中
 for(int i = 0 ; i < num ;i++,endHalf2--){
 a[endHalf2] = tmpArray[endHalf2];
 }
 
 
 }
 
}