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


        //Initialize frames
        javax.swing.JFrame frame = new javax.swing.JFrame();

        frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
        frame.setVisible(true);

        // constructing random array
        int[] A = new int[RESOLUTION];
        for (int i = 0; i< RESOLUTION; i++) {
            A[i] = (int) (Math.random() * MAX_COLOR);
        }
        // displaying heap sorted array
        MaxHeap H = new MaxHeap(RESOLUTION);
        int[][] processToDraw = H.BuildMaxHeapHandler(A);
        DrawEntireProcess(frame, processToDraw, x,y);

        //Close window.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void DrawProcessLine(javax.swing.JFrame frame, int[] value, int x, int y){

        for(int j = 0; j< RESOLUTION; j++) {
            DrawingComponent temp = new DrawingComponent(value[j], (x + (SIZE * j)), y);
            frame.getContentPane().add(temp);
            temp.paint(frame.getGraphics());
        }
    }

    public static void DrawEntireProcess(javax.swing.JFrame frame, int[][] handler, int x, int y){
        int lines_to_print = handler.length;
        for(int i = 0; i< lines_to_print; i++){
            DrawProcessLine(frame, handler[i], x, y+ (i *SIZE));
        }
    }


}
