package org.itmo.math.trigonometry;

import lombok.RequiredArgsConstructor;
import org.itmo.math.interfaces.Calculable;

@RequiredArgsConstructor
public class Tangent implements Calculable {

    private final Sine sine;
    private final double epsilon = 0.01;

    private final Cosine cosine;
    @Override
    public double calculate(double x) {
        double cosineValue = cosine.calculate(x);
        if(Math.abs(cosineValue)<epsilon){
            throw new ArithmeticException("zero division");
        }

        return sine.calculate(x)/cosineValue;
    }
}
