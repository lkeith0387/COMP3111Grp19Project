package src.main.java.Function_A;

/**
 * Result class stores the result data of the optimal calculation from function A.
 */
public class Result {

    public final int Opt_Rose;		 // Number of litres to be produced for Rosé
    public final int Opt_Noir;		 // Number of litres to be produced for P-Noir
    public final int Opt_Profit;	 // Optimized total gross profits before tax could be generated for the year
    public final double Opt_Margin;	 // Optimized profit margin

    /**
     * Initialize a new Result object that stores all the result of the optimal calculation in function A
     * @param Opt_Rose Number of litres to be produced for Rosé
     * @param Opt_Noir Number of litres to be produced for P-Noir
     * @param Opt_Profit Optimized total gross profits before tax could be generated for the year
     * @param Opt_Margin Optimized profit margin
     */
    public Result(int Opt_Rose,int Opt_Noir,int Opt_Profit, double Opt_Margin){
        this.Opt_Rose = Opt_Rose;
        this.Opt_Noir = Opt_Noir;
        this.Opt_Profit = Opt_Profit;
        this.Opt_Margin = Opt_Margin;
    }
}