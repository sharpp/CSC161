
public class BigO
{

	public static void main( String[ ] args )
	{
		TimeIt t = new TimeIt ( );
		
		System.out.println ("Testing runForNTime method");
		for (int i = 1; i <= 16; i *= 2) {
			int N = i * 1000000;
			t.reset ( );
			runForNTime(N);
			t.printElapsedTime(N);
		}
		
		System.out.println ("\nTesting createRandomArrayOfSizeN method");
		for (int i = 1; i <= 16; i *= 2) {
			int N = i * 1000000;
			t.reset ( );
			int[] array = createRandomArrayOfSizeN ( N );
			t.printElapsedTime(N);
		}
		
		System.out.println ("\nTesting getItem method");
		for (int i = 1; i <= 16; i *= 2) {
			int N = i * 1000000;
			int[] array = createRandomArrayOfSizeN ( N );
			int position = (int) Math.random ( ) * N;
			t.reset ( );
			getItem(position, array);
			t.printElapsedTime ( position );
		}
		
		//complete and test bubbleSort
		
		//complete and test findValueBasic
		
		//complete and test FindValueWithBinarySearch

	}
	
	public static int[] createRandomArrayOfSizeN(int N) {
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = (int) Math.random ( );
		}
		return array;
	}
	
	public static void runForNTime(int n) {
		int j = 0;
		for (int i = 0; i < n; i++)
			j += (int)Math.random ( );
	}
	
	public static int getItem(int position, int[] inputArray) {
		return inputArray[position];
	}
	
	public static void bubbleSort(int[] inputArray) {
		
	}
	
	public static void findValueBasic(int value, int[] inputArray) {
		
	}
	
	public static void findValueWithBinarySearch(int value, int[] inputArray) {
		
	}
	

}

class TimeIt{
	long startTime;
	long totalTime;
	
	TimeIt(){
		startTime = System.currentTimeMillis ( );
	}
	
	public void reset() {
		startTime = System.currentTimeMillis ( );
	}
	
	public void stop(){
		totalTime = System.currentTimeMillis ( ) - startTime;
	}
	
	public void print(int N) {
		System.out.println ("For N = " + N + " Operation took " + totalTime + " milliseconds");
	}
	
	public void printElapsedTime(int N) {
		stop();
		print(N);
	}
}
