package Algo;

public class CountingSort extends Sort {

    public static void main(String[] args) {
        int[] A = {6,7,3,4,5,11,12,56,78,65};
        int[] B = new int[A.length];
        sort(A, B, 78);

    }

    /**
     * Given an input and output array, and a number to signify the max value in the input array
     * counts all elements less than x, and puts it in the corresponding place in output array
     * @param input integer array to be sorted
     * @param sorted sorted array to be returned
     * @param k max integer in the input array
     * @return sorted array
     */
    public static int[] sort(int[] input, int[] sorted, int k){
        int[] temp = new int[k];
        for(int i=0; i< k; i++){
            temp[i] = 0;
        }

        for(int j =1; j<input.length; j++){
            temp[input[j]] = temp[input[j]] + 1;
        }

        for(int i =1; i<k; i++){
            temp[i] = temp[i] + temp[i+1];
        }

        for(int j = input.length; j >1; j--){
            sorted[temp[input[j]]] = input[j];
            temp[input[j]] = temp[input[j]]-1;
        }

        return sorted;
    }
}
