package com.gasappsolution.gasTypePage;

import com.gasappsolution.gasTypePage.gases.Gas;

public interface AbstractFactoryGas {
//    BiogasImpl biogas();
//    SvalochniyGasImpl natureGas();
    Gas getGas(EnumGasType type);
}