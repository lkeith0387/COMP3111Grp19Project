package function_C;

import org.junit.Test;
import src.main.java.Function_C.Solver_Function_C;

import static org.junit.Assert.*;
public class Solver_FunctionC_Tester {

    @Test
    public void opt_Solution1() {
        Solver_Function_C sol = new Solver_Function_C(16,36,12,40);
        int[] expected = {0,1};
        int[] actual = sol.Opt_Solution(false,0,0);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void opt_Solution2() {
        Solver_Function_C sol = new Solver_Function_C(5,6,12,40);
        int[] expected = {1,0};
        int[] actual = sol.Opt_Solution(false,0,0);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void opt_Solution3() {
        Solver_Function_C sol = new Solver_Function_C(12,6,60,40);
        int[] expected = {0,1};
        int[] actual = sol.Opt_Solution(true,0,1);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void opt_Solution4() {
        Solver_Function_C sol = new Solver_Function_C(12,6,60,1000);
        int[] expected = {1,0};
        int[] actual = sol.Opt_Solution(true,1,0);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void calculation() {
        Solver_Function_C sol = new Solver_Function_C(16,36,12,40);
        float actual = sol.Calculation(1,1);
        float expected = 52.0f;
        assertEquals(expected,actual,0);
    }
}