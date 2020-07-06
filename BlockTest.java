
public class BlockTest {
	
	{
		System.out.println("non-static block");
	}
	
	static{
		System.out.println("static block");
	}
	
	public BlockTest(String name){
		System.out.println("Constructor "+name);
	}
	
	public static void main(String args[]){
		BlockTest bt1 = new BlockTest("1");
		//BlockTest bt2 = new BlockTest("2");
		
	}
}