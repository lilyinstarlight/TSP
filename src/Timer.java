public class Timer {
	long start;
	long stop;

	public Timer() {
		start = -1;
	}

	public void start() {
		start = System.nanoTime();
	}

	public void stop() {
		stop = System.nanoTime();
	}

	public double getTime() {
		return (stop - start) / 1000;
	}
}
