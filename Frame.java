package mp6;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Frame extends JFrame  {
private JMenuBar bar=null;
private String[] FigNames={"Straight Line","Rectangle","Oval","Round Rectangle","Filled Rectangle","Filled Oval"};
private JMenu File=null;
private JMenu Figure=null;
private JMenu Color=null;
private JMenu Foreground=null;
private JMenu Background=null;
private JMenu Font1=null;
private JMenu Style=null;
private JMenu Size=null;
private JMenuItem ColorItems[]=new JMenuItem[6];
private JMenuItem ColorItems2[]=new JMenuItem[6];
private JMenuItem StyleItems[]=new JMenuItem[3];
private JMenuItem SizeItems[]=new JMenuItem[3];
private JMenuItem FigItems[]=new JMenuItem[6];
private String [] ColorNames={"Black","Blue","Cyan","Green","Magenta","Red"};
private String [] Misc={"Exit","Clear"};
private JMenuItem [] MiscItems=new JMenuItem[2];
private String [] StyleTypes={"BOLD","ITALICS","UNDERLINE"};
private String [] SizeTypes={"SIZE 10","SIZE 20","SIZE 72"};
private Font f1=null;
private static JTextField tf;
public static DrawingPanel dp;
private JLabel displayLabel=null;

public Frame()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,1000);
		dp=new DrawingPanel();
		tf=new JTextField(200);
		this.setLayout(new BorderLayout());
		this.add(dp, BorderLayout.CENTER);
		this.add(tf,BorderLayout.SOUTH);
		bar=new JMenuBar();
		File=new JMenu("File");
		Figure=new JMenu("Figure");
		Color=new JMenu("Color");
		Foreground=new JMenu("Foreground");
		Background=new JMenu("Background");
		Font1=new JMenu("Font");
		Style=new JMenu("Style");
		Size=new JMenu("Size");
		f1= tf.getFont().deriveFont(Font.PLAIN,32f);
		tf.setFont(f1);
		JMenu[] Menus={File,Figure,Color,Font1,};
		JMenu[] Menus2={Foreground,Background};
		JMenu[]Menus3={Style,Size};
		for(int i=0;i<Menus.length;i++)
		{
			Menus[i].setFont(f1);
			bar.add(Menus[i]);
			
		}
		for(int i=0;i<FigNames.length;i++)
		{
			FigItems[i]=new JMenuItem(FigNames[i]);
			FigItems[i].addActionListener(new FigHandler());
			FigItems[i].setFont(f1);
			Figure.add(FigItems[i]);
		}
		for(int i=0;i<Menus2.length;i++)
		    Color.add(Menus2[i]).setFont(f1);;
		
		for(int i=0;i<Menus2.length;i++)
		    Font1.add(Menus3[i]).setFont(f1);;
		
		for(int i=0;i<ColorNames.length;i++)
		{
		    ColorItems[i]=new JMenuItem(ColorNames[i]);
			ColorItems[i].addActionListener(new colorHandler());
			ColorItems[i].setFont(f1);
			Background.add(ColorItems[i]);	
		}
		for(int i=0;i<ColorNames.length;i++)
		{
		    ColorItems2[i]=new JMenuItem(ColorNames[i]);
			ColorItems2[i].addActionListener(new colorHandler());
			ColorItems2[i].setFont(f1);
			Foreground.add(ColorItems2[i]);	
		}
		for(int i=0;i<StyleTypes.length;i++)
		{
		    StyleItems[i]=new JMenuItem(StyleTypes[i]);
			StyleItems[i].addActionListener(new fontHandler());
			StyleItems[i].setFont(f1);
			Style.add(StyleItems[i]);
		}
		for(int i=0;i<SizeTypes.length;i++)
		{
		    SizeItems[i]=new JMenuItem(SizeTypes[i]);
			SizeItems[i].addActionListener(new fontHandler());
			SizeItems[i].setFont(f1);
			Size.add(SizeItems[i]);
		}
		for(int i=0;i<Misc.length;i++)
		{
			if(i==0)
			{
				MiscItems[i]=new JMenuItem(Misc[i]);
				MiscItems[i].addActionListener(new exitHandler());
				MiscItems[i].setFont(f1);
				File.add(MiscItems[i]);
			}
			else
			{
				MiscItems[i]=new JMenuItem(Misc[i]);
				MiscItems[i].addActionListener(new colorHandler());
				MiscItems[i].setFont(f1);
				Color.add(MiscItems[i]);
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
private class colorHandler implements ActionListener
{

public void actionPerformed(ActionEvent e) 
	{
	
	}
	
	
}
public class FigHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	
}
public class fontHandler implements ActionListener
{

public void actionPerformed(ActionEvent e) 
	{
	
	 }
}
	
}

