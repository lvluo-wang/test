package com.zbs.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestJson {

	public static void main(String[] args) {
		System.out.println(Math.ceil(833.33));
	
		List<String> tokenList = new ArrayList<>();
		tokenList.add("123");
		tokenList.add("456");
		String strs = tokenList.stream().collect(Collectors.joining(","));
		System.out.println(tokenList.toString());
		System.out.println(strs);
		
        //JsonObject��JsonArray�������JsonObject�Ƕ�����ʽ��JsonArray��������ʽ
        //����JsonObject��һ�ַ���
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("UserName", "ZHULI");
        jsonObject.put("age", "30");
        jsonObject.put("workIn", "ALI");
        System.out.println("jsonObject1��" + jsonObject);
        
        //����JsonObject�ڶ��ַ���
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("UserName", "ZHULI");
        hashMap.put("age", "30");
        hashMap.put("workIn", "ALI");
        System.out.println("jsonObject2��" + JSONObject.fromObject(hashMap));
        
        //����һ��JsonArray����1
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0, "ZHULI");
        jsonArray.add(1, "30");
        jsonArray.add(2, "ALI");
        System.out.println("jsonArray1��" + jsonArray);
        
        //����JsonArray����2
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("ZHULI");
        arrayList.add("30");
        arrayList.add("ALI");
        System.out.println("jsonArray2��" + JSONArray.fromObject(arrayList));
        
        //���JSONArray����һ��HashMap����Ὣ��������ķŽ�һ�������ֵ��
        System.out.println("jsonArray FROM HASHMAP��" + JSONArray.fromObject(hashMap));
        
        //��װһ�����ӵ�JSONArray
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("UserName", "ZHULI");
        jsonObject2.put("age", "30");
        jsonObject2.put("workIn", "ALI");
        jsonObject2.element("Array", arrayList);
        System.out.println("jsonObject2��" + jsonObject2);
                
    }
}
