package src.main.java;
/**
 * A class to verify if the input are in valid format.
 */
public class InputValidation {
	
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
