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
    
    
    public void initialize() {
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
        
    }
    @FXML 
    public void toclickB(ActionEvent event) {   ///function structure complete.
    	int maxRevenue =0;
    	int opt_Rose=0,opt_Noir=0, sur_labor =0, sur_grape = 0, opt_total = 0, sur_total = 0;
    	int cap_labor = Integer.parseInt(Cap_Labor.getText());
    	int cap_grape = Integer.parseInt(Cap_Grape.getText());
    	float prc_rose = Float.parseFloat(Prc_Rose.getText());
    	float prc_noir = Float.parseFloat(Prc_Noir.getText());
    	//int x = 0;
    	Calculator a = new Calculator();
    	/* if(cap_labor >= cap_grape) {
    		x = cap_labor;
    	}else {
    		x = cap_grape;
    	}
    	
    	for(int i =0; i< x; i++) {
    		for(int j=0;j< x; j++) {
    			if(5*i + 12*j > cap_labor) {
        			break;
        		}
    			if(6*i +4*j > cap_grape) {
    				break;
    			}
    			revenue = a.Calculation(i,j,prc_rose,prc_noir);
    			if(maxRevenue < revenue) {
    				maxRevenue = revenue;
    				opt_Rose = i;
    				opt_Noir = j;
    			}
    		}
    	} */
    	
    	int[] b = a.Optimization(cap_labor,cap_grape,prc_rose,prc_noir);
    	opt_Rose = b[0];
    	opt_Noir = b[1];
    	maxRevenue = b[2];
    	opt_total = opt_Rose + opt_Noir;
    	or_Prod_Vol_Rose.setText(Integer.toString(opt_Rose));
    	or_Prod_Vol_Noir.setText(Integer.toString(opt_Noir));
    	or_Prod_Vol_Total.setText(Integer.toString(opt_total));
    	or_Revenue.setText(Integer.toString(maxRevenue));
    	sur_labor = cap_labor - (opt_Rose*5 + opt_Noir*12);
    	sur_grape = cap_grape - (opt_Rose*6 + opt_Noir*4);
     	
    	ObservableList<String> items = FXCollections.observableArrayList();
    	
    	if(5000 < opt_total) {
    		items.add("w1: Insufficient production capacity to produce the optimal mix, please reduce or adjust the capacity of labor & grape volume!");
    	}
    	if((opt_Rose*6 + opt_Noir*4) <cap_grape*0.9) {
    		items.add("W2: Insufficient labor supplied to utilize the grape resource (less than 90%).");
    	}
    	
    	if((sur_labor > 0) & (sur_labor < 5)) {
    		sur_labor = 0;
    		or_sur_Labor.setText(Integer.toString(sur_labor));
    	}else if (sur_labor < 0) {
    		sur_labor = 0;
    		or_sur_Labor.setText(Integer.toString(sur_labor));
    		items.add("Er1a:Program bug is occurred, Labor Consumption cannot greater than its capacity!");
    	}else {
    		or_sur_Labor.setText(Integer.toString(sur_labor));
    	}


    	if((sur_grape > 0) & (sur_grape < 4)) {
    		sur_grape = 0;
    		or_sur_Grape.setText(Integer.toString(sur_grape));
    	}else if (sur_grape < 0) {
    		sur_grape = 0;
    		or_sur_Grape.setText(Integer.toString(sur_grape));
    		items.add("Er1b:Program bug is occurred, Grape Consumption cannot greater than its capacity!");
    	}else {
    		or_sur_Grape.setText(Integer.toString(sur_grape));
    	} 
    	
    	listviewB.setItems(items);
    	
    	sur_total = sur_grape + sur_labor;
    	or_sur_Total.setText(Integer.toString(sur_total));
    }	
       
    public void toexitB(ActionEvent event) {
    	Main.stage.setScene(Main.scene);
    }

}
