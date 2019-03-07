
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Instrumentation {
	private static Instrumentation instance = new Instrumentation();
	
	private Boolean isActive; 	//Boolean to Check if Inst. is Active
	private String log;			//Buffer for log output
	private Stack<Long> startTime; //Stack to keep track of start timings
	private Stack<String> runningInst; //Stack to keep track of running instrumentations
	
	private Instrumentation() {
		isActive = false;
		log = "";
		startTime = new Stack<Long>();
		runningInst = new Stack<String>();
	}
	
	//Accessor
	public static Instrumentation Instance() {
		return instance;
	}
	
	//Start timing the method
	public void startTiming(String comment) {
		if(!isActive) {
			return;
		}
		String indent = Indent();
		log += indent + "STARTTIMING:" + comment + "\n";
		runningInst.add(comment);
		startTime.add(System.currentTimeMillis());
	}
	

	//Stop timing the method
	public void stopTiming(String comment) {

		if(!isActive) {
			return;
		}
		if (runningInst.peek()!=comment) {
			System.err.println("Error: Not the most recent instrumentation");
		}
		else {
			runningInst.pop();
			long timeTaken = System.currentTimeMillis() - startTime.pop();
			String indent = Indent();
			log += indent + "STOPTIMING:" + comment + " " + timeTaken + "ms" + "\n";
		}

	}
	
	//Place an additional comment in the output
	public void comment(String comment) {
		String indent = Indent();
		log += indent + "COMMENT: " + comment + "\n";
		
	}
	
	//Write formatted start/stop timing statement
	public void dump(String filename) {
		Path path = Paths.get(filename);
		List<String> lines = new ArrayList<>();
		lines = Arrays.asList(log.split("\n"));
		try {
			Files.write(path, lines, Charset.forName("UTF-8"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//Activates/Deactivates Instrumentation
	public void activate(Boolean onOff) {
		this.isActive = onOff;
	}
	
	//Generate Indent based on the amount of currently running Inst.
	public String Indent() {
		String indent = "";
		for (int i = 0; i < runningInst.size(); i ++) {
			indent += "| ";
		}
		return indent;
	}
}
