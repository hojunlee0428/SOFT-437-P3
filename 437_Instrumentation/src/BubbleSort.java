import java.util.*;
import java.security.*;

class BubbleSort extends SortAlgorithm
{
	void sort(int a[])
	{
		Instrumentation ins = Instrumentation.Instance();
		for (int i = a.length; --i >= 0;)
		{
			boolean flipped = false;
			for (int j = 0; j < i; j++)
			{
				if (stopRequested)
				{
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
				return;
			}
			super.hiMarker = i;
			super.updateAllViews();
		}
		
		super.updateAllViews(-1, -1);
	}
}