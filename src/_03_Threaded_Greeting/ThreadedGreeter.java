package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {
	int i;
	ThreadedGreeter(int i){
	this.i = i;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from thread number: " + i);
		if (i <= 50) {
			Thread repeat = new Thread(new ThreadedGreeter((i+1)));
			repeat.start();
			try {
				repeat.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
