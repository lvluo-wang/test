package spel;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSPEL {
	
	@Test  
	public void testFunctionExpression() throws SecurityException, NoSuchMethodException {  
	    ExpressionParser parser = new SpelExpressionParser();  
	    StandardEvaluationContext context = new StandardEvaluationContext();  
	    Method parseInt = Integer.class.getDeclaredMethod("parseInt", String.class);  
	    context.registerFunction("parseInt", parseInt);  
	    context.setVariable("parseInt2", parseInt);  
	    String expression1 = "#parseInt('3') == #parseInt2('3')";  
	    boolean result1 = parser.parseExpression(expression1).getValue(context, boolean.class);
	    System.out.println(result1);
	    Assert.assertEquals(true, result1);         
	}  
	
	@Test  
	public void testAssignExpression() {  
	    ExpressionParser parser = new SpelExpressionParser();  
//	    //1.给root对象赋值  
//	    EvaluationContext context = new StandardEvaluationContext("aaaa");  
//	    String result1 = parser.parseExpression("#root='aaaaa'").getValue(context, String.class);
//	    System.out.println(result1);
//	    Assert.assertEquals("aaaaa", result1);  
//	    String result2 = parser.parseExpression("#this='aaaa'").getValue(context, String.class);  
//	    Assert.assertEquals("aaaa", result2);  
//	    System.out.println(result2);
//	    //2.给自定义变量赋值  
//	    context.setVariable("#variable", "variable");  
//	    String result3 = parser.parseExpression("#variable=#root").getValue(context, String.class);  
//	    Assert.assertEquals("aaaa", result3);  
//	    System.out.println(result3);
//	    
//	    
//	  //2.修改集合值  
//	    Collection<Integer> collection = new ArrayList<Integer>();  
//	    collection.add(1);  
//	    collection.add(2);  
//	    EvaluationContext context2 = new StandardEvaluationContext();  
//	    context2.setVariable("collection", collection);  
//	    int result4 = parser.parseExpression("#collection[1] = 3").getValue(context2, int.class);  
//	    Assert.assertEquals(3, result4);  
//	    System.out.println(result4);
//	    parser.parseExpression("#collection[1]").setValue(context2, 4);  
//	    result4 = parser.parseExpression("#collection[1]").getValue(context2, int.class);  
//	    Assert.assertEquals(4, result4);  
//	    System.out.println(result4);
	    
	    
	    
	  //1.首先准备测试数据  
	    Collection<Integer> collection1 = new ArrayList<Integer>();  
	    collection1.add(4);   collection1.add(5);  
	    Map<String, String> map = new HashMap<String, String>();  
	    map.put("a", "12");  
	    map.put("b", "23"); 
	    
	  //2.测试集合或数组  
	    EvaluationContext context1 = new StandardEvaluationContext();  
	    context1.setVariable("collection", collection1);  
	    Collection<Integer> collection1result1 =  
	    parser.parseExpression("#collection.![#this+1]").getValue(context1, Collection.class);  
	    Assert.assertEquals(2, collection1result1.size());  
	    Assert.assertEquals(new Integer(5), collection1result1.iterator().next());  
	    
	    
	  //3.测试字典  
	    EvaluationContext mapcontext2 = new StandardEvaluationContext();  
	    mapcontext2.setVariable("map", map);  
	    List<String> mapresult2 =  
	    parser.parseExpression("#map.![value]").getValue(mapcontext2, List.class);  
	    Assert.assertEquals(2, mapresult2.size());  
	    
	    
	    
	    
	    
	}  

}
