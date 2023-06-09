package src.test.java.Function_A;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;
import src.main.java.Function_A.Function_A;
import src.main.java.Function_A.Result_Function_A;

import static org.junit.Assert.*;

public class Function_A_Tester {

    @Test
    public void Get_Result_Fun_A() {
        Function_A func = new Function_A();
        String[] input = {"1","0","0","0.0","0.0","0"};
        func.Get_Data(input);
        Result_Function_A expected = new Result_Function_A(0,0,0,0.0);
        Result_Function_A actual = func.Get_Result();
        assertEquals(expected.Opt_Noir,actual.Opt_Noir);
        assertEquals(expected.Opt_Rose,actual.Opt_Rose);
        assertEquals(expected.Opt_Profit,actual.Opt_Profit);
        assertEquals(expected.Opt_Margin,actual.Opt_Margin,0.1);
    }


    @Test
    public void Get_Warning_Message_W1_Valid() {
        Function_A func = new Function_A();
        ObservableList<String> expected = FXCollections.observableArrayList("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!");
        ObservableList<String> actual = func.Get_Warning_Message(6000,1000);
        assertEquals(expected.get(0),actual.get(0));
    }
    
    
    @Test
    public void Get_Warning_Message_W1_Invalid() {
        Function_A func = new Function_A();
        ObservableList<String> expected = FXCollections.observableArrayList();
        ObservableList<String> actual = func.Get_Warning_Message(0,0);
        assertEquals(expected.size(),actual.size());
    }
    
    
    @Test
    public void Get_Warning_Message_W2_Valid(){
        Function_A func = new Function_A();
        String[] input = {"2","0","1","1","1","0"};
        func.Get_Data(input);
        ObservableList<String> expected = FXCollections.observableArrayList("w2: Insufficient labor supplied to utilize the grape resource (less than 90%).");
        ObservableList<String> actual  = func.Get_Warning_Message(0,0);
        assertEquals(expected.get(0),actual.get(0));
    }
    
    
    @Test
    public void Get_Warning_Message_W2_Invalid(){
        Function_A func = new Function_A();
        String[] input = {"2","0","1","1","1","-1"};
        func.Get_Data(input);
        ObservableList<String> expected = FXCollections.observableArrayList();
        ObservableList<String> actual  = func.Get_Warning_Message(10,10);
        assertEquals(expected.size(),actual.size());
    }
    
    
    @Test
    public void Data_Validation(){
        String[] expected = new String[]{
                "Input error for Number of weeks: Please enter an integer in between 1 and 15",
                "Input error for Capacity Of Labor: Please enter an integer greater than 0",
                "Input error for Capacity Of Grape: Please enter an integer greater than 0",
                "Input error for Price Of Rose: Please enter a number greater than 0",
                "Input error for Price Of P-Noir: Please enter a number greater than 0",
                "Input error for Fixed Costs: Please enter a number greater than 0",
        };
        Function_A func = new Function_A();
        String[] input = {"","","","","",""};
        ObservableList<String> actual = func.Data_Validation(input);
        for(int i = 0; i < 6; i++){
            assertEquals(expected[i],actual.get(i));
        }
    }
}