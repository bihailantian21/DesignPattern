package com.zcr.behavior.interpreter;

/**
 * @author zcr
 * @date 2019/7/14-20:42
 *
 * 解释器模式 Interpreter
 * 介绍：
 * 是一种不常用的设计模式
 *
 * 用于描述如何构成一个简单的语言解释器，主要用于使用面向对象语言开发的编译器和解释器设计。
 *
 * 当我们需要开发一种新的语言时，可以考虑使用解释器模式。
 *
 * 尽量不要使用解释器模式，后期维护会有很大麻烦。在项目中，可以使用Jruby，Groovy、java的js引擎来替代解释器的作用，弥补java语言的不足。
 *
 * 开发中常见的场景：
 * EL表达式式的处理
 * 正则表达式解释器
 * SQL语法的解释器
 * 数学表达式解析器
 * 如现成的工具包:Math Expression String Parser、Expression4J等。
 * MESP的网址： http://sourceforge.net/projects/expression-tree/
 * Expression4J的网址： http://sourceforge.net/projects/expression4j/
 *
 */
public class Client {

    public static void main(String[] args) {

    }
}
