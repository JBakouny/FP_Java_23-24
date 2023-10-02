package lb.esib;
import static org.junit.Assert.assertEquals;

import lb.esib.Functions;
import org.junit.Test;

import static lb.esib.Functions.*;


public class FunctionsTest {
    @Test
    public void sumIntsTest() {
        assertEquals(125250, sumInts(0, 500));
    }

    @Test
    public void sumCubesTest() {
        assertEquals(1625625, sumCubes(0, 50));
    }

    @Test
    public void sumFactTest() {
        assertEquals(154, sumFact(0, 5));
    }

    @Test
    public void factorialTest() {
        assertEquals(120, factorial(5));
    }

    @Test
    public void sumIntsPerformanceTest() {
        assertEquals(1250000025 * 1000000, sumInts(0, 50000000));
    }
}
