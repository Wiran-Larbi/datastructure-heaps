package org.dotcipher.heap;

/**
    - a Heap is a complete binary tree
    - It Must satisfy the heap property
    - Max Heap: Every parent is greater than or equal to its children
    - Min Heap: Every parent is less than or equal to its children
    - a Binary Heap must be a complete tree
    - Children are added at each level from left to right
    - Usually implemented as arrays
    - The maximum or minimum value will always be at the root of the tree - the advantage of using a heap
    -
*/
public class Heap {
    public static HeapArray heapArray;
    public static PriorityQueueClass<Integer> priorityQueueClass;

    public static void main(String[] args) {
        heapArray = new HeapArray(10);
        priorityQueueClass = new PriorityQueueClass<>();

        heapArray.insert(1);
        heapArray.insert(22);
        heapArray.insert(32);
        heapArray.insert(14);
        heapArray.insert(7);
        heapArray.insert(10);
        heapArray.insert(5);
        heapArray.insert(55);

        System.out.println("Root Element is : " + heapArray.peek());

        heapArray.getHeap();

        heapArray.delete(1);
        heapArray.delete(2);
        heapArray.delete(0);


        System.out.println("\n After Deleting Element at index 1 and 2 : ");
        System.out.println("Root Element is : " + heapArray.peek());
        //heapArray.getHeap();

        System.out.println("\n Displaying Heap Elements Sorted : ");

        for (Object elem : heapArray.HeapSort()){
            System.out.print(" " + elem + " ");
        }
//        heapArray.HeapSort().forEach(System.out::print);
        for (int elem : heapArray.HeapSort()){
            System.out.print(" " + elem + " ");
        }
//        heapArray.getHeap();

        System.out.println("\n Priority Queue Code ....");
        priorityQueueClass.add(25);
        priorityQueueClass.add(-22);
        priorityQueueClass.add(1343);
        priorityQueueClass.add(54);
        priorityQueueClass.add(0);
        priorityQueueClass.add(-3492);
        priorityQueueClass.add(429);

        Object[] ints = priorityQueueClass.priorityQueue.toArray();
        for (Object num: ints){
            System.out.print(" " + num + " ");
        }

        System.out.println("\n" + priorityQueueClass.peek());



    }
}
