package src.main.java;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;


/**
 * A Controller for function B in ppc1 calculator project.
 * @author Cheung Kwok Wai, Steven
 * @version 1.0
 */



public class functionBController {

    @FXML
    private TextField Cap_Grape;

    @FXML
    private TextField Cap_Labor;

    @FXML
    private Line HLine_1;

    @FXML
    private Line HLine_2;

    @FXML
    private Line HLine_3;

    @FXML
    private Line HLine_4;

    @FXML
    private Line HLine_5;

    @FXML
    private TextField Num_Week;

    @FXML
    private TextField Prc_Noir;

    @FXML
    private TextField Prc_Rose;

    @FXML
    private Line VLine1;

    @FXML
    private Line VLine2;

    @FXML
    private Line VLine3;

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
    private Label data_input_heading1;

    @FXML
    private Label form_heading1;

    @FXML
    private AnchorPane label_col_headingB;

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
    private Label opt_r_caption3a;

    @FXML
    private Label opt_r_caption3b;

    @FXML
    private Label opt_r_caption3c;

    @FXML
    private Label opt_result_heading1;

    @FXML
    private TextField or_Prod_Vol_Noir;

    @FXML
    private TextField or_Prod_Vol_Rose;

    @FXML
    private TextField or_Prod_Vol_Total;

    @FXML
    private TextField or_Revenue;

    @FXML
    private TextField or_sur_Grape;

    @FXML
    private TextField or_sur_Labor;

    @FXML
    private TextField or_sur_Total;
    
    @FXML
    private ListView<String> listviewB;
    
    
    /* public void initialize() {
    	ObservableList<String> items1 = FXCollections.observableArrayList();
    	
    	Num_Week.textProperty().addListener(new ChangeListener<String>() {
    		@Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (0 > Integer.parseInt(newValue) || 2316 < Integer.parseInt(newValue)) {
                    	if(Integer.parseInt(newValue) <=  2300) {
                    		items1.add("Num_Week: Please enter an integer between 2301 and 2315");
                    		Num_Week.setText("");
                    	}
                    	items1.add("Num_Week: Please enter an integer between 2301 and 2315"); //replicated
                		Num_Week.setText("");
                    } else {

                    }
                } catch (NumberFormatException e) {
                	items1.add("Num_Week: Please enter an integer between 2301 and 2315");
                    Num_Week.setText("");
                }
            }
    	});
    	
    	
    	Cap_Grape.textProperty().addListener(new ChangeListener<String>() {
    		@Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (0 > Integer.parseInt(newValue)) {
                        items1.add("Cap_Grape: Please enter an integer greater than 0");
                        Num_Week.setText("");
                    } else {

                    }
                } catch (NumberFormatException e) {
                	items1.add("Cap_Grape: Please enter an integer greater than 0");
                    Num_Week.setText("");
                }
            }
    	});
    	
    	Cap_Labor.textProperty().addListener(new ChangeListener<String>() {
    		@Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (0 > Integer.parseInt(newValue)) {
                        items1.add("Cap_Labor: Please enter an integer greater than 0");
                        Num_Week.setText("");
                    } else {

                    }
                } catch (NumberFormatException e) {
                	items1.add("Cap_Labor: Please enter an integer greater than 0");
                    Num_Week.setText("");
                }
            }
    	});
    	
    	Prc_Rose.textProperty().addListener(new ChangeListener<String>() {
    		@Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (0 > Float.parseFloat(newValue)) {
                        items1.add("Prc_Rose: Please enter a number greater than 0");
                        Num_Week.setText("");
                    } else {

                    }
                } catch (NumberFormatException e) {
                	items1.add("Prc_Rose: Please enter a number greater than 0");
                    Num_Week.setText("");
                }
            }
    	});
    	
    	Prc_Noir.textProperty().addListener(new ChangeListener<String>() {
    		@Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (0 > Float.parseFloat(newValue)) {
                        items1.add("Prc_Noir: Please enter a number greater than 0");
                        Num_Week.setText("");
                    } else {

                    }
                } catch (NumberFormatException e) {
                	items1.add("Prc_Noir: Please enter a number greater than 0");
                    Num_Week.setText("");
                }
            }
    	});
    	
    	
    	listviewB.setItems(items1);
        
    } */
    int cap_labor =0, cap_grape=0, num_week =0;//maxRevenue=0;
    float prc_rose=0, prc_noir=0;
    
    
  
    /**
     * to get user input in integer or float.
     * @param input the string input
     */
    public void Input_Data(String[] input) {
    	num_week = Integer.parseInt(input[0]);
    	cap_labor = Integer.parseInt(input[1]);
    	cap_grape = Integer.parseInt(input[2]);
    	prc_rose = Float.parseFloat(input[3]);
    	prc_noir = Float.parseFloat(input[4]);
    }
    

    /**
     * Output text in textfields.
     * @param opt_Rose Optimal mix of Rose
     * @param opt_Noir Optimal mix of P-Noir
     * @param opt_total Optimal total mix of wines                
     * @param maxRevenue The maxRevenue calculated
     * @param sur_labor Surplus of labor force
     * @param sur_grape Surplus of Grape
     * @param sur_total Total surplus of labor force and grape
     */
    public void Output_Data(int opt_Rose, int opt_Noir, int opt_total,int maxRevenue,int sur_labor,int sur_grape,int sur_total){
    	or_Prod_Vol_Rose.setText(Integer.toString(opt_Rose));
    	or_Prod_Vol_Noir.setText(Integer.toString(opt_Noir));
    	or_Prod_Vol_Total.setText(Integer.toString(opt_total));
    	or_Revenue.setText(Integer.toString(maxRevenue));
    	or_sur_Labor.setText(Integer.toString(sur_labor));
    	or_sur_Grape.setText(Integer.toString(sur_grape));
    	or_sur_Total.setText(Integer.toString(sur_total));
    }
    
    /**
     * Handles mouse click event on "run" button
     * @param event mouse click event
     */
    @FXML 
    public void toclickB(ActionEvent event) {   ///function structure complete.
    	
    	String[] input = new String[5];
    	input[0] = Num_Week.getText();
        input[1] = Cap_Labor.getText();
        input[2] = Cap_Grape.getText();
        input[3] = Prc_Rose.getText();
        input[4] = Prc_Noir.getText();
   
 
    	int opt_Rose=0,opt_Noir=0, sur_labor =0, sur_grape = 0, opt_total = 0, sur_total = 0, maxRevenue =0;
 
    	Calculator a = new Calculator();
    	ObservableList<String> Message = datainvalid(input);
    	
    	if(Message.size()>0) {
    		Display_Message(Message);
    		return;
    	}
    	Input_Data(input);
    	int[] b = a.Optimization(cap_labor,cap_grape,prc_rose,prc_noir);
    	opt_Rose = b[0];
    	opt_Noir = b[1];
    	maxRevenue = b[2];
    	opt_total = opt_Rose + opt_Noir;
    	/*or_Prod_Vol_Rose.setText(Integer.toString(opt_Rose));
    	or_Prod_Vol_Noir.setText(Integer.toString(opt_Noir));
    	or_Prod_Vol_Total.setText(Integer.toString(opt_total));
    	or_Revenue.setText(Integer.toString(maxRevenue)); */
    	sur_labor = cap_labor - (opt_Rose*5 + opt_Noir*12);
    	sur_grape = cap_grape - (opt_Rose*6 + opt_Noir*4);
     	
    	ObservableList<String> items = FXCollections.observableArrayList();
    	ObservableList<String> items1 = FXCollections.observableArrayList();
    
    	/*if((sur_labor > 0) & (sur_labor < 5)) {
    		sur_labor = 0;
    	}else if (sur_labor < 0) {
    		sur_labor = 0;
    		items.add("Er1a:Program bug is occurred, Labor Consumption cannot greater than its capacity!");
    	}else {
    		
    	}


    	if((sur_grape > 0) & (sur_grape < 4)) {
    		sur_grape = 0;
    	}else if (sur_grape < 0) {
    		sur_grape = 0;
    		items.add("Er1b:Program bug is occurred, Grape Consumption cannot greater than its capacity!");
    	}else {
    		
    	} 
    	listviewB.setItems(items);*/
    	
    	
    	
    	items = surplus_message(sur_labor,sur_grape);
    	
    	
    	Display_Message(items);
    	
    	sur_total = sur_grape + sur_labor;
    	Output_Data(opt_Rose, opt_Noir, opt_total,maxRevenue,sur_labor,sur_grape,sur_total);
    	items1 = message(opt_Rose,opt_Noir);
    	Display_Message(items1);
    }	
    
    /**
     * to get error messages of condition when consumption greater than capacity
     * @param sur_labor surplus number of labor
     * @param sur_grape surplus number of grape
     * @param items an array store error message
     * @return items
     */
    public ObservableList<String> surplus_message(int sur_labor, int sur_grape){
    	ObservableList<String> items = FXCollections.observableArrayList();
    	if((sur_labor > 0) & (sur_labor < 5)) {
    		sur_labor = 0;
    	}else if (sur_labor < 0) {
    		sur_labor = 0;
    		items.add("Er1a:Program bug is occurred, Labor Consumption cannot greater than its capacity!");
    	}else {
    		
    	}


    	if((sur_grape > 0) & (sur_grape < 4)) {
    		sur_grape = 0;
    	}else if (sur_grape < 0) {
    		sur_grape = 0;
    		items.add("Er1b:Program bug is occurred, Grape Consumption cannot greater than its capacity!");
    	}else {
    		
    	}
		return items; 
    }
   
    
    /**
     * to get warning messages
     * @param opt_Rose the optimal mix of rose
     * @param opt_Noir the optimal mix of P-Noir
     */
    public ObservableList<String> message(int opt_Rose,int opt_Noir) {
    	ObservableList<String> items = FXCollections.observableArrayList();
    	if(5000 < opt_Rose + opt_Noir) {
    		items.add("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!");
    	}
    	if((opt_Rose*6 + opt_Noir*4) <cap_grape*0.9) {
    		items.add("W2: Insufficient labor supplied to utilize the grape resource (less than 90%).");
    	}
    	return items;
    }
   
    /**
     * display warning messages
     * @param Message the output message
     */
    public void Display_Message(ObservableList<String> Message) {
        listviewB.setItems(Message);
    }
    

    
    /**
     * A function to call an extra class to verify if the input are in valid formats.
     * @return a boolean whether the test passed.
     */
    public ObservableList<String> datainvalid(String[] input) {
    	//boolean result = true;
    	ObservableList<String> items = FXCollections.observableArrayList();
    	InputValidation valid = new InputValidation();
    	
    	if(!valid.Check_Num_Week(input[0])) {
    		//Num_Week.setText("");
    		//result = false;
    		items.add("Num_Week: Please enter an integer between 2301 and 2315");
    	}
    	if(!valid.Check_Cap_Labor(input[1])) {
    		//Cap_Labor.setText("");
    		//result = false;
    		items.add("Cap_Labor: Please enter an integer greater than 0");
    	}
    	if(!valid.Check_Cap_Grape(input[2])) {
    		//Cap_Grape.setText("");
    		//result = false;
    		items.add("Cap_Grape: Please enter an integer greater than 0");
    	}
    	if(!valid.Check_Prc_Rose(input[3])) {
    		//Prc_Rose.setText("");
    		//result = false;
    		items.add("Prc_Rose: Please enter a number greater than 0");
    	}
    	if(!valid.Check_Prc_Noir(input[4])) {
    		//Prc_Noir.setText("");
    		//result = false;
    		items.add("Prc_Noir: Please enter a number greater than 0");
    	}
    	
    	return items;
    }
       
    
    /**
     * Handle mouse click event on "Exit" button
     * @param event
     */
    public void toexitB(ActionEvent event) {
    	Main.stage.setScene(Main.scene);
    }

}
