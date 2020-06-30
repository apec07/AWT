import java.awt.*;
import java.awt.event.*;

public class MyFrameTest extends Frame implements ActionListener {
	
	private String name;
	
	//Contructor
	public MyFrameTest(String name){
		this.name = name;
		setLocation(10,10);
		setSize(200,300);
		Panel pan = new Panel();
			Button clearBtn = new Button ("Exit");	
			clearBtn.addActionListener (this);	
			pan.add (clearBtn);					
			add (pan, BorderLayout.NORTH);
	}
	//overwrited ActionListener method
	public void actionPerformed (ActionEvent e) {
		setVisible (false);
	  dispose();
	  //System.exit (0);
	}
	
	//Start here
	public static void main(String[] args){
			MyFrameTest f = new MyFrameTest("Hello");
			f.show();
	}

}