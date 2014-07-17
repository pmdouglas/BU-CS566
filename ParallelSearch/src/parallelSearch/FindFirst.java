package parallelSearch;

import java.util.concurrent.Callable;

/**
 * Finds the first occurrence of intToFind in sample.  Returns 0 if not found
 * @param sample
 * @param intToFind
 * @return location of first occurrence
 */
public class FindFirst implements Callable<Integer>{
	private int[] sample;
	private int intToFind;

	FindFirst(int[] sample, int intToFind) {
		this.sample = sample;
		this.intToFind = intToFind;
	}
	
	@Override
	public Integer call(){
		for(int i = 0;i<sample.length;i++)
		{
			if(sample[i] == intToFind)
				return i;
		}
		return 0;
	}
}
