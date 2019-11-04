package Algo;

import javax.swing.*;
import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class DrawingComponent extends Component{

    public int color;
    public int x;
    public int y;

    public DrawingComponent(int color, int x, int y){
        super();
        this.color = color;
        this.x = x;
        this.y = y;

    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Color c = new Color(0,0,0);

        //TODO: implement a better hashing function for colors so that they are evenly distributed from green to red.

        if(this.color <128){
            c = new Color(0, 255-this.color, 0);
        }
        if(this.color >=128 && this.color< 128+255){
            int intermediate = (int) Math.max(255-this.color, 0);
            int blue = this.color -128;
            c = new Color(0, intermediate, blue);
        }
        if(this.color >=128+255){
            int intermediate = (int) Math.max(510-this.color, 0);
            int red = this.color -(128+255);
            c = new Color(red, 0, intermediate);
        }

        g.setColor(c);

        g.fillRect(this.x,this.y, DrawArrays.SIZE,DrawArrays.SIZE);

    }
}
