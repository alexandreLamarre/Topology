package Test;
import Struct.Heap;
import java.util.Scanner;

public class HeapTest {


    public static void main(String[] args) {

        Heap heap1 = new Heap(0);
        Heap heap2 = new Heap(53);
        Heap heap3 = new Heap(1);


        assert(heap1.heap_length() == 0): "heaplength1 incorrect";
        assert(heap1.heap_size() == 0): "heapsize1 incorrect";

        assert(heap2.heap_length() == 53):"heaplength2 incorrect";
        assert(heap2.heap_size() == 0): "heapsize2 incorrect";

        assert(heap3.heap_length() == 1): "heaplength3 incorrect";
        assert(heap3.heap_size() == 0 ): "heapsize3 incorrect";

        System.out.println("Done");

    }
}
