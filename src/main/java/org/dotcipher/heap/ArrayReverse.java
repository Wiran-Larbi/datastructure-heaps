package org.dotcipher.heap;

public class ArrayReverse {
    public ArrayReverse() {}

    public static void reverse(int[] arr, int length){
        int left = 0;
        int right = length - 1;

        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}
