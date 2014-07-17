package parallelSearch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelSearch {

/**
 * finds the first and last occurrence of a given integer in a sorted array and prints results
 * @param args
 */
    public static void main(String[] args) {
    
    	int[] sample = {1,1,1,2,2,2,3,3,3,4,4,4};
    	int intToFind = 2;
    	int first = 0;
    	int last = 0;
    	ExecutorService executorService = Executors.newFixedThreadPool(2);
    	
    	//create and start a sub task for finding the first and last instance of the integer
    	Future<Integer> futureFirst = executorService.submit(new FindFirst(sample, intToFind));
    	Future<Integer> futureLast = executorService.submit(new FindLast(sample, intToFind));
    	
    	//wait for each task to return with results
    	try {
			first = futureFirst.get(); // get() blocks until results are in
			last = futureLast.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	executorService.shutdown();
    	
    	//ouptut the results now that all results are in
    	System.out.println();
    	System.out.print("Integer " + intToFind + " Occurs from " + first + " to " + last);
    	System.out.println();
    }
}
   



