package test1;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by henry on 15/12/01.
 */
public class InvestmentDetail {
    private Long investmentId;
    private Long loanId;
    private Long groupLoanId;
    private String loanName;
    private Date loanStartTime;
    private Integer loanDuration;
    private Long investorId;
    private BigDecimal amount;
    private BigDecimal principal;
    private BigDecimal receivedPrincipal;
    private BigDecimal expectInterest;
    private BigDecimal receivedInterest;
    private BigDecimal receivedLateFee;
    private BigDecimal buyPrice;
    private Date createTime;
    private BigDecimal interestRate;
    private Long repaymentPlanId;
    private Date dueDate;
    private Long minimumInvestDays;
    private BigDecimal earlyQuitMgmtFeeRate;
    private BigDecimal interestCommissionRate;
    private boolean investmentTradeable;
	public Long getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(Long investmentId) {
		this.investmentId = investmentId;
	}
	public Long getLoanId() {
		return loanId;
	}
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}
	public Long getGroupLoanId() {
		return groupLoanId;
	}
	public void setGroupLoanId(Long groupLoanId) {
		this.groupLoanId = groupLoanId;
	}
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public Date getLoanStartTime() {
		return loanStartTime;
	}
	public void setLoanStartTime(Date loanStartTime) {
		this.loanStartTime = loanStartTime;
	}
	public Integer getLoanDuration() {
		return loanDuration;
	}
	public void setLoanDuration(Integer loanDuration) {
		this.loanDuration = loanDuration;
	}
	public Long getInvestorId() {
		return investorId;
	}
	public void setInvestorId(Long investorId) {
		this.investorId = investorId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getPrincipal() {
		return principal;
	}
	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}
	public BigDecimal getReceivedPrincipal() {
		return receivedPrincipal;
	}
	public void setReceivedPrincipal(BigDecimal receivedPrincipal) {
		this.receivedPrincipal = receivedPrincipal;
	}
	public BigDecimal getExpectInterest() {
		return expectInterest;
	}
	public void setExpectInterest(BigDecimal expectInterest) {
		this.expectInterest = expectInterest;
	}
	public BigDecimal getReceivedInterest() {
		return receivedInterest;
	}
	public void setReceivedInterest(BigDecimal receivedInterest) {
		this.receivedInterest = receivedInterest;
	}
	public BigDecimal getReceivedLateFee() {
		return receivedLateFee;
	}
	public void setReceivedLateFee(BigDecimal receivedLateFee) {
		this.receivedLateFee = receivedLateFee;
	}
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public BigDecimal getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	public Long getRepaymentPlanId() {
		return repaymentPlanId;
	}
	public void setRepaymentPlanId(Long repaymentPlanId) {
		this.repaymentPlanId = repaymentPlanId;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Long getMinimumInvestDays() {
		return minimumInvestDays;
	}
	public void setMinimumInvestDays(Long minimumInvestDays) {
		this.minimumInvestDays = minimumInvestDays;
	}
	public BigDecimal getEarlyQuitMgmtFeeRate() {
		return earlyQuitMgmtFeeRate;
	}
	public void setEarlyQuitMgmtFeeRate(BigDecimal earlyQuitMgmtFeeRate) {
		this.earlyQuitMgmtFeeRate = earlyQuitMgmtFeeRate;
	}
	public BigDecimal getInterestCommissionRate() {
		return interestCommissionRate;
	}
	public void setInterestCommissionRate(BigDecimal interestCommissionRate) {
		this.interestCommissionRate = interestCommissionRate;
	}
	public boolean isInvestmentTradeable() {
		return investmentTradeable;
	}
	public void setInvestmentTradeable(boolean investmentTradeable) {
		this.investmentTradeable = investmentTradeable;
	}
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public String toString() {
		return "InvestmentDetail [amount=" + amount + ", createTime="
				+ dateFormat.format(createTime) + ", dueDate=" + dueDate  + "]";
	}
    
	
    
}
