package com.hy.basic.java.specification.example.ifelse;

import java.util.HashMap;
import java.util.Map;

/**
 * @user hy
 * @date sometime
 * @introduce        方法三,用map消除工厂模式的分支
 **/
public class BusinessFactory {

    private Map<Integer,Class<? extends Business>> factory = new HashMap<>();

    private void init(){
        //标识其实应该放在factory
        factory.put(Business.TYPE_ONE,Business1.class);
        factory.put(Business.TYPE_TWO,Business2.class);
    }

    public BusinessFactory(){
        init();
    }

    public Business createBusiness(int type){
        try {
            Business business = factory.get(type).newInstance();
            return business;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("这里也可以返回默认实现方法,或者报错");
    }

}
