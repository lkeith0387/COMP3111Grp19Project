package src.main.java.Function_C;


/**
 * The Validation_Function_C class provides input validation for function C.
 */
public class Validation_Function_C {

    /**Checks the input validation for input Week_Of_Year
     * @param Week_Of_Year The week of year
     * @return True for valid input<br>
     *          False for invalid input
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
    /**Checks the input validation for input Bko_Rose
     * @param Bko_Rose The backorder volume of Rosé
     * @return True for valid input<br>
     *          False for invalid input
     */
    public boolean Check_Bko_Rose(String Bko_Rose){

        try {
            if (0 > Integer.parseInt(Bko_Rose)) {


                return false;
            } else {

                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
    /**Checks the input validation for input Bko_Noir
     * @param Bko_Noir The backorder volume of P-Noir
     * @return True for valid input<br>
     *          False for invalid input
     */
    public boolean Check_Bko_Noir(String Bko_Noir){

        try {
            if (0 > Integer.parseInt(Bko_Noir)) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
    /**Checks the input validation for input Prc_Rose
     * @param Prc_Rose The price of Rosé
     * @return True for valid input<br>
     *          False for invalid input
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

    /**Checks the input validation for input Prc_Noir
     * @param Prc_Noir The price of P-Noir
     * @return True for valid input<br>
     *          False for invalid input
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

    /**Checks the input validation for input Cap_Labor
     * @param Cap_Labor The capacity of Labor
     * @return True for valid input<br>
     *          False for invalid input
     */
    public boolean Check_Cap_Labor(String Cap_Labor){
        try{

                if (1 > Integer.parseInt(Cap_Labor) ) {
                    return false;
                } else {

                    return true;
                }
        }catch(NumberFormatException e) {

            return false;
        }
    }

    /**Checks the input validation for input Cap_Grape
     * @param Cap_Grape The capacity of grape
     * @return True for valid input<br>
     *          False for invalid input
     */
    public boolean Check_Cap_Grape(String Cap_Grape){
        try{
            if (1 > Integer.parseInt(Cap_Grape) ) {
                return false;
            } else {
                return true;
            }
        }catch(NumberFormatException e) {
            return false;
        }
    }


}
