package com.zcr.behavior.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcr
 * @date 2019/7/14-19:09
 * 总经理类—中介者的具体实现类
 * 为了让总经理知道自己有哪同事
 */
public class PresidentMediator implements AbstractMediator {

   private Map<String,AbstractDepartment> map = new HashMap<String, AbstractDepartment>();


    @Override
    public void register(String dname, AbstractDepartment d) {
        map.put(dname,d);
    }

    @Override
    public void command(String dname) {
        map.get(dname).outAction();
    }
}
