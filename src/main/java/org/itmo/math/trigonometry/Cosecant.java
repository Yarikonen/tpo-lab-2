package org.itmo.math.trigonometry;

import lombok.RequiredArgsConstructor;
import org.itmo.math.interfaces.Calculable;

@RequiredArgsConstructor
public class Cosecant implements Calculable {
    private final Sine sine;
    private final double epsilon = 0.01;
    @Override
    public double calculate(double x) {
        double sinResult = sine.calculate(x);
        if (Math.abs(sinResult) < epsilon) {
            throw new ArithmeticException("zero division");
        }
        return 1 / sinResult;
    }
}
