
import java.awt.*;
import java.awt.event.*;

public class SwitchPanel implements ActionListener {
		
		private Frame f1,f2;
		private Panel p1,p2;
		private Button colorBtn1,colorBtn2;
		private TextArea ta1,ta2;
		private int mySwitch;
		
		//Constructor
		public SwitchPanel(String name){
			f1 = new Frame("f1");
			f2 = new Frame("f2");
			f1.setBackground(Color.ORANGE);
			f2.setBackground(Color.BLUE);
			f1.setLayout(new GridLayout(2,1));
			f2.setLayout(new GridLayout(2,1));
	  }
	  private void launchFrame() {
	  	colorBtn1 = new Button("Change");
			colorBtn2 = new Button("Change");
			colorBtn1.addActionListener(this);
			colorBtn2.addActionListener(this);
			ta1 = new TextArea();
			ta2 = new TextArea();
			f1.add(colorBtn1);
			f1.add(ta1);
			f2.add(colorBtn2);
			f2.add(ta2);
			f1.setSize(300, 300);
			f2.setSize(300, 300);
  		f1.show();
  		f2.show();
  	}
	
	 
		public void actionPerformed (ActionEvent e) {
					
				if (e.getSource() == colorBtn1){
						f1.setVisible(false);
						f2.setVisible(true);
				}else if(e.getSource() == colorBtn2){
						f1.setVisible(true);
						f2.setVisible(false);	
				}
		}
	  public static void main (String args[]){
	  	SwitchPanel f = new SwitchPanel("Test");
	  	f.launchFrame();
	  	
	  }

}