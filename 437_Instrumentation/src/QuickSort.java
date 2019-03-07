class QuickSort extends SortAlgorithm
{
	void sort(int a[], int lo0, int hi0)
	{
		int lo = lo0;
		int hi = hi0;
		super.lowMarker = lo0;
		super.hiMarker = hi0;
		if (lo >= hi)
		{
			return;
		} else if (lo == hi - 1)
		{
			/*
			 *  sort a two element list by swapping if necessary 
			 */
			if (a[lo] > a[hi])
			{
				int T = a[lo];
				a[lo] = a[hi];
				a[hi] = T;
				super.moves++;
				super.updateAllViews();
			}
			return;
		}

		/*
		 *  Pick a pivot and move it out of the way
		 */
		int pivot = a[(lo + hi) / 2];
		a[(lo + hi) / 2] = a[hi];
		a[hi] = pivot;
		super.other += 3;

		while (lo < hi)
		{
			/*
			 *  Search forward from a[lo] until an element is found that
			 *  is greater than the pivot or lo >= hi 
			 */
			super.compares++;
			while (a[lo] <= pivot && lo < hi)
			{
				lo++;
				super.compares++;
			}

			/*
			 *  Search backward from a[hi] until element is found that
			 *  is less than the pivot, or lo >= hi
			 */
			super.compares++;
			while (pivot <= a[hi] && lo < hi)
			{
				hi--;
				super.compares++;
			}

			/*
			 *  Swap elements a[lo] and a[hi]
			 */
			if (lo < hi)
			{
				int T = a[lo];
				a[lo] = a[hi];
				a[hi] = T;
				super.moves++;
			}
			super.updateAllViews();

			if (stopRequested)
			{
				return;
			}
		}

		/*
		 *  Put the median in the "center" of the list
		 */
		a[hi0] = a[hi];
		a[hi] = pivot;
		super.moves += 2;
		super.updateAllViews();

		/*
		 *  Recursive calls, elements a[lo0] to a[lo-1] are less than or
		 *  equal to pivot, elements a[hi+1] to a[hi0] are greater than
		 *  pivot.
		 */
		sort(a, lo0, lo - 1);
		sort(a, hi + 1, hi0);
	}

	void sort(int a[])
	{
		//Start Timing
		Instrumentation ins = Instrumentation.Instance();
		ins.startTiming("QuickSort");
		
		sort(a, 0, a.length - 1);
		super.updateAllViews(-1, -1);
		
		//Stop Timing
		ins.stopTiming("QuickSort");
	}
}