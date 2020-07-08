
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {
	
		private GridLayout mGrid ;
		private Panel[] panels = new Panel[4] ;
		private Label[] labels = new Label[4] ;
		private TextField[] texts =  new TextField[2];
		private final String[] labelName = {"Login Page","Account","Paassword",""};
		private Button btnOk,btnClear;
		
		
		public LoginPage(String name){
			super(name);
			mGrid = new GridLayout(4,1);
			setLayout(mGrid);
			btnOk = new Button("OK");
			btnClear = new Button("Clear");
			btnOk.addActionListener(this);
			btnClear.addActionListener(this);
			for(int i =0 ; i<4 ; i++){
				panels[i] = new Panel();
				((FlowLayout)panels[i].getLayout()).setAlignment(FlowLayout.LEFT);
				labels[i] = new Label(i+1+"");
				labels[i].setAlignment(Label.LEFT);
				labels[i].setText(labelName[i]);
				panels[i].add(labels[i]);
				add(panels[i]);
			}
			panels[3].add(btnOk);
			panels[3].add(btnClear);
			texts[0] = new TextField(20);
			texts[1] = new TextField(40);
			panels[1].add(texts[0]);
			panels[2].add(texts[1]);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setBounds(100,200,400,400);
      setVisible(true);

		}
		
		@Override
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource()==btnOk){
				System.out.println("Click OK");
				//System.out.println(texts[0].getText()+texts[1].getText());
				//Read Data
				
				UserAccount account = new UserAccount();
				account.setName(texts[0].getText());
				account.setPassword(texts[1].getText());
				System.out.println(account);
			  JOptionPane.showMessageDialog(null, "Saved account...");
			  //Save Data (overwrited!)
			  Utility.writeToFile("data.txt",account);
			  
			}else if(e.getSource()==btnClear){
				System.out.println("Click Clear");
				texts[0].setText(" "); //not work...if no space why?
				texts[1].setText(" "); 
			}	else{
				System.out.println("not defined!");
			}
			
		}
		
		public static void main(String args[]){
			new LoginPage("Login Page");
		}
}