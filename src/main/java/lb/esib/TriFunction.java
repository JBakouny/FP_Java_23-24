package lb.esib;

@FunctionalInterface
public interface TriFunction<T1, T2, T3, R> {
    R apply(T1 x1, T2 x2, T3 x3);
}
