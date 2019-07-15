package com.zcr.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcr
 * @date 2019/7/14-18:35
 */
public class Aggregate {

    private List<Object> list = new ArrayList<Object>();


    public void addObject(Object obj) {
        this.list.add(obj);
    }

    public void removeObject(Object obj) {
        this.list.remove(obj);
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public AbstractIterator createIterator() {
        return new Iterator(this);
    }



}
