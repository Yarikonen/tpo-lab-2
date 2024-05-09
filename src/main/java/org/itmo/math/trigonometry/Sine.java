package org.itmo.math.trigonometry;

import lombok.Setter;
import org.itmo.math.interfaces.Calculable;

@Setter
public class Sine implements Calculable {
    private int N=100;
    private double epsilon = 0.000001;

    @Override
    public double calculate(double x) {
        if (Double.isInfinite(x) || Double.isNaN(x)) {
            throw new IllegalArgumentException("Argument must be a number");
        }

        if (N <= 0) {
            throw new IllegalArgumentException("Number of iterations must be >= 0");
        }

        x = getPeriod(x);

        double current = 0.;
        double prev;
        int sign = 1;
        double factorial = 1;

        for (int i = 1; i <= N; i+=2) {
            prev = current;
            current = current + (sign * Math.pow(x, i) / factorial);

            if (Math.abs(current - prev) < epsilon) {
                break;
            }

            sign *= -1;

            factorial *= (i + 1) * (i + 2);
        }
        return current;
    }

    public double getPeriod(double x) {
        if (x >= 0) {
            while (x > Math.PI) {
                x -= Math.PI * 2;
            }
        } else {
            while (x < -Math.PI) {
                x += Math.PI * 2;
            }
        }
        if (x>Math.PI/2) {
            x=Math.PI-x;
        }
        else if (x<-Math.PI/2){
            x=-Math.PI-x;
        }
        return x;
    }
}
