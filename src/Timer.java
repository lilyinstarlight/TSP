public class Timer {
	long start;
	long stop;

	public Timer() {
		start = -1;
	}

	public void start() {
		start = System.currentTimeMillis();
	}

	public void stop() {
		stop = System.currentTimeMillis();
	}

	public double getTime() {
		return (stop - start) / 1000;
	}
}
