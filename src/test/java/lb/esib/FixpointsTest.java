package lb.esib;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static lb.esib.Fixpoints.*;

public class FixpointsTest {

    public static final double DELTA = 0.0001;

    @Test
    public void fixpointTest() {
        assertEquals(fixedPoint(x->1+x/2.0, 1),2, DELTA);
    }
    @Test
    public void sqrtTest() {
        assertEquals(sqrt(9), 3, DELTA);
    }

}
