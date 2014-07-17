package quicksort;


public class quicksort {
/**
 * main function used to call sort algorithm and print results
 * @param args
 */
    public static void main(String[] args) {
    	int[] sample = {6,3,6,4,8,9,4,3,6,7};
    	//int[] sample = {2,1,3};
    	int[] sortedSample = sort(sample);
    	printArray(sortedSample);
    	
    }
    /**
     * recursive sort algorithm
     * takes an array of integers and returns the same array sorted small to large
     * @param sample
     * @return
     */
    public static int[] sort(int[] sample){
    	
    	int[] sortedSample = new int[sample.length]; // create a placeholder for sort results
    	if(sample.length > 2) //recursive case for arrays bigger then 2
    	{
    		int pivot = sample[sample.length/2]; // set the value at the middle point as the pivot
    		
    		int[] left = new int[0]; //set placeholders for sub arrays to make recursive calls
    		int[] right = new int[0];
    		int[] middle = new int[0];
    		
    		for(int i:sample) //for each integer in sample
    		{
    			if(i<pivot)
    			{
    				left = addToArray(left,i); //add integers that are smaller then pivot to left array
    			}else if ( i == pivot)
    			{
    				middle = addToArray(middle,i); //add integers that are equal to pivot to left array
    			}else
    			{
    				right = addToArray(right,i);  //add integers that are bigger then pivot to left array
    			}
    			
    			
    		}
    		sortedSample = concatArray(sort(left),middle);
    		sortedSample = concatArray(sortedSample, sort(right)); // make recursive calls to left and right arrays. middle array is already sorted
    	}else if (sample.length ==2){
    		if (sample[0] > sample[1]) //base case for arrays of length 2 if sorted leave as is if not swap
    		{		
    			sortedSample[0] = sample[1];
    			sortedSample[1] = sample[0];
    		}else
    		{
    			sortedSample[0] = sample[0];
    			sortedSample[1] = sample[1];
    		}
    	}else if (sample.length == 1){ // base case for arrays of length 1 just return single item array
    		sortedSample[0] = sample[0];
    	}
    	return sortedSample;
    }
    /**
     * appends array right to the end of array left
     * @param left
     * @param right
     * @return
     */
    public static int[] concatArray(int[] left, int[] right)
    {
    	int[] out = new int[left.length+right.length];
    	for(int i = 0; i < out.length; i++)
    	{
    		if(i < left.length)
    		{
    			out[i] = left[i];
    		}else
    		{
    			out[i] = right[i - left.length];
    		}
    	}
    	return out;
    }
    /**
     * takes an array and append an integer to the end
     * @param arrayIn
     * @param newInt
     * @return
     */
    public static int[] addToArray(int[] arrayIn, int newInt)
    {
    	int[] arrayOut = new int[arrayIn.length+1];
    	for(int i = 0; i< arrayIn.length; i++)
    	{ 
    		arrayOut[i] = arrayIn[i];
    	}
    	arrayOut[arrayOut.length-1] = newInt;
    	return arrayOut;
    }
    /**
     * print the contents of out to system output
     * @param out
     */
    public static void printArray(int[] out)
    {
    	for(int i:out)
    	{
    		System.out.print(i);
    	}
    	System.out.println();
    }
}

