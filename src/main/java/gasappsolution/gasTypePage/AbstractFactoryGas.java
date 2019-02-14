package gasappsolution.gasTypePage;

public interface AbstractFactoryGas {
//    Biogas biogas();
//    NatureGas natureGas();
    Gas getGas(GasType type);
}