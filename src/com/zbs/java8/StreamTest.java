package com.zbs.java8;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.itextpdf.awt.geom.misc.RenderingHints.Key;

public class StreamTest {
	
	
	 public static String timeBasedRandomContractNo() {
	        LocalDateTime current = LocalDateTime.now();
	        String time = current.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
	        String random = new DecimalFormat("00").format(new Random().nextInt(100));
	        //check值 所有数字相加后 mod 7 余 1
	        int sum = 0;
	        for (char c : (time + random).toCharArray()) {
	            sum += c - '0';
	        }
	        int check = (8 - (sum % 7)) % 7;
	        return "L" + time + random + check;
	    }
	
	 public static void testmap(String key){
		 System.out.println(key);
	 }
	
	public static void main(String[] args) {
		Map<String, String> testmap = new HashMap<>();
		testmap.put("1", "1111");
		testmap.put("2", "222");
		Stream.of(new String[]{"1","2"}).forEachOrdered(key ->{
			testmap(key);
		});
		
		List<String> strlistList = new ArrayList<>();
		System.out.println(strlistList.isEmpty());
		timeBasedRandomContractNo();
		
		System.out.println(new Random().nextInt(100));
		
		List<Map<String, String>> listmap = new ArrayList<Map<String,String>>();
		Map<String, String> m1 = new HashMap<>();
		m1.put("22", "2222222222");
		listmap.add(m1);
		listmap.stream().map(m ->{
			m.put("111", m.get("22"));
			m.remove("22");
			return m;
		}
		).collect(Collectors.toList());		
		
		
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println(filtered);
		
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("合并字符串: " + mergedString);
		
		
		List<String> stringsCount = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		stringsCount.stream();
		// 获取空字符串的数量
		long count = stringsCount.stream().filter(string -> string.isEmpty()).count();
		System.out.println(count);
		
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// 获取对应的平方数
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		System.out.println(squaresList);
		
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("列表中最大的数 : " + stats.getMax());
		System.out.println("列表中最小的数 : " + stats.getMin());
		System.out.println("所有数之和 : " + stats.getSum());
		System.out.println("平均数 : " + stats.getAverage());
		
		
		
		
		
		
		/**
		 *  summary.setNextRepaymentDate(Stream.of(schedules)
                .map(RepaymentSchedule::getRepaymentDate)
                .filter(rd -> rd.toInstant().isAfter(now))
                .min(Date::compareTo)
                .orElse(null));
                
                
                List<HashMap> infoList = JsonUtil.toList(info, HashMap.class);
            infoList.stream()
                .filter(m -> m.get("name").toString().equals("车牌号") || m.get("name").toString().equals("车架号") || m.get("name").toString().equals("发动机号"))
                .forEachOrdered(m -> {
                    String toMaskStr = m.get("value").toString();
                    if (toMaskStr.length() >= 4) {
                        m.put("value", toMaskStr.replaceAll("\\b(\\S{2}).+(\\S)", "$1***$2"));
                    }
                });
                
                
                requestMap.entrySet()
                .stream()
                .filter(e -> !Strings.isNullOrEmpty(e.getValue()))
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));
                
                
                TreeMap<String, String> newMap = new TreeMap<>();
        signedMap.entrySet().stream().filter(entry -> !Objects.equals(signKey, entry.getKey())).forEach(
            entry -> newMap.put(entry.getKey(), entry.getValue())
        );
        
        
        
        Map<Date, HolidaySetting> settings = mapper.findDays(start, end)
                                                    .stream()
                                                    .collect(Collectors.toMap(s -> s.getDay(), Function.identity()));
                                                    
           Map<String, DataSourceInfo> targetMap = dataSourceInfoList
            .stream()
            .filter(t -> t.getId().equals(id))
            .collect(Collectors.toMap(DataSourceInfo::getRegion, s -> s));
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		
		
		
		
	}

}
