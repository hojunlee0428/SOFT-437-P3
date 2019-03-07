class MergeSort extends SortAlgorithm
{
	void sort(int a[], int lo, int hi, int scratch[])
	{

		
		super.updateAllViews(lo, hi);
		
		if (super.stopRequested)
		{
			return;
		}
		
		if (lo >= hi)
		{
			return; /* a[lo] is sorted already   */
		}

		int mid = (lo + hi) / 2;
		sort(a, lo, mid, scratch); /* Sort sublist a[lo..mid]   */
		sort(a, mid + 1, hi, scratch); /* Sort sublist a[mid+1..hi] */

		if (super.stopRequested)
		{
			return;
		}

		// Merge results
		int k, t_lo = lo, t_hi = mid + 1;
		super.lowMarker = lo;
		super.hiMarker = hi;
		for (k = lo; k <= hi; k++)
		{
			/* Merge sorted sublists    */
			super.compares++;
			if ((t_lo <= mid) && ((t_hi > hi) || (a[t_lo] < a[t_hi])))
			{
				scratch[k] = a[t_lo++];
			} else
			{
				scratch[k] = a[t_hi++];
			}
			super.moves++;
			super.activeMarker = k;
			super.updateAllViews();
		}

		for (k = lo; k <= hi; k++)
		{
			a[k] = scratch[k]; /* Copy back to a   */
			super.moves++;
			super.activeMarker = k;
			super.updateAllViews();
		}
		
	}

	void sort(int a[])
	{
		//Start Timing
		Instrumentation ins = Instrumentation.Instance();
		ins.startTiming("MergeSort");
		
		int scratch[] = new int[a.length];
		sort(a, 0, a.length - 1, scratch);
		super.updateAllViews(-1, -1);
		
		//Stop Timing
		ins.stopTiming("MergeSort");
	}
}