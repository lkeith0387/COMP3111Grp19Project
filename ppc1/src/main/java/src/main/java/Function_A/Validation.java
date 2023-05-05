package src.main.java.Function_A;

public class Validation {
	/**
     * Field validation for Num_Week variable, check if the input is smaller than 2301 or greater than 2315
     * @return Return true if the input is within valid range, otherwise, return false
     */
    public boolean Check_Week_Of_Year(String Week_Of_Year) {
        try {
            if (2301 > Integer.parseInt(Week_Of_Year) || 2315 < Integer.parseInt(Week_Of_Year)) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }

    }
    
    /**
     * Field validation for Cap_Labor variable, check if the input is less than 0
     * @return Return true if the input is within valid range, otherwise, return false
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
     * Field validation for Cap_Grape variable, check if the input is less than 0
     * @return Return true if the input is within valid range, otherwise, return false
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
     * Field validation for Prc_Rose variable, check if the input is less than 1.0
     * @return Return true if the input is within valid range, otherwise, return false
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
     * Field validation for Prc_Noir variable, check if the input is less than 1.0
     * @return Return true if the input is within valid range, otherwise, return false
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
     * Field validation for Prc_Noir variable, check if the input is less than 0
     * @return Return true if the input is within valid range, otherwise, return false
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