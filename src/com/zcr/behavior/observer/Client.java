package com.zcr.behavior.observer;

/**
 * @author zcr
 * @date 2019/7/14-22:01
 *
 *场景：
 * 聊天室程序的创建。服务器创建好后，A,B,C三个客户端连上来公开聊天。
 * A向服务器发送数据，服务器端聊天数据改变。我们希望将这些聊天数据分别发给其他在线的客户。
 * 也就是说，每个客户端需要更新服务器端得数据。
 *
 * 网站上，很多人订阅了”java主题”的新闻。当有这个主题新闻时，就会将这些新闻发给所有订阅的人。
 *
 * 大家一起玩CS游戏时，服务器需要将每个人的方位变化发给所有的客户。
 *
 * 上面这些场景，我们都可以使用观察者模式来处理。我们可以把多个订阅者、客户称之为观察者；
 * 需要同步给多个订阅者的数据封装到对象中，称之为目标。
 *
 *
 *
 *
 *
 *
 * 核心：
 * 观察者模式主要用于1：N的通知。当一个对象(目标对象Subject或Objservable)的状态变化时，
 * 他需要及时告知一系列对象(观察者对象,Observer)，令他们做出响应
 *
 * 通知观察者的方式：
 * 推
 * 每次都会把通知以广播方式发送给所有观察者，所有观察者只能被动接收。
 * 拉
 * 观察者只要直到有情况即可。至于什么时候获取内容，获取什么内容，都可以自主决定。
 *
 *
 *
 * 抽象观察者类   定义更新方法方法参数为目标类
 *
 * 观察者类 实现抽象观察者类，实现更新方法【调用目标类的获取状态方法】。定义状态参数、定义获取状态和设置状态。
 *
 * 抽象目标类   把订阅这个主题的所有观察者都放到这里，通知所有的观察者
 * 定义观察者列表参数、定义注册观察者和移除观察者的方法、定义通知所有观察者的方法【即循环调用所有观察者的更新方法】
 *
 * 目标类 继承抽象目标类。定义状态参数、定义获取状态和设置状态【调用通知所有观察者的方法】目标对象值发生了变化，请通知所有的观察者
 *
 *
 *
 *
 *
 * JAVASE提供了java.util.Observable和java.util.Observer来实现观察者模式
 *
 * 目标类继承Observable。 定义状态、定义获取状态和设置状态方法。定义设置的方法【目标对象状态发生了更改、表示目标对象已经做了更改、通知所有的观察者】
 * 观察者类实现Observer。定义状态、定义获取状态和设置状态方法。定义更新方法，调用Observable的获取参数方法。
 *
 *开发中常见的场景：
 * 聊天室程序的，服务器转发给所有客户端
 * 网络游戏(多人联机对战)场景中，服务器将客户端的状态进行分发
 * 邮件订阅
 * Servlet中，监听器的实现
 * Android中，广播机制
 *
 * JDK的AWT中事件处理模型,基于观察者模式的委派事件模型(Delegation Event Model)
 * 事件源----------------目标对象
 * 事件监听器------------观察者
 *
 * 京东商城中，群发某商品打折信息
 *
 *
 *
 *
 *
 */
public class Client {

    public static void main(String[] args) {
        //创建目标对象
        //创建多个观察者
        //将多个观察者添加到目标对象的观察者队伍中
        //改变目标对象的状态
        //看看观察者的状态有没有发生变化吧

        Subject subject = new Subject();

        ObserverA observerA = new ObserverA();
        ObserverA observerA1 = new ObserverA();
        ObserverA observerA2 = new ObserverA();

        subject.registerObserver(observerA);
        subject.registerObserver(observerA1);
        subject.registerObserver(observerA2);

        subject.setState(3000);
        System.out.println(observerA.getMyState());
        System.out.println(observerA1.getMyState());
        System.out.println(observerA2.getMyState());






        Subject2 subject2 = new Subject2();
        ObserverA2 observerA21 = new ObserverA2();
        ObserverA2 observerA22 = new ObserverA2();
        ObserverA2 observerA23 = new ObserverA2();
        subject2.addObserver(observerA21);
        subject2.addObserver(observerA22);
        subject2.addObserver(observerA23);
        subject2.set(12);
        System.out.println(observerA21.getMyState());
        System.out.println(observerA22.getMyState());
        System.out.println(observerA23.getMyState());

    }
}
