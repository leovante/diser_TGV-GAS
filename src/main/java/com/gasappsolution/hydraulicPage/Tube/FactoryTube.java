package com.gasappsolution.hydraulicPage.Tube;

public class FactoryTube implements AbstractFactoryTube {

    @Override
    public Tube getTube(TubeType type) {
        if (type == TubeType.Steel) {
            return new SteelTube();
        } else if (type == TubeType.Polyethylene) {
            return new PolyethyleneTube();
        }
        return null;
    }
}