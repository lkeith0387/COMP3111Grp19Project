package src.main.java.Function_C;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import src.main.java.Main;

/**
 * The functionCContoller class is the controller to control the GUI of function C.
 */
public class functionCController {

    @FXML
    private AnchorPane label_col_heading2;

    @FXML
    private TextField Textfield_Week_Of_Year;

    @FXML
    private Label data_input_heading1;

    @FXML
    private Label data_input_caption2a;

    @FXML
    private Label form_heading1;

    @FXML
    private Label data_input_caption1;

    @FXML
    private TextField Textfield_Cap_Labor;

    @FXML
    private Label data_input_caption2b;

    @FXML
    private TextField Textfield_Cap_Grape;

    @FXML
    private Label data_input_caption3a;

    @FXML
    private TextField Textfield_Prc_Rose;

    @FXML
    private Label data_input_caption3b;

    @FXML
    private TextField Textfield_Prc_Noir;

    @FXML
    private TextField Textfield_Bko_Rose;

    @FXML
    private Label opt_result_heading1;

    @FXML
    private Button button_run1;

    @FXML
    private Button button_exit1;

    @FXML
    private TextField or_Prod_Vol_Rose;

    @FXML
    private Label opt_r_caption1;

    @FXML
    private Label opt_r_caption1a;

    @FXML
    private Label opt_r_caption1b;

    @FXML
    private TextField or_Prod_Vol_Noir;

    @FXML
    private Label opt_r_caption1c;

    @FXML
    private TextField or_Prod_Vol_Total;

    @FXML
    private Line HLine4;

    @FXML
    private Label opt_r_caption2;

    @FXML
    private Label opt_r_caption3;

    @FXML
    private TextField or_Gross_Profit;

    @FXML
    private TextField or_Profit_Margin;

    @FXML
    private Line HLine3;

    @FXML
    private Line HLine2;

    @FXML
    private Line VLine1;

    @FXML
    private Line HLine_1;

    @FXML
    private Line VLine2;

    @FXML
    private Line vLine3;

    @FXML
    private ListView<String> Or_Message;

    @FXML
    private Label label_sysmsg1;

    @FXML
    private TextField Textfield_Bko_Noir;

    @FXML
    private Label data_input_caption3b1;

    @FXML
    private Label data_input_caption3b2;


    /**
     * Displays the result at the output panel
     * @param Opt_Revenue The optimized sales revenue
     * @param Opt_Noir  Number of litres to be produced for P-Noir
     * @param Opt_Rose  Number of litres to be produced for Rosé
     * @param Bko_fulfill The result on whether there is sufficient resource of labor and grape to produce
     * backorders volume of Rosé and P-Noir
     */
    public void Display_Result(int Opt_Revenue, int Opt_Noir, int Opt_Rose, boolean Bko_fulfill){
        or_Gross_Profit.setText(String.format("%,8d%n",Opt_Revenue ));
        or_Prod_Vol_Noir.setText(String.format("%,8d%n",Opt_Noir));
        or_Prod_Vol_Rose.setText(String.format("%,8d%n",Opt_Rose));
        or_Prod_Vol_Total.setText(String.format("%,8d%n",Opt_Noir+Opt_Rose));
        or_Profit_Margin.setText(Bko_fulfill?"Yes":"No");
    }

    /**
     * Handles the click event of "Run" button.
     * @param actionEvent
     */
    @FXML

    public void To_Click(ActionEvent actionEvent) {
        String[] input = new String[7];
        input[0] = Textfield_Week_Of_Year.getText();
        input[1] = Textfield_Cap_Labor.getText();
        input[2] = Textfield_Cap_Grape.getText();
        input[3] = Textfield_Prc_Rose.getText();
        input[4] = Textfield_Prc_Noir.getText();
        input[5] = Textfield_Bko_Rose.getText();
        input[6] = Textfield_Bko_Noir.getText();
        Process_Calculation(input);

    }

    /**Processes the calculation with the input data by calling methods in Function_C class.The calculation stops if any invalid input exists.
     * @param input input[0] is the week of year.
     *              input[1] is the capacity of the labor.
     *              input[2] is the capacity of the grape.
     *              input[3] is the price of Rosé.
     *              input[4] is the price of P-Noir.
     *              input[5] is the backorder volume of Rosé
     *              input[6] is the backorder volume of P-Noir.

     */
    private void Process_Calculation(String[] input) {
        Function_C func = new Function_C();
        ObservableList<String> Message = func.Data_Validation(input);
        if(Message.size()>0){
            Display_Message(Message);
            return;
        }
        func.Get_Data(input);
        Result_Function_C result = func.Get_Result();
        Display_Result(result.Opt_Revenue,result.Opt_Noir,result.Opt_Rose,result.Bko_Fulfill);
        Message = func.Get_Warning_Message(result.Opt_Rose,result.Opt_Noir);
        Display_Message(Message);
    }

    /**Displays the message on the ListView of the panel.
     * @param Message A List of Message that displays on the ListView
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
