import java.awt.*;

public class MyFrameTest extends Frame {
	
	private String name;
	
	//Contructor
	public MyFrameTest(String name){
		this.name = name;
		setLocation(10,10);
		setSize(200,300);
	}
	
	//Start here
	public static void main(String[] args){
			MyFrameTest f = new MyFrameTest("Hello");
			f.show();
	}

}