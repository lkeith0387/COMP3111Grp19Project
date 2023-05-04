package ppc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import src.main.java.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * A class to test if different values pass the calculation in the Calculator class.
 * @author Steven
 *
 */

public class CalculatorTest {
	
	Calculator a = new Calculator();

	@Test
    public void testCalculatorPass() {
    	Assert.assertEquals("true",2, a.Calculation(1, 1, 1, 1));
    	Assert.assertEquals("true",557, a.Calculation(2, 15, 50, 30.5f));
    	Assert.assertEquals("true",1570, a.Calculation(7, 40, 50, 30.5f));
    	Assert.assertEquals("true",4414, a.Calculation(12, 65, 97, 50));
    	Assert.assertEquals("true",60, a.Calculation(5, 5, 6, 6));
    	Assert.assertEquals("true",4186, a.Calculation(567, 789, 3, 3.15f));
    	Assert.assertEquals("true",7080, a.Calculation(3, 231, 50, 30));
    	Assert.assertEquals("true",20470, a.Calculation(15, 43, 132, 430));
    	Assert.assertEquals("true",750, a.Calculation(10, 15, 30, 30));
    	Assert.assertEquals("true",1670, a.Calculation(57, 23, 17, 30.52f));
    	Assert.assertEquals("true",4372, a.Calculation(60, 45, 50, 30.5f));
    	Assert.assertEquals("true",13613, a.Calculation(132, 253, 45, 30.33f));
    	Assert.assertEquals("true",607, a.Calculation(3, 15, 50, 30.5f));
    	Assert.assertEquals("true",71612, a.Calculation(1234, 325, 50, 30.5f));
    	Assert.assertEquals("true",1950, a.Calculation(24, 25, 50, 30));
    	Assert.assertEquals("true",11287, a.Calculation(124, 25, 50.5f, 201));
    	Assert.assertEquals("true",71612, a.Calculation(1234, 325, 50, 30.5f));
    	Assert.assertEquals("true",71612, a.Calculation(1234, 325, 50, 30.5f));
    	Assert.assertEquals("true",71612, a.Calculation(1234, 325, 50, 30.5f));
    	Assert.assertEquals("true",71612, a.Calculation(1234, 325, 50, 30.5f));
    	Assert.assertEquals("true",71612, a.Calculation(1234, 325, 50, 30.5f));
    	
    }
	
	
	@Test 
	public void testOptimizationPass() {
		int[] b =a.Optimization(12000, 5000, 10.0f, 10.0f);
		int[] b1 = {230,904,11340};
		Assert.assertArrayEquals(b, b1);
		
		int[] c =a.Optimization(54810, 94000, 47, 52);
		int[] c1 = {10962,0,515214};
		Assert.assertArrayEquals(c, c1);
		
		
	}
}
