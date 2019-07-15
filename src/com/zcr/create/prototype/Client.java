package com.zcr.create.prototype;

import javafx.scene.input.DataFormat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author zcr
 * @date 2019/7/13-16:25
 *
 *原型模式：
 * – 通过new产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式。
 * – 就是java中的克隆技术，以某个对象为原型，复制出新的对象。显然，新的对象具备原型对象的特点
 * – 优势有：
 * 效率高(直接克隆，避免了重新执行构造过程步骤)、
 * “接口造接口”。
 * – 克隆类似于new，但是不同于new。new创建新的对象属性采用的是默认值。克隆出的对象的属性值完全和原型对象相同。并且克隆出的新对象改变不会影响原型对象。然后， 再修改克隆对象的值。
 *
 * 原型模式实现：
 * – Cloneable接口和clone方法
 * – Prototype模式中实现起来最困难的地方就是内存复制操作，所幸在Java中提供了 clone()方法替我们做了绝大部分事情。
 *
 * • 注意用词：克隆和拷贝一回事！
 *
 *
 *
 *浅克隆存在的问题
 * – 被复制的对象的所有变量都含有与原来的对象相同的值，
 * 而所有的对其他对象的引用都仍然指向原来的对象。
 *
 * 深克隆如何实现?
 * – 深克隆把引用的变量指向复制过的新对象，而不是原有的被引用的对象。
 * – 深克隆：让已实现Clonable接口的类中的属性也实现Clonable接口
 * – 基本数据类型能够自动实现深度克隆（值的复制）
 * – 有时候增加克隆的代码比较麻烦！
 * – 可以利用序列化和反序列化实现深克隆！
 *
 *
 *
 *
 *克隆省时间
 *
 * 开发中的应用场景
 * – 原型模式很少单独出现，一般是和工厂方法模式一起出现，通过clone 的方法创建一个对象，然后由工厂方法提供给调用者。
 * • spring中bean的创建实际就是两种：单例模式和原型模式。（当然，原型模式需要和工厂模式搭配起来）
 *
 *
 *
 *
 *
 *
 *
 * 创建型模式的总结
 * 创建型模式：都是用来帮助我们创建对象的！
 * – 单例模式
 * • 保证一个类只有一个实例，并且提供一个访问该实例的全局访问点。
 *
 * – 工厂模式
 * • 简单工厂模式
 * – 用来生产同一等级结构中的任意产品。（对于增加新的产品，需要修改已有代码）
 * • 工厂方法模式
 * – 用来生产同一等级结构中的固定产品。（支持增加任意产品）
 * • 抽象工厂模式
 * – 用来生产不同产品族的全部产品。（对于增加新的产品，无能为力；支持增加产品族）
 *
 * – 建造者模式
 * • 分离了对象子组件的单独构造(由Builder来负责)和装配(由Director负责)。 从而可 以构造出复杂的对象。
 *
 * – 原型模式
 * • 通过new产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式
 */
public class Client {

    public static void main(String[] args) throws Exception{

        Date date = new Date(1111111111111L);
        Sheep s1 = new Sheep("小李",date);
        System.out.println(s1);
        Sheep s2 = (Sheep) s1.clone();
        s2.setSanme("小葵");
        System.out.println(s2);
        date.setTime(2222222222222L);
        System.out.println(s1);
        System.out.println(s2);//浅克隆，所有的对其他对象的引用都仍然指向原来的对象
        System.out.println("=============================");


        Date date1 = new Date(1111111111111L);
        Sheep1 s3 = new Sheep1("小李",date1);
        System.out.println(s3);
        Sheep1 s4 = (Sheep1) s3.clone();
        s4.setSanme("小葵");
        System.out.println(s4);
        date1.setTime(2222222222222L);
        System.out.println(s3);
        System.out.println(s4);//修改了s3的时间，不影响s4的时间。实现深复制！
        System.out.println("=============================");



        //可以利用序列化和反序列化实现深克隆！
        Date date2 = new Date(1111111111111L);
        Sheep s5 = new Sheep("小李",date2);
        System.out.println(s5);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s5);

        byte[] bytes = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);

        Sheep s6 = (Sheep) ois.readObject();//可以利用序列化和反序列化实现深克隆！
        s6.setSanme("小葵");
        System.out.println(s6);

        date2.setTime(2222222222222L);
        System.out.println(s5);
        System.out.println(s6);//实现了深度克隆

        //测试效率
        testNew(10000);
        testClone(10000);


    }


    public static void testNew(int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            Sheep s = new Sheep();
        }
        long end = System.currentTimeMillis();
        System.out.println("new方式创建耗时：" + (end - start));
    }

    public static void testClone(int size) throws Exception{
        long start = System.currentTimeMillis();
        Sheep s = new Sheep();
        for (int i = 0; i < size; i++) {
            Sheep temp = (Sheep) s.clone();
        }
        long end = System.currentTimeMillis();
        System.out.println("clone方式创建耗时：" + (end - start));
    }
}
