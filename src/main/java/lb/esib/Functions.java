package lb.esib;

import java.util.function.Function;

public class Functions {


    public static int product(Function<Integer,Integer> f, int a, int b) {
        if (a > b)
            return 1;
        else
            return f.apply(a) * product(f,a+1, b);
    }

    public static int sum(Function<Integer,Integer> f, int a, int b) {
        if (a > b)
            return 0;
        else
            return f.apply(a) + sum(f,a+1, b);
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
