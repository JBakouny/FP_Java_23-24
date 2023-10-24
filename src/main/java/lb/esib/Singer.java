package lb.esib;

public interface Singer {
    default void sing() {
        System.out.println("Singing");
    }
}
