package com.zcr.structural.composite;

/**
 * @author zcr
 * @date 2019/7/14-9:28
 */

//抽象组件
public interface Component {
    void operation();
}

//叶子组件
interface Leaf extends Component {

}

//容器组件
interface Composite extends Component {
    void add(Component component);
    void remove(Component component);
    Component getChild(int index);
}
