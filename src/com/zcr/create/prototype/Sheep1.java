package com.zcr.create.prototype;

import java.util.Date;

/**
 * @author zcr
 * @date 2019/7/13-16:39
 */
public class Sheep1 implements Cloneable {

    private String sanme;
    private Date birthday;

    public Sheep1(String sanme, Date birthday) {
        this.sanme = sanme;
        this.birthday = birthday;
    }

    public String getSanme() {
        return sanme;
    }

    public void setSanme(String sanme) {
        this.sanme = sanme;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Sheep{" + "sanme='" + sanme + '\'' + ", birthday=" + birthday + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object = super.clone();//直接调用object对象的clone()方法

        //添加如下代码实现深复制
        Sheep1 sheep = (Sheep1) object;
        sheep.birthday = (Date)this.birthday.clone();//把对象属性也进行克隆


        return object;
    }
}
