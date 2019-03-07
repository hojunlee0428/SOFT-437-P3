class SelectionSort extends SortAlgorithm
{
	void sort(int a[])
	{
		//Start Timing
		Instrumentation ins = Instrumentation.Instance();
		ins.startTiming("SelectionSort");
		
		for (int i = 0; i < a.length; i++)
		{
			super.lowMarker = i;
			int min = i;
			int j;

			/*
			 * Find the smallest element in the unsorted list
			 */
			for (j = i + 1; j < a.length; j++)
			{
				if (stopRequested)
				{
					//Stop Timing
					ins.stopTiming("BubbleSort");
					return;
				}

				if (a[j] < a[min])
				{
					min = j;
				}
				super.compares++;
				super.activeMarker = j;
				super.updateAllViews();
			}

			/*
			 * Swap the smallest unsorted element into the end of the sorted list.
			 */
			int T = a[min];
			a[min] = a[i];
			a[i] = T;
			super.moves++;
			super.activeMarker = i;
			super.updateAllViews();
		}
		super.updateAllViews(-1, -1);
		
		//Stop Timing
		ins.stopTiming("SelectionSort");
	}
}