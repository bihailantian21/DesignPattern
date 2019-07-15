package com.zcr.structural.proxy;

import java.lang.reflect.Proxy;

/**
 * @author zcr
 * @date 2019/7/13-17:04
 *
 *• 代理模式(Proxy pattern)：
 * – 核心作用：
 * 通过代理，控制对对象的访问！ 可以详细控制访问某个（某类）对象的方法，在调用这个方法前做前置处理，调用这个方法后 做后置处理。（即：AOP的微观实现！）。
 * 代理类负责为委托类预处理消息，过滤消息并转发消息，以及进行消息被委托类执行后的后续处理。
 * 从而实现将统一流程代码放到代理类中处理
 * – AOP(Aspect Oriented Programming面向切面编程)的核心实现机制！
 *
 * 经纪人可以代理很多个明星.核心事件都是明星干，但在核心事件之前之后都是经纪人做
 * 经纪人比明星大
 *
 *
 *
 * 更通俗的说，代理解决的问题当两个类需要通信时，引入第三方代理类，将两个类的关系解耦，让我们只了解代理类即可，
 * 而且代理的出现还可以让我们完成与另一个类之间的关系的统一管理，但是切记，代理类和委托类要实现相同的接口，
 * 因为代理真正调用的还是委托类的方法。
 *
 *
 *
 *
 * 角色
 * – 核心角色：
 * • 抽象角色
 * – 定义代理角色和真实角色的公共对外方法
 *
 * • 真实角色
 * – 实现抽象角色，定义真实角色所要实现的业务逻辑， 供代理角色调用。
 * – 关注真正的业务逻辑！
 *
 * • 代理角色
 * – 实现抽象角色，是真实角色的代理，通过真实角色 的业务逻辑方法来实现抽象方法，并可以附加自己的操作。
 * – 将统一的流程控制放到代理角色中处理！
 *
 *
 *
 *
 * 应用场景：
 * – 安全代理：屏蔽对真实角色的直接访问。
 * – 远程代理：通过代理类处理远程方法调用(RMI)
 * – 延迟加载：先加载轻量级的代理对象，真正需要再加载真实对象。
 * • 比如你要开发一个大文档查看软件，大文档中有大的图片，有可能一个图片有100MB，
 * 在打开文件时不可能将所有的图片都显示出来，这样就可以 使用代理模式，当需要查看图片时，用proxy来进行大图片的打开。
 *
 *
 *
 *
 *
 *
 * 分类：
 * 按照代理的创建时期，代理类可以分为两种：
 * 静态：由程序员创建代理类或特定工具自动生成源代码再对其编译。在程序运行前代理类的.class文件就已经存在了。
 * 动态：在程序运行时运用反射机制动态创建而成。
 * – 静态代理(静态定义代理类)
 * – 动态代理(动态生成代理类)
 * • JDK自带的动态代理
 * • javaassist字节码操作库实现(推荐)
 * • CGLIB
 * • ASM(底层使用指令，可维护性较差)
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * 静态代理（static proxy）
 * • 静态代理(静态定义代理类)
 * 代理类持有了真实角色的引用
 * 重点关注类之间的关系
 *
 * 静态代理类优缺点
 * 优点：
 * 代理使客户端不需要知道实现类是什么，怎么做的，而客户端只需知道代理即可（解耦合）。
 * 缺点：
 * 1）代理类和委托类实现了相同的接口，代理类通过委托类实现了相同的方法。这样就出现了大量的代码重复。
 * 如果接口增加一个方法，除了所有实现类需要实现这个方法外，所有代理类也需要实现此方法。增加了代码维护的复杂度。
 *2）代理对象只服务于一种类型的对象，如果要服务多类型的对象。势必要为每一种对象都进行代理，静态代理在程序规模稍大时就无法胜任了。
 * 如上的代码是只为UserManager类的访问提供了代理，但是如果还要为其他类如Department类提供代理的话，就需要我们再次添加代理Department的代理类。
 *
 * 举例说明：代理可以对实现类进行统一的管理，如在调用具体实现类之前，需要打印日志等信息，这样我们只需要添加一个代理类，在代理类中添加打印日志的功能，
 * 然后调用实现类，这样就避免了修改具体实现类。满足我们所说的开闭原则。但是如果想让每个实现类都添加打印日志的功能的话，就需要添加多个代理类，
 * 以及代理类中各个方法都需要添加打印日志功能（如上的代理方法中删除，修改，以及查询都需要添加上打印日志的功能）
 * 即静态代理类只能为特定的接口(Service)服务。如想要为多个接口服务则需要建立很多个代理类。
 *
 *
 *
 *
 *
 *
 *动态代理(dynamic proxy)
 * 根据如上的介绍，你会发现每个代理类只能为一个接口服务，这样程序开发中必然会产生许多的代理类
 * 所以我们就会想办法可以通过一个代理类完成全部的代理功能，那么我们就需要用动态代理
 * 在上面的示例中，一个代理只能代理一种类型，而且是在编译器就已经确定被代理的对象。
 * 而动态代理是在运行时，通过反射机制实现动态代理，并且能够代理各种类型的对象
 * 在Java中要想实现动态代理机制，需要java.lang.reflect.InvocationHandler接口和 java.lang.reflect.Proxy 类的支持
 * 动态代理(动态生成代理类)
 * • JDK自带的动态代理
 * java.lang.reflect.Proxy作用：动态生成代理类和对象
 * java.lang.reflect.InvocationHandler(处理器接口)：
 * 可以通过invoke方法实现对真实角色的代理访问；
 * 每次通过Proxy生成代理类对象时都要指定对应的处理器对象
 *1）java.lang.reflect.Proxy
 * 这是 Java 动态代理机制生成的所有动态代理类的父类，它提供了一组静态方法来为一组接口动态地生成代理类及其对象。
 * 清单6：Proxy类的静态方法
 * // 方法 1: 该方法用于获取指定代理对象所关联的调用处理器
 * static InvocationHandler getInvocationHandler(Object proxy)
 * // 方法 2：该方法用于获取关联于指定类装载器和一组接口的动态代理类的类对象
 * static Class getProxyClass(ClassLoader loader, Class[] interfaces)
 * // 方法 3：该方法用于判断指定类对象是否是一个动态代理类
 * static boolean isProxyClass(Class cl)
 * // 方法 4：该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
 * static Object newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h)
 * 2）java.lang.reflect.InvocationHandler
 * 这是调用处理器接口，它自定义了一个 invoke 方法，用于集中处理在动态代理类对象上的方法调用，通常在该方法中实现对委托类的代理访问。每次生成动态代理类对象时都要指定一个对应的调用处理器对象。
 * 清单7：InvocationHandler的核心方法
 * // 该方法负责集中处理动态代理类上的所有方法调用。第一个参数既是代理类实例，第二个参数是被调用的方法对象
 * // 第三个方法是调用参数。调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
 * Object invoke(Object proxy, Method method, Object[] args)
 * 3）java.lang.ClassLoader
 * 这是类装载器类，负责将类的字节码装载到 Java 虚拟机（JVM）中并为其定义类对象，然后该类才能被使用。Proxy 静态方法生成动态代理类同样需要通过类装载器来进行装载才能使用，它与普通类的唯一区别就是其字节码是由 JVM 在运行时动态生成的而非预存在于任何一个 .class 文件中。
 * 每次生成动态代理类对象时都需要指定一个类装载器对象
 *
 *
 *动态代理实现步骤
 * 具体步骤是：
 * a. 实现InvocationHandler接口创建自己的调用处理器
 * b. 给Proxy类提供ClassLoader和代理接口类型数组创建动态代理类
 * c. 以调用处理器类型为参数，利用反射机制得到动态代理类的构造函数
 * d. 以调用处理器对象为参数，利用动态代理类的构造函数创建动态代理类对象
 *
 *
 * • javaassist字节码操作库实现(推荐)
 * • CGLIB
 * • ASM(底层使用指令，可维护性较差)
 * 代理类的内容不需要自己定义了
 * 交给工具来生成代理类的内容
 * 定义处理器的接口
 * 流程控制的类\
 * 动态代理优点：
 *动态代理与静态代理相比较，最大的好处是接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理（InvocationHandler.invoke）。
 * 这样，在接口方法数量比较多的时候，我们可以进行灵活处理，而不需要像静态代理那样每一个方法进行中转。而且动态代理的应用使我们的类职责更加单一，复用性更强
在本示例中看不出来，因为invoke方法体内嵌入了具体的外围业务（记录任务处理前后时间并计算时间差），实际中可以类似Spring AOP那样配置外围业务。
 *
 *
 *
 *
 *
 * 总结：
 * 其实所谓代理，就是一个人或者一个机构代表另一个人或者另一个机构采取行动。在一些情况下，一个客户不想或者不能够直接引用一个对象，
 * 而代理对象可以在客户端和目标对象之前起到中介的作用。代理对象就是把被代理对象包装一层，在其内部做一些额外的工作，
 * 比如用户需要上facebook,而普通网络无法直接访问，网络代理帮助用户先FQ，然后再访问facebook。这就是代理的作用了。
 * 纵观静态代理与动态代理，它们都能实现相同的功能，而我们看从静态代理到动态代理的这个过程，
 * 我们会发现其实动态代理只是对类做了进一步抽象和封装，使其复用性和易用性得到进一步提升而这不仅仅符合了面向对象的设计理念，
 * 其中还有AOP的身影，这也提供给我们对类抽象的一种参考。关于动态代理与AOP的关系，个人觉得AOP是一种思想，而动态代理是一种AOP思想的实现！
 *
 *
 *
 *  代理模式
 * • 开发框架中应用场景：
 * – struts2中拦截器的实现
 * – 数据库连接池关闭处理
 * – Hibernate中延时加载的实现
 * – mybatis中实现拦截器插件
 * – AspectJ的实现
 * – spring中AOP的实现
 * – web service
 * – RMI远程方法调用
 * – …
 * – 实际上，随便选择一个技术框架都会用到代理模式！！
 *如：AOP
 * 放到handler类中统一进行处理
 *
 *
 *
 *关于JDK的动态代理，最为人熟知要可能要数Spring AOP的实现，默认情况下，Spring AOP的实现对于接口来说就是使用的JDK的动态代理来实现的，而对于类的代理使用CGLIB来实现。
 * 那么，什么是JDK的动态代理呢？
 * JDK的动态代理，就是在程序运行的过程中，根据被代理的接口来动态生成代理类的class文件，并加载运行的过程。JDK从1.3开始支持动态代理。
 * 那么JDK是如何生成动态代理的呢？JDK动态代理为什么不支持类的代理，只支持接口的代理？
 * 首先来看一下如何使用JDK动态代理。JDK提供了java.lang.reflect.Proxy类来实现动态代理的，可通过它的newProxyInstance来获得代理实现类。
 * 同时对于代理的接口的实际处理，是一个java.lang.reflect.InvocationHandler，它提供了一个invoke方法供实现者提供相应的代理逻辑的实现。
 * 可以对实际的实现进行一些特殊的处理，像Spring AOP中的各种advice。下面来看看如何使用。
 *
 *JDK的动态代理使用起来非常简单，但是只知道如何使用是不够的，知其然，还需知其所以然。所以要想搞清楚它的实现，那么得从源码入手。这里的源码是1.7.0_79。首先来看看它是如何生成代理类的：
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class Client {

    public static void main(String[] args) {
        /**
         * 静态代理(静态定义代理类)
         * 代理类持有了真实角色的引用
         * 重点关注类之间的关系
         * 实现代理类完全控制真实角色
         *
         */
        //真实角色实现抽象角色、代理角色实现抽象角色将真实角色作为属性通过构造方法传入真实角色，重写方法中用调用真实角色的方法
        Star realStar = new RealStar();
        Star proxyStar = new ProxyStar(realStar);
        proxyStar.confer();
        proxyStar.signContract();
        proxyStar.bookTicket();
        proxyStar.sing();
        proxyStar.collectMoney();
        System.out.println("===============");

        /**
         * *根据如上的介绍，你会发现每个代理类只能为一个接口服务，这样程序开发中必然会产生许多的代理类
         * 所以我们就会想办法可以通过一个代理类完成全部的代理功能，那么我们就需要用动态代理
         * 在上面的示例中，一个代理只能代理一种类型，而且是在编译器就已经确定被代理的对象。而动态代理是在运行时，通过反射机制实现动态代理，并且能够代理各种类型的对象
         *
         *
         * • JDK自带的动态代理
         * java.lang.reflect.Proxy作用：动态生成代理类和对象
         * java.lang.reflect.InvocationHandler(处理器接口)：
         * 可以通过invoke方法实现对真实角色的代理访问；
         * 每次通过Proxy生成代理类对象时都要指定对应的处理器对象
         * java.lang.reflect.InvocationHandler接口的定义如下：
         * //Object proxy:被代理的对象
         * //Method method:要调用的方法
         * //Object[] args:方法调用时所需要参数
         * public interface InvocationHandler {
         *     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
         * }
         * java.lang.reflect.Proxy类的定义如下：
         * //CLassLoader loader:类的加载器
         * //Class<?> interfaces:得到全部的接口
         * //InvocationHandler h:得到InvocationHandler接口的子类的实例
         * public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) throws IllegalArgumentException
         **
         * 代理类的内容不需要自己定义了,交给工具来生成代理类的内容。定义处理器的接口。
         *
         * 流程控制的类
         *
         * 测试:先后创建
         * 真实对象
         * 处理器接口对象
         * 代理类对象
         *
         * 调用代理类的方法时，全都是去调用的是真实对象的方法
         * 因为全部都是取invoke里面进行调用的
         * 所以在这个方法中就可以进行统一的流程控制
         */
        Star realStar1 = new RealStar();
        StarHandler handler = new StarHandler(realStar);
        //该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
        //第一个参数指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器
        //第二个参数要实现和目标对象一样的接口，所以只需要拿到目标对象的实现接口
        //第三个参数表明这些被拦截的方法在被拦截时需要执行哪个InvocationHandler的invoke方法
        //根据传入的目标返回一个代理对象
        Star proxyStar1 = (Star)Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class},
                handler);

        /*传入目标对象参数的第二种方法：
        StarHandler handler = new StarHandler();
        Star proxyStar1 = (Star)Proxy.newProxyInstance(new RealStar());
        */
        proxyStar1.sing();
        /**
         * 可以看到，我们可以通过StarHandler代理不同类型的对象，如果我们把对外的接口都通过动态代理来实现，
         * 那么所有的函数调用最终都会经过invoke函数的转发，因此我们就可以在这里做一些自己想做的操作，
         * 比如日志系统、事务、拦截器、权限控制等。这也就是AOP(面向切面编程)的基本原理。
         */






    }
}