package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestStringToEnum {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("INNER","DEPOSIT");
		List<TransactionBizType> types= new ArrayList<>();
		list.stream().forEachOrdered(string ->{
			types.add(TransactionBizType.valueOf(string));
		});
		System.out.println(types);
		
		
	}

}
