package dynamicCutRod;

import junit.framework.TestCase;

public class TestCutRod extends TestCase {

	
	//*************************************************************
	public void testGetCutWiMaxRevnu(){

		// SG1 --------------------------------------------
		//SG1#1
		CutRod cr = new CutRod();  // re-initializes variables
		int[] prics = {0,1,2,4,2,1};
		CutRod.getCutWiMaxRevnu(prics, 0);
		assertEquals(0, CutRod.maxValsA[0][CutRod.MAX_REVNU]);
		assertEquals(0, CutRod.maxValsA[0][CutRod.MAX_CUT]);
		//SG1#2 
		CutRod.getCutWiMaxRevnu(prics, 1);
		assertEquals(0, CutRod.maxValsA[0][CutRod.MAX_REVNU]);
		assertEquals(1, CutRod.maxValsA[1][CutRod.MAX_REVNU]);
		assertEquals(1, CutRod.maxValsA[1][CutRod.MAX_CUT]);
		CutRod.getCutWiMaxRevnu(prics, 4);
		assertEquals(4, CutRod.maxValsA[3][CutRod.MAX_REVNU]);
		assertEquals(3, CutRod.maxValsA[3][CutRod.MAX_CUT]);
		CutRod.getCutWiMaxRevnu(prics, 5);
		assertEquals(4, CutRod.maxValsA[3][CutRod.MAX_REVNU]);
		assertEquals(3, CutRod.maxValsA[3][CutRod.MAX_CUT]);
		assertEquals(5, CutRod.maxValsA[4][CutRod.MAX_REVNU]);
		assertEquals(3, CutRod.maxValsA[4][CutRod.MAX_CUT]);
		
		// Nominal Cases ----------------------------------
		//N#1
		CutRod.clearmaxValsA();
		int[] prics1 = {0,1,3,4,2,1,8,2};
		//              0 1 2 3 4 5 6 7
		CutRod.getCutWiMaxRevnu(prics1, 7);
		assertEquals(4, CutRod.maxValsA[3][CutRod.MAX_REVNU]);
		assertEquals(3, CutRod.maxValsA[3][CutRod.MAX_CUT]);
		// 7 = 2+2+3   $3+$3+$4 = $10
		assertEquals(10, CutRod.maxValsA[7][CutRod.MAX_REVNU]);
		assertEquals(3, CutRod.maxValsA[7][CutRod.MAX_CUT]);
		//N#2
		CutRod.clearmaxValsA();
		int[] prics2 = {0,1,3,4,2,1,12,1,12};
		//              0 1 2 3 4 5  6 7  8
		// premium      0 0 1 1-2-4  6-6 4 
		CutRod.getCutWiMaxRevnu(prics2, 8);
		// cut 8 into 6+2
		assertEquals(15, CutRod.maxValsA[8][CutRod.MAX_REVNU]);
		assertEquals(6, CutRod.maxValsA[8][CutRod.MAX_CUT]);
		//N#3
		CutRod.clearmaxValsA();
		int[] prics5 = {0,1,2,3,4,5,6,7,8};
		CutRod.clearmaxValsA();
		CutRod.getCutWiMaxRevnu(prics5, 8);
		assertEquals(8, CutRod.maxValsA[8][CutRod.MAX_REVNU]);
		//N#4
		CutRod.clearmaxValsA();
		int[] prics6 = {0,1,2,3,1,5,6,7,8};
		CutRod.getCutWiMaxRevnu(prics6, 8);
		assertEquals(8, CutRod.maxValsA[8][CutRod.MAX_REVNU]);
		
		// Corner Cases ----------------------------------- 
		//C#1
		CutRod.clearmaxValsA();
		int[] prics3 = {0,1,1,1,1,1,1,1,1};
		CutRod.getCutWiMaxRevnu(prics3, 8);
		assertEquals(8, CutRod.maxValsA[8][CutRod.MAX_REVNU]);
		assertEquals(1, CutRod.maxValsA[8][CutRod.MAX_CUT]);
	 	//C#2
		CutRod.clearmaxValsA();
		int[] prics4 = {0,0,0,0};
		CutRod.getCutWiMaxRevnu(prics4, 3);
		assertEquals(0, CutRod.maxValsA[3][CutRod.MAX_REVNU]);
 	}
}