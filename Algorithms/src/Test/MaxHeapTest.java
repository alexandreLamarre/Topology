package Test;

import Struct.Heap;
import Struct.MaxHeap;

public class MaxHeapTest {
    public static void main(String[] args) {

        MaxHeap heap1 = new MaxHeap(10);
        MaxHeap heap2 = new MaxHeap(53);
        MaxHeap heap3 = new MaxHeap(1);

        int[] A = {4,1,3,2,16,9,10,14,8,7};
        int[] result = {16, 14 ,10,8,7,9,3,2,4,1};
        heap1.BuildMaxHeap(A);

        assert(heap1.heap_length() == 10): "heaplength1 incorrect";
        assert(heap1.heap_size() == 10): "heapsize1 incorrect";
        assert(heap1.get_container() == result) : " incorrect sorting";

        //assert(heap2.heap_length() == 53):"heaplength2 incorrect";
        //assert(heap2.heap_size() == 0): "heapsize2 incorrect";

        //assert(heap3.heap_length() == 1): "heaplength3 incorrect";
        //assert(heap3.heap_size() == 0 ): "heapsize3 incorrect";
        for (int i = 0; i< heap1.heap_length(); i++){
            assert(heap1.get_container()[i] == result[i]) : "Incorrect array values";
        }

        System.out.println("Done");

    }
}
