package scheduling;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestSchedule extends TestCase {
	
	//*************************************************************
	public void testGetSchedule(){
		
		// Nominal Cases ----------------------------------
		//N#1
		int[][] someMeets = {{1,2},{3,4}};
		ArrayList<Integer> result = Schedule.getSchedule(someMeets);
		assertEquals(1, someMeets[result.get(0)][0]);
		assertEquals(4, someMeets[result.get(1)][1]);
		//N#2
		int[][] someMeets1 = {{1,2},{2,3},{3,4}};
		ArrayList<Integer> result1 = Schedule.getSchedule(someMeets1);
		assertEquals(1, someMeets1[result1.get(0)][0]);
		assertEquals(3, someMeets1.length);
		assertEquals(3, someMeets1[result1.get(1)][1]);
		assertEquals(4, someMeets1[result1.get(2)][1]);
		//N#3
		int[][] someMeets3 = {{1,2},{2,4},{2,3},{3,5},{4,7},{6,9}};
		//                     ---   ---               ---
		ArrayList<Integer> result3 = Schedule.getSchedule(someMeets3);
		assertEquals(4, someMeets3[result3.get(1)][1]);
		assertEquals(4, someMeets3[result3.get(2)][0]);
		//N#4
		int[][] someMeets4 = {{1,2},{2,4},{2,3},{3,5},{4,7},{8,9}};
		//                     ---   ---               ---   ---
		ArrayList<Integer> result4 = Schedule.getSchedule(someMeets4);
		assertEquals(4, someMeets4[result4.get(1)][1]);
		assertEquals(4, someMeets4[result4.get(2)][0]);
		assertEquals(9, someMeets4[result4.get(3)][1]);
		
		// Corner Cases ----------------------------------- 
		//C#1
		int[][] someMeets5 = {{1,2}};
		ArrayList<Integer> result5 = Schedule.getSchedule(someMeets5);
		assertEquals(1, someMeets5[result5.get(0)][0]);
		assertEquals(2, someMeets5[result5.get(0)][1]);
		//C#2
		int[][] someMeets6 = {{1,2},{1,2},{1,2}};
 		ArrayList<Integer> result6 = Schedule.getSchedule(someMeets6);
		assertEquals(1, someMeets6[result6.get(0)][0]);
		assertEquals(2, someMeets6[result6.get(0)][1]);
 	}	
	
	//*************************************************************
	public void testLast(){
		
		// Nominal Cases ----------------------------------
		//N#1
		ArrayList<Integer> aL1 = new ArrayList<Integer>();
		aL1.add(99);
		assertEquals(99, Schedule.last(aL1));
		aL1.add(77);
		assertEquals(77, Schedule.last(aL1));
	}
}