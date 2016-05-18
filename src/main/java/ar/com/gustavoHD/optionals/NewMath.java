package ar.com.gustavoHD.optionals;

import java.util.Optional;

/**
 * Created by gustavo on 15/05/16.
 */
public class NewMath {

    public static Optional<Double> inv(Double d) {
        return d == 0d ? Optional.empty() :
                Optional.of(1d/d);
    }

    public static Optional<Double> sqrt(Double d) {
        return d < 0d ? Optional.empty() :
                Optional.of(Math.sqrt(d));
    }
}
