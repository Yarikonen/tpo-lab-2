package org.itmo.math.function;

import lombok.RequiredArgsConstructor;
import org.itmo.math.interfaces.Calculable;
import org.itmo.math.logarithm.Logarithm;
import org.itmo.math.logarithm.NaturalLogarithm;
import org.itmo.math.trigonometry.*;

@RequiredArgsConstructor
public class Function implements Calculable {
    private final Cosine cosine;
    private final Tangent tangent;
    private final Secant secant;
    private final Cosecant cosecant;

    private final NaturalLogarithm naturalLogarithm;
    private final Logarithm logarithm2;
    private final Logarithm logarithm3;
    private final Logarithm logarithm5;

    private final Logarithm logarithm10;

    public double calculate(double x) {
        double result;



        if (x <= 0) {
            result = Math.pow((secant.calculate(x)/cosecant.calculate(x))* tangent.calculate(x),2)
                    - Math.pow((cosecant.calculate(x)-(cosine.calculate(x)* tangent.calculate(x))),2);

        } else {
            result = (logarithm3.calculate(x)* logarithm3.calculate(x))/(logarithm10.calculate(x)
                    *(logarithm10.calculate(x)+ naturalLogarithm.calculate(x))) *
                    (2*logarithm5.calculate(x)- logarithm2.calculate(x)) -
                    logarithm5.calculate(x)/(logarithm10.calculate(x)- logarithm2.calculate(x));
        }
        return result;
    }
}