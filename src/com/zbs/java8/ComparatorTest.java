package com.zbs.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zuo on 2017/2/21.
 */
public class ComparatorTest {

    public static void main(String args[]){
        List<OptionContent> list = new ArrayList<>();

        OptionContent content = null;
        for(int i=0; i<=4; i++){
            content = new OptionContent();
            if(i==0){
                content.setOption("D");
                content.setContent("dfsdf");
                list.add(content);
            }
            if(i==1){
                content.setOption("B");
                content.setContent("bfsdf");
                list.add(content);
            }
            if(i==2){
                content.setOption("C");
                content.setContent("cfsdf");
                list.add(content);
            }
            if(i==3){
                content.setOption("A");
                content.setContent("afsdf");
                list.add(content);
            }
        }
        System.out.println(list.contains(new OptionContent().setOption("B").setContent("bfsdf")));

        System.out.println(list.stream().anyMatch(obj ->obj.getOption().equals("B")));

        list.forEach(option -> System.out.println(option.getOption()));
        System.out.println("=======");
        //Comparator<OptionContent> comparator = (o1,o2) -> o1.getOption().compareTo(o2.getOption());
        //Collections.sort(list,comparator);

        Comparator<OptionContent> comparator = (o1,o2) -> o1.getContent().compareTo(o2.getContent());
        Collections.sort(list,comparator);

        list.forEach(option -> System.out.println(option.getContent()));

        BigDecimal investmentRate = new BigDecimal(0.01).divide(new BigDecimal(72000), 20, BigDecimal.ROUND_FLOOR);    //投资金额站贷款总金额的比例
        System.out.println(investmentRate);
        BigDecimal investmentMinAmount = new BigDecimal("0.01");
        BigDecimal investmentReceivedAmount = BigDecimal.ZERO;
        if (true) {
            //利息收益率=1-利息平台分成率
            BigDecimal investmentInterestRate = BigDecimal.ONE.subtract(new BigDecimal("0.1"));
            System.out.println(investmentInterestRate);

            //利息=投资利息收益/利息收益率
            investmentReceivedAmount = new BigDecimal("0.01");
            if (investmentInterestRate.compareTo(BigDecimal.ZERO) > 0 && investmentInterestRate.compareTo(BigDecimal.ONE) < 0) {
                investmentReceivedAmount = investmentMinAmount.divide(investmentInterestRate, 2, BigDecimal.ROUND_CEILING);    //精度为2
                System.out.println(investmentReceivedAmount);

            }
        }

        investmentReceivedAmount.divide(investmentRate, 2, BigDecimal.ROUND_CEILING);
        System.out.println(investmentReceivedAmount);

    }
}
