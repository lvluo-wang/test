package test;


import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by changlin on 16-2-26.
 */
public class LoanRepaymentTaskResource {
    private int period;
    private int totalPeriods;
    private Date repaymentDate;
    private BigDecimal interest;
    private BigDecimal principal;
    private BigDecimal remainingPrincipal;
    private BigDecimal managementFee;
    private BigDecimal totalAmount;

    private String _links;
    
    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public LoanRepaymentTaskResource setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
        return this;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getTotalPeriods() {
        return totalPeriods;
    }

    public void setTotalPeriods(int totalPeriods) {
        this.totalPeriods = totalPeriods;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getRemainingPrincipal() {
        return remainingPrincipal;
    }

    public void setRemainingPrincipal(BigDecimal remainingPrincipal) {
        this.remainingPrincipal = remainingPrincipal;
    }

    public BigDecimal getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(BigDecimal managementFee) {
        this.managementFee = managementFee;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    
	public String get_links() {
		return _links;
	}

	public void set_links(String _links) {
		this._links = _links;
	}

	@Override
	public String toString() {
		return "LoanRepaymentTaskResource [period=" + period
				+ ", totalPeriods=" + totalPeriods + ", repaymentDate="
				+ repaymentDate + ", interest=" + interest + ", principal="
				+ principal + ", remainingPrincipal=" + remainingPrincipal
				+ ", managementFee=" + managementFee + ", totalAmount="
				+ totalAmount + "]";
	}
    
    
}
