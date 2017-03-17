package Week8;

public class MyStack {
	private int maxSize;
	private long[] stackArray;
	private int top; 
	
	public MyStack(int s) { 
		maxSize = s;
	    stackArray = new long[maxSize];
	    top = -1;
	}

	public void push(long j) {
		while (isFull()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		stackArray[++top] = j;
		notifyAll();
	}

	public synchronized long pop() {
		long toReturn;

		while (isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		toReturn = stackArray[top--];
		notifyAll();
		return toReturn;
	}

	public long peek() {
	    return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == maxSize - 1);
	}
}