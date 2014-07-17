/*
 * Cormen et al Advanced Design / 15. Dynamic Programming: 
 * 15.1 Rod Cutting 
 * "Top-down memo-ized" top of p 366
 */

package dynamicCutRod;

public class CutRod {
	
	// CONSTANTS ========================================== 
	
	public static final int MAX_REVNU = 0;
	public static final int MAX_CUT = 1; 
	public static final int MAX_SIZE = 20; 
	
	// ATTRIBUTES ========================================= 
	
	// To retain prior work (dynamic programming)
	public static int[][] maxValsA =  new int[MAX_SIZE+1][2];
	public static int limitOfKnownA = 0;
	
	// CLASS INVARIANTS =================================== 
	 
	// ClInv1: 0 <= limitOfKnownA <= MAX_SIZE
	
	// ClInv2 (Some already known): For i = 0,1,...,limitOfKnownA:
	// maxValsA[i][MAX_REVNU] = max revenue from rod with length i 
	// AND maxValsA[i][MAX_CUT] = corresponding longest cut -OR-
	// maxValsA[i][MAX_REVNU] = MINUS_INFINITY
	
	{	// Set class invariants
		limitOfKnownA = 0;	
		maxValsA[0][MAX_REVNU] = 0;
		maxValsA[0][MAX_CUT] = 0;
	}
	
	// METHODS ============================================ 
	
	// *******************************************
	static void clearmaxValsA(){
		limitOfKnownA = 0;	
		maxValsA =  new int[MAX_SIZE+1][2];
	}

	// *******************************************
	static void getCutWiMaxRevnu( int[] somePrices, int aRodLen ){
	/*
	Intent: Cut rod in pieces to maximize revenue
	assuming (revenue from uncut length k) = somePrices[k]
		
	Pre: 0 <= aRodLen < MAX_SIZE
	
	Post: limitOfKnownA >= aRodLen
	*/
		//----SG1> (Already known?):  
		// limitOfKnownA >= aRodLen AND this has returned -OR-
		// limitOfKnownA <= aRodLen

		if( limitOfKnownA >= aRodLen )
			return;
		
		//----SG2 (Known up to aRodLen-1):
		// aRodLen>0 AND limitOfKnownA >= aRodLen-1 
					
		// Fulfill SG2 (keeping CLInv invariant)
			getCutWiMaxRevnu( somePrices, aRodLen-1 );
		
		//----SG3: limitOfKnownA != aRodLen-1 
		
		++limitOfKnownA;  // fulfills SG3
		// Restore ClInv with maxValsA[aRodLen][].  Remains only to 
		// consider (each length 0,1,...) + (single remaining piece)
		for( int len=0; len<aRodLen; ++len ) 
			if( maxValsA[len][MAX_REVNU] + somePrices[aRodLen-len]
			/**/> maxValsA[aRodLen][MAX_REVNU] ){  
				maxValsA[aRodLen][MAX_REVNU] =  // replace
				/**/maxValsA[len][MAX_REVNU] + somePrices[aRodLen-len];
				maxValsA[aRodLen][MAX_CUT] =   // replace
				/**/Math.max(maxValsA[len][MAX_CUT], aRodLen-len);
			}				
	}
}