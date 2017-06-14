package test;


import static org.springframework.util.Assert.isTrue;

/**
 * Created by daniel on 15/12/2.
 */
public enum TransactionBizType {
    INNER("00"),      //�ڲ�ҵ��
    DEPOSIT("01"),    //��ֵ
    WITHDRAW("02"),   //����
    INVESTMENT("03"), //Ͷ��
    ISSUE("04"),      //�ſ�
    REPAYMENT("05"),  //����
    BONUS("06"),      //���Ͷ��
    WITHHOLD("07"),
    GIFT("08"),
    TRADE("09"),
    TRADE_FEE("10"),
    COMMISSION("11"), //Ӷ��
    RED_PACKET("12"), //���
    CONSULTANT("13"), //��ѯ�����
    PRESENT("14");    //����

    private final String bizId;

    TransactionBizType(String bizId) {
        isTrue(bizId != null && bizId.length() == 2, "Biz Id must has length 2");
        this.bizId = bizId;
    }

    public String getBizId() {
        return bizId;
    }
}
