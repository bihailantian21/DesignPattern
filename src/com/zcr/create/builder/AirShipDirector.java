package com.zcr.create.builder;

/**
 * @author zcr
 * @date 2019/7/13-16:13
 */
public interface AirShipDirector {

    AirShip directAirShip();
}

class AirShipDirectorImpl implements AirShipDirector {

    private AirShipBuilder builder;

    public AirShipDirectorImpl(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {
        Engine engine = builder.builderENgine();
        OrbitalModule orbitalModule = builder.builderOrbitalModule();
        EscapeTower escapeTower = builder.builderEscapeTower();

        AirShip airShip = new AirShip();
        airShip.setEngine(engine);
        airShip.setOrbitalModule(orbitalModule);
        airShip.setEscapeTower(escapeTower);

        return airShip;
    }
}
