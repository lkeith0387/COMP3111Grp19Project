package Function_A;

import org.junit.Test;
import src.main.java.Function_A.Solver_Function_A;

import static org.junit.Assert.*;
public class Solver_FunctionA_Tester {

    @Test
    public void opt_Solution1() {
        Solver_Function_A sol = new Solver_Function_A(16,36,12,40);
        int[] expected = {0,1};
        int[] actual = sol.Opt_Solution();
        assertArrayEquals(expected,actual);
    }
    @Test
    public void opt_Solution2() {
        Solver_Function_A sol = new Solver_Function_A(5,6,12,40);
        int[] expected = {1,0};
        int[] actual = sol.Opt_Solution();
        assertArrayEquals(expected,actual);
    }
    @Test
    public void calculation() {
        Solver_Function_A sol = new Solver_Function_A(16,36,12,40);
        float actual = sol.Calculation(1,1);
        float expected = 52.0f;
        assertEquals(expected,actual,0);
    }
}