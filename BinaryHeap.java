import java.util.*;
/**
 * Write a description of class BinaryHeap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BinaryHeap
{
    // instance variables - replace the example below with your own
    private int[] heap;
    private int size;
    /**
     * Constructor for objects of class BinaryHeap
     */
    public BinaryHeap()
    {
        // initialise instance variables
        heap = new int[30];
        size = 0;
    }

    private int parent (int pos)
    {
        return heap[(pos-1)/2];
    }
    private int leftChild (int pos)
    {
        return heap[pos*2+1];
    }
    private int rightChild (int pos)
    {
        return heap[pos*2+2];
    }
    
    private void growHeap()
    {
        heap = Arrays.copyOf(heap, heap.length*2);
    }
    private void swap(int x1, int x2) 
    { 
        int temp = heap[x1]; 
        heap[x1] = heap[x2]; 
        heap[x2] = temp; 
    } 
    public boolean isLeaf(int pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
    
    public void add (int x)
    {
        if (size >= heap.length-1)
            growHeap();
        heap[size] = x;
        int index = size;
        size++;
        while ( index != 0 && parent(index) > x) // Swaps new child node into right place
        {
            swap((index-1)/2, index);
            index = (index-1)/2;
        }
    }
    
    public int remove () throws Exception
    {
        if (size == 0)
            throw new Exception ("Heap empty");
            
        int temp = heap [0];
        heap[0] = heap[--size];
        int index = 0; 
        
        while (!isLeaf(index) && (heap[index] > leftChild(index) ||  heap[index] > rightChild(index)))
        {
            if (leftChild(index) <= rightChild(index))
            {
                swap(index*2+1, index);
                index = index*2+1;
            }
            else 
            {
                swap(index*2+2, index);
                index = index*2+2;
            }
        }
        
        return temp;
    }
    
    public String toString()
    {
        return Arrays.toString(heap);
    }
}
