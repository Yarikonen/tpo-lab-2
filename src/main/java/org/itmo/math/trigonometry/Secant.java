package org.itmo.math.trigonometry;

import lombok.RequiredArgsConstructor;
import org.itmo.math.interfaces.Calculable;

@RequiredArgsConstructor
public class Secant implements Calculable {
    private final Cosine cosine;
    private final double epsilon = 0.01;
    @Override
    public double calculate(double x) {
        double cosineResult = cosine.calculate(x);
        if (Math.abs(cosineResult) < epsilon) {
            throw new ArithmeticException("zero division");
        }
        return 1 / cosineResult;
    }
}
