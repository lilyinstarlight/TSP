public class Timer
{
	long startTime;
	long stopTime;
	
	public Timer()
	{
		startTime = -1;
	}
	
	public void start()
	{
		startTime = System.currentTimeMillis();
	}
	
	public void stop()
	{
		stopTime = System.currentTimeMillis();
	}
	
	public double getTime()
	{
		return (stopTime - startTime) / 1000;
	}
}
