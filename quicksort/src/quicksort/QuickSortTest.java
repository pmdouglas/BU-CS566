package quicksort;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void sortTest() {
		int[] sample = {6,3,6,4,8,9,4,3,6,7};
		int[] sortedSample = {3,3,4,4,6,6,6,7,8,9};
		int [] a = quicksort.sort(sample);
		for(int j = 0; j<sample.length; j++ ){
			assertEquals(a[j],sortedSample[j]);
		}
		assertEquals(a.length,sortedSample.length);
	}
	@Test
	public void concatArrayTest() {
		int[] a = {1,2,3};
		int[] b = {1,2};
		int[] c = {1,2,3,1,2};
		int[] d = quicksort.concatArray(a,b);
		for(int j = 0; j<c.length; j++ ){
			assertEquals(c[j],d[j]);
		}
		assertEquals(c.length,d.length);
	}
	@Test
	public void addToArrayTest(){
		int[] a = {1,2,3};
		int[] b = {1,2,3,1};
		int i = 1;
		
		int[] c = quicksort.addToArray(a,i);
		for(int j = 0; j<a.length; j++ ){
			assertEquals(a[j],b[j]);
		}
		assertEquals(a.length+1,b.length);
	}
	@Test
	public void concatWithEmptyTest(){
		int[] a = {1,2,3};
		int[] b = {};
		int[] c = quicksort.concatArray(a,b);
		for(int j = 0; j<c.length; j++ ){
			assertEquals(c[j],a[j]);
		}
		assertEquals(c.length,a.length);
	}

}
