package org.itmo.math.logarithm;

import lombok.RequiredArgsConstructor;
import org.itmo.math.interfaces.Calculable;

@RequiredArgsConstructor
public class Logarithm implements Calculable {

    private final NaturalLogarithm naturalLogarithm;
    private final Integer base;


    @Override
    public double calculate(double x) {
        if (base <= 0 || base == 1) {
            throw new IllegalArgumentException("Base must be > 0 and != 1");
        }

        return naturalLogarithm.calculate(x) / naturalLogarithm.calculate(base);
    }
}
