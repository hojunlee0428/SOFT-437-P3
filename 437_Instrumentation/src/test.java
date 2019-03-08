/* Test class to test the performance of the sorting algorithms*/

import java.util.Random;

public class test {
	private static Instrumentation ins = Instrumentation.Instance();
	public static void main(String[] args) {
		
		ins.activate(true);
		
		/*
		//Testing Instrumentation Itself
		ins.startTiming("InstOverhead");
		for(int i=0;i<10;i++) {
			InstTest();
		}
		ins.stopTiming("InstOverhead");	
		ins.dump("Inst.log");
		*/
		
		/*
		//Testing the Sorting Algorithm
		ins.startTiming("main");
				

		ins.comment("populateArray Running Time Test");
		ins.startTiming("populateArray");
		int[] arr = populateArray();
		ins.stopTiming("populateArray");

				
		BubbleSort(arr);
		QuickSort(arr);
		SelectionSort(arr);
		MergeSort(arr);

		ins.stopTiming("main");
		ins.comment("Testing the sorting algorithms");
		ins.dump("output1.log");	
		
		*/
		
		
		//Testing with Instrumentation in the Sorting Algorithm Classes
		//Make instance of sorting algorithms since they are not static
		BubbleSort BSort = new BubbleSort();
		QuickSort QSort = new QuickSort();
		SelectionSort SSort = new SelectionSort();
		MergeSort MSort = new MergeSort();
		
		ins.comment("populateArray Running Time Test");
		ins.startTiming("populateArray");
		int[] arr = populateArray();
		ins.stopTiming("populateArray");
		
		ins.startTiming("main");
		
		BSort.sort(arr);
		QSort.sort(arr);
		SSort.sort(arr);
		MSort.sort(arr);
		
		ins.stopTiming("main");
		ins.comment("Testing the sorting algorithms with instrumentation added");
		ins.dump("output2.log");
		
		
		
	}
	
	public static int[] populateArray() {
		int[] array = new int[10000];
		for(int i = 0; i < array.length; i++) {
			Random random = new Random();
			array[i] = random.nextInt(99999-1)+1;
		}	
		return array;
	}
	public static void InstTest() {
		ins.startTiming("Instrumentation");
		ins.stopTiming("Instrumentation");
	}
	
	public static void BubbleSort(int[] arr) {
		BubbleSort BSort = new BubbleSort();
		ins.startTiming("BubbleSort");
		BSort.sort(arr);
		ins.stopTiming("BubbleSort");
	}
	
	public static void QuickSort(int[] arr) {
		QuickSort QSort = new QuickSort();
		ins.startTiming("QuickSort");
		QSort.sort(arr);
		ins.stopTiming("QuickSort");
	}
	public static void MergeSort(int[] arr) {
		MergeSort MSort = new MergeSort();
		ins.startTiming("MergeSort");
		MSort.sort(arr);
		ins.stopTiming("MergeSort");
	}
	public static void SelectionSort(int[] arr) {
		SelectionSort SSort = new SelectionSort();
		ins.startTiming("SelectionSort");
		SSort.sort(arr);
		ins.stopTiming("SelectionSort");
	}
	
	
	

}
