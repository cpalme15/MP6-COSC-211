package mp6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Frame extends JFrame {
	private JMenuBar bar=null;
	private JSlider sl=null;
	private JSlider sl2=null;
	private JSlider sl3=null;
	private JSlider sl4=null;
	private JSlider sl5=null;
	private JSlider sl6=null;
	private String[] FigNames={"Straight Line","Rectangle","Oval","Round Rectangle","Filled Rectangle","Filled Oval"};
	private JMenu File1=null;
	private JMenu Figure=null;
	private JMenu Color1=null;
	int R=0;
	int G=0;
	int B=0;
	int R2=0;
	int G2=0;
	int B2=0;
	private JMenu Foreground=null;
	private JMenu Background=null;
	private JMenu Font1=null;
	private JMenu Style=null;
	private JMenu Size=null;
	private JMenu pick=null;
	private JMenuItem ColorItems[]=new JMenuItem[7];
	private JMenuItem ColorItems2[]=new JMenuItem[7];
	Random r=new Random();
	private JMenuItem StyleItems[]=new JMenuItem[3];
	private JMenuItem SizeItems[]=new JMenuItem[3];
	private JMenuItem FigItems[]=new JMenuItem[6];
	private String [] ColorNames={"Black","Blue","Cyan","Green","Magenta","Red","Random Color"};
	private String [] Misc={"Exit","Clear"};
	private JMenuItem [] MiscItems=new JMenuItem[2];
	private String [] StyleTypes={"BOLD","ITALICS","UNDERLINE"};
	private String [] SizeTypes={"SIZE 10","SIZE 20","SIZE 72"};
	private Font f1=null;
	private Font f8=null;
	DrawingPanel dp;
	private static JTextField tf;
	private JLabel displayLabel=null;

	public Frame()
	{
		super();

		tf=new JTextField(100);
		dp=new DrawingPanel();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,1000);
		this.setLayout(new BorderLayout());
		this.getContentPane().add(dp, BorderLayout.CENTER);
		this.add(tf,BorderLayout.SOUTH);
		bar=new JMenuBar();
		File1=new JMenu("File");
		Figure=new JMenu("Figure");
		Color1=new JMenu("Color");
		Foreground=new JMenu("Foreground");
		Background=new JMenu("Background");
		pick=new JMenu("Pick Your Own");
		Font1=new JMenu("Font");
		Style=new JMenu("Style");
		Size=new JMenu("Size");
		f1= tf.getFont().deriveFont(Font.PLAIN,50f);
		f8= tf.getFont().deriveFont(Font.PLAIN,32f);
		tf.setFont(f1);
		JMenu[] Menus={File1,Figure,Color1,Font1,};
		JMenu[] Menus2={Foreground,Background};
		JMenu[]Menus3={Style,Size};
		JMenu[]Menus4={pick};
		for(int i=0;i<Menus.length;i++)
		{
			Menus[i].setFont(f8);
			bar.add(Menus[i]);

		}
		for(int i=0;i<FigNames.length;i++)
		{
			FigItems[i]=new JMenuItem(FigNames[i]);
			FigItems[i].addActionListener(new FigHandler());
			FigItems[i].setFont(f8);
			Figure.add(FigItems[i]);
		}
		for(int i=0;i<Menus2.length;i++){
			Menus2[i].addActionListener(new colorHandler());
			Color1.add(Menus2[i]).setFont(f8);
		}

		for(int i=0;i<Menus3.length;i++){
			Menus3[i].addActionListener(new fontHandler());
			Font1.add(Menus3[i]).setFont(f8);
		}

		
		for(int i=0;i<ColorNames.length;i++)
		{
			ColorItems2[i]=new JMenuItem(ColorNames[i].toLowerCase());
			ColorItems2[i].addActionListener(new colorHandler());
			ColorItems2[i].setFont(f8);
			Foreground.add(ColorItems2[i]);	
			if(i==ColorNames.length-1){
				String x=Menus4[0].getLabel();
				x=x.toLowerCase();
				Font f9=tf.getFont().deriveFont(200f);
				Font f10=tf.getFont().deriveFont(16f);
				JMenu f=new JMenu(x);
				f.setFont(f8);
				Foreground.add(f);
				sl4=new JSlider(SwingConstants.HORIZONTAL,0,256,1);
				sl5=new JSlider(SwingConstants.HORIZONTAL,0,256,1);
				sl6=new JSlider(SwingConstants.HORIZONTAL,0,256,1);
				sl4.addChangeListener(new sliderHandler());
				sl5.addChangeListener(new sliderHandler());
				sl6.addChangeListener(new sliderHandler());
				JMenuItem slider=new JMenuItem("-----------------------");
				sl4.setFont(f10);
				sl4.setMajorTickSpacing(10);
				sl4.setMinorTickSpacing(1);
				sl4.setPaintTicks(true);
				sl4.setPaintLabels(true);
				sl5.setFont(f10);
				sl5.setMajorTickSpacing(10);
				sl5.setMinorTickSpacing(1);
				sl5.setPaintTicks(true);
				sl5.setPaintLabels(true);
				sl6.setFont(f10);
				sl6.setMajorTickSpacing(10);
				sl6.setMinorTickSpacing(1);
				sl6.setPaintTicks(true);
				sl6.setPaintLabels(true);
				slider.setFont(f9);
				slider.setLayout(new BorderLayout());
				slider.add(sl4,BorderLayout.NORTH);
				slider.add(sl5,BorderLayout.CENTER);
				slider.add(sl6, BorderLayout.SOUTH);
				f.add(slider);
			}

		}
		for(int i=0;i<ColorNames.length;i++)
		{
			ColorItems[i]=new JMenuItem(ColorNames[i]);
			ColorItems[i].addActionListener(new colorHandler());
			ColorItems[i].setFont(f8);
			Background.add(ColorItems[i]);	
			if(i==ColorNames.length-1)
			{
				Menus4[0].setFont(f8);
				Font f9=tf.getFont().deriveFont(200f);
				Font f10=tf.getFont().deriveFont(16f);
				sl=new JSlider(SwingConstants.HORIZONTAL,0,256,1);
				sl2=new JSlider(SwingConstants.HORIZONTAL,0,256,1);
				sl3=new JSlider(SwingConstants.HORIZONTAL,0,256,1);
				sl.addChangeListener(new sliderHandler());
				sl2.addChangeListener(new sliderHandler());
				sl3.addChangeListener(new sliderHandler());
				JMenuItem slider=new JMenuItem("-----------------------");
				sl.setFont(f10);
				sl.setMajorTickSpacing(10);
				sl.setMinorTickSpacing(1);
				sl.setPaintTicks(true);
				sl.setPaintLabels(true);
				sl2.setFont(f10);
				sl2.setMajorTickSpacing(10);
				sl2.setMinorTickSpacing(1);
				sl2.setPaintTicks(true);
				sl2.setPaintLabels(true);
				sl3.setFont(f10);
				sl3.setMajorTickSpacing(10);
				sl3.setMinorTickSpacing(1);
				sl3.setPaintTicks(true);
				sl3.setPaintLabels(true);
				slider.setFont(f9);
				slider.setLayout(new BorderLayout());
				slider.add(sl,BorderLayout.NORTH);
				slider.add(sl2,BorderLayout.CENTER);
				slider.add(sl3, BorderLayout.SOUTH);
				Menus4[0].add(slider);
				Background.add(Menus4[0]);

			}
		}
		for(int i=0;i<StyleTypes.length;i++)
		{
			StyleItems[i]=new JMenuItem(StyleTypes[i]);
			StyleItems[i].addActionListener(new fontHandler());
			StyleItems[i].setFont(f8);
			Style.add(StyleItems[i]);
		}
		for(int i=0;i<SizeTypes.length;i++)
		{
			SizeItems[i]=new JMenuItem(SizeTypes[i]);
			SizeItems[i].addActionListener(new fontHandler());
			SizeItems[i].setFont(f8);
			Size.add(SizeItems[i]);
		}
		for(int i=0;i<Misc.length;i++)
		{
			if(i==0)
			{
				MiscItems[i]=new JMenuItem(Misc[i]);
				MiscItems[i].addActionListener(new exitHandler());
				MiscItems[i].setFont(f8);
				File1.add(MiscItems[i]);
			}
			else
			{
				MiscItems[i]=new JMenuItem(Misc[i]);
				MiscItems[i].addActionListener(new colorHandler());
				MiscItems[i].setFont(f8);
				Color1.add(MiscItems[i]);
			}
		}
		this.setJMenuBar(bar);
		this.setVisible(true);


	}

	private class exitHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
		}

	}
	private class sliderHandler implements ChangeListener
	{
		
		@Override
		public void stateChanged(ChangeEvent arg0) 
		{
			boolean sliderback=false;
				if(arg0.getSource().equals(sl)==true)
				{
					R=sl.getValue();
					sliderback=true;
				}
				else if(arg0.getSource().equals(sl2)==true)
				{
					G=sl2.getValue();
					sliderback=true;
				}
				else if(arg0.getSource().equals(sl3)==true)
				{
					B=sl3.getValue();
					sliderback=true;
				}
				else if(arg0.getSource().equals(sl4)==true)
				{
					R2=sl4.getValue();
				  dp.setSliderclr(true);
				}
				else if(arg0.getSource().equals(sl5)==true)
				{
					G2=sl5.getValue();
					dp.setSliderclr(true);
				}
				else if(arg0.getSource().equals(sl6)==true)
				{
					B2=sl6.getValue();
					dp.setSliderclr(true);
				}
				if(sliderback==true)
				{
				dp.setBackground(new Color(R,G,B));
				sliderback=false;
				}
				if(dp.getSliderclr()==true)
				{
				dp.setR(R2);
				dp.setG(G2);
				dp.setB(B2);
				}
			
				
			
		}
		
		
	}
	private class colorHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			String x=e.getActionCommand();
			JMenuItem z=(JMenuItem) e.getSource();
			switch(x)
			{

			case "Black": dp.setBackground(Color.BLACK);break;
			case "Blue": dp.setBackground(Color.blue); break;
			case "Cyan": dp.setBackground(Color.cyan); break;
			case "Green": dp.setBackground(Color.green);break;
			case "Magenta": dp.setBackground(Color.magenta);break;
			case "Red":dp.setBackground(Color.red);break;
			case "Random Color": dp.setBackground(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256))); break;

			case "black":dp.setSliderclr(false);dp.setC(1);break;
			case "blue": dp.setSliderclr(false);dp.setC(2); break;
			case "cyan": dp.setSliderclr(false);dp.setC(3);break;
			case "green":dp.setSliderclr(false);dp.setC(4);break;
			case "magenta":dp.setSliderclr(false); dp.setC(5); break;
			case "red": dp.setSliderclr(false);dp.setC(6);break;
			case "random color":dp.setR(r.nextInt(256));dp.setG(r.nextInt(256));dp.setB(r.nextInt(256));dp.setRandclr(true); break;

			case "Clear":break;
			}
		}


	}
	public class FigHandler implements ActionListener
	{

		String x;
		public void actionPerformed(ActionEvent arg0)
		{
			x=arg0.getActionCommand();
			dp.setS(x);
		}

	}





	public class fontHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			String x=e.getActionCommand();
			boolean checked=false;

			switch(x)
			{

			case "SIZE 10": Font f2=tf.getFont().deriveFont(10f);
			tf.setFont(f2);
			break;
			case "SIZE 20": Font f5=tf.getFont().deriveFont(20f);
			tf.setFont(f5);
			break;
			case"SIZE 72": Font f6=tf.getFont().deriveFont(72f);
			tf.setFont(f6);
			break;
			case "BOLD": Font f3=tf.getFont().deriveFont(Font.BOLD);
			tf.setFont(f3);
			break;
			case "ITALICS": Font f4=tf.getFont().deriveFont(Font.ITALIC); 
			tf.setFont(f4);
			break;
			case "UNDERLINE": Font f7 = tf.getFont();
			Map attributes = f7.getAttributes();
			attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			tf.setFont(f7.deriveFont(attributes));
			break;

			}
		}
	}

}

