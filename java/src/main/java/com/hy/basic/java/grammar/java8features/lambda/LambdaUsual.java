package com.hy.basic.java.grammar.java8features.lambda;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 *  lambda常用用例
 */
public class LambdaUsual {

    public static void main(String[] args) {


    }


    /**
     * 集合类型
     *
     */



    /**
     *  数字类型
     */
    public static void number() {

        List<String> numbersList =new ArrayList<>(Arrays.asList("4","5",null,"","6"));

        Stream<String> isNumberStream = numbersList.stream().filter(StringUtils::isNumeric);

        //求和


        int intSum = isNumberStream.mapToInt(Integer::valueOf).sum();
        BigDecimal decimalSum = isNumberStream.map(BigDecimal::new).reduce(BigDecimal.ZERO, BigDecimal::add);


    }



}
