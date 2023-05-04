package src.main.java;

import org.junit.Test;

public class Calculator {
	
	@Test
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
	@Test
    public int Calculation(int Num_Rose,int Num_Noir, float prc_rose , float prc_noir) {
    	float b = prc_rose*Num_Rose + prc_noir*Num_Noir;
    	int c = (int)b;
    	return c;
    }
}