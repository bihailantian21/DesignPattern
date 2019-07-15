package com.zcr.create.prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zcr
 * @date 2019/7/13-16:27
 */
public class Sheep implements Cloneable, Serializable {

    private String sanme;
    private Date birthday;

    public Sheep() {
    }

    public Sheep(String sanme, Date birthday) {
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
        return super.clone();
    }
}
