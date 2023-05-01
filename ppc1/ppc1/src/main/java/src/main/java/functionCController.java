package src.main.java;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

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

    @FXML
    void getDefaultValue(InputMethodEvent event) {

    }
    int Week_Of_Year;
    int Bko_Rose;
    int Cap_Labor;
    int Cap_Grape;
    int Bko_Noir;
    float Prc_Rose;
    float Prc_Noir;
    private void Get_Data(){
        Week_Of_Year = Integer.parseInt(Textfield_Week_Of_Year.getText());
        Bko_Rose = Integer.parseInt(Textfield_Bko_Rose.getText());
        Bko_Noir = Integer.parseInt(Textfield_Bko_Noir.getText());
        Cap_Labor = Integer.parseInt(Textfield_Cap_Labor.getText());
        Cap_Grape = Integer.parseInt(Textfield_Cap_Grape.getText());
        Prc_Rose = Integer.parseInt(Textfield_Prc_Rose.getText());
        Prc_Noir = Integer.parseInt(Textfield_Prc_Noir.getText());
    }
    private void Release_Result(int Opt_Revenue,int Opt_Noir,int Opt_Rose,boolean Bko_fulfill){
        or_Gross_Profit.setText(String.valueOf(Opt_Revenue));
        or_Prod_Vol_Noir.setText(String.valueOf(Opt_Noir));
        or_Prod_Vol_Rose.setText(String.valueOf(Opt_Rose));
        or_Prod_Vol_Total.setText(String.valueOf(Opt_Noir+Opt_Rose));
        or_Profit_Margin.setText(Bko_fulfill?"Yes":"No");
    }
    @FXML

    public void toclick(ActionEvent actionEvent) {
        if(!Data_Validation()){
            return;
        }
        Get_Data();



        boolean Bko_fulfill = false;
        int Opt_Rose = 0 ;
        int Opt_Noir = 0 ;
        if((Bko_Rose*5+Bko_Noir*12<=Cap_Labor)&&(Bko_Rose*6+Bko_Noir*4<=Cap_Grape)){
            Bko_fulfill = true;
        }
        Solver sol;
        if(Bko_fulfill){
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
        Release_Result(Opt_Revenue,Opt_Noir,Opt_Rose,Bko_fulfill);
        Show_Message(Opt_Rose,Opt_Noir);

    }

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
        if((Bko_Rose+Bko_Noir)<0.7*(Opt_Rose+Opt_Noir)){
            //message = message + "w3: According to company policy, ratio of backorder volume should not lower than 70% of the optimal production volume!\n";
            items.add("w3: According to company policy, ratio of backorder volume should not lower than 70% of the optimal production volume!");
        }
        Or_Message.setItems(items);
    }

    private boolean Data_Validation(){

        String[] Message = new String[]{
                "Input error for Week Of Year: Please enter an integer in between 2301 and 2315",
                "Input error for Capacity Of Labor: Please enter an integer greater than 0",
                "Input error for Capacity Of Grape: Please enter an integer greater than 0",
                "Input error for Price Of Rose: Please enter a number greater than 0",
                "Input error for Price Of P-Noir: Please enter a number greater than 0",
                "Input error for Backorder Volume of Rose: Please enter a number greater than 0",
                "Input error for Backorder Volume of P-Noir: Please enter a number greater than 0"

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
        if(!Check_Bko_Rose()){
            Flag = false;
            items.add(Message[5]);
        }
        if(!Check_Bko_Noir()){
            Flag = false;
            items.add(Message[6]);
        }
        Or_Message.setItems(items);
        return Flag;
    }

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
    private boolean Check_Bko_Rose(){
        String temp = Textfield_Bko_Rose.getText();
        try {
            if (0 > Integer.parseInt(temp)) {

                Textfield_Bko_Rose.setText("");
                return false;
            } else {

                return true;
            }
        } catch (NumberFormatException e) {

            Textfield_Bko_Rose.setText("");
            return false;
        }
    }
    private boolean Check_Bko_Noir(){
        String temp = Textfield_Bko_Noir.getText();
        try {
            if (0 > Integer.parseInt(temp)) {

                Textfield_Bko_Noir.setText("");
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {

            Textfield_Bko_Noir.setText("");
            return false;
        }
    }
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

    private boolean Check_Cap_Labor(){
        String temp = Textfield_Cap_Labor.getText();
        try{

                if (0 > Integer.parseInt(temp) ) {

                    Textfield_Cap_Labor.setText("");
                    return false;
                } else {

                    return true;
                }
        }catch(NumberFormatException e) {

            Textfield_Cap_Labor.setText("");
            return false;
        }
    }
    private boolean Check_Cap_Grape(){
        String temp = Textfield_Cap_Grape.getText();
        try{

            if (0 > Integer.parseInt(temp) ) {

                Textfield_Cap_Grape.setText("");
                return false;
            } else {

                return true;
            }
        }catch(NumberFormatException e) {

            Textfield_Cap_Grape.setText("");
            return false;
        }
    }


    @FXML
    void toexit(ActionEvent event) throws  java.io.IOException{
        Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/ppc1.fxml")));
        Main.stage.setScene(scene);
    }
    public void initialize() {

    }

}
