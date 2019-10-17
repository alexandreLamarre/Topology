package Struct;
import java.lang.Math.*;

/**
 * Class Heap implementing a HeapDataStructure with Arrays
 */
public class Heap {
    int[] container;
    int size;
    int length;

    public Heap(int heap_length){
        container = new int[heap_length];
        size = 0;
        length = heap_length;
    }

    public int heap_length(){
        return length;
    }

    public int heap_size(){
        return size;
    }

    public int parent(int i){

        return (int) Math.floor(i/2);
    }

    public int Left(int i){
        return 2*i;
    }

    public int Right(int i){
        return 2*i +1;
    }


}
