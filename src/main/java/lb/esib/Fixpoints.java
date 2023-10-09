package lb.esib;

import java.util.function.Function;

import static java.lang.Math.abs;

public class Fixpoints {
    private static final double tolerance = 0.0000000000000000001;

    private static boolean isCloseEnough(double expected, double actual) {
        return abs((expected - actual) / expected) < tolerance;
    }

    public static double fixedPoint(Function<Double, Double> f, double firstGuess) {
        double x = firstGuess;
        double next = f.apply(x);
        while(!isCloseEnough(x, next)) {
            x = next;
            next = f.apply(x);
        }
        return next;
    }

    public static Function<Double, Double> averageDamp(Function<Double, Double> f) {
        return x -> (x + f.apply(x)) / 2;
    }

    public static double sqrt(double x) {
        return fixedPoint(averageDamp(y -> x / y), 1);
    }
}
