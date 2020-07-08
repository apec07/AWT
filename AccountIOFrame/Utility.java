// Utility for 
import java.io.*;
import java.util.*;

public class Utility {

	public static boolean writeToFile (String pathName,List myList){
		try {
		FileOutputStream fos = new FileOutputStream (pathName);
		ObjectOutputStream oos = new ObjectOutputStream (fos);
		oos.writeObject (myList);
		oos.flush();
		oos.close();
		fos.close();
		} catch (IOException ex) {
		System.err.println ("Trouble writing - "+ex);
		return false;
	  }
		
		return true;
	}
	
	public static List readFromList(String pathName){
		List myList;
		try {
		FileInputStream fis = new FileInputStream (pathName);
		ObjectInputStream ois = new ObjectInputStream (fis);
		myList = (List)(ois.readObject());
		ois.close();
		fis.close();
		} catch (IOException ex) {
		System.err.println ("Trouble reading - "+ex);
		return null;
	  } catch (ClassNotFoundException ex){
	  System.err.println ("Trouble Casing - "+ex);
		return null;
		}
		return myList;
	}


}