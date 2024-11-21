package Services;

import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import model.User;
import util.EmailUtility;
import util.hibernate;


public class LoginRegisterService {
	
	private static Random rand = new Random();
	private static int randomNum = rand.nextInt(99999);

	public static boolean newregister(String email,String username,String password,String role,String tokenText) {
		try(Session session = hibernate.getSession()) {
            User newuser = new User(email,username,password,role);
			if(tokenText.equals(generateVerificationToken())){
				new userService().addUser(newuser);
				System.out.println("new user added");
				return true;   
			}else {
				return false;
			}
			} catch (Exception e){
            e.printStackTrace();
        }
		return false;
	}
	
	
	public static boolean checkUser(String email,String username,String password) {
		if((email.isBlank()) || (username.isBlank())) {
			JOptionPane.showMessageDialog(null,"Email and Username cannot be blank");
			return false;
		}
			if((email.isBlank())) {
				JOptionPane.showMessageDialog(null,"Email cannot be blank");
				return false;
			}
			if((username.isBlank())) {
				JOptionPane.showMessageDialog(null,"Username cannot be blank");
				return false;
			}

		try(Session session = hibernate.getSession()) {
            userService userservice = new userService();
			User user = userservice.getUseronUsername(username);
			List<String> emaillist = userservice.getAllemails();
			if(emaillist.contains(email)) {
				JOptionPane.showMessageDialog(null,"User Already exists");
			}else if((user == null)){
				System.out.println("new user check");
				return true;
			}else if(user.getUsername().equalsIgnoreCase(username)) {
				JOptionPane.showMessageDialog(null,"UserName Already exists");
			}
			} catch (Exception e){
            e.printStackTrace();
        }
		return false;
	}
	
	public static void sendemail( String email, String username,String role) {
		String token = generateVerificationToken();
		
		String verificationCode = token;   
		String Details = "Name: " + username + "<br>" +
		                                  "Email: " + email + "<br>" +
		                                  "Role: " + role;
		        
		EmailUtility.sendVerificationEmail(email, Details, verificationCode);
		System.out.println("Verification email sent to: " + email);
		
	}
	
	private static String generateVerificationToken() {
//        return UUID.randomUUID().toString();  // Generate a random UUID for the token
		return String.valueOf(randomNum);
//		return "12345";
    }
	


	public static String login(String username,String password,String role) {
		if((password.isBlank()) || (username.isBlank())) {
			JOptionPane.showMessageDialog(null,"Username or Password cannot be blank");
			return null;
		}
		try(Session session = hibernate.getSession()) {
            List<User> list = new userService().getAllUser();
            for(User u:list) {
            	if(password.equalsIgnoreCase(u.getPassword()) && username.equalsIgnoreCase(u.getUsername())) {
        			if(role.equalsIgnoreCase(u.getRole())){
        				return role;        				
        			}
        			return "norole";
    					}
            	}
        }catch (Exception e){
            e.printStackTrace();
	}
		return null;
	}
}
