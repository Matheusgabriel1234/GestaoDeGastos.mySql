package DataBase;

import java.util.Random;

public class DadosUsers {
	private static final int MIN_ID = 100000; 
    private static final int MAX_ID = 999999;
    private String username;
    private String email;
    private String password;

 
    
    
    public static int generateRandomId() {
        Random random = new Random();
        return random.nextInt(MAX_ID - MIN_ID + 1) + MIN_ID;
    }




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public static int getMinId() {
		return MIN_ID;
	}




	public static int getMaxId() {
		return MAX_ID;
	}
    
    


}
