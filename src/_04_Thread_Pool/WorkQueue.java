package _04_Thread_Pool;

public class WorkQueue implements Runnable {
	private Thread[] threads;
	private boolean isRunning = true;
	
	public WorkQueue() {
		int totalThreads = Runtime.getRuntime().availableProcessors()-1;
		threads = new Thread[totalThreads];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(this);
			threads[i].start();
		}
	}
	public int getThreadCount() {
		return threads.length;
	}
	@Override
	public void run() {
		while(isRunning) {
			System.out.println("Output from thread # " + Thread.currentThread().getId());
		}
	}
	public void shutdown() {
		isRunning = false;
	}

}
