package Struct;
import java.lang.Math.*;

public class MaxHeap extends Heap{

    public MaxHeap(int heap_length){
        super(heap_length);
    }

    public void MaxHeapify(int[] A, int i){

        int largest;
        int current = i-1;
        int l = Left(i) -1;
        int r = Right(i) -1;

        //Check the left node if it exists and compare it to the current node
        if((l < this.heap_size()) && (A[l] > A[current])){
            largest = l;
        }
        else{
            largest = current;
        }

        //Check the right node if it exists and compare it to the current node
        if((r < this.heap_size()) && A[r]> A[largest]){
            largest = r;
        }


        if(largest != current){
            int switch_i = A[current];
            int switch_largest = A[largest];
            A[current] = switch_largest;
            A[largest] = switch_i;
            MaxHeapify(A, largest+1);
        }

    }

    public void BuildMaxHeap(int[] A){
        this.set_heap_size(A.length);
        for(int i = (int)Math.floor((A.length)/2); i>= 1; i--){
            MaxHeapify(A, i);
        }
        for(int j =0; j < Math.min(this.length, A.length); j++){
            this.container[j] = A[j];
        }
    }
}
