package ppc;

import org.junit.Test;

import src.main.java.InputValidation;

import static org.junit.Assert.*;

public class InputValidationTest {
	private InputValidation valid = new InputValidation();
	
	@Test
	public void Check_valid_num_week() {
		boolean expected = true;
        boolean actual = valid.Check_Num_Week("2302");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_num_week() {
		boolean expected = false;
        boolean actual = valid.Check_Num_Week("23");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_upper_bound_num_week() {
		boolean expected = true;
        boolean actual = valid.Check_Num_Week("2315");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_lower_bound_num_week() {
		boolean expected = true;
        boolean actual = valid.Check_Num_Week("2301");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_format1_num_week() {
		boolean expected = false;
        boolean actual = valid.Check_Num_Week("asidash kuga ka");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_format2_num_week() {
		boolean expected = false;
        boolean actual = valid.Check_Num_Week("2.34");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_format3_num_week() {
		boolean expected = false;
        boolean actual = valid.Check_Num_Week("!@#$%^##$@$");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_valid_cap_labor() {
		boolean expected = true;
        boolean actual = valid.Check_Cap_Labor("23");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_cap_labor() {
		boolean expected = false;
        boolean actual = valid.Check_Cap_Labor("1.1");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_lower_bound_cap_labor() {
		boolean expected = true;
        boolean actual = valid.Check_Cap_Labor("1");
        assertEquals(expected,actual);
	}
	
	
	@Test
	public void Check_invalid_format1_cap_labor() {
		boolean expected = false;
        boolean actual = valid.Check_Cap_Labor("asd");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_format2_cap_labor() {
		boolean expected = false;
        boolean actual = valid.Check_Cap_Labor("7.7");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_format3_cap_labor() {
		boolean expected = false;
        boolean actual = valid.Check_Cap_Labor("!#@$%#");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_valid_cap_grape() {
		boolean expected = true;
        boolean actual = valid.Check_Cap_Grape("2302");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_cap_grape() {
		boolean expected = false;
        boolean actual = valid.Check_Cap_Grape("23.2");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_lower_bound_cap_grape() {
		boolean expected = true;
        boolean actual = valid.Check_Cap_Grape("1");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_format1_cap_grape() {
		boolean expected = false;
        boolean actual = valid.Check_Cap_Grape("asdasdasdas");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_format2_cap_grape() {
		boolean expected = false;
        boolean actual = valid.Check_Cap_Grape("23.43");
        assertEquals(expected,actual);
	}
	
	
	@Test
	public void Check_invalid_format3_cap_grape() {
		boolean expected = false;
        boolean actual = valid.Check_Cap_Grape("!@%@()*!");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_valid_prc_rose() {
		boolean expected = true;
        boolean actual = valid.Check_Prc_Rose("123");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_valid1_prc_rose() {
		boolean expected = true;
        boolean actual = valid.Check_Prc_Rose("2.3");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_prc_rose() {
		boolean expected = false;
        boolean actual = valid.Check_Prc_Rose("-1");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_format1_prc_rose() {
		boolean expected = false;
        boolean actual = valid.Check_Prc_Rose("asd");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_format2_prc_rose() {
		boolean expected = false;
        boolean actual = valid.Check_Prc_Rose("-1223");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_format3_prc_rose() {
		boolean expected = false;
        boolean actual = valid.Check_Prc_Rose("!@#$%^&*()");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_out_of_bound_prc_rose() {
		boolean expected = false;
        boolean actual = valid.Check_Prc_Rose("0");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_valid_prc_noir() {
		boolean expected = true;
        boolean actual = valid.Check_Prc_Noir("2302");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_invalid_prc_noir() {
		boolean expected = false;
        boolean actual = valid.Check_Prc_Noir("-123");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_lower_bound_prc_noir() {
		boolean expected = true;
        boolean actual = valid.Check_Prc_Noir("0.1");
        assertEquals(expected,actual);
	}
	
	@Test
	public void Check_out_of_bound_prc_noir() {
		boolean expected = false;
        boolean actual = valid.Check_Prc_Noir("0");
        assertEquals(expected,actual);
	}
	

}
