import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane;

public class MyFrameTest extends Frame implements ActionListener {
	
	private String name;
	private Button saveBtn,exitBtn;
	private TextField inputField;
	private String message;
	
	//Contructor
	public MyFrameTest(String name){
		this.name = name;
		setLocation(10,10);
		setSize(200,300);
		setLayout (new GridLayout(3,1));	
		//Panel pan = new Panel();
		  inputField = new TextField();
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
				 message = inputField.getText();
				 if(message.length()==0){
				 	JOptionPane.showMessageDialog(null, "Please type any words!");   
				 	return;
				 }
				System.out.println(message);
				JOptionPane.showMessageDialog(null, "Saved...\n"+message);
				try{
					saveText("text.txt");
					clearText();
				}catch(IOException ex){
					ex.printStackTrace();
				}
				
			} else{
			  //To enter on textField will cause here!!
				System.err.println("Not defiend");
			}
		
	}
	private void saveText(String pathName) throws IOException {
			FileWriter fw = new FileWriter(pathName,true);
			fw.write(message+"\n");
			fw.flush();
			fw.close();
	}
	private void clearText(){
		inputField.setText("");
	}
	
	//Start here
	public static void main(String[] args){
			MyFrameTest f = new MyFrameTest("Hello");
			f.show();
	}

}