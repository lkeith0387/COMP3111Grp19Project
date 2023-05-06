package src.main.java.Function_C;

/**
 * The Result class stores the result data of the optimal calculation in function C.
 */
public class Result {
    public final boolean Bko_Fulfill ;
    public final int Opt_Rose ;
    public final int Opt_Noir ;
    public final int Opt_Revenue ;

    /** intialize a new Result object that stores all the result of the optimal calculation in function C.
     * @param Bko_Fulfill The result on whether there is sufficient resource of labor and grape to produce
     *      * backorders volume of Rosé and P-Noir
     * @param Opt_Rose Number of litres to be produced for Rosé
     * @param Opt_Noir Number of litres to be produced for P-Noir
     * @param Opt_Revenue The optimized sales revenue
     */
    public Result(boolean Bko_Fulfill,int Opt_Rose,int Opt_Noir,int Opt_Revenue){
        this.Bko_Fulfill = Bko_Fulfill;
        this.Opt_Rose = Opt_Rose;
        this.Opt_Noir = Opt_Noir;
        this.Opt_Revenue = Opt_Revenue;
    }
}
