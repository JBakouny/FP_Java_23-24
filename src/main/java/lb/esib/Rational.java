package lb.esib;

import java.util.Objects;

import static lb.esib.Functions.gcd;

public class Rational {
    public Rational(int x, int y) {
        int g = gcd(x, y);
        this.x = x / g;
        this.y = y / g;
    }

    public int numer() {
        return x;
    }

    public int denom() {
        return y;
    }

    public Rational add(Rational that) {
        return new Rational(
                numer() * that.denom() + that.numer() * denom(),
                denom() * that.denom());
    }

    private final int x;
    private final int y;

    @Override
    public String toString() {
        if (y == 1)
            return x + "";
        return x + " / " + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rational rational)) return false;
        return x == rational.x && y == rational.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    // equals
    // hashCode
}
