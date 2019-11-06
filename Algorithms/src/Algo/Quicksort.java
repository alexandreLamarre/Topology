package Algo;

public class Quicksort extends Sort {

    public static void main(String[] args) {
        //Static test for quicksort
        int[] A = {6,7,3,4,5,11,12,56,78,65};
        int[][] B;
        B = quickSortHandler(A);
        System.out.println(B.length);
        for(int i =0; i< B.length; i++){
            if(B[i] != null) {
                printArray(B[i]);
            }
        }
        //random test for quicksort
        int[] Arr = DrawArrays.randArr(DrawArrays.RESOLUTION);
        int [][] Brr;
        Brr = quickSortHandler(Arr);
        System.out.println(Brr.length);
        for(int i =0; i< Brr.length; i++){
            if(Brr[i] != null) {
                System.out.println(i + "\n");
                printArray(Brr[i]);
            }
        }

    }


    /**
     * Quicksort the array A in place without specifiying indices for convenience
     * @param A array to be sorted
     */
    public static void quickSort(int[] A){
        quickSortIterative(A, 0, A.length-1);
    }

    /**
     * Quicksort the array A in place without specifying indicies for convenience and
     * returning an array which contains all of the substeps needed to sort the array
     * @param A array to be sorted
     * @return 2D array of intermediate sorted states
     */
    public static int[][] quickSortHandler(int[] A){
        return quickSortIterative(A, 0, A.length-1);
    }

    /**
     * Divide array to be sorted and swamp its entries in the corresponding divided partitions
     * @param arr array to partition
     * @param start start index of partition
     * @param end last index of partition
     * @return the index of the pivot
     */
    private static int partition(int arr[], int start, int end)
    {
        int pivot = arr[end];

        // index of smaller element
        int i = (start - 1);
        for (int j = start; j <= end - 1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }


    /**
     * Iterative implementation of quicksort -- chooses a pivot and sorts around it
     * @param arr array to be sorted
     * @param start start index for sorting
     * @param end end index for sorting
     * @return handler for all the step in quicksort
     */
    private static int[][] quickSortIterative(int arr[], int start, int end)
    {
        // Create an auxiliary stack
        int[] stack = new int[end - start + 1];

        // initialize top of stack
        int top = -1;

        //Initialize step of Handler
        int step = 0;
        int Blength = arr.length;
        int [][] B = new int[Blength][];
        B[step] = copy(arr);
        step++;
        // push initial values of l and h to stack
        stack[++top] = start;
        stack[++top] = end;

        // Keep popping from stack while is not empty
        while (top >= 0) {
            // Pop h and l
            end = stack[top--];
            start = stack[top--];
            B[step] = copy(arr);
            step++;
            // Set pivot element at its correct position
            // in sorted array
            int p = partition(arr, start, end);



            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p - 1 > start) {
                stack[++top] = start;
                stack[++top] = p - 1;
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (p + 1 < end) {
                stack[++top] = p + 1;
                stack[++top] = end;
            }
        }
        B[step] = copy(arr);

        return B;
    }

    /**
     * Complete copy of array using implementation of System.arraycopy
     * @param A array to be copied
     * @return Copy of array
     */
    private static int[] copy(int[] A){
        int[] C = new int[A.length];

        System.arraycopy(A,0,C,0,A.length);
        return C;
    }



}
