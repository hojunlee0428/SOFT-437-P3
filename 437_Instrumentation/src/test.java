/* Test class to test the performance of the sorting algorithms*/

import java.util.Random;

public class test {
	
	public static void main(String[] args) {
		Instrumentation ins = Instrumentation.Instance();
		ins.activate(true);
		
		//Make instance of sorting algorithms since they are not static
		BubbleSort BSort = new BubbleSort();
		QuickSort QSort = new QuickSort();
		SelectionSort SSort = new SelectionSort();
		MergeSort MSort = new MergeSort();
		
		ins.startTiming("main");
		
		ins.startTiming("populateArray");
		int[] arr = populateArray();
		ins.stopTiming("populateArray");
		
		
		BSort.sort(arr);
		QSort.sort(arr);
		SSort.sort(arr);
		MSort.sort(arr);
		
		ins.stopTiming("main");
		ins.comment("Testing the sorting algorithms");
		ins.dump("output.log");
	}
	
	public static int[] populateArray() {
		
		int[] array = new int[10000];
		for(int i = 0; i < array.length; i++) {
			Random random = new Random();
			array[i] = random.nextInt(99999-1)+1;
		}
		
		return array;
	}
	

}
