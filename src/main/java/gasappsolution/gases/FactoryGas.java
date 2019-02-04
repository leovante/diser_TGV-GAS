package gasappsolution.gases;

public class FactoryGas implements AbstractFactoryGas {
    @Override
    public Gas getGas(GasType type) {
        if (type == GasType.Biogas) {
            return new Biogas();
        } else if (type == GasType.NatureGas) {
            return new NatureGas();
        }
        return null;
    }

//    public Gas getParam(Object object){
//        Gas gas = null;
//        if(object instanceof NatureGas){
//            gas = new NatureGas();
//        } else if (object instanceof Biogas){
//            gas = new Biogas();
//        }
//        return gas;
//    }
/*
    @Override
    public Biogas biogas() {
        return new Biogas();
    }

    @Override
    public NatureGas natureGas() {
        return new NatureGas();
    }
  */


}