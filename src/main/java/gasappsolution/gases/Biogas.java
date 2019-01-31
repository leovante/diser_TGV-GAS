package gasappsolution.gases;

import java.util.LinkedHashMap;
import java.util.Map;

public class Biogas extends AbstractGas{
    @Override
    public void param(Object context) {
        Map<String, Double> prop = new LinkedHashMap<String, Double>();
        prop.put("", 0.0);
    }
}