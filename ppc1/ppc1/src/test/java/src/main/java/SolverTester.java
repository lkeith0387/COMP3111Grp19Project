package src.main.java;

import org.junit.Test;

import static org.junit.Assert.*;
public class SolverTester {

    @Test
    public void opt_Solution() {
        Solver sol = new Solver(16,36,12,40);
        int[] expected = {0,1};
        int[] actual = sol.Opt_Solution();
        assertArrayEquals(expected,actual);
    }

    @Test
    public void calculation() {
        Solver sol = new Solver(16,36,12,40);
        double actual = sol.Calculation(1,1);
        double expected = 52.0;
        assertEquals(expected,actual,0);
    }
}