package src.main.java.Function_C;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Function_C class contains the process performed in the function C.
 */
public class Function_C {
    private int Week_Of_Year;
    private int Bko_Rose;
    private int Cap_Labor;
    private int Cap_Grape;
    private int Bko_Noir;
    private float Prc_Rose;
    private float Prc_Noir;

    /**Calculates the optimal solution of the volume of Rosé and P-Noir with or without any backorder of Rosé and P-Noir to maximize the revenue
     * @return A Result object that stores the result of the optimal solution including the state of backorder fulfillment, optimal volume of Rosé, optimal volume of P-Noir, optimized sales revenue
     */
    public Result Get_Result(){
        boolean Bko_Fulfill = false;
        int Opt_Rose = 0 ;
        int Opt_Noir = 0 ;
        if((Bko_Rose*5+Bko_Noir*12<=Cap_Labor)&&(Bko_Rose*6+Bko_Noir*4<=Cap_Grape)){
            Bko_Fulfill = true;
        }
        Solver sol;
        if(Bko_Fulfill){
            Opt_Rose = Bko_Rose ;
            Opt_Noir = Bko_Noir ;
            int Available_Cap_Labor =  Cap_Labor - Bko_Rose*5 - Bko_Noir*12;
            int Available_Cap_Grape = Cap_Grape - Bko_Rose * 6 - Bko_Noir * 4;
            sol = new Solver(Available_Cap_Labor,Available_Cap_Grape,Prc_Rose,Prc_Noir);
            int[] Result = sol.Opt_Solution();
            Opt_Rose += Result[0];
            Opt_Noir += Result[1];
        }else{
            sol = new Solver(Cap_Labor,Cap_Grape,Prc_Rose,Prc_Noir);
            int[] Result = sol.Opt_Solution();
            Opt_Rose += Result[0];
            Opt_Noir += Result[1];
        }

        int Opt_Revenue = Double.valueOf(sol.Calculation(Opt_Rose,Opt_Noir)).intValue();
        return new Result(Bko_Fulfill,Opt_Rose,Opt_Noir,Opt_Revenue);
    }

    /**Converts an array of the texted input into numeric data and stores in the fields of the class.
     * @param input input[0] is the week of year.
     *              input[1] is the capacity of the labor.
     *              input[2] is the capacity of the grape.
     *              input[3] is the price of Rosé.
     *              input[4] is the price of P-Noir.
     *              input[5] is the backorder volume of Rosé
     *              input[6] is the backorder volume of P-Noir.
     */
    public void Get_Data(String[] input){
        Week_Of_Year = Integer.parseInt(input[0]);
        Cap_Labor = Integer.parseInt(input[1]);
        Cap_Grape = Integer.parseInt(input[2]);
        Prc_Rose = Float.parseFloat(input[3]);
        Prc_Noir = Float.parseFloat(input[4]);
        Bko_Rose = Integer.parseInt(input[5]);
        Bko_Noir = Integer.parseInt(input[6]);
    }

    /**Checks whether the optimal solution of the volume of Rosé and P-Noir will lead to abnormal situation and produces warning messages for abnormal situations.
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
        if((Bko_Rose+Bko_Noir)<0.7*(Opt_Rose+Opt_Noir)){

            items.add("w3: According to company policy, ratio of backorder volume should not lower than 70% of the optimal production volume!");
        }
        return items;
    }

    /** Validates the data input
     * @param input input[0] is the week of year.
     *              input[1] is the capacity of the labor.
     *              input[2] is the capacity of the grape.
     *              input[3] is the price of Rosé.
     *              input[4] is the price of P-Noir.
     *              input[5] is the backorder volume of Rosé
     *              input[6] is the backorder volume of P-Noir.
     * @return A list of error messages caused by invalid inputs. The list will be empty if all the inputs are valid.
     */
    public ObservableList<String> Data_Validation(String[] input){
        String[] Message = new String[]{
                "Input error for Week Of Year: Please enter an integer in between 2301 and 2315",
                "Input error for Capacity Of Labor: Please enter an integer greater than 0",
                "Input error for Capacity Of Grape: Please enter an integer greater than 0",
                "Input error for Price Of Rose: Please enter a number greater than 0",
                "Input error for Price Of P-Noir: Please enter a number greater than 0",
                "Input error for Backorder Volume of Rose: Please enter a number greater than 0",
                "Input error for Backorder Volume of P-Noir: Please enter a number greater than 0"
        };
        Validation val = new Validation();
        ObservableList<String> items = FXCollections.observableArrayList();
        if(!val.Check_Week_Of_Year(input[0])){
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
        if(!val.Check_Bko_Rose(input[5])){

            items.add(Message[5]);
        }
        if(!val.Check_Bko_Noir(input[6])){

            items.add(Message[6]);
        }
        return items;
    }
}
