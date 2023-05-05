package src.main.java;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

/**
 * Date: 2023-05-05
 * @author Lau Nga Sze
 * @version 1.0
 */
public class functionAController {

    @FXML
    private TextField Textfield_Cap_Grape;

    @FXML
    private TextField Textfield_Cap_Labor;

    @FXML
    private TextField Textfield_Fixed_Costs;

    @FXML
    private Line HLine2;

    @FXML
    private Line HLine3;

    @FXML
    private Line HLine4;

    @FXML
    private Line HLine_1;

    @FXML
    private TextField Textfield_Week_Of_Year;

    @FXML
    private TextField Textfield_Prc_Noir;

    @FXML
    private TextField Textfield_Prc_Rose;

    @FXML
    private Line VLine1;

    @FXML
    private Line VLine2;

    @FXML
    private Button button_exit1;

    @FXML
    private Button button_run1;

    @FXML
    private Label data_input_caption1;

    @FXML
    private Label data_input_caption2;

    @FXML
    private Label data_input_caption2a;

    @FXML
    private Label data_input_caption2b;

    @FXML
    private Label data_input_caption3;

    @FXML
    private Label data_input_caption3a;

    @FXML
    private Label data_input_caption3b;

    @FXML
    private Label data_input_caption4;

    @FXML
    private Label data_input_heading1;

    @FXML
    private Label form_heading1;

    @FXML
    private AnchorPane label_col_heading2;

    @FXML
    private Label label_sysmsg1;

    @FXML
    private Label opt_r_caption1;

    @FXML
    private Label opt_r_caption1a;

    @FXML
    private Label opt_r_caption1b;

    @FXML
    private Label opt_r_caption1c;

    @FXML
    private Label opt_r_caption2;

    @FXML
    private Label opt_r_caption3;

    @FXML
    private Label opt_result_heading1;

    @FXML
    private TextField or_Gross_Profit;

    @FXML
    private TextField or_Prod_Vol_Noir;

    @FXML
    private TextField or_Prod_Vol_Rose;

    @FXML
    private TextField or_Prod_Vol_Total;

    @FXML
    private TextField or_Profit_Margin;

    @FXML
    private Spinner<String> or_scroll_text1;

    @FXML
    private Line vLine3;
    
    @FXML
    private ListView<String> Or_Message;

    @FXML
    void buttonpressed(ActionEvent event) {

    }
    public void initialize() {
    	
    }
    @FXML
    
    int Week_Of_Year;
    int Cap_Labor;
    int Cap_Grape;
    float Prc_Rose;
    float Prc_Noir;
    int Fixed_Costs;
    
    /**
     * Get the inputs from corresponding textfield
     */
    private void Get_Data(){
        Week_Of_Year = Integer.parseInt(Textfield_Week_Of_Year.getText());
        Cap_Labor = Integer.parseInt(Textfield_Cap_Labor.getText());
        Cap_Grape = Integer.parseInt(Textfield_Cap_Grape.getText());
        Prc_Rose = Float.parseFloat(Textfield_Prc_Rose.getText());
        Prc_Noir = Float.parseFloat(Textfield_Prc_Noir.getText());
        Fixed_Costs = Integer.parseInt(Textfield_Fixed_Costs.getText());
    }
    
    
    /**
     * Return calculated results for corresponding text fields
     * @param Opt_Noir Number of litres to be produced for P-Noir
     * @param Opt_Rose Number of litres to be produced for Rose
     * @param Opt_Profit Optimized total gross profits before tax could be generated for the year
     * @param Opt_Margin Optimized profit margin
     */
    private void Release_Result(int Opt_Noir,int Opt_Rose, int Opt_Profit, double Opt_Margin){
        or_Prod_Vol_Noir.setText(String.valueOf(Opt_Noir));
        or_Prod_Vol_Rose.setText(String.valueOf(Opt_Rose));
        or_Prod_Vol_Total.setText(String.valueOf(Opt_Noir+Opt_Rose));
        or_Gross_Profit.setText(String.valueOf(Opt_Profit));;
        or_Profit_Margin.setText(String.valueOf(Opt_Margin));
    }
    
    //Missing solver part and determine how to calculate the profit
    @FXML
    public void toclick(ActionEvent actionEvent) {
        if(!Data_Validation()){
            return;
        }
        Get_Data();
        
        int Opt_Rose = 0 ;
        int Opt_Noir = 0 ;
        double Labor_Rate = (935/37.5/60);
        
        Solver sol;
        sol = new Solver(Cap_Labor, Cap_Grape, Prc_Rose, Prc_Noir);
        int[] Result = sol.Opt_Solution();
        Opt_Rose += Result[0];
        Opt_Noir += Result[1];
        
        double VCL = ((Opt_Rose * 5 + Opt_Noir * 12) * Labor_Rate);						 		//VCL = Variable Cost of Labor
        int Sales_Revenue = (int) (Math.round(Opt_Rose * Prc_Rose + Opt_Noir * Prc_Noir)); 		//Sales Revenue = Total Revenue
        int Gross_Profit = (int) (Math.round(Sales_Revenue - VCL - Fixed_Costs)); 			 	//Gross Profit = Opt_Profit
        double Opt_Margin_NotConv = (((double)Gross_Profit) * 100 / Sales_Revenue);
        double Opt_Margin = roundAvoid(Opt_Margin_NotConv, 1);
        Release_Result(Opt_Noir, Opt_Rose, Gross_Profit, Opt_Margin);
        Show_Message(Opt_Rose,Opt_Noir);
    }
    
    
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    /**
     * Show system messages for abnormal situations
     * @param Opt_Rose Number of litres to be produced for Rose
     * @param Opt_Noir Number of litres to be produced for P-Noir
     */
    private void Show_Message(int Opt_Rose,int Opt_Noir) {

        ObservableList<String> items = FXCollections.observableArrayList();
        if(5000<Opt_Rose+Opt_Noir){
           // message = message +"w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!\n";
            items.add("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!");
        }
        if((Opt_Rose*6+Opt_Noir*4)<Cap_Grape*0.9){
            //message = message +"w2: Insufficient labor supplied to utilize the grape resource (less than 90%).\n";
            items.add("w2: Insufficient labor supplied to utilize the grape resource (less than 90%).");
        }
        Or_Message.setItems(items);
    }
    
    
    /**
     * Use to return error messages
     * @return Return corresponding error message if input field(s) is/are not correct
     */
    private boolean Data_Validation() {
    	String[] Message = new String[] {
			"Input error for Week Of Year: Please enter an integer in between 2301 and 2315",
            "Input error for Capacity Of Labor: Please enter an integer greater than 0",
            "Input error for Capacity Of Grape: Please enter an integer greater than 0",
            "Input error for Price Of Rose: Please enter a number greater than 0",
            "Input error for Price Of P-Noir: Please enter a number greater than 0",
            "Input error for Fixed Costs: Please enter a number greater than 0"
    	};
    	
    	boolean Flag = true;
    	
    	ObservableList<String> items = FXCollections.observableArrayList();
        if(!Check_Week_Of_Year()){
            Flag = false;
            items.add(Message[0]);
        }
        if(!Check_Cap_Labor()){
            Flag =false;
            items.add(Message[1]);
        }
        if(!Check_Cap_Grape()){
            Flag =false;
            items.add(Message[2]);
        }
        if (!Check_Prc_Rose()){
            Flag = false;
            items.add(Message[3]);
        }
        if(!Check_Prc_Noir()){
            Flag= false;
            items.add(Message[4]);
        }
        if(!Check_Fixed_Costs()){
            Flag = false;
            items.add(Message[5]);
        }
        Or_Message.setItems(items);
        return Flag; 		
    }
    
    
    /**
     * Field validation for Num_Week variable, check if the input is smaller than 2301 or greater than 2315
     * @return Return true if the input is within valid range, otherwise, return false
     */
    private boolean Check_Week_Of_Year() {
        String temp = Textfield_Week_Of_Year.getText();
        try {
            if (2301 > Integer.parseInt(temp) || 2315 < Integer.parseInt(temp)) {

                Textfield_Week_Of_Year.setText("");
                return false;
            } else {

                return true;
            }
        } catch (NumberFormatException e) {

            Textfield_Week_Of_Year.setText("");
            return false;
        }

    }
    
    /**
     * Field validation for Cap_Labor variable, check if the input is less than 0
     * @return Return true if the input is within valid range, otherwise, return false
     */
    private boolean Check_Cap_Labor() {
        String temp = Textfield_Cap_Labor.getText();
        try {
            if (0 > Integer.parseInt(temp)) {

            	Textfield_Cap_Labor.setText("");
                return false;
            } else {

                return true;
            }
        } catch (NumberFormatException e) {

        	Textfield_Cap_Labor.setText("");
            return false;
        }

    }
    
    /**
     * Field validation for Cap_Grape variable, check if the input is less than 0
     * @return Return true if the input is within valid range, otherwise, return false
     */
    private boolean Check_Cap_Grape() {
        String temp = Textfield_Cap_Grape.getText();
        try {
            if (0 > Integer.parseInt(temp)) {

            	Textfield_Cap_Grape.setText("");
                return false;
            } else {

                return true;
            }
        } catch (NumberFormatException e) {

        	Textfield_Cap_Grape.setText("");
            return false;
        }

    }
    
   
    /**
     * Field validation for Prc_Rose variable, check if the input is less than 1.0
     * @return Return true if the input is within valid range, otherwise, return false
     */
    private boolean Check_Prc_Rose(){
        String temp = Textfield_Prc_Rose.getText();
        try {
            if (1.0f > Float.parseFloat(temp)) {

                Textfield_Prc_Rose.setText("");
                return false;
            } else {

                return true;
            }
        } catch (NumberFormatException e) {

            Textfield_Prc_Rose.setText("");
            return false;
        }
    }

    /**
     * Field validation for Prc_Noir variable, check if the input is less than 1.0
     * @return Return true if the input is within valid range, otherwise, return false
     */
    private boolean Check_Prc_Noir(){
        String temp = Textfield_Prc_Noir.getText();
        try {
            if (1.0f > Float.parseFloat(temp)) {

                Textfield_Prc_Noir.setText("");
                return false;
            } else {

                return true;
            }
        } catch (NumberFormatException e) {

            Textfield_Prc_Noir.setText("");
            return false;
        }
    }
    
    /**
     * Field validation for Prc_Noir variable, check if the input is less than 0
     * @return Return true if the input is within valid range, otherwise, return false
     */
    private boolean Check_Fixed_Costs(){
        String temp = Textfield_Fixed_Costs.getText();
        try {
            if (0 > Integer.parseInt(temp)) {

            	Textfield_Fixed_Costs.setText("");
                return false;
            } else {

                return true;
            }
        } catch (NumberFormatException e) {

        	Textfield_Fixed_Costs.setText("");
            return false;
        }
    }
    
    @FXML
    void toexit(ActionEvent event) throws  java.io.IOException{
        Scene scene=new Scene(FXMLLoader.load(getClass().getResource("ppc1.fxml")));
        Main.stage.setScene(scene);
    }
    
}
