package mp6;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.*;


public class Frame extends JFrame {
private JMenuItem exitItem=null;
private JMenuItem[] Figures;
private JMenu FiguresMenu=null;
private JMenuBar bar=null;
private JMenu Color=null;
private JMenu Font=null;
private static JTextField tf;
public static DrawingPanel dp;
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
		this.setVisible(true);
		
		
	}
}
