package function_C;

import org.junit.Test;
import src.main.java.Function_C.Solver;

import static org.junit.Assert.*;
public class Solver_Tester {

    @Test
    public void opt_Solution1() {
        Solver sol = new Solver(16,36,12,40);
        int[] expected = {0,1};
        int[] actual = sol.Opt_Solution(false,0,0);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void opt_Solution2() {
        Solver sol = new Solver(5,6,12,40);
        int[] expected = {1,0};
        int[] actual = sol.Opt_Solution(false,0,0);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void opt_Solution3() {
        Solver sol = new Solver(12,6,60,40);
        int[] expected = {0,1};
        int[] actual = sol.Opt_Solution(true,0,1);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void opt_Solution4() {
        Solver sol = new Solver(12,6,60,1000);
        int[] expected = {1,0};
        int[] actual = sol.Opt_Solution(true,1,0);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void calculation() {
        Solver sol = new Solver(16,36,12,40);
        float actual = sol.Calculation(1,1);
        float expected = 52.0f;
        assertEquals(expected,actual,0);
    }
}