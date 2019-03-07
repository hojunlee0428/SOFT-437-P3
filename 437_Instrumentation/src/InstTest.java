/* Test class to test the overhead of the Instrumentation itself */


public class InstTest {
	public static void main(String[] args) {
		Instrumentation ins = Instrumentation.Instance();
		ins.activate(true);
		
		ins.startTiming("Instrumentation");
		for(int i = 0; i < 10; i++) {
			ins.startTiming("Inst test");
			ins.stopTiming("Inst test");
		}
		ins.stopTiming("Instrumentation");
		
		ins.comment("Instrumentation overhead test (10 iterations)");
		ins.startTiming("Instrumentation");
		for(int i = 0; i < 100; i++) {
			ins.startTiming("Inst test");
			ins.stopTiming("Inst test");
		}
		ins.stopTiming("Instrumentation");
		
		ins.comment("Instrumentation overhead test (100 iterations)");
		
		ins.startTiming("Instrumentation");
		for(int i = 0; i < 1000; i++) {
			ins.startTiming("Inst test");
			ins.stopTiming("Inst test");
		}
		ins.stopTiming("Instrumentation");
		
		ins.comment("Instrumentation overhead test (1000 iterations)");
		ins.dump("Inst_Output.log");
	}
}
