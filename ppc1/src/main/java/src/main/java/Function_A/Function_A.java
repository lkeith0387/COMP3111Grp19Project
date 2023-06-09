package src.main.java.Function_A;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Function_A class is used to perform compute the optimal mix of wines to be produced in the year to maximize the gross profit of the winery
 */
public class Function_A {
	private int Num_Week;
    private int Cap_Labor;
    private int Cap_Grape;
    private float Prc_Rose;
    private float Prc_Noir;
    private int Fixed_Costs;
    
    
    /**
     * Calculates the optimal volume of two wines (Rosé and P-Noir), then used them to calculate VCL, Sales Revenue, Gross Profit and Profit Margin.
     * @return A Result object that stores the returns optimal volume of Rosé, optimal volume of P-Noir, optimized total gross profits, optimized profit margin
     */
    public Result_Function_A Get_Result(){
    	int Opt_Rose = 0 ;
        int Opt_Noir = 0 ;
        double Labor_Rate = (935/37.5/60);
        
        Solver_Function_A sol;
        sol = new Solver_Function_A(Cap_Labor, Cap_Grape, Prc_Rose, Prc_Noir);
        int[] Result = sol.Opt_Solution();
        Opt_Rose += Result[0];
        Opt_Noir += Result[1];
        
        double VCL = ((Opt_Rose * 5 + Opt_Noir * 12) * Labor_Rate);						 		// VCL = Variable Cost of Labor
        int Sales_Revenue = (int) (Math.round(Opt_Rose * Prc_Rose + Opt_Noir * Prc_Noir)); 		// Sales Revenue = Total Revenue
        int Gross_Profit = (int) (Math.round(Sales_Revenue - VCL - Fixed_Costs)); 			 	// Gross Profit = Opt_Profit
        double Opt_Margin_NotConv = (((double)Gross_Profit) * 100 / Sales_Revenue);				// Profit Margin = Opt_Margin
        double Opt_Margin = roundTwoSigFig(Opt_Margin_NotConv, 1);								// Round Opt_Margin_NotConv to the nearest significant figure
        return new Result_Function_A(Opt_Rose, Opt_Noir, Gross_Profit, Opt_Margin);
    }
    
    
    /**
     * @param value Optimal Margin that has not been converted to the nearest significant figure
     * @param places Round to how many significant figure
     * @return The rounded version of optimal margin
     */
    public static double roundTwoSigFig(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    
    
    /**
     * Converts an array of input into numeric data and stores in the fields of the class.
     * @param input Contains Number of weeks, Capacity of Labor, Capacity of Grape, Price of Rosé, Price of P-Noir, Fixed Costs (in ascending order) 
     */
    public void Get_Data(String[] input){
        Num_Week = Integer.parseInt(input[0]);
        Cap_Labor = Integer.parseInt(input[1]);
        Cap_Grape = Integer.parseInt(input[2]);
        Prc_Rose = Float.parseFloat(input[3]);
        Prc_Noir = Float.parseFloat(input[4]);
        Fixed_Costs = Integer.parseInt(input[5]);
    }
    
    
    /**
     * Checks whether the optimal solution of the volume of Rosé and P-Noir will lead to abnormal situation and produces warning messages for abnormal situations.
     * @param Opt_Rose Number of litres to be produced for Rosé
     * @param Opt_Noir Number of litres to be produced for P-Noir
     * @return A list of warning messages caused by the optimal solution. The list will be empty if there is no abnormal situation happened.
     */
    public ObservableList<String> Get_Warning_Message(int Opt_Rose, int Opt_Noir) {

        ObservableList<String> items = FXCollections.observableArrayList();
        if(5000<Opt_Rose+Opt_Noir){

            items.add("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!");
        }
        if((Opt_Rose*6+Opt_Noir*4)<Cap_Grape*0.9){

            items.add("w2: Insufficient labor supplied to utilize the grape resource (less than 90%).");
        }
        return items;
    }
    
    
    /**
     * Validates the data input
     * @param input Contains Number of weeks, Capacity of Labor, Capacity of Grape, Price of Rosé, Price of P-Noir, Fixed Costs (in ascending order)
     * @return Generate error message(s) caused by invalid inputs. The list will be empty if all the inputs are valid.
     */
    public ObservableList<String> Data_Validation(String[] input){
        String[] Message = new String[]{
                "Input error for Number of weeks: Please enter an integer in between 1 and 15",
                "Input error for Capacity Of Labor: Please enter an integer greater than 0",
                "Input error for Capacity Of Grape: Please enter an integer greater than 0",
                "Input error for Price Of Rose: Please enter a number greater than 0",
                "Input error for Price Of P-Noir: Please enter a number greater than 0",
                "Input error for Fixed Costs: Please enter a number greater than 0"
        };
        
        Validation_Function_A val = new Validation_Function_A();
        ObservableList<String> items = FXCollections.observableArrayList();
        if(!val.Check_Num_Week(input[0])){
            items.add(Message[0]);
        }
        if(!val.Check_Cap_Labor(input[1])){
            items.add(Message[1]);
        }
        if(!val.Check_Cap_Grape(input[2])){
            items.add(Message[2]);
        }
        if (!val.Check_Prc_Rose(input[3])){
            items.add(Message[3]);
        }
        if(!val.Check_Prc_Noir(input[4])){
            items.add(Message[4]);
        }
        if(!val.Check_Fixed_Costs(input[5])){
            items.add(Message[5]);
        }
        return items;
    }
}