package lb.esib;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Functions {


    public static int mapReduce(int zero, BiFunction<Integer, Integer, Integer> op,
                                Function<Integer, Integer> f, int a, int b) {
        if (a > b)
            return zero;
        else
            return op.apply(f.apply(a), mapReduce(zero, op,f,a+1, b));
    }

    public static int product(Function<Integer,Integer> f, int a, int b) {
        return mapReduce(1, (x, y) -> x * y, f, a, b);
    }

    public static int sum(Function<Integer,Integer> f, int a, int b) {
        return mapReduce(0, (x, y) -> y + x, f, a, b);
    }


    public static int sumCubes(int a, int b) {
        return sum(x -> x * x * x, a, b);
    }

    public static int sumInts(int a, int b) {
        return sum(x -> x, a, b);
    }


    public static int factorial(int n) {
        return product(x->x, 1, n);
    }

    public static int sumFact(int a, int b) {
        return sum(x-> Functions.factorial(x), a, b);
    }

    private Functions() {
        // Private constructor
    }
}
