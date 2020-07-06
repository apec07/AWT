
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwitchCardLayout extends JFrame{

		private CardLayout myCardLayout;
		private Container myContainer = getContentPane();
		JPanel panel1,panel2;
		//panel1 with cardlayout
		{
			myCardLayout = new CardLayout();
			panel1 = new JPanel();
			panel1.setLayout(myCardLayout);
			myContainer.add(panel1,BorderLayout.CENTER);
			String textName[] = {"Page1","Page2","Page3"};
			for(int i=0;i<textName.length;i++){
				JLabel jLabel = new JLabel(textName[i],SwingConstants.CENTER);
				jLabel.setName(textName[i]);
				panel1.add(jLabel,textName[i]);	
			}
		}
		//panel2 with flowlayout
		{
			panel2 = new JPanel();
			panel2.setLayout(new FlowLayout());
			myContainer.add(panel2,BorderLayout.SOUTH);
			
			String[] buttonName = {"First","Previous","Page1","Page2","Page3","Next","Last"};
			for (int i=0;i<buttonName.length;i++){
				Button button = new Button(buttonName[i]);
				button.setName(buttonName[i]);
				button.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						//e.getSource() == exitBtn
						String name = button.getName();
						switch (name){
							case "First":
								System.out.println("First");
								myCardLayout.first(panel1);
								break;
							case "Previous":
								System.out.println("Previous");
								myCardLayout.previous(panel1);
								break;
							case "Page1":
								System.out.println("Page1");
								myCardLayout.show(panel1,"Page1");
								break;
							case "Page2":
								System.out.println("Page2");
								myCardLayout.show(panel1,"Page2");
								break;
							case "Page3":
								System.out.println("Page3");
								myCardLayout.show(panel1,"Page3");
								break;
							case "Next":
								System.out.println("Next");
								myCardLayout.next(panel1);
								break;
							case "Last":
								System.out.println("Last");
								myCardLayout.last(panel1);
								break;
								
							default:								
								System.out.println("Default");
						}
					}
				});
				panel2.add(button);
			}
		}
		
		public SwitchCardLayout(){
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setBounds(100,200,400,400);
      setVisible(true);
		}
		public static void main(String[] args){
			SwitchCardLayout sw = new SwitchCardLayout();
		}

}