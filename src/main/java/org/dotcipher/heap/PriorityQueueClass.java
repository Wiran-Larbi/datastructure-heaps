package org.dotcipher.heap;

import java.lang.reflect.Constructor;
import java.util.PriorityQueue;

public class PriorityQueueClass<T> {

    PriorityQueue<T> priorityQueue;

    PriorityQueueClass(){
        this.priorityQueue = new PriorityQueue<>();
    }

    public void add(T element){
        this.priorityQueue.add(element);
    }

    public T peek(){
        return this.priorityQueue.peek();
    }

}
