/*
 * Cormen et al Advanced Design / 16. Dynamic Programming: 
 * 16.1 ?????? Scheduling
 * "????"  p366 XXXth edition
 */

package scheduling;

import java.util.ArrayList;

public class Schedule {
	
	// CONSTANTS ========================================== 
	
	public static final int BEG = 0;
	public static final int END = 1;	
	
	// METHODS ============================================ 
	// *******************************************
	public static ArrayList<Integer> getSchedule( int[][] someMeets ){
	/*	
	Intent: Maximize usage given proposed someMeets[start][finish] times
	
	Pre1 (Intervals are given): someMeets[][BEG].length > 0
			
	Pre2 (Intervals proper): 0 <= someMeets[i][BEG] < someMeets[i][END]
	for i = 0,1, ..., someMeets[][BEG].length -1
		
	Pre3 (Ordered by ends): someMeets[0][END] <= someMeets[1][END] <=
	.... <= someMeets[someMeets.length-1][END]
		
	Example: 0--[====)-----------------------[=========)----
	    sM[0][B]^    ^sM[0][E]       sM[3][B]^         ^sM[3][E]

             0-----[================================)-------
         sM[1][BEG]^                                ^sM[1][E]  

	         0-----[=======)-------------------[=========)--
	       sM[2][B]^       ^sM[2][E]   sM[4][B]^         ^sM[4][E]  
		
	Post1 (Non-overlapping): for s!=t, 
	someMeets[returnM[s]] and someMeets[returnM[t]] do not overlap
			
	Post2: The size of returnM is maximal
		
	Example: 0--[====)-----------------------[=========)----
	    sM[0][B]^    ^sM[0][E]       sM[3][B]^         ^sM[3][E] 
	returnM = {0,3}
	*/	
		//----SG1 (= Post1): someMeets[0][END] <= someMeets[1][END] <=
		// .... <= someMeets[someMeets.length-1][END]
				/* fulfilled together with */	
		//----SG2 (Parts collected): returnM[] = indices of someMeets meetings
		// that are part of a globally optimized solution
				/* fulfilled together with */		
		//----SG3 (Greed used): someMeets[last(returnM)][END] is minimal
		// (see proof that SG3 maintains SG2)
		
		ArrayList<Integer> returnM = new ArrayList<Integer>();  // zeros
		returnM.add(0);  // by precondition

		//----SG4 (Complete):  For every i > returnM[last], 
		// someMeets[i][BEG] < someMeets[last(returnM)][END]
		
		int i = last(returnM) + 1;
		while( i < someMeets.length ){  // SG4
			if( someMeets[i][BEG] >= someMeets[last(returnM)][END] ) 
				returnM.add(i);  
			++i;  // SG1 due to condition; SG3 preserves SG2; SG3 due to Pre3 
		}  // terminates because i bounded but increases each iteration
		
		return returnM;   
	}
	
	// *******************************************
	public static int last( ArrayList<Integer> anIntArr ){
	/*
	Pre: anIntArr contains at least one element
	Post: returnI = content of the last element of anIntArr
	*/
		return anIntArr.get(anIntArr.size() - 1).shortValue();
	}
}

/*
 * Note 1: In this disjoint case, k is incremented to get new maximal set.
 * If someMeets[i][BEG] < returnM[i-1][END] and we added someMeets[i][], we would 
 * lose a count of 1 by dropping returnM[k-1][] and this can't be made up for 
 * with any meeting set in [0, someMeets[i][BEG]) because of existing optimalities.
*/