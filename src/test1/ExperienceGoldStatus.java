package test1;

public enum ExperienceGoldStatus {
	    NEW("�´���"),
	    ACTIVE("������"),
	    PAID_OFF("�ѽ���"),
	    WITHDRAW("�ѻ���"),
	    COMPLETED("�ѽ�������Ͷ��");
	 final String label;

	    ExperienceGoldStatus(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
}
