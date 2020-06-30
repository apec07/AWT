import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class MyFrameTest extends Frame implements ActionListener {
	
	private String name;
	private Button saveBtn,exitBtn;
	private TextField inputField;
	
	//Contructor
	public MyFrameTest(String name){
		this.name = name;
		setLocation(10,10);
		setSize(200,300);
		setLayout (new GridLayout(3,1));	
		//Panel pan = new Panel();
		  inputField = new TextField();
		  inputField.setText("Please type in here");
		  inputField.addActionListener (this);	
			exitBtn = new Button ("Exit");	
			exitBtn.addActionListener (this);	
			saveBtn = new Button ("Save");	
			saveBtn.addActionListener (this);	
			add(inputField);
			add(saveBtn);
			add(exitBtn);
	
	}
	//overwrited ActionListener method
	public void actionPerformed (ActionEvent e) {
			if (e.getSource() == exitBtn){
				//JOptionPane.showMessageDialog(null, "Exit");
				int option =JOptionPane.showConfirmDialog(null, "Really Exit?", "Exit", JOptionPane.YES_NO_OPTION);
				System.out.println(option);
				if(option==1){
					//Do NOT EXIT!
					return;
				}
				setVisible (false);
	  		dispose();
	  		//System.exit (0);
			} else if (e.getSource() == saveBtn) {
				JOptionPane.showMessageDialog(null, "Saved...");  
				//saveText();
			} else{
				System.err.println("Not defiend");
			}
		
	}
	
	//Start here
	public static void main(String[] args){
			MyFrameTest f = new MyFrameTest("Hello");
			f.show();
	}

}