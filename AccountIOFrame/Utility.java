// Utility for Account
import java.io.*;
import java.util.*;

public class Utility {

	public static boolean writeToFile (String pathName,Account account){
		try {
		FileOutputStream fos = new FileOutputStream (pathName);
		ObjectOutputStream oos = new ObjectOutputStream (fos);
		oos.writeObject (account);
		oos.flush();
		oos.close();
		fos.close();
		} catch (IOException ex) {
		System.err.println ("Trouble writing - "+ex);
		return false;
	  }
		
		return true;
	}
	
	public static Account readFromAccount(String pathName){
		Account account;
		try {
		FileInputStream fis = new FileInputStream (pathName);
		ObjectInputStream ois = new ObjectInputStream (fis);
		account = (Account)(ois.readObject());
		ois.close();
		fis.close();
		} catch (IOException ex) {
		System.err.println ("Trouble reading - "+ex);
		return null;
	  } catch (ClassNotFoundException ex){
	  System.err.println ("Trouble Casing - "+ex);
		return null;
		}
		return account;
	}

	

}