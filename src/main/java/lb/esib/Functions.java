package lb.esib;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Functions {

    public static int mapReduce(int zero, BiFunction<Integer, Integer, Integer> op,
                                Function<Integer, Integer> f, int a, int b) {
        int res = zero;
        for (int i = a; i < b+1; ++i) {
            res = op.apply(res, f.apply(i));
        }
        return res;
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
        return sum(Functions::factorial, a, b);
    }

    private Functions() {
        // Private constructor
    }
}
