package src.test.java.function_A;

import org.junit.Test;
import src.main.java.Function_A.Validation;

import static org.junit.Assert.*;

public class Validation_Tester {
    private Validation val = new Validation();


    
    @Test
    public void Check_Num_Week_Valid() {
        boolean expected = true;
        boolean actual = val.Check_Num_Week("2");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Num_Week_InValid1(){
        boolean expected = false;
        boolean actual = val.Check_Num_Week("01");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Num_Week_InValid2(){
        boolean expected = false;
        boolean actual = val.Check_Num_Week("10000");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Num_Week_Upper_Bound(){
        boolean expected = true;
        boolean actual = val.Check_Num_Week("15");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Num_Week_Lower_Bound(){
        boolean expected = true;
        boolean actual = val.Check_Num_Week("1");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Num_Week_Invalid_Format1(){
        boolean expected = false;
        boolean actual = val.Check_Num_Week("Ahduhf-7");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Num_Week_Invalid_Format2(){
        boolean expected = false;
        boolean actual = val.Check_Num_Week("6.7");
        assertEquals(expected,actual);
    }

    
   
    @Test
    public void Check_Prc_Rose_Valid() {
        boolean expected = true;
        boolean actual = val.Check_Prc_Rose("6.07");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Prc_Rose_Invalid(){
        boolean expected= false;
        boolean actual = val.Check_Prc_Rose("-0.89");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Prc_Rose_Bound(){
        boolean expected= true;
        boolean actual = val.Check_Prc_Rose("1.00");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Prc_Rose_Invalid_Format1(){
        boolean expected= false;
        boolean actual = val.Check_Prc_Rose("xyz");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Prc_Rose_Invalid_Format2(){
        boolean expected= false;
        boolean actual = val.Check_Prc_Rose("0.4f");
        assertEquals(expected,actual);
    }
    
    
    @Test
    public void Check_Prc_Noir_Valid() {
        boolean expected = true;
        boolean actual = val.Check_Prc_Noir("2.01");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Prc_Noir_Invalid(){
        boolean expected= false;
        boolean actual = val.Check_Prc_Noir("-1.26");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Prc_Noir_Bound(){
        boolean expected= true;
        boolean actual = val.Check_Prc_Noir("1.00");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Prc_Noir_Invalid_Format1(){
        boolean expected= false;
        boolean actual = val.Check_Prc_Noir("asd");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Prc_Noir_Invalid_Format2(){
        boolean expected= false;
        boolean actual = val.Check_Prc_Noir("0.2f");
        assertEquals(expected,actual);
    }
    
    
    
    @Test
    public void Check_Cap_Labor_Valid() {
        boolean expected = true;
        boolean actual = val.Check_Cap_Labor("2");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Cap_Labor_InValid(){
        boolean expected = false;
        boolean actual = val.Check_Cap_Labor("0");
        assertEquals(expected,actual);
    }

    @Test
    public void Check_Cap_Labor_Bound(){
        boolean expected = true;
        boolean actual = val.Check_Cap_Labor("1");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Cap_Labor_Invalid_Format1(){
        boolean expected = false;
        boolean actual = val.Check_Cap_Labor("Ahduhf-7");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Cap_Labor_Invalid_Format2(){
        boolean expected = false;
        boolean actual = val.Check_Cap_Labor("7.7");
        assertEquals(expected,actual);
    }
    
    
    
    @Test
    public void Check_Cap_Grape_Valid() {
        boolean expected = true;
        boolean actual = val.Check_Cap_Grape("2");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Cap_Grape_InValid(){
        boolean expected = false;
        boolean actual = val.Check_Cap_Grape("0");
        assertEquals(expected,actual);
    }

    @Test
    public void Check_Cap_Grape_Bound(){
        boolean expected = true;
        boolean actual = val.Check_Cap_Grape("1");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Cap_Grape_Invalid_Format1(){
        boolean expected = false;
        boolean actual = val.Check_Cap_Grape("Ahduhf-7");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Cap_Grape_Invalid_Format2(){
        boolean expected = false;
        boolean actual = val.Check_Cap_Grape("7.7");
        assertEquals(expected,actual);
    }

    
    
    @Test
    public void Check_Fixed_Costs_Valid() {
        boolean expected = true;
        boolean actual = val.Check_Fixed_Costs("10000");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Fixed_Costs_InValid(){
        boolean expected = false;
        boolean actual = val.Check_Fixed_Costs("-7");
        assertEquals(expected,actual);
    }

    @Test
    public void Check_Fixed_Costs_Bound(){
        boolean expected = true;
        boolean actual = val.Check_Fixed_Costs("0");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Fixed_Costs_Invalid_Format1(){
        boolean expected = false;
        boolean actual = val.Check_Fixed_Costs("Ahduhf-7");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Fixed_Costs_Invalid_Format2(){
        boolean expected = false;
        boolean actual = val.Check_Fixed_Costs("6.6");
        assertEquals(expected,actual);
    }


}