package com.zcr.structural.flyweight;

import sun.plugin.net.protocol.jar.CachedJarURLConnection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcr
 * @date 2019/7/14-11:08
 */

//享元工厂类
public class ChessFactory {

    //抽象享元类
    private static Map<String,AbstractChess> map = new HashMap<String, AbstractChess>();

    public static AbstractChess getChess(String color) {

        if (map.get(color) != null) {
            return map.get(color);
        } else {
            AbstractChess chess = new Chess(color);
            map.put(color,chess);
            return chess;
        }
    }
}
