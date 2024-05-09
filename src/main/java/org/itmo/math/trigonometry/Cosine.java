package org.itmo.math.trigonometry;

import lombok.RequiredArgsConstructor;
import org.itmo.math.interfaces.Calculable;


@RequiredArgsConstructor
public class Cosine implements Calculable {



    private final Sine sine;
    @Override
    public double calculate(double x) {
        if (Double.isInfinite(x) || Double.isNaN(x)) {
            throw new IllegalArgumentException("Argument must be a number");
        }

        x = sine.getPeriod(Math.PI/2 - x);

        return sine.calculate(x);
    }
}
