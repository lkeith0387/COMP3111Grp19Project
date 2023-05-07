package src.main.java.Function_A;

/**
 * Validation_Function_A class use to validate input from Function_A.
 */
public class Validation_Function_A {
	
	
    /**
     * Checks if the input of Num_Week variable is invalid (smaller than 1 or greater than 15)
     * @param Num_Week Number of weeks
     * @return True for valid input, false otherwise
     */
    public boolean Check_Num_Week(String Num_Week) {
        try {
            if (1 > Integer.parseInt(Num_Week) || 15 < Integer.parseInt(Num_Week)) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }

    }
    
    
    /**
     * Checks if the input of Cap_Labor variable is invalid (smaller than 0)
     * @param Cap_Labor Labor resource planned for the production cycle
     * @return True for valid input, false otherwise
     */
    public boolean Check_Cap_Labor(String Cap_Labor) {
        try {
            if (0 > Integer.parseInt(Cap_Labor)) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }

    }
    
    
    /**
     * Checks if the input of Cap_Grape variable is invalid (smaller than 0)
     * @param Cap_Grape Grape resource planned for the production cycle
     * @return True for valid input, false otherwise
     */
    public boolean Check_Cap_Grape(String Cap_Grape) {
        try {
            if (0 > Integer.parseInt(Cap_Grape)) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }

    }
    
   
    /**
     * Checks if the input of Prc_Rose variable is invalid (smaller than 1.0)
     * @param Prc_Rose Price of Rose
     * @return True for valid input, false otherwise
     */
    public boolean Check_Prc_Rose(String Prc_Rose){
        try {
            if (1.0f > Float.parseFloat(Prc_Rose)) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    
    /**
     * Checks if the input of Prc_Noir variable is invalid (smaller than 1.0)
     * @param Prc_Noir Price of P-Noir
     * @return True for valid input, false otherwise
     */
    public boolean Check_Prc_Noir(String Prc_Noir){
        try {
            if (1.0f > Float.parseFloat(Prc_Noir)) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
    /**
     * Checks if the input of Fixed_Costs variable is invalid (smaller than 0)
     * @param Fixed_Costs Total fixed costs of operating and manufacturing overheads
     * @return True for valid input, false otherwise
     */
    public boolean Check_Fixed_Costs(String Fixed_Costs){
        try {
            if (0 > Integer.parseInt(Fixed_Costs)) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
}