package mp6;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Frame extends JFrame  {
private JMenuItem exitItem=null;
private JMenuItem[] Figures;
private JMenu FiguresMenu=null;
private JMenuBar bar=null;
private JMenu Color=null;
private JMenu Font=null;
private static JTextField tf;
public static DrawingPanel dp;
private JLabel displayLabel=null;
private static JMenu fileMenu=null;
	public Frame()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,400);
		dp=new DrawingPanel();
		tf=new JTextField(200);
		this.setLayout(new BorderLayout());
		this.add(dp, BorderLayout.CENTER);
		this.add(tf,BorderLayout.SOUTH);
		Color=new JMenu("Color");
		Font=new JMenu("Font");
		FiguresMenu=new JMenu("Figures");
		fileMenu=new JMenu("File");
		exitItem=new JMenuItem("Exit");
		exitItem.addActionListener(new exitHandler());
		fileMenu.add(exitItem);
		bar=new JMenuBar();
		bar.add(fileMenu);
		bar.add(Color);
		bar.add(Font);
		bar.add(FiguresMenu);
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
public class fontHandler implements ActionListener
{

public void actionPerformed(ActionEvent e) 
	{
	
	 }
}
	
}

