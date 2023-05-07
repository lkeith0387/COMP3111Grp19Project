package src.main.java.function_B;
/**
 * A class to verify if the input are in valid format.
 */
public class InputValidation {
	/**
	 * Check validation of num_week variable
	 * @param Num_Week number of weeks
	 * @return boolean value
	 */
	public boolean Check_Num_Week(String Num_Week) {
		try {
			
            if (2301 > Integer.parseInt(Num_Week) || 2315 < Integer.parseInt(Num_Week)) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
	}
	/**
	 * Check validation of cap_grape variable
	 * @param Cap_Grape capacity of grape
	 * @return boolean value
	 */
	public boolean Check_Cap_Grape(String Cap_Grape) {
		try {
            if (0 >= Integer.parseInt(Cap_Grape)){
                return false;
            } else {

                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
	}
	/**
	 * Check validation of cap_labor variable
	 * @param Cap_Labor capacity of labor force
	 * @return boolean value
	 */
	public boolean Check_Cap_Labor(String Cap_Labor) {
		try {
            if (0 >= Integer.parseInt(Cap_Labor)) {
                return false;
            } else {

                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
	}
	/**
	 * Check validation of prc_rose
	 * @param Prc_Rose price of the wine named rose
	 * @return boolean value
	 */
	public boolean Check_Prc_Rose(String Prc_Rose) {
		try {
            if (0 >= Float.parseFloat(Prc_Rose)) {
                return false;
            } else {

                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
	}
	/**
	 * Check validation of prc_noir
	 * @param Prc_Noir price of the wine named p-noir
	 * @return boolean value
	 */
	public boolean Check_Prc_Noir(String Prc_Noir) {
		try {
            if (0 >= Float.parseFloat(Prc_Noir)) {
                return false;
            } else {

                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
	}
}
