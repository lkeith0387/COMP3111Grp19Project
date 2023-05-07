package function_B;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import src.main.java.*;
import org.junit.Assert;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import src.main.java.function_B.functionBController;


public class functionBControllerTest {
	
	
	@Test
	public void testdatainvalid_valid() {
		functionBController func = new functionBController();
		String[] input = {"0","0","0","0","0"};
		String[] expected = new String[]{
				"Num_Week: Please enter an integer between 2301 and 2315",
				"Cap_Labor: Please enter an integer greater than 0",
				"Cap_Grape: Please enter an integer greater than 0",
				"Prc_Rose: Please enter a number greater than 0",
				"Prc_Noir: Please enter a number greater than 0",
        };
        ObservableList<String> actual = func.datainvalid(input);
        for(int i = 0; i < 5; i++){
            assertEquals(expected[i],actual.get(i));
        }
    }
		
	@Test
	public void test_message_valid_w1() {
		functionBController func = new functionBController();
		ObservableList<String> expected = FXCollections.observableArrayList("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!");
        ObservableList<String> actual = func.message(6000,1000);
        assertEquals(expected.get(0),actual.get(0));

	}
	
	@Test
	public void test_message_valid_w2() {
		functionBController func = new functionBController();
		String[] input = {"2301","1","1","1","1"};
        func.Input_Data(input);
        ObservableList<String> expected = FXCollections.observableArrayList("W2: Insufficient labor supplied to utilize the grape resource (less than 90%).");
        ObservableList<String> actual  = func.message(0,0);
        assertEquals(expected.get(0),actual.get(0));
    }
	
	
	@Test
	public void test_message_invalid_w1() {
		functionBController func = new functionBController();
        ObservableList<String> expected = FXCollections.observableArrayList();
        ObservableList<String> actual = func.message(0,0);
        assertEquals(expected.size(),actual.size());
	}
	
	@Test
	public void test_message_invalid_w2() {
		functionBController func = new functionBController();
		String[] input = {"2301","12000","5000","10","10"};
        func.Input_Data(input);
		ObservableList<String> expected = FXCollections.observableArrayList();
        ObservableList<String> actual = func.message(230,904);
        assertEquals(expected.size(),actual.size());
		
	}
	
	
	@Test
	public void test_surplus_message_invalid() {
		functionBController func = new functionBController();
		ObservableList<String> expected = FXCollections.observableArrayList();
		ObservableList<String> actual = func.surplus_message(1,1);
		assertEquals(expected.size(),actual.size());
	}
	
	@Test
	public void test_surplus_message_valid_er1a() {
		functionBController func = new functionBController();
		ObservableList<String> expected = FXCollections.observableArrayList("Er1a:Program bug is occurred, Labor Consumption cannot greater than its capacity!");
		ObservableList<String> actual = func.surplus_message(-1,1);
		assertEquals(expected.get(0),actual.get(0));
	}
	
	@Test
	public void test_surplus_message_valid_er1b() {
		functionBController func = new functionBController();
		ObservableList<String> expected = FXCollections.observableArrayList("Er1b:Program bug is occurred, Grape Consumption cannot greater than its capacity!");
		ObservableList<String> actual = func.surplus_message(1,-1);
		assertEquals(expected.get(0),actual.get(0));
	}
	
	@Test 
	public void test_surplus_message_valid() {
		functionBController func = new functionBController();
		ObservableList<String> expected = FXCollections.observableArrayList("Er1a:Program bug is occurred, Labor Consumption cannot greater than its capacity!","Er1b:Program bug is occurred, Grape Consumption cannot greater than its capacity!");
		ObservableList<String> actual = func.surplus_message(-1,-1);
		assertEquals(expected.get(0),actual.get(0));
		assertEquals(expected.get(1),actual.get(1));
	}
}
