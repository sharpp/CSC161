import java.util.Arrays;

public class BigO {
	
	/*
	 * This code is intended to get you to thinking about how to write 
	 * Java code again as well as demonstrate how Big O applies to real
	 * code
	 * 
	 * I have completed all the methods but feel free to delete my code 
	 * and write your own
	 */
	public static void main(String[] args) {
		Timer timer = new Timer();

		// look at growth in running time what is the big O for createRandomArrayOfSizeN?
		System.out.println("\nTesting createRandomArrayOfSizeN method");
		for (int i = 1; i <= 16; i *= 2) {
			int N = i * 1000000;
			timer.reset();
			createRandomArrayOfSizeN(N);	//method being timed
			timer.printElapsedTime(N);
		}

		// look at growth in running time what is the big O for getItem?
		System.out.println("\nTesting getItem method");
		for (int i = 1; i <= 16; i *= 2) {
			int N = i * 1000000;
			int[] array = createRandomArrayOfSizeN(N);		
			int position = (int) (Math.random() * N);
			timer.reset();
			getItem(position, array);	//method being timed
			timer.printElapsedTime(N);
		}

		// look at growth in running time what is the big O for bubbleSort?
		System.out.println("\nTesting bubbleSort method");
		for (int i = 1; i <= 16; i *= 2) {
			int N = i * 10000;
			int[] array = createRandomArrayOfSizeN(N);
			timer.reset();
			bubbleSort(array);	//method being timed
			timer.printElapsedTime(N);
		}

		// look at growth in running time what is the big O for linearSearch?
		System.out.println("\nTesting linearSearch method");
		for (int i = 1; i <= 16; i *= 2) {
			int N = i * 1000000;
			int[] array = createRandomArrayOfSizeN(N);
			int value = (int) (Math.random() * N);
			timer.reset();
			linearSearch(value, array); 	//method being timed
			timer.printElapsedTime(N);
		}

		// look at growth in running time what is the big O for binarySearch?
		System.out.println("\nTesting binarySearch method");
		for (int i = 1; i <= 16; i *= 2) {
			int N = i * 1000000;
			int[] array = createRandomArrayOfSizeN(N);
			// array must be sorted for binarySearch
			Arrays.sort(array);
			int value = (int) (Math.random() * N);
			timer.reset();
			binarySearch(value, array); 	//method being timed
			timer.printElapsedTime(N);
		}

	}

	public static int[] createRandomArrayOfSizeN(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * n);
		}
		return array;
	}


	public static int getItem(int position, int[] inputArray) {
		return inputArray[position];
	}

	public static void bubbleSort(int[] inputArray) {
        int n = inputArray.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (inputArray[j] > inputArray[j+1]) 
                { 
                    // swap inputArray[j+1] and inputArray[i] 
                    int temp = inputArray[j]; 
                    inputArray[j] = inputArray[j+1]; 
                    inputArray[j+1] = temp; 
                } 
	}

	public static int linearSearch(int value, int[] inputArray) {
		for (int i : inputArray) {
			if (value == inputArray[i]) {
				return i;
			}
		}
		return -1;
	}

	public static int binarySearch(int value, int[] inputArray) {
		// use recursive helper method
		return binarySearchHelper(value, inputArray, 0, inputArray.length - 1);		
	}

	private static int binarySearchHelper(int value, int[] inputArray, int low, int high) {
		//if high is not >= to low the array is size 0 so item must not be in it.
        if (high >= low) { 
            int mid = low + (high - low) / 2; 
            // If the element is present at the mid point of the array
            if (inputArray[mid] == value) 
                return mid; 
  
            // If element is smaller than mid, then the element is in the lower portion of the array 
            if (inputArray[mid] > value) 
                return binarySearchHelper(value, inputArray, low, mid - 1); 
  
            // Else the element can only be present in upper portion of the array
         
            return binarySearchHelper( value, inputArray, mid + 1, high); 
        } 
        // item not found
        return -1; 
	}
}

class Timer {
	long startTime;
	long totalTime;

	Timer() {
		startTime = System.currentTimeMillis();
	}

	public void reset() {
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		totalTime = System.currentTimeMillis() - startTime;
	}

	public void print(int N) {
		System.out.println("For N = " + N + " Operation took " + totalTime + " milliseconds");
	}

	public void printElapsedTime(int N) {
		stop();
		print(N);
	}
}
