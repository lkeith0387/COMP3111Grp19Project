/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package src.main.java;

public class Solver {
    private int Cap_Labor = 0;
    private int Cap_Grape = 0;
    private int Prc_Rose = 0 ;
    private int Prc_Noir = 0 ;

    private int Opt_Rose = 0;
    private int Opt_Noir = 0;
    //private int Production_Capacity_Limit = 0;
    //private double Man_Power_Limit = 0 ;
    public Solver(int Cap_Labor,int Cap_Grape,int Prc_Rose,int Prc_Noir){
        this.Cap_Labor = Cap_Labor;
        this.Cap_Grape = Cap_Grape;
        this.Prc_Rose =  Prc_Rose;
        this.Prc_Noir = Prc_Noir;

        //Production_Capacity_Limit = Num_week * 5000;
        //Man_Power_Limit = Num_week * 37.5;
    }
    public int[] Opt_Solution() {
        double maxRevenue = 0;
        int opt_Rose = 0 ;
        int opt_Noir = 0 ;
        int i = 0 ;
        int j = 0 ;

        while(true) {
            if(5*i+12*j>Cap_Labor||6*i+4*j>Cap_Grape) {

                break;
            }
            while(true) {
                if(5*i+12*j>Cap_Labor||6*i+4*j>Cap_Grape) {
                    j= 0;
                    break;
                }
                double revenue = Calculation(i,j);
                if(maxRevenue<revenue) {
                    maxRevenue = revenue;
                    opt_Rose = i;
                    opt_Noir = j;

                }
                j++;
            }
            i++;
        }
        int[] result = {opt_Rose,opt_Noir};
        return result;
    }
    public  double Calculation(int Num_Rose,int Num_Noir){
        return Prc_Rose*Num_Rose + Prc_Noir*Num_Noir;
    }
}
