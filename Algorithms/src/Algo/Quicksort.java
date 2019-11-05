package Algo;

public class Quicksort {

    public static void main(String[] args) {
        int[] A = {6,7,3,4,5,11,12,56,78,65};
        int[][] B;
        B = quickSortHandler(A);
        System.out.println(B.length);
        for(int i =0; i< B.length; i++){
            if(B[i] != null) {
                printArray(B[i]);
            }
        }
    }

    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void quickSort(int[] A){
        quickSortIterative(A, 0, A.length-1);
    }
    public static int[][] quickSortHandler(int[] A){
        return quickSortIterative(A, 0, A.length-1);
    }

    static int partition(int arr[], int start, int end)
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

    /* A[] --> Array to be sorted,
   l  --> Starting index,
   h  --> Ending index */

    static int[][] quickSortIterative(int arr[], int start, int end)
    {
        // Create an auxiliary stack
        int[] stack = new int[end - start + 1];

        // initialize top of stack
        int top = -1;

        //Initialize step of Handler
        int step = 0;
        int [][] B = new int[arr.length][];

        // push initial values of l and h to stack
        stack[++top] = start;
        stack[++top] = end;

        // Keep popping from stack while is not empty
        while (top >= 0) {
            // Pop h and l
            end = stack[top--];
            start = stack[top--];
            B[step] = copy(arr);
            // Set pivot element at its correct position
            // in sorted array
            int p = partition(arr, start, end);
            step++;


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

        return B;
    }

    public static int[] copy(int[] A){
        int[] C = new int[A.length];

        for(int i =0; i< A.length; i++){
            C[i] = A[i];
        }

        return C;
    }



}
