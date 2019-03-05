public interface IView
{

	/** Update the view with the most recent information from the model.
	 * @param totalOps The total number of comparisons, movements, and
	 * other array operations since the last update.  Used to control the
	 * length of the pause in the display. */
	public void updateView(int totalOps);
}