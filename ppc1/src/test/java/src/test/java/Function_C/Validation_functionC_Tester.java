package src.test.java.Function_C;

import org.junit.Test;
import src.main.java.Function_C.Validation_Function_C;

import static org.junit.Assert.*;

public class Validation_functionC_Tester {
    private Validation_Function_C val = new Validation_Function_C();


    @Test
    public void Check_Week_Of_Year_Valid() {
        boolean expected = true;
        boolean actual = val.Check_Week_Of_Year("2302");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Week_Of_Year_InValid1(){
        boolean expected = false;
        boolean actual = val.Check_Week_Of_Year("1");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Week_Of_Year_InValid2(){
        boolean expected = false;
        boolean actual = val.Check_Week_Of_Year("10000");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Week_Of_Year_Upper_Bound(){
        boolean expected = true;
        boolean actual = val.Check_Week_Of_Year("2315");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Week_Of_Year_Lower_Bound(){
        boolean expected = true;
        boolean actual = val.Check_Week_Of_Year("2301");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Week_Of_Year_Invalid_Format1(){
        boolean expected = false;
        boolean actual = val.Check_Week_Of_Year("Ahduhf-7");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Week_Of_Year_Invalid_Format2(){
        boolean expected = false;
        boolean actual = val.Check_Week_Of_Year("7.7");
        assertEquals(expected,actual);
    }


    @Test
    public void Check_Bko_Rose_Valid() {
        boolean expected = true;
        boolean actual = val.Check_Bko_Rose("2");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Bko_Rose_Invalid(){
        boolean expected= false;
        boolean actual = val.Check_Bko_Rose("-1");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Bko_Rose_Bound(){
        boolean expected= true;
        boolean actual = val.Check_Bko_Rose("0");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Bko_Rose_Invalid_Format1(){
        boolean expected= false;
        boolean actual = val.Check_Bko_Rose("0.2");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Bko_Rose_Invalid_Format2(){
        boolean expected= false;
        boolean actual = val.Check_Bko_Rose("0.2f");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Bko_Noir_Valid() {
        boolean expected = true;
        boolean actual = val.Check_Bko_Noir("2");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Bko_Noir_Invalid(){
        boolean expected= false;
        boolean actual = val.Check_Bko_Noir("-1");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Bko_Noir_Bound(){
        boolean expected= true;
        boolean actual = val.Check_Bko_Noir("0");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Bko_Noir_Invalid_Format1(){
        boolean expected= false;
        boolean actual = val.Check_Bko_Noir("0.2");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Bko_Noir_Invalid_Format2(){
        boolean expected= false;
        boolean actual = val.Check_Bko_Noir("0.2f");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Prc_Rose_Valid() {
        boolean expected = true;
        boolean actual = val.Check_Prc_Rose("2.01");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Prc_Rose_Invalid(){
        boolean expected= false;
        boolean actual = val.Check_Prc_Rose("-1.26");
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
        boolean actual = val.Check_Prc_Rose("asd");
        assertEquals(expected,actual);
    }
    @Test
    public void Check_Prc_Rose_Invalid_Format2(){
        boolean expected= false;
        boolean actual = val.Check_Prc_Rose("0.2f");
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


}