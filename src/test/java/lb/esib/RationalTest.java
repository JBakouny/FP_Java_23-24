package lb.esib;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class RationalTest {
    @Test
    public void RationalAddTest() {
        Rational a = new Rational(2, 3);
        Rational b = new Rational(3, 5);
        Rational actual = a.add(b);
        Rational expected = new Rational(19,15);
        assertEquals(expected, actual);
    }

    @Test
    public void RationalAddExtremeValuesTest() {
        Rational a = new Rational(1, 2);
        Rational actual = a.add(a);
        Rational expected = new Rational(1,1);
        assertEquals(expected, actual);
    }
}
