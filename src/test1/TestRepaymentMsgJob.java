package test1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.RepaymentTask;

public class TestRepaymentMsgJob {
	
	public static void main(String[] args) {
		Integer a =1;
		System.out.println(a+1);
		Map<String, Object> amountMap = new HashMap<String, Object>();
        Map<String, Object> countMap = new HashMap<String, Object>();
        List<RepaymentTask> repaymentTaskList = new ArrayList<RepaymentTask>();
        for(int i =1;i<10;i++){
        	RepaymentTask re = new RepaymentTask();
        	re.setLoanId(i);
        	re.setPlanId(i);
        	re.setBorrowerId(1);
        	re.setMGMT_FEE_ACCRUED(new BigDecimal(i));
        	re.setINTEREST_ACCRUED(new BigDecimal(i));
        	repaymentTaskList.add(re);
        }
        for(int i =10;i<20;i++){
        	RepaymentTask re = new RepaymentTask();
        	re.setLoanId(i);
        	re.setPlanId(i);
        	re.setBorrowerId(2);
        	re.setMGMT_FEE_ACCRUED(new BigDecimal(i+100));
        	re.setINTEREST_ACCRUED(new BigDecimal(i+200));
        	repaymentTaskList.add(re);
        }
        for(int i =20;i<1000;i++){
        	RepaymentTask re = new RepaymentTask();
        	re.setLoanId(i);
        	re.setPlanId(i);
        	re.setBorrowerId(i);
        	re.setMGMT_FEE_ACCRUED(new BigDecimal(i+100));
        	re.setINTEREST_ACCRUED(new BigDecimal(i+200));
        	repaymentTaskList.add(re);
        }
        Integer loanId = null;
        Integer planId = null;
        for(RepaymentTask repaymentTask : repaymentTaskList){
            if(loanId !=null && planId !=null) {
                if (repaymentTask.getLoanId() == loanId && repaymentTask.getPlanId() == planId) {
                    continue;
                }
            }
            int borrowerId = repaymentTask.getBorrowerId();
            BigDecimal managementFee = repaymentTask.getMGMT_FEE_ACCRUED();
            BigDecimal interest = repaymentTask.getINTEREST_ACCRUED();
            BigDecimal repaymentAmount = managementFee.add(interest);
            if(amountMap.get(String.valueOf(borrowerId)) == null){
                amountMap.put(String.valueOf(borrowerId),repaymentAmount);
            }else{
                amountMap.put(String.valueOf(borrowerId),((BigDecimal)amountMap.get(String.valueOf(borrowerId))).add(repaymentAmount));
            }
            if(countMap.get(String.valueOf(borrowerId)) == null){
                countMap.put(String.valueOf(borrowerId),1);
            }else{
                countMap.put(String.valueOf(borrowerId),((int)countMap.get(String.valueOf(borrowerId)))+1);
            }
            loanId = repaymentTask.getLoanId();
            planId = repaymentTask.getPlanId();
        }
        for(String borrowerId : amountMap.keySet()){
        	System.out.println(borrowerId+"::::amount"+amountMap.get(borrowerId)+":::total"+countMap.get(borrowerId));
        }
	}

}
