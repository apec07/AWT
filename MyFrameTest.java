import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane;

public class MyFrameTest extends Frame implements ActionListener{
	
	private String name;
	private Button saveBtn,exitBtn;
	private TextArea inputField;
	private StringBuffer message;
	
	//Constructor
	public MyFrameTest(String name){
		this.name = name;
		message = new StringBuffer();
		setLocation(10,10);
		setSize(200,300);
		setLayout (new GridLayout(3,1));	
		//Panel pan = new Panel();
		  inputField = new TextArea();
		  //inputField.addActionListener (this);	
		  //inputField.addKeyListener (this);
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
				 message.append(inputField.getText());
				 if(message.length()==0){
				 	JOptionPane.showMessageDialog(null, "Please type any words!");   
				 	return;
				 }
				System.out.println(message);
				try{
					saveText("text.txt");
					clearText();
				}catch(IOException ex){
				  JOptionPane.showMessageDialog(null, "Oops....Not Saved\n"+message);
					ex.printStackTrace();
				}
				
			} else{
			  System.err.println("Not defiend "+ e.getSource());
			}
		
	}
	/**
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e){
		if(e.getKeyChar()== KeyEvent.VK_ENTER){
			System.out.println("Enter");
				message.append("\n");
		}
	}
	*/
	private void saveText(String pathName) throws IOException {
			FileWriter fw = new FileWriter(pathName,true);
			fw.write(message+"\n");
			fw.flush();
			fw.close();
			JOptionPane.showMessageDialog(null, "Saved...\n"+message);
	}
	private void clearText(){
		inputField.setText("");
		message.delete(0,message.length());
	}
	
	//Start here
	public static void main(String[] args){
			MyFrameTest f = new MyFrameTest("Hello");
			f.show();
	}

}