package Week8;

import java.util.concurrent.atomic.AtomicInteger;

//is this class thread-safe?
public class RangeSafe {
    public final AtomicInteger lower = new AtomicInteger(0);
    public final AtomicInteger upper = new AtomicInteger(0);

    //invariant: lower <= upper

    public synchronized void setLower(int i) {
        String mid = String.valueOf(i);
        int k = Integer.valueOf(mid);
        if (k > upper.get()) {
            throw new IllegalArgumentException ("Can't set lower to " + i + " > upper");
        }

        lower.set(k);
    }

    public synchronized void setUpper(int i) {
        String mid = String.valueOf(i);
        int k = Integer.valueOf(mid);
        if (k < lower.get()) {
            throw new IllegalArgumentException ("Can't set upper to " + i + " < lower");
        }

        upper.set(k);
    }

    public boolean isInRange(int i) {
        return (i >= lower.get()) && i <= upper.get();
    }

    public boolean isValid() {
        return lower.get() <= upper.get();
    }

}



