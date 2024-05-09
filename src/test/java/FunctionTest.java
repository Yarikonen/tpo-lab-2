import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.itmo.math.function.Function;
import org.itmo.math.logarithm.Logarithm;
import org.itmo.math.logarithm.NaturalLogarithm;
import org.itmo.math.trigonometry.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class FunctionTest {
    private static Cosine mockedCosine;
    private static Tangent mockedTangent;
    private static Cosecant mockedCosecant;
    private static Secant mockedSecant;

    private static NaturalLogarithm mockedNaturalLogarithm;
    private static Logarithm mockedLogarithm2;
    private static Logarithm mockedLogarithm3;
    private static Logarithm mockedLogarithm5;
    private static Logarithm mockedLogarithm10;


    private static Sine sine;
    private static Cosine cosine;
    private static Tangent tangent;
    private static Cosecant cosecant;
    private static Secant secant;

    private static NaturalLogarithm naturalLogarithm;
    private static Logarithm logarithm2;
    private static Logarithm logarithm3;
    private static Logarithm logarithm5;
    private static Logarithm logarithm10;


    private final double epsilon = 0.1;

    @BeforeAll
    static void init() {
        mockedCosine = Mockito.mock(Cosine.class);
        mockedTangent = Mockito.mock(Tangent.class);
        mockedCosecant = Mockito.mock(Cosecant.class);
        mockedSecant = Mockito.mock(Secant.class);


        mockedNaturalLogarithm = Mockito.mock(NaturalLogarithm.class);
        mockedLogarithm2 = Mockito.mock(Logarithm.class);
        mockedLogarithm3 = Mockito.mock(Logarithm.class);
        mockedLogarithm5 = Mockito.mock(Logarithm.class);
        mockedLogarithm10 = Mockito.mock(Logarithm.class);


        sine = new Sine();
        cosine = new Cosine(sine);
        tangent = new Tangent(sine,cosine);
        cosecant = new Cosecant(sine);
        secant = new Secant(cosine);


        naturalLogarithm = new NaturalLogarithm();

        logarithm2 = new Logarithm(naturalLogarithm, 2);
        logarithm3 = new Logarithm(naturalLogarithm, 3);
        logarithm5 = new Logarithm(naturalLogarithm, 5);
        logarithm10 = new Logarithm(naturalLogarithm, 10);


        try {
            Reader cos = new FileReader("src/main/resources/csv/cosine.csv");
            Reader tan = new FileReader("src/main/resources/csv/tangent.csv");
            Reader cosec = new FileReader("src/main/resources/csv/cosecant.csv");
            Reader sec = new FileReader("src/main/resources/csv/secant.csv");
            Reader ln = new FileReader("src/main/resources/csv/natural_log.csv");
            Reader log2 = new FileReader("src/main/resources/csv/log2.csv");
            Reader log3 = new FileReader("src/main/resources/csv/log3.csv");
            Reader log5 = new FileReader("src/main/resources/csv/log5.csv");
            Reader log10 = new FileReader("src/main/resources/csv/log10.csv");


            for (CSVRecord record : CSVFormat.DEFAULT.parse(cos)) {
                Mockito.when(mockedCosine.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(tan)) {
                Mockito.when(mockedTangent.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(cosec)) {
                    Mockito.when(mockedCosecant.calculate(Double.parseDouble(record.get(0))))
                            .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(sec)) {
                Mockito.when(mockedSecant.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(ln)) {
                double value = Double.parseDouble((record.get(0)));
                if (value<=0){
                    Mockito.when(mockedNaturalLogarithm.calculate(Double.parseDouble(record.get(0))))
                            .thenThrow(NumberFormatException.class);
                }
                else {
                    Mockito.when(mockedNaturalLogarithm.calculate(Double.parseDouble(record.get(0))))
                            .thenReturn(Double.parseDouble(record.get(1)));
                }
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(log2)) {
                double value = Double.parseDouble((record.get(0)));
                if (value<=0){
                    Mockito.when(mockedLogarithm2.calculate(Double.parseDouble(record.get(0))))
                            .thenThrow(NumberFormatException.class);
                }
                else {
                    Mockito.when(mockedLogarithm2.calculate(Double.parseDouble(record.get(0))))
                            .thenReturn(Double.parseDouble(record.get(1)));
                }
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(log3)) {
                double value = Double.parseDouble((record.get(0)));
                if (value<=0){
                    Mockito.when(mockedLogarithm3.calculate(Double.parseDouble(record.get(0))))
                            .thenThrow(NumberFormatException.class);
                }
                else {
                    Mockito.when(mockedLogarithm3.calculate(Double.parseDouble(record.get(0))))
                            .thenReturn(Double.parseDouble(record.get(1)));
                }
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(log5)) {
                double value = Double.parseDouble((record.get(0)));
                if (value<=0){
                    Mockito.when(mockedLogarithm5.calculate(Double.parseDouble(record.get(0))))
                            .thenThrow(NumberFormatException.class);
                }
                else {
                    Mockito.when(mockedLogarithm5.calculate(Double.parseDouble(record.get(0))))
                            .thenReturn(Double.parseDouble(record.get(1)));
                }
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(log10)) {
                double value = Double.parseDouble((record.get(0)));
                if (value<=0){
                    Mockito.when(mockedLogarithm10.calculate(Double.parseDouble(record.get(0))))
                            .thenThrow(NumberFormatException.class);
                }
                else {
                    Mockito.when(mockedLogarithm10.calculate(Double.parseDouble(record.get(0))))
                            .thenReturn(Double.parseDouble(record.get(1)));
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testCosine(double value, double expected) {
        Function function = new Function(
                cosine,
                mockedTangent,
                mockedSecant,
                mockedCosecant,
                mockedNaturalLogarithm,
                mockedLogarithm2,
                mockedLogarithm3,
                mockedLogarithm5,
                mockedLogarithm10
        );
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testTangent(double value, double expected) {
        Function function = new Function(
                mockedCosine,
                tangent,
                mockedSecant,
                mockedCosecant,
                mockedNaturalLogarithm,
                mockedLogarithm2,
                mockedLogarithm3,
                mockedLogarithm5,
                mockedLogarithm10
        );
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testSecant(double value, double expected) {
        Function function = new Function(
                mockedCosine,
                mockedTangent,
                secant,
                mockedCosecant,
                mockedNaturalLogarithm,
                mockedLogarithm2,
                mockedLogarithm3,
                mockedLogarithm5,
                mockedLogarithm10
        );
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testCosecant(double value, double expected) {
        Function function = new Function(
                mockedCosine,
                mockedTangent,
                mockedSecant,
                cosecant,
                mockedNaturalLogarithm,
                mockedLogarithm2,
                mockedLogarithm3,
                mockedLogarithm5,
                mockedLogarithm10
        );
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testTrig(double value, double expected) {
        Function function = new Function(
                cosine,
                tangent,
                secant,
                cosecant,
                mockedNaturalLogarithm,
                mockedLogarithm2,
                mockedLogarithm3,
                mockedLogarithm5,
                mockedLogarithm10
        );
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testNaturalLogarithm(double value, double expected) {
        Function function = new Function(
                mockedCosine,
                mockedTangent,
                mockedSecant,
                mockedCosecant,
                naturalLogarithm,
                mockedLogarithm2,
                mockedLogarithm3,
                mockedLogarithm5,
                mockedLogarithm10
        );
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void test2Logarithm(double value, double expected) {
        Function function = new Function(
                mockedCosine,
                mockedTangent,
                mockedSecant,
                mockedCosecant,
                mockedNaturalLogarithm,
                logarithm2,
                mockedLogarithm3,
                mockedLogarithm5,
                mockedLogarithm10
        );
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void tes3Logarithm(double value, double expected) {
        Function function = new Function(
                mockedCosine,
                mockedTangent,
                mockedSecant,
                mockedCosecant,
                mockedNaturalLogarithm,
                mockedLogarithm2,
                logarithm3,
                mockedLogarithm5,
                mockedLogarithm10
        );
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void test5Logarithm(double value, double expected) {
        Function function = new Function(
                mockedCosine,
                mockedTangent,
                mockedSecant,
                mockedCosecant,
                mockedNaturalLogarithm,
                mockedLogarithm2,
                mockedLogarithm3,
                logarithm5,
                mockedLogarithm10
        );
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void test10Logarithm(double value, double expected) {
        Function function = new Function(
                mockedCosine,
                mockedTangent,
                mockedSecant,
                mockedCosecant,
                mockedNaturalLogarithm,
                mockedLogarithm2,
                mockedLogarithm3,
                mockedLogarithm5,
                logarithm10
        );
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }
}
