package Week8;

import java.util.Random;

public class BufferExample {
	public static void main (String[] args) throws Exception {
		BufferFixed buffer = new BufferFixed (10);
		MyProducer prod = new MyProducer(buffer);
		prod.start();
		MyConsumer cons = new MyConsumer(buffer);
		cons.start();
	}
}

class MyProducer extends Thread {
	private BufferFixed buffer;
	
	public MyProducer (BufferFixed buffer) {
        this.buffer = buffer;
	}
	
	public void run () {
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        try {
            buffer.addItem(new Object());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyConsumer extends Thread {
	private BufferFixed buffer;
	
	public MyConsumer (BufferFixed buffer) {
		this.buffer = buffer;
	}
	
	public void run () {
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        try {
            buffer.removeItem();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BufferFixed {
	public int SIZE;	
	private Object[] objects;
	private int count = 0;

	public BufferFixed (int size) {
		SIZE = size;
		objects = new Object[SIZE];
	}
	
	public synchronized void addItem (Object object) throws InterruptedException {
        while (count==SIZE-1) {
            wait();
        }
        objects[count] = object;
        count++;
        notifyAll();
	}
	
	public synchronized Object removeItem() throws InterruptedException {
        while (count==0){
            wait();
        }
        count--;
        Object object = objects[count];
        notifyAll();
        return object;
	}
}