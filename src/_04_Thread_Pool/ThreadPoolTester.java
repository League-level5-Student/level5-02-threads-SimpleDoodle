package _04_Thread_Pool;

public class ThreadPoolTester {
	public static void main(String[] args) {
		WorkQueue wq = new WorkQueue();
		for (int i = 0; i < 1000; i++) {
			int x 	= i;
			Job j = ()->{
				System.out.println("Printing " + x + "from thread #" + Thread.currentThread().getId());
			};
			wq.addJob(j);
		}
		wq.shutdown();
	}
}
