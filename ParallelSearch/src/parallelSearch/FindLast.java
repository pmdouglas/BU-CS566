package parallelSearch;

import java.util.concurrent.Callable;

/**
 * finds the last occurrence of intToFind in sample. Returns 0 if not found
 * @param sample
 * @param intToFind
 * @return location of last occurrence
 */

public class FindLast implements Callable<Integer>{
	private int[] sample;
	private int intToFind;
	FindLast(int[] sample, int intToFind)
	{
		this.sample = sample;
		this.intToFind = intToFind;
	}
	
	@Override
	public Integer call(){
		for(int i = sample.length-1;i>=0;i--)
		{
			if(sample[i] == intToFind)
				return i;
		}
		return 0;
	}
}