package Algo;

import javax.swing.*;
import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawingComponent extends Component{
    public static int MAX_COLOR = 16581375;
    public int color;

    public static void main(String[] args) {
        int frameWidth = 2048;
        int frameHeight = 2048;
        int color = 5;
        javax.swing.JFrame frame = new javax.swing.JFrame();

        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);
        frame.getContentPane().add(new DrawingComponent(color));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public DrawingComponent(int color){
        super();
        this.color = color;
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
       Color c = new Color(0,0,0);

        if (this.color<= 255){
            c = new Color(0,this.color,0);
        }
        else if(this.color > 255 && this.color <= 65025){

            int green = this.color / 255;
            int blue = this.color / 255;

            c = new Color(0, 255 - green, blue);

        }
        else if(this.color > 65025 && this.color <=MAX_COLOR){

            int temp = this.color /255;
            int blue = temp/255;
            int red = temp/255;

            c= new Color(red,0,255 - blue);


        }

        g.setColor(c);

        int x = 25;
        int y = 32;
        g.fillRect(0,0, 400,400);

    }
}
