package gasappsolution.gases;

public interface AbstractFactoryGas {
//    Biogas biogas();
//    NatureGas natureGas();
    Gas getGas(GasType type);
}