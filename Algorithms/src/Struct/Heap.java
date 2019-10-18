package Struct;
import java.lang.Math.*;

/**
 * Class Heap implementing a HeapDataStructure with integer Arrays
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

    public void set_heap_length(int length){
        this.length = length;
    }

    public int heap_size(){
        return size;
    }

    public void set_heap_size(int size){
        this.size = size;
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

    public int[] get_container(){
        return this.container;
    }


}
