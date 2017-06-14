package test1;

public enum ExperienceGoldStatus {
	    NEW("新创建"),
	    ACTIVE("待结清"),
	    PAID_OFF("已结清"),
	    WITHDRAW("已回收"),
	    COMPLETED("已结清且已投资");
	 final String label;

	    ExperienceGoldStatus(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
