import java.util.Random;

public class test {
	
	public static void main(String[] args) {
		Instrumentation ins = Instrumentation.Instance();
		ins.activate(true);
		/*
		ins.startTiming("Instrumentation");
		ins.stopTiming("Instrumentation");
		ins.dump("Inst.log");
		*/
		
		ins.startTiming("main");
		
		ins.startTiming("populateArray");
		int[] arr = populateArray();
		ins.stopTiming("populateArray");
		
		BubbleSort.sort(arr);
		
		
	}
	
	public int[] populateArray() {
		
		int[] array = new int[10000];
		for(int i = 0; i < array.length; i++) {
			Random random = new Random();
			array[i] = random.nextInt(99999-1)+1;
		}
		
		return array;
	}
	

}
