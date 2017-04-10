package mp6;

import javax.swing.*;

import mp6.Frame.FigHandler;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.image.*;



public class DrawingPanel extends JPanel implements MouseListener,MouseMotionListener{
	
	
	Random ra=new Random();
	
	
	private int x=50,y=100;
	private int x1,y1,x2,y2;
	private int[] xPoints={100,250,400,50,400};
	private int[] yPoints={370,150,370,200,200};
	String s="";
	int c;
	int r;
	int g;
	int b;
	int arcstuff=3000;
	boolean sliderclr=false;
	boolean randclr=false;
	

	public DrawingPanel()
	{
		super();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setBackground(Color.yellow);
		
		
	}
	public void paintComponent(Graphics gr)
	{
		super.paintComponent(gr);//calls this everytime mess with panel
		Color v=new Color(r,g,b);
		if(sliderclr==true)
		{
			gr.setColor(v);
		}
		if(randclr==true)
		{
			gr.setColor(v);
			
		}
		if(sliderclr==false&&randclr==false)
		{
		switch(c)
		{
		case 0:break;
		case 1: gr.setColor(Color.BLACK); break;
		case 2:gr.setColor(Color.blue); break;
		case 3:gr.setColor(Color.cyan); break;
		case 4:gr.setColor(Color.GREEN); break;
		case 5: gr.setColor(Color.MAGENTA);break;
		case 6: gr.setColor(Color.RED);break;
		}
		}
		
			switch(s)
			{
			case "Straight Line":gr.drawLine(x1, y1, x2, y2);break;
			case "Rectangle": gr.drawRect(x1, y1, x2, y2); break;
			case "Oval":gr.drawOval(x1, y1, x2, y2); break;
			case "Round Rectangle":gr.fillRoundRect(x1, y1, x2, y2,arcstuff,arcstuff);
			case "Filled Rectangle":gr.fillRect(x1, y1, x2, y2);
			case"Filled Oval": gr.fillOval(x1, y1, x2, y2);
			case "":break;
			}
		
			
			
	}
	
	public void setRandclr(boolean randclr) {
		this.randclr = randclr;
	}
	public boolean getSliderclr() {
		return sliderclr;
	}
	public void setSliderclr(boolean sliderclr) {
		this.sliderclr = sliderclr;
	}
	public void setR(int r) {
		this.r = r;
	}
	public void setG(int g) {
		this.g = g;
	}
	public void setB(int b) {
		this.b = b;
	}
	public void setC(int cl)
	{
		c=cl;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
	x2=e.getX();
	y2=e.getY();
	repaint();
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
	
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		x=e.getX();
		y=e.getY();

		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		x1=e.getX();
		y1=e.getY();
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
