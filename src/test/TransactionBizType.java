package test;


import static org.springframework.util.Assert.isTrue;

/**
 * Created by daniel on 15/12/2.
 */
public enum TransactionBizType {
    INNER("00"),      //内部业务
    DEPOSIT("01"),    //充值
    WITHDRAW("02"),   //提现
    INVESTMENT("03"), //投资
    ISSUE("04"),      //放款
    REPAYMENT("05"),  //还款
    BONUS("06"),      //红包投资
    WITHHOLD("07"),
    GIFT("08"),
    TRADE("09"),
    TRADE_FEE("10"),
    COMMISSION("11"), //佣金
    RED_PACKET("12"), //红包
    CONSULTANT("13"), //咨询服务费
    PRESENT("14");    //礼物

    private final String bizId;

    TransactionBizType(String bizId) {
        isTrue(bizId != null && bizId.length() == 2, "Biz Id must has length 2");
        this.bizId = bizId;
    }

    public String getBizId() {
        return bizId;
    }
}
