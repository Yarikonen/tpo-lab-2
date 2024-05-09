package org.itmo;

import org.itmo.math.function.Function;
import org.itmo.math.logarithm.Logarithm;
import org.itmo.math.logarithm.NaturalLogarithm;
import org.itmo.math.trigonometry.*;
import org.itmo.math.writer.CsvWriter;

public class Main {
    public static void main(String[] args) {

        Sine sine = new Sine();
        sine.setN(1000);

        Cosine cosine = new Cosine(sine);

        Tangent tangent = new Tangent(sine, cosine);
        Cosecant cosecant = new Cosecant(sine);
        Secant secant = new Secant(cosine);

        NaturalLogarithm naturalLogarithm = new NaturalLogarithm();
        naturalLogarithm.setN(1000);

        Logarithm logarithm2 = new Logarithm(naturalLogarithm, 2);
        Logarithm logarithm3 = new Logarithm(naturalLogarithm, 3);
        Logarithm logarithm5 = new Logarithm(naturalLogarithm, 5);
        Logarithm logarithm10 = new Logarithm(naturalLogarithm, 10);




        Function function = new Function(cosine,tangent,secant,cosecant,naturalLogarithm,logarithm2,logarithm3,logarithm5,logarithm10);

        CsvWriter csvWriter = new CsvWriter(-2.3, 5, 0.2);

        csvWriter.write("src/main/resources/csv/cosine.csv", cosine);
        csvWriter.write("src/main/resources/csv/tangent.csv", tangent);
        csvWriter.write("src/main/resources/csv/cosecant.csv", cosecant);
        csvWriter.write("src/main/resources/csv/secant.csv", secant);
        csvWriter.write("src/main/resources/csv/function.csv", function);
        csvWriter.write("src/main/resources/csv/natural_log.csv", naturalLogarithm);
        csvWriter.write("src/main/resources/csv/log2.csv", logarithm2);
        csvWriter.write("src/main/resources/csv/log3.csv", logarithm3);
        csvWriter.write("src/main/resources/csv/log5.csv", logarithm5);
        csvWriter.write("src/main/resources/csv/log10.csv", logarithm10);

    }
}