package src.main.java;


/**
 * The functionCContoller class is the class to perform function C in pp
 */
public class Validation {

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
