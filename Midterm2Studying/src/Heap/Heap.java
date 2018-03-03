package Heap;

import java.util.Arrays;

/**
 * Implementing a priority queue using a heap.
 * Operations: insert (o(logn)), delMin (o(logn)).
 * @author carlos
 */
public class Heap {
    private int currentSize; // Keeps track of the index of the last element.
    private int [] heap; // The array that implements the heap.
    
    /**
     * Creates an empty heap with default size of "100".
     */
    public Heap()
    {
        int size = 100; 
        heap = new int [size];
        heap[0] = 0; // Initialize the first index as garbage.
        currentSize = 1; // Skip the first index.
    }
    
    /**
     * Creates an empty heap with the size passed by the user.
     * @param size The size of the heap to be created.
     */
    public Heap(int size)
    {
        heap = new int[size];
        heap[0] = 0;
        currentSize = 0; // Do not count the index "0" as an element.
    }
    
    /**
     * Insert an integer into the heap.
     * @param data The integer to insert into the heap.
     */
    public void insert(int data)
    {
        boolean isHeapRuleMet = false; // Checks if the heap rule has been met.
        int currentIndex; // Keep track of the index of the new "data" node.
        int parentIndex; // The index of the parent of the new "data" node.
        int tmp; // Used to hold a value while swapping.
        
        // Insert data at end of the array, unless full then return.
        if(currentSize == heap.length - 1)
        {
            System.out.println("Sorry, the heap is full!");
            return;
        }
        else
        {
            currentSize++;
            heap[currentSize] = data;
            currentIndex = currentSize;
        }
        
        // Continue to peroclate up until heap rule is met, or the new "data"
        // node is at the root.
        while(!isHeapRuleMet && currentIndex > 1)
        {
            // Calculate parent index by using the relationship of "i" = parent,
            // "2i" = left child, and "2i+1" = right child.
            if(currentIndex % 2 == 0)
            {
                parentIndex = currentIndex / 2;
            }
            else
            {
                parentIndex = (currentIndex - 1) / 2;
            }
            
            // Swap if parent > child.
            if(heap[parentIndex] > data)
            {
                tmp = heap[parentIndex];
                heap[parentIndex] = data;
                heap[currentIndex] = tmp;
                
                // Update currentIndex to the parent's index since swap was 
                // performed.
                currentIndex = parentIndex;
            }
            else
            {
                isHeapRuleMet = true;
            }
        }
    }
    
    /**
     * Return the heap represented as a string in array form.
     * @return The heap as a string in array form.
     */
    @Override
    public String toString()
    {
        return Arrays.toString(heap);
    }
    
    /**
     * Deletes the minimum integer, and returns its value.
     * @return The minimum in the heap.
     */
    public int delMin()
    {
        return -1;
    }
    
}
