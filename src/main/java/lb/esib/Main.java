package lb.esib;

import java.util.function.Function;

class Calculator {
    private final int x;
    public Calculator(int x) {
        this.x = x;
    }

    public int add(int y) {
        return x + y;
    }
}


public class Main {

    static int doOp(Function<Integer, Integer> f, Integer a) {
        return f.apply(a);
    }


    public static void main(String[] args) {
        Calculator add5 = new Calculator(5);
        System.out.println(doOp(add5::add, 7));
        System.out.println(doOp(add5::add, 10));

        System.out.println("hello");
    }
}