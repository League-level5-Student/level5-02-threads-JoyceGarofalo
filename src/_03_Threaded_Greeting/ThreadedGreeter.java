package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable{
	int var;
	
	ThreadedGreeter(int var){
		this.var = var;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(var <= 50) {
			System.out.println("Hello from thread number: " + var);
			Thread t4 = new Thread(new ThreadedGreeter(var+1));
			t4.start();
			try {
				t4.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}