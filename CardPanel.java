
import java.awt.*;
import java.awt.event.*;

/**
Please read below document first!
https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/CardLayoutDemoProject/src/layout/CardLayoutDemo.java
*/

public class CardPanel extends Frame implements ActionListener {
	
		private Button b1,b2;
		private Panel p1,p2;
		private CardLayout cl;

		public CardPanel (String name){
				super("name");
				cl = new CardLayout(100,100);
				setLayout(cl);
				//cl.addLayoutComponent(this, p1);
				//cl.addLayoutComponent(this, p2);
				setSize(300, 300);
		}
		@Override
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource()==b1){
				System.out.println("next to p2");
				cl.next(p2);
			}else if(e.getSource()==b2){
				System.out.println("previous to p1");
				cl.previous(p1);
			}	else{
				System.out.println("not defined!");
			}
			
		}
		
		private void launchPanel(){
				p1 = new Panel();
				p2 = new Panel();
				b1 = new Button("Next");
				b2 = new Button("Back");
				b1.addActionListener(this);
				b2.addActionListener(this);
				p1.add(b1);
				p2.add(b2);
				add(p1);
				add(p2);
		}

		public static void main (String[] args){
				
				CardPanel cp = new CardPanel("Frame");
				cp.show();
				cp.launchPanel();
				
		}

}