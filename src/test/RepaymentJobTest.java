package test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepaymentJobTest {
	
	/**
     * 
     * @param date1 <String>
     * @param date2 <String>
     * @return int
     * @throws ParseException
     */
    public static int getMonthSpace(String date1, String date2)
            throws ParseException {

        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result);

    }

	
	public static void main(String[] args) throws ParseException {
		
		 System.out.println(RepaymentJobTest.getMonthSpace("2016-1-31", "2016-2-1"));
		
		Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);       //ÈÕ
        int month = cal.get(Calendar.MONTH) + 1;//ÔÂ
        int year = cal.get(Calendar.YEAR);      //Äê

        System.out.println("Date: " + cal.getTime());
        System.out.println("Day: " + day);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
        
		Map<String,Object> map1 = new HashMap<String,Object>();
		Object a = map1.get("111");
		if(map1.get("111")==null){
			
		}
		List<RepaymentTask> list  = new ArrayList<RepaymentTask>();
		RepaymentTask rt1 = new RepaymentTask();
		rt1.setPlanId(11);
		rt1.setLoanId(1000);
		rt1.setINTEREST_ACCRUED(new BigDecimal(100));
		rt1.setMGMT_FEE_ACCRUED(new BigDecimal(200));
		list.add(rt1);
		
		RepaymentTask rt2 = new RepaymentTask();
		rt2.setPlanId(11);
		rt2.setLoanId(1000);
		rt2.setINTEREST_ACCRUED(new BigDecimal(111));
		rt2.setMGMT_FEE_ACCRUED(new BigDecimal(222));
		list.add(rt2);
		
		RepaymentTask rt3 = new RepaymentTask();
		rt3.setPlanId(22);
		rt3.setLoanId(1002);
		rt3.setINTEREST_ACCRUED(new BigDecimal(10));
		rt3.setMGMT_FEE_ACCRUED(new BigDecimal(20));
		list.add(rt3);
		RepaymentTask rt4 = new RepaymentTask();
		rt4.setPlanId(33);
		rt4.setLoanId(1003);
		rt4.setINTEREST_ACCRUED(new BigDecimal(11));
		rt4.setMGMT_FEE_ACCRUED(new BigDecimal(22));
		list.add(rt4);
		
		RepaymentTask rt5 = new RepaymentTask();
		rt5.setPlanId(44);
		rt5.setLoanId(1004);
		rt5.setINTEREST_ACCRUED(new BigDecimal(1));
		rt5.setMGMT_FEE_ACCRUED(new BigDecimal(2));
		list.add(rt5);
		
		 Integer loanId = null;
		 Integer planId = null;
		for(RepaymentTask re : list){
			if(loanId!=null && planId !=null){
				if(re.getLoanId() == loanId && re.getPlanId() == planId){
					continue;
				}
			}
			System.out.println("===loanId="+loanId+"===planId="+planId);
			loanId = re.getLoanId();
            planId = re.getPlanId();
		}
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> countmap = new HashMap<String,Object>();
		for(RepaymentTask re :list){
			BigDecimal amount = map.get(""+re.getBorrowerId()) == null?BigDecimal.ZERO :(BigDecimal)map.get(""+re.getBorrowerId());
			map.put(""+re.getBorrowerId(), amount.add(re.getINTEREST_ACCRUED()).add(re.getMGMT_FEE_ACCRUED()));
		}
		System.out.println(map.toString());
		for(String borrower:map.keySet()){
		for(RepaymentTask re :list){
				if(borrower.equals(""+re.getBorrowerId())){
					Object count = countmap.get(""+re.getBorrowerId()) == null?0 :countmap.get(""+re.getBorrowerId());
					countmap.put(borrower,(int)count+1);
				}
			}
		}
		System.out.println(countmap.toString());
		List<RepaymentTask> list1  = new ArrayList<RepaymentTask>();
		for(int i=0;i<4;i++){
			RepaymentTask re = new RepaymentTask();
			re.setBorrowerId(1000);
			re.setLoanId(555);
			list1.add(re);
		}
		System.out.println(list1);
	}
	
}
