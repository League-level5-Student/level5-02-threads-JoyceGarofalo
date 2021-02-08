package _06_Wait_and_Notify.Practice;

import _06_Wait_and_Notify.Example.ThreadPrinter;

/*
 
Below are two threads. One thread increments the counter
and the other thread prints the result. If you run the
program as it is, you'll notice that the output in not
sequential.

Your goal is to modify the code inside the threads so that 
they are in synch. Use synchronized, wait, and notify to make
it so that t1 will only increase counter after t2 has printed 
the previous result. The output should be the numbers 0 to 100000
printed in order.
  
*/

public class SynchedSplitLoops {
	static int counter = 0;
	private static final Object counterIncreased = new Object();

	
	public static void main(String[] args) {
		
		synchronized(counterIncreased) {
			Thread t2 = new Thread(() -> {
				for(int i = 0; i < 100000; i++) {
					System.out.println(counter);
				}
			});
			counterIncreased.notify();
			try {
				counterIncreased.wait(); //pauses execution until another thread calls notify using threadLock
			} catch (InterruptedException e) {
				System.out.println("error!");
			}
			Thread t1 = new Thread(() -> {
				for(int i = 0; i < 100000; i++) {
					counter++;
				}
			});
		}
		
		
		/*
		Thread t1 = new Thread(() -> {
			for(int i = 0; i < 100000; i++) {
				counter++;
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i = 0; i < 100000; i++) {
				System.out.println(counter);
			}
		});
		*/
		Thread t1 = new Thread(new ThreadPrinter());
		Thread t2 = new Thread(new ThreadPrinter());
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			System.err.println("Could not join threads");
		}
		
	}
}
