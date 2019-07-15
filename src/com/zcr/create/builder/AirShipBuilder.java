package com.zcr.create.builder;

/**
 * @author zcr
 * @date 2019/7/13-16:12
 */
public interface AirShipBuilder {
    Engine builderENgine();
    OrbitalModule builderOrbitalModule();
    EscapeTower builderEscapeTower();
}

class AirShipBuilderImpl implements AirShipBuilder {

    @Override
    public Engine builderENgine() {
        System.out.println("构建发动机");
        return new Engine("发动机");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("构建轨道舱");
        return new OrbitalModule("轨道舱");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("构建逃逸塔");
        return new EscapeTower("逃逸塔");
    }
}
