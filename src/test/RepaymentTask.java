package test;

import java.math.BigDecimal;

public class RepaymentTask {

	private int borrowerId;
	private int loanId;
	private int planId;
	private BigDecimal MGMT_FEE_ACCRUED;
	private BigDecimal INTEREST_ACCRUED;
	public int getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public BigDecimal getMGMT_FEE_ACCRUED() {
		return MGMT_FEE_ACCRUED;
	}
	public void setMGMT_FEE_ACCRUED(BigDecimal mGMT_FEE_ACCRUED) {
		MGMT_FEE_ACCRUED = mGMT_FEE_ACCRUED;
	}
	public BigDecimal getINTEREST_ACCRUED() {
		return INTEREST_ACCRUED;
	}
	public void setINTEREST_ACCRUED(BigDecimal iNTEREST_ACCRUED) {
		INTEREST_ACCRUED = iNTEREST_ACCRUED;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	
	
}
