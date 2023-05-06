package src.main.java.function_B;





/**
 * A Calculator class used to do all the calculation on optimization
 * @author Cheung Kwok Wai, Steven
 * @version 1.0
 */
public class Calculator {
	/**
	 * Calculate the optimize solution of opt_Rose,opt_Noir
	 * @param cap_labor the capacity of labor force
	 * @param cap_grape the capacity of grapes
	 * @param prc_rose the price of the wine named rose
	 * @param prc_noir the price of the wine named p-noir
	 * @return a integer array insist of opt_Rose, opt_Noir, maxRevenue
	 */
	public int[] Optimization(int cap_labor, int cap_grape, float prc_rose, float prc_noir) {
		int x = 0;
		int opt_Rose = 0 , opt_Noir = 0;
		int maxRevenue =0, revenue =0;
		if(cap_labor >= cap_grape) {
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
    			revenue = Calculation(i,j,prc_rose,prc_noir);
    			if(maxRevenue < revenue) {
    				maxRevenue = revenue;
    				opt_Rose = i;
    				opt_Noir = j;
    			}
    		}
    	}
    	int[] a = {opt_Rose,opt_Noir,maxRevenue};
		return a;
	}
	
	/**
	 * Calculation based multiplication and addition to calculate the revenue
	 * @param Num_Rose Number of Rose should be produced
	 * @param Num_Noir Number of P-Noir should be produced
	 * @param prc_rose prc_rose the price of the wine named rose
	 * @param prc_noir prc_noir the price of the wine named p-noir
	 * @return revenue
	 */
    public int Calculation(int Num_Rose,int Num_Noir, float prc_rose , float prc_noir) {
    	float b = prc_rose*Num_Rose + prc_noir*Num_Noir;
    	int c = (int)b;
    	return c;
    }
}