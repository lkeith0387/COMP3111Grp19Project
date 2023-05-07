package function_C;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;
import src.main.java.Function_C.Function_C;
import src.main.java.Function_C.Result;

import static org.junit.Assert.*;

public class Function_C_Tester {

    @Test
    public void Get_Result_Without_Bko_Fulfill() {
        Function_C func = new Function_C();
        String[] input = {"2301","0","0","0.0","0.0","1","1"};
        func.Get_Data(input);
        Result expected = new Result(false,0,0,0);
        Result actual = func.Get_Result();
        assertEquals(expected.Opt_Noir,actual.Opt_Noir);
        assertEquals(expected.Opt_Rose,actual.Opt_Rose);
        assertEquals(expected.Opt_Revenue,actual.Opt_Revenue);
        assertEquals(expected.Bko_Fulfill,actual.Bko_Fulfill);
    }
    @Test
    public void Get_Result_With_Bko_Fulfill() {
        Function_C func = new Function_C();
        String[] input = {"2301","16","36","12","40","0","1"};
        func.Get_Data(input);
        Result expected = new Result(true,0,1,40);
        Result actual = func.Get_Result();
        assertEquals(expected.Opt_Noir,actual.Opt_Noir);
        assertEquals(expected.Opt_Rose,actual.Opt_Rose);
        assertEquals(expected.Opt_Revenue,actual.Opt_Revenue);
        assertEquals(expected.Bko_Fulfill,actual.Bko_Fulfill);
    }



    @Test
    public void Get_Warning_Message_W1_Valid() {
        Function_C func = new Function_C();
        ObservableList<String> expected = FXCollections.observableArrayList("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!");
        ObservableList<String> actual = func.Get_Warning_Message(6000,1000);
        assertEquals(expected.get(0),actual.get(0));
    }
    @Test
    public void Get_Warning_Message_W1_Invalid() {
        Function_C func = new Function_C();
        ObservableList<String> expected = FXCollections.observableArrayList();
        ObservableList<String> actual = func.Get_Warning_Message(0,0);
        assertEquals(expected.size(),actual.size());
    }
    @Test
    public void Get_Warning_Message_W2_Valid(){
        Function_C func = new Function_C();
        String[] input = {"2302","0","1","1","1","0","0"};
        func.Get_Data(input);
        ObservableList<String> expected = FXCollections.observableArrayList("w2: Insufficient labor supplied to utilize the grape resource (less than 90%).");
        ObservableList<String> actual  = func.Get_Warning_Message(0,0);
        assertEquals(expected.get(0),actual.get(0));
    }
    @Test
    public void Get_Warning_Message_W2_Invalid(){
        Function_C func = new Function_C();
        String[] input = {"2302","0","1","1","1","100","100"};
        func.Get_Data(input);
        ObservableList<String> expected = FXCollections.observableArrayList();
        ObservableList<String> actual  = func.Get_Warning_Message(10,10);
        assertEquals(expected.size(),actual.size());
    }
    @Test
    public void Get_Warning_Message_W3_Valid(){
        Function_C func = new Function_C();
        String[] input = {"2302","0","1","1","1","0","0"};
        func.Get_Data(input);
        ObservableList<String> expected = FXCollections.observableArrayList("w3: According to company policy, ratio of backorder volume should not lower than 70% of the optimal production volume!");
        ObservableList<String> actual  = func.Get_Warning_Message(1,10);
        assertEquals(expected.get(0),actual.get(0));
    }
    @Test
    public void Get_Warning_Message_W3_Invalid(){
        Function_C func = new Function_C();
        String[] input = {"2302","0","0","1","1","0","0"};
        func.Get_Data(input);
        ObservableList<String> expected = FXCollections.observableArrayList();
        ObservableList<String> actual  = func.Get_Warning_Message(0,0);
        assertEquals(expected.size(),actual.size());
    }
    @Test
    public void Data_Validation(){
        String[] expected = new String[]{
                "Input error for Week Of Year: Please enter an integer in between 2301 and 2315.",
                "Input error for Capacity Of Labor: Please enter an integer greater than 0.",
                "Input error for Capacity Of Grape: Please enter an integer greater than 0.",
                "Input error for Price Of Rose: Please enter a number greater than 0.",
                "Input error for Price Of P-Noir: Please enter a number greater than 0.",
                "Input error for Backorder Volume of Rose: Please enter a non-negative number.",
                "Input error for Backorder Volume of P-Noir: Please enter a non-negative number."
        };
        Function_C func = new Function_C();
        String[] input = {"","","","","","",""};
        ObservableList<String> actual = func.Data_Validation(input);
        for(int i = 0 ;i <7 ;i++){
            assertEquals(expected[i],actual.get(i));
        }
    }
}