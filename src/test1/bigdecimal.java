package test1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hamcrest.core.IsEqual;

public class bigdecimal {
	
	public static void main(String[] args) {
		 Map<Long, AccountUpdateData> maps = new TreeMap<>();
		 System.out.println(addToAccount(maps, 1004L, new BigDecimal(100)));
		 
		 while(true && !test1()){
			 try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		
	}
	public static boolean test1(){
		System.out.println("test1");
		List<String> list  = new ArrayList<String>();
		list.add("task1");
		list.add("task2");
		list.add("task3");
		if(list ==null){
			list.add("noGroupTask1");
			list.add("noGroupTask2");
			list.add("noGroupTask3");
		}
		if(list ==null){
			return true;
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
			list.remove(i);
		}
		return false;
	}
	
	public static boolean test2(){
		System.out.println("test2");
		List<String> list  = new ArrayList<String>();
		if(list ==null){
			return true;
		}
		for(String str:list){
			System.out.println(str);
		}
		return false;
	}

	private static BigDecimal addToAccount(Map<Long, AccountUpdateData> dataTreeMap, Long acctId, BigDecimal amount) {
        //给账户增减余额
        AccountUpdateData updateData = dataTreeMap.get(acctId);
        if (updateData == null) {
            //初始化新账号数据
            updateData = new AccountUpdateData();
            updateData.setAcctId(acctId);
            updateData.setDelta(BigDecimal.ZERO);
            updateData.setMinimum(BigDecimal.ZERO);
            dataTreeMap.put(acctId, updateData);
        }
        BigDecimal oldBalance = updateData.delta;
        //更新账户变化。
        updateData.delta = updateData.delta.add(amount);
        //记录账号变化过程中最小的余额；
        //这一个额度加上真实账户的余额就是本次组合交易过程中该账户最小的余额，该余额必须非负。
        if (updateData.delta.compareTo(updateData.minimum) < 0) {
            updateData.minimum = updateData.delta;
        }
        return oldBalance;
    }
	
	private static final class AccountUpdateData {
        Long acctId;
        Long custId;
        BigDecimal minimum;
        BigDecimal delta;
        BigDecimal newBalance;
        BigDecimal lastBalance;
        Long version;

        public Long getAcctId() {
            return acctId;
        }

        public AccountUpdateData setAcctId(Long acctId) {
            this.acctId = acctId;
            return this;
        }

        public Long getCustId() {
            return custId;
        }

        public AccountUpdateData setCustId(Long custId) {
            this.custId = custId;
            return this;
        }

        public BigDecimal getMinimum() {
            return minimum;
        }

        public AccountUpdateData setMinimum(BigDecimal minimum) {
            this.minimum = minimum;
            return this;
        }

        public BigDecimal getDelta() {
            return delta;
        }

        public AccountUpdateData setDelta(BigDecimal delta) {
            this.delta = delta;
            return this;
        }


        public BigDecimal getNewBalance() {
            return newBalance;
        }

        public AccountUpdateData setNewBalance(BigDecimal newBalance) {
            this.newBalance = newBalance;
            return this;
        }

        public BigDecimal getLastBalance() {
            return lastBalance;
        }

        public AccountUpdateData setLastBalance(BigDecimal lastBalance) {
            this.lastBalance = lastBalance;
            return this;
        }

        public Long getVersion() {
            return version;
        }

        public AccountUpdateData setVersion(Long version) {
            this.version = version;
            return this;
        }
    }
}
