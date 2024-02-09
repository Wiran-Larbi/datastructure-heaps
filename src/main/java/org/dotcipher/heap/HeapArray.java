package org.dotcipher.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * We Store a binary heap as array
 * We put the root at array[0]
 * We then traverse each level from left to right,
 * and so the left child of the root would go into
 * array[1], its right child would go into array[2], etc
 *
 * a Simple representation of a heap as an array :
 * [22 , 19, 18, 15, 3, 14, 4, 12]
 * [Max, l1, r1, l2,r2, l3,r3,l4]
 *
 * The Rule to find Left and Right and Root Elements
 * For the node at array[i]
 * Left child = 2i + 1
 * Right child = 2i + 2
 * Parent = floor((i - 1) / 2)
 */
public class HeapArray {
    private int[] heap;
    private int size = 0;

    public HeapArray(int capacity) {
        heap = new int[capacity];
    }
    public boolean isFull(){
        return size == heap.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public int getParent (int index) {
        return (index - 1) / 2;
    }

    private void heapifyUp(int index){
        int newValue = heap[index];

        while(index > 0 && newValue > heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    private void heapifyDown(int index, int lastHeapIndex){
        int childToSwap;

        while (index <= lastHeapIndex){
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            if (leftChild <= lastHeapIndex){
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                }else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];

                    heap[childToSwap] = temp;
                }else {
                    break;
                }

                index = childToSwap;
            } else {
                break;
            }

        }

    }


    // Inserting to the array
   // Always add new items to the end of the array
   // Then we have to fix the heap (heapify)
   // We compare the new item against its parent
   // If the item is greater than its parent, we swap it with its parent
   // We then rinse and repeat

    public void insert(int value){
        if (isFull()){
            throw new IndexOutOfBoundsException("Heap is Full");
        }

        heap[size] = value;

        heapifyUp(size);
        size++;
    }

    // Deleting from the heap
    // Must choose a replacement value
    // Will take the rightmost value, so that the tree remains complete
    // Then we must heapify the heap
    // When replacement value is greater than parent, fix heap above. Otherwise, fix heap below
    public int delete(int index){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Heap is Empty !");
        }
        if (index > this.size - 1){
            throw new IndexOutOfBoundsException("Index Out of Bound !");
        }

        int parent = getParent(index);
        int deletedValue = heap[index];

        heap[index] = heap[size - 1];

        if (index == 0 || heap [index] < heap[parent]){
            heapifyDown(index, size - 1);
        } else {
            heapifyUp(index);
        }

        size--;
        return deletedValue;
    }

    // Peek Gives us the Maximum Element in the Heap
    public int peek() throws IndexOutOfBoundsException{
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException("Empty Heap");
        }
        return this.heap[0];
    }

    public int getChild(int index, boolean left){
        return 2 * index + (left ? 1 : 2);
    }
    public void getHeap(){
        int i = 0;

        while(i < this.size){
            System.out.print(" " + this.heap[i] + " ");
            i++;
        }
    }

    // Heap - Sort
    // - We know the root has the largest value (In the case of a Max Heap)
    // - We will Swap the root with the last element in the array
    // - Heapify the tree, but exclude the last node
    // - After Heapify, second largest element is at the root
    // - Rinse and Repeat

    public int[] HeapSort(){
        // We will return a sorted array
        int temp;
        int lastHeapIndex = this.size - 1;
        int[] copyHeap = Arrays.copyOf(this.heap, this.heap.length);
//        System.out.println("Before Sorting : ");
//        Arrays.asList(this.heap).forEach(System.out::print);
        ArrayReverse arrayReverse = new ArrayReverse();
        for (int i = 0; i < lastHeapIndex; i++) {
            // Swapping Elements
            temp = copyHeap[0];
            copyHeap[0] = copyHeap[lastHeapIndex - i];
            copyHeap[lastHeapIndex - i] = temp;

            heapifyDown(0, lastHeapIndex - i - 1);
        }
        arrayReverse.reverse(copyHeap,this.heap.length);

        return copyHeap;
    }






}
