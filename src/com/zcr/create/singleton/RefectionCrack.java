package com.zcr.create.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @author zcr
 * @date 2019/7/12-20:32
 * 测试反射和反序列化破解单例模式
 */
public class RefectionCrack {
    /**
     *学过反射知道，即使构造器是私有的，你也可以通过反射去调用
     * – 反射可以破解上面几种(不包含枚举式)实现方式！（可以在构造方法中手动 抛出异常控制）
     * – 反序列化可以破解上面几种((不包含枚举式))实现方式！
     *
     * • 可以通过定义readResolve()防止获得不同对象。
     * – 反序列化时，如果对象所在类定义了readResolve()，（实际是一种回调）， 定义返回哪个对象。
     *
     */

    public static void main(String[] args) throws Exception {
        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();
        System.out.println(s1);
        System.out.println(s2);

        /*//通过反射的方式直接调用私有构造器
		Class<SingletonLazy> clazz = (Class<SingletonLazy>) Class.forName("com.zcr.create.singleton.SingletonLazy");//加载类
		Constructor<SingletonLazy> c = clazz.getDeclaredConstructor(null);//获得无参构造器
		c.setAccessible(true);//如果想要访问私有成员，要用这个跳过检查
        SingletonLazy  s3 = c.newInstance();//通过构造器去创建对象
        SingletonLazy  s4 = c.newInstance();
		System.out.println(s3);//
		System.out.println(s4);//和s3不一样，跳过了我们的单例

        //通过反序列化的方式构造多个对象
        FileOutputStream fos = new FileOutputStream("d:/a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.close();
        fos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
        SingletonLazy s5 = (SingletonLazy)ois.readObject();
        System.out.println(s5);//通过反序列化又创建了一个新的对象.这样的话就跳过了我们的单例！*/


        //加了抛出异常代码防止反射多次调用创建多个对象后
        SingletonLazy2 s9 = SingletonLazy2.getInstance();
        System.out.println(s9);
        //通过反射的方式直接调用私有构造器
        /*Class<SingletonLazy2> clazz2 = (Class<SingletonLazy2>) Class.forName("com.zcr.create.singleton.SingletonLazy2");//加载类
        Constructor<SingletonLazy2> c2 = clazz2.getDeclaredConstructor(null);//获得无参构造器
        c2.setAccessible(true);//如果想要访问私有成员，要用这个跳过检查
        SingletonLazy2  s6 = c2.newInstance();//通过构造器去创建对象
        SingletonLazy2  s7 = c2.newInstance();
        System.out.println(s6);//
        System.out.println(s7);//加了抛出异常代码防止反射多次调用创建多个对象后*/

        //通过反序列化的方式构造多个对象
        FileOutputStream fos2 = new FileOutputStream("d:/b.txt");
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
        oos2.writeObject(s9);
        oos2.close();
        fos2.close();

        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("d:/b.txt"));
        SingletonLazy2 s8 = (SingletonLazy2)ois2.readObject();
        System.out.println(s8);//通过反序列化读出对象，生成了一个新的对象。破解反序列化后（定义好了自动调用）







    }

}
