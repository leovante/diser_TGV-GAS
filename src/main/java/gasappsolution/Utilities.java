package gasappsolution;

import java.util.Locale;

public class Utilities {
    public String toText(double a){
        return String.valueOf(String.format(Locale.US, "%.4f", a));
    }

    public Integer toInt(double a){
        return Integer.valueOf(String.format(Locale.US, "%.4f", a));
    }
}
