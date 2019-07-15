package com.zcr.behavior.iterator;

/**
 * @author zcr
 * @date 2019/7/14-18:52
 */
//使用内部类定义迭代器，可以直接使用外部类的属性
public class Iterator implements AbstractIterator {

    private int cursor;//定义游标用于记录遍历时的位置
    private Aggregate aggregate;

    public Iterator(Aggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public void first() {
        cursor = 0;
    }

    @Override
    public void next() {
        if (cursor < aggregate.getList().size()) {
            cursor++;
        }

    }

    @Override
    public boolean hasNext() {
        if (cursor < aggregate.getList().size()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFirst() {
        return cursor == 0 ? true :false;
    }

    @Override
    public boolean isLast() {
        return cursor == (aggregate.getList().size() - 1) ? true :false;
    }

    @Override
    public Object getCurrentObj() {
        return aggregate.getList().get(cursor);
    }
}
