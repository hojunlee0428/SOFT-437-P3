import java.util.*;
import java.security.*;

class BubbleSort extends SortAlgorithm
{
	void sort(int a[])
	{
		//Start Timing
		Instrumentation ins = Instrumentation.Instance();
		ins.startTiming("BubbleSort");
		
		for (int i = a.length; --i >= 0;)
		{
			boolean flipped = false;
			for (int j = 0; j < i; j++)
			{
				if (stopRequested)
				{
					//Stop Timing
					ins.stopTiming("BubbleSort");
					return;
				}
				super.compares++;
				super.activeMarker = j;
				if (a[j] > a[j + 1])
				{
					int T = a[j];
					a[j] = a[j + 1];
					a[j + 1] = T;
					super.moves++;
					flipped = true;
				}
				super.updateAllViews();
			}
			if (!flipped)
			{
				super.updateAllViews(-1, -1);
				//Stop Timing
				ins.stopTiming("BubbleSort");
				return;
			}
			super.hiMarker = i;
			super.updateAllViews();
		}
		
		super.updateAllViews(-1, -1);
		//Stop Timing
		ins.stopTiming("BubbleSort");
	}
}