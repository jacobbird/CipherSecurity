package Methods;
import java.util.ArrayList;
import CipherSecurity.GUILogin;

public class RSA {
	
	private ArrayList<Key> obj = new ArrayList<Key>();
	private Key text;
	Key user;
	private String text2;
        private String name ="";
	
	public String convert(String data, char op) {
            GUILogin login = new GUILogin();
            name = login.getUserNameString();
		String data2 = User(data, op, name);
		return data2;
	}
	
	private String User(String data, char op, String name) {
		
		if(obj.isEmpty()) {
			text = new Key();
			obj.add(text);
			text2 = text.getKey(data, op, name);
		}
		else{
			if(ifExists(name)) {
				text2 = text.getData(data, op, name, user);
			}
			else {
				text = new Key();
				 obj.add(text);
				 text2 = text.getKey(data, op, name);
			}
		}
		return text2;
	}
	
	boolean ifExists(String name) {
		for (Key person : obj) {
	        if(person.getName() ==  name) {
	        	user = person;
	        	return true;
	     }
	  }
		return false;
	}
}
