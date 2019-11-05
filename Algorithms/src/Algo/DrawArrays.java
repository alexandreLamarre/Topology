package Algo;

import javax.swing.*;
import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import Struct.MaxHeap;


public class DrawArrays {
    public static int MAX_COLOR = 510+128;
    public static int RESOLUTION = 256;
    public static int FRAMEWIDTH = 2048;
    public static int FRAMEHEIGHT = 2048;
    public static int SIZE = FRAMEWIDTH/RESOLUTION;

    public static void main(String[] args) {
        //Set Default colors
        int color = 0;
        //Set Default coordinates
        int x =0;
        int y= 0;


        //TODO there's some bugs with drawing and array index out of bounds.
        javax.swing.JFrame frame = createBasicWindow(FRAMEWIDTH, FRAMEHEIGHT);
        heapsortProcessFrame(frame, 0,0);

        //TODO fix a function that draws within the RESOLUTION and FRAMEWIDTH and FRAMEHEIGHT
        javax.swing.JFrame frame1 = createBasicWindow(FRAMEWIDTH, FRAMEHEIGHT);
        quicksortProcessFrame(frame1, 0,0);

    }


    /**
     * Draw an array of  int values on a given "line" starting at (x,y) in the window
     * @param frame the window
     * @param value set of values to draw
     * @param x x coordinate of start of the line
     * @param y y coordinate of start of the line
     */
    public static void DrawProcessLine(javax.swing.JFrame frame, int[] value, int x, int y){

        for(int j = 0; j< RESOLUTION; j++) {
            DrawingComponent temp = new DrawingComponent(value[j], (x + (SIZE * j)), y);
            frame.getContentPane().add(temp);
            temp.paint(frame.getGraphics());
        }
    }

    /**
     * Draw a 2D array of a sorting process to the window, handles null values in the array
     * in the case of algorithm like quicksort that might not need the max number of steps
     * @param frame the window
     * @param handler 2D array of sorting substeps
     * @param x starting x to draw the 2D array
     * @param y starting y to draw the 2D array
     */
    public static void DrawEntireProcess(javax.swing.JFrame frame, int[][] handler, int x, int y){
        int lines_to_print = handler.length;
        for(int i = 0; i< lines_to_print; i++){
            if(handler[i] != null) {
                DrawProcessLine(frame, handler[i], x, y + (i * SIZE));
            }
        }
    }

    /**
     * Draws a random array of integers into a pixel form
     * Then draws all it the substeps required to sort it into a maxheap
     * @param frame window to display the heapsort process on
     * @param x x coordinate to draw it on the frame
     * @param y y coordinate to draw it on the frame
     */
    public static void heapsortProcessFrame(javax.swing.JFrame frame, int x, int y){
        //create random array
        int[] A = randArr(RESOLUTION);
        //Create a heap Object
        MaxHeap H = new MaxHeap(RESOLUTION);
        // Decompose it into steps
        int[][] processToDraw = H.BuildMaxHeapHandler(A);
        DrawEntireProcess(frame, processToDraw, x,y);

    }
    /**
     * Draws a random array of integers into a pixel form
     * Then draws all it the substeps required to sort it into a maxheap
     * @param frame window to display the heapsort process on
     * @param x x coordinate to draw it on the frame
     * @param y y coordinate to draw it on the frame
     */
    public static void quicksortProcessFrame(javax.swing.JFrame frame, int x, int y){
        //create random array
        int[] A = randArr(RESOLUTION);
        //Create a 2D array displaying quicksort sorting process
        int[][] processToDraw = Quicksort.quickSortHandler(A);
        DrawEntireProcess(frame, processToDraw, x,y);
    }


    /**
     * Creates an array of random integers between 0 and MAXCOLOR
     * @param length length of random array
     * @return the random array
     */
    public static int[] randArr(int length){
        int[] A = new int[length];
        for (int i = 0; i< length; i++) {
            A[i] = (int) (Math.random() * MAX_COLOR);
        }
        return A;
    }

    /**
     * Creates a basic window to work with
     * @param width width of the window
     * @param length length of the window
     */
    public static javax.swing.JFrame createBasicWindow(int width, int length){
        //Initialize frames
        javax.swing.JFrame frame = new javax.swing.JFrame();

        frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
        frame.setVisible(true);

        //Closing the window terminates the program
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return frame;
    }


}
