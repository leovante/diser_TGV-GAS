package gasappsolution.gases;

public class FactoryGas implements AbstractFactoryGas{

    public Gas getParam(Object object){
        Gas gas = null;
        if(object instanceof NatureGas){
            gas = new NatureGas();
        } else if (object instanceof Biogas){
            gas = new Biogas();
        }
        return gas;
    }

    @Override
    public Gas createBiogas() {
        return new Biogas();
    }

    @Override
    public Gas createNatureGas() {
        return new NatureGas();
    }
}