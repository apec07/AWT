

import java.io.*;

public class UserAccount implements Serializable{
	
	private String accountName;
	private String accountPassword;
	
	public void setName(String accountName){
		this.accountName = accountName;
	}
	public void setPassword(String accountPassword){
		this.accountPassword = accountPassword;
	}
	
	public String getName(){
		return accountName;
	}
	public String getPassword(){
		return accountPassword;
	}
	@Override
	public String toString(){
		String ans = "Account = "+accountName + " Password = "+accountPassword;
		return ans;
	}

}