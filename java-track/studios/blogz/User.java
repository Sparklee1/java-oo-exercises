package blogz;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User extends Entity {

	private String userName;
	private String password;
	private static List<User> userList = new ArrayList();

	public User (String userName, String password, int uid){
		super(uid);
		if (isValidUserName(userName)){
			this.userName = userName;
		}else{
			throw new IllegalArgumentException("Invalid user name or password");
		}
		
		if (isValidPassword(password)){
			this.password = password;
		}else{
			throw new IllegalArgumentException("Invalid user name or password");
		}
		
	}
	private static String hashPassword (String password){
		String hashedPassword=password;
		return hashedPassword;
	}
	private boolean isValidPassword (String password){
		String hashedPassword = hashPassword(password);
		if (this.password.equals(hashedPassword)){
			return true;
		}else{
			return false;
		}
	}
	
	private static boolean isValidUserName(String userName){
		return Pattern.matches(userName, "[a-zA-Z][a-zA-Z0-9_-]{4,11}");
	}
	
	private static void addUserList(User newUser){
		userList.add(newUser);
	}
	
	private static List<User> getUserList(){
		return userList;
	}
}
