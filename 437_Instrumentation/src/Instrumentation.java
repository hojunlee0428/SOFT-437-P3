
public class Instrumentation {
	private static Instrumentation instance = new Instrumentation();
	
	private Boolean isActive;
	//Accessor
	public static Instrumentation Instance() {
		return instance;
	}
	//Start timing the method
	public void startTiming(String comment) {
		if(!isActive) {
			return;
		}
	}
	
	//Stop timing the method
	public void stopTiming(String comment) {
		if(!isActive) {
			return;
		}
	}
	
	//Place an additional comment in the output
	public void comment(String comment) {
		
	}
	
	//Write formatted start/stop timing statement
	public void dump(String filename) {
		
	}
	
	//Activates/Deactivates Instrumentation
	public void activate(Boolean onOff) {
		this.isActive = onOff;
	}
}
