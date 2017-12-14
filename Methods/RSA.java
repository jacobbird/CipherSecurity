package CipherSecurity.Methods;
import java.util.ArrayList;
import CipherSecurity.CipherSecurity.GUILogin;

public class RSA {
	
	private ArrayList<Key> obj = new ArrayList<Key>(); //Keeps list of user objects logged on while app is running
	private Key text;
	Key user;
	private String text2;
        private String name ="";
	
	public String convert(String data, char op) {
            //GUILogin login = new GUILogin();
            name = GUILogin.getUserNameString(); // Grabs username of app from textfield
		String data2 = User(data, op, name);
		return data2;
	}
	
	private String User(String data, char op, String name) {
		
		if(obj.isEmpty()) {// Checks if arraylist if empty
			text = new Key();
			obj.add(text);
			text2 = text.getKey(data, op, name);//Calls to convert given string to another encrypted/decrypted string
		}
		else{
			if(ifExists(name)) {//Checks if user object already exists. Does not have to generate Key if it does
				text2 = text.getData(data, op, name, user);
			}
			else {
				text = new Key();//Creates user object
				 obj.add(text);
				 text2 = text.getKey(data, op, name);
			}
		}
		return text2;
	}
	
	boolean ifExists(String name) {//Checks if name exists in user objects
		for (Key person : obj) {
	        if(person.getName().equals(name)) {
	        	user = person;
	        	return true;
	     }
	  }
		return false;
	}
}
