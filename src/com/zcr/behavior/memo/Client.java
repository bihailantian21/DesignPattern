package com.zcr.behavior.memo;

/**
 * @author zcr
 * @date 2019/7/15-17:33
 *
 *备忘录模式 memento
 * 场景：
 * 录入大批人员资料。正在录入当前人资料时，发现上一个人录错了，此时需要恢复上一个人的资料，再进行修改。
 * Word文档编辑时，忽然电脑死机或断电，再打开时，可以看到word提示你恢复到以前的文档
 * 管理系统中，公文撤回功能。公文发送出去后，想撤回来。
 *
 * 核心
 * 就是保存某个对象内部状态的拷贝，这样以后就可以将该对象恢复到原先的状态。
 *
 * 结构：
 * 源发器类 Originator 保存对象内部的状态。定义类、构造器、get/set
 * 源发器类中还需要加两个内容：进行备忘操作，并返回备忘录对象【创建备忘录对象，参数是this】；进行数据恢复，恢复成指定备忘录对象的值【参数是备忘器类】
 * 备忘录类 Memento 保存对象内部状态的拷贝。定义类、构造器【参数是源发器类】、get/set
 * 负责人类 CareTaker 存储备忘录的。管理备忘录对象，把备忘录类作为一个属性，通过set扥方法传递参数进来
 *
 *careTaker.setMemento(emp.memento());//备忘
 *emp.recovery(careTaker.getMemento());//恢复
 *要设置多个备忘点，通过容器来做
 *
 *
 *开发中常见的应用场景：
 * 棋类游戏中的，悔棋
 * 普通软件中的，撤销操作
 * 数据库软件中的，事务管理中的，回滚操作
 * Photoshop软件中的，历史记录
 *
 *
 *
 */
public class Client {

    public static void main(String[] args) {

        CareTaker careTaker = new CareTaker();

        Emp emp = new Emp("张",12,1222);
        System.out.println(emp);

        careTaker.setMemento(emp.memento());//备忘


        emp.setAge(23);
        emp.setEname("as");
        emp.setSalary(12223333);

        System.out.println(emp);



        emp.recovery(careTaker.getMemento());//恢复
        System.out.println(emp);

    }
}
