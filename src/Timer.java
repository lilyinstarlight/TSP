/**
 * General class to time tasks
 */
public class Timer {
	long start;
	long stop;
	public final static String[] units = { "μs", "ms", "s", "ks", "Ms" };

	/**
	 * Start the timer
	 */
	public void start() {
		start = System.nanoTime();
	}

	/**
	 * Stop the timer
	 */
	public void stop() {
		stop = System.nanoTime();
	}

	/**
	 * Get the time elapsed in nanoseconds
	 *
	 * @return Time in nanoseconds
	 */
	public long getTime() {
		return stop - start;
	}

	/**
	 * Get a formatted time string that adjusts the number and includes units
	 *
	 * @return Formatted time
	 */
	public String getFormattedTime() {
		long time = getTime();
		int unit = (int)((Math.log10(time) - 9 - 2) / 3); //-9 because nano, -2 because it chooses a unit with -1 to 2 digits
		if(unit > 2)
			unit = 2;
		else if(unit < -2)
			unit = -2;

		return (time / Math.pow(10, unit * 3 + 9)) + units[unit + 2]; //+9 because nano, +2 because arrays can't have negative indices
	}
}
