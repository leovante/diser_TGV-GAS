package gasappsolution.paramPage;

public interface AbstractFactoryGas {
//    Biogas biogas();
//    NatureGas natureGas();
    Gas getGas(GasType type);
}