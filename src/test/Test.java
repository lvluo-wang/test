package test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zbs.cyclelife.TeacherService;

public class Test {

	
//	public static void main(String[] args) {
//		 //Pattern pattern = Pattern.compile("lvjinsuoapp\/(\\d+(\\.\\d+){2})");
//		 String s="lvjinsuoapp\\/(\\d+(\\.\\d)+)";
//		 
//		 Matcher matcher = Pattern.compile("lvjinsuoapp\\/(\\d+(\\.\\d+){1,2})")
//                 .matcher("lvjinsuoapp/1.3.4.5");
//		 
////		 Matcher matcher = Pattern.compile("lvjinsuoapp[0-9]+([.]{1}[0-9]+){0,1}$")
////              .matcher("lvjinsuoapp1.4");
//		 System.out.println(matcher.matches());
//		 System.out.println("/");
//		 System.out.println(-1<=0);
//	}
	
	@org.junit.Test
	public void test1(){
		
		/**��������*/
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		/**����getbean����*/
		TeacherService ts = (TeacherService) ac.getBean("teacherService");
		
		
		ts.display();
		
		/**����close�����ر�bean*/
		AbstractApplicationContext aac =(AbstractApplicationContext) ac;
		aac.close();
		
	}
	
	@org.junit.Test
	public void test2(){
		String str = "jufx_";
		String str2="jufx_";
		System.out.println(str.startsWith(str2));
		String strarr[] ={"a","b","c"};
		for(String a :strarr){
			if(a.equals("a")){
				continue;
			}
			System.out.println(a);
		}
		
		
		String bizId = TransactionBizType.CONSULTANT.getBizId();
		System.out.println(bizId);
//		String key= "car.market.default.title";
//		int a =  key.indexOf(".default");
//		key = key.substring(0, key.indexOf(".default"));
//		System.out.println(key);
		
//		String value="test1:����1;test2:����2;";
//		String values[] = value.split(";");
//		for(String vl :values){
//			System.out.println(vl);
//			
//		}
//		//(\\d+(\\.\\d+){1,2})
//		String match ="([a-z]+(\\.[a-z]+)){0,3}";
//		Matcher matcher = Pattern.compile(match)
//            .matcher("lvjinsuoapp.a.a");
//		System.out.println(matcher.matches());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(new Date()));
		
		  	Date now = new Date();
	        LocalDateTime current = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	       Date fromdate = getFromDate(current);
	       System.out.println(format.format(fromdate));
	       Date todate = getToDate(current);
	       System.out.println(format.format(todate));
	       String type = LoanIconType.BIG.toString();
	       System.out.println(type);
	       String size=null;
	       String lastsize = size==null ?type :size;
	       System.out.println(lastsize);
	}
	
	/**
     * due_date��ʼʱ��
     * @param current
     * @return due_date+3���0��
     */
    private Date getFromDate(LocalDateTime current) {
        return Date.from(current
            .plusDays(3)
            .withHour(0)
            .withMinute(0)
            .withSecond(0)
            .atZone(ZoneId.systemDefault())
            .toInstant());
    }

    /**
     * due_date��ֹʱ��
     * @param current
     * @return ��4��0��
     */
    private Date getToDate(LocalDateTime current) {
        return Date.from(current
            .plusDays(15)
            .withHour(0)
            .withMinute(0)
            .withSecond(0)
            .atZone(ZoneId.systemDefault())
            .toInstant());
    }
	
    @org.junit.Test
    public void test3(){
    	register("11111",null);
    }
    
    public static void register(String mobile,HttpServletResponse res){
    	System.out.println(mobile);
    }
	
}
