package gasappsolution.gases;

public class FactoryMethod {
    public AbstractGas getParam(Object object){
        AbstractGas gas = null;
        if(object instanceof NatureGas){
            gas = new NatureGas();
        } else if (object instanceof Biogas){
            gas = new Biogas();
        }
        return gas;
    }
}
