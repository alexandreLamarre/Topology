package Struct;
import java.lang.Math.*;

public class MaxHeap extends Heap{

    public MaxHeap(int heap_length){
        super(heap_length);
    }

    public void MaxHeapify(int[] A, int i){
        int largest = 0; //TODO: find what initial value this should hold.
        int l = Left(i);
        int r = Right(i);
        if((l <= this.heap_size()) && (A[l] > A[i])){
            largest = l;
        }
        if((r <= this.heap_size()) && A[r]> A[largest]){
            largest = r;
        }
        if(largest != i){
            int switch_i = A[i];
            int switch_largest = A[largest];
            A[i] = switch_largest;
            A[largest] = switch_i;
            MaxHeapify(A, largest);
        }

    }

    public void BuildMaxHeap(int[] A){
        this.set_heap_size(A.length);
        for(int i = (int)Math.floor(A.length/2); i>= 1; i--){
            MaxHeapify(A, i);
        }
        this.container = A;


    }
}
