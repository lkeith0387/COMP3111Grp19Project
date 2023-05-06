package src.main.java.Function_A;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import src.main.java.Main;

/**
 * functionAContoller class is the controller to the control the GUL of function A
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
    private TextField Textfield_Num_Week;

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
    private Line vLine3;
    
    @FXML
    private ListView<String> Or_Message;
    

    /**
     * Displays the result at in "Optimized Result" section
     * @param Opt_Rose Number of litres to be produced for Rosé
     * @param Opt_Noir Number of litres to be produced for P-Noir
     * @param Opt_Profit Optimized total gross profits before tax could be generated for the year
     * @param Opt_Margin Optimized profit margin
     */
    public void Display_Result(int Opt_Rose, int Opt_Noir, int Opt_Profit, double Opt_Margin){
    	or_Prod_Vol_Rose.setText(String.format("%,8d%n",Opt_Rose));
    	or_Prod_Vol_Noir.setText(String.format("%,8d%n",Opt_Noir));
        or_Prod_Vol_Total.setText(String.format("%,8d%n",Opt_Noir+Opt_Rose));
        or_Gross_Profit.setText(String.format("%,8d%n", Opt_Profit));
        or_Profit_Margin.setText(String.format("%,.1f", Opt_Margin));
    }
    
    
    /**
     * Handles the click event of "Run" button.
     * @param actionEvent
     */
    @FXML
    public void To_Click(ActionEvent actionEvent) {
    	 String[] input = new String[7];
         input[0] = Textfield_Num_Week.getText();
         input[1] = Textfield_Cap_Labor.getText();
         input[2] = Textfield_Cap_Grape.getText();
         input[3] = Textfield_Prc_Rose.getText();
         input[4] = Textfield_Prc_Noir.getText();
         input[5] = Textfield_Fixed_Costs.getText();
         Process_Calculation(input);     
    }
    
    
    /**
     * Processes the calculation with the input data by calling methods in Function_A class.The calculation stops if encountered invalid input(s).
     * @param input Contains Week of the year, Capacity of Labor, Capacity of Grape, Price of Rosé, Price of P-Noir, Fixed Costs (in ascending order) 
     */
    private void Process_Calculation(String[] input) {
        Function_A func = new Function_A();
        ObservableList<String> Message = func.Data_Validation(input);
        if(Message.size()>0){
            Display_Message(Message);
            return;
        }
        func.Get_Data(input);
        Result result = func.Get_Result();
        Display_Result(result.Opt_Rose,result.Opt_Noir,result.Opt_Profit,result.Opt_Margin);
        Message = func.Get_Warning_Message(result.Opt_Rose,result.Opt_Noir);
        Display_Message(Message);
    }

    
    /**
     * Displays the message in the format of ListView and display on "System Messages/Warnings/Reminders" section.
     * @param Message
     */
    public void Display_Message(ObservableList<String> Message) {
        Or_Message.setItems(Message);
    }


    /**Handle the click event of the "Exit" button.
     * @param event
     * @throws java.io.IOException
     */
    @FXML
    void To_Exit(ActionEvent event) throws  java.io.IOException{
        Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/ppc1.fxml")));
        Main.stage.setScene(scene);
    }

    
}
