package Week8;

import java.util.Stack;

/**
 * Created by zhouxuexuan on 17/3/17.
 */

public class SafeStack<E>  {
    private Stack<E> stack = new Stack<>();
    public void pushIfNotFull(E e){
        synchronized (stack){
            if(stack.size() != stack.capacity()){
                stack.push(e);
            }
        }
    }
    public synchronized E popIfNotEmpty(){
        synchronized (stack) {
            if (!stack.isEmpty()) {
                return stack.pop();
            }

            return null;
        }
    }

}
