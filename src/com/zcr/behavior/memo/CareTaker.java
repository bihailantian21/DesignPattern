package com.zcr.behavior.memo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcr
 * @date 2019/7/15-17:44
 */
public class CareTaker {

    private EmpMemento memento;

    //负责保存好的备忘录对象。
    //可以通过增加容器，设置多个“备忘点”
    //private List<EmpMemento> list = new ArrayList<EmpMemento>();

    //备忘点较多时：
    //将备忘录压栈



    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }
}
