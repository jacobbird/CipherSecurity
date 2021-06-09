package CipherSecurity.Methods;
import java.util.Random;


public class Key {
	private String name;
	private String data;
	private String text = "";
	private String str[];
	private char op;
	private int e = 0;
	private int n = 0;
	private int d = 0;
	private int phi;
	private int prime1;
	private int prime2;
	
	
	public String getKey(String data, char op, String name) {
		
		this.name = name;
		this.data = data;
		this.op = op;
		
		
		
			Generator gen = new Generator();
			int sum = gen.getNum(name); // Converts username to single integer

			prime1 = sum;// Sets prime # 1 to convert username integer

			prime1 = gen.getPrime(prime1); //Calls to check if given is prime, if not returns one

			int power = (int)((java.lang.Math.pow(10, ((prime1 > 0 ? (int)java.lang.Math.log10((double)(prime1)) + 1 : 1) - 1)))); //Gets number of Digits in prime1 - 1

			prime2 = ((prime1 % power) + (prime1 % 10) * 10); //Sets prime # 2 using prime1

			prime2 = gen.getPrime(prime2); 

			n = prime1 * prime2; //Key common number
			phi = (prime1 - 1) * (prime2 - 1); //Used to create encryption and decryption keys
			if(phi == 0){ //If username is empty returns empty string
                            return text;
                        }
			Random rnd = new Random(n); //Creates random number with seed from common Key number
			do {
				e = rnd.nextInt(32767) + 1 % phi;//Generates a number less than phi
				//e = phi*rnd.nextInt(32767) + 1;
			} while (gen.gcd(phi, e) != 1); //Gets encryption key from GCD(e,phi) = 1


			do {

				d = rnd.nextInt(32767) + 1 % phi;//Generates a number less than phi
				//d = phi*rnd.nextInt(32767) + 1;

			} while (((d * e) % phi) != 1); //Gets decryption key from GCD(e*d,phi) = 1
		Cryption();//Calls to encrypt or decrypt
		return text;
	}
	
	public String getData(String data, char op, String name, Key obj) {
		this.data = data;
		this.op = op;
		this.name = name;
		setData(obj);
		Cryption();
		return text;
	}
	
	
	private void Cryption() {
		
		Cryption crypt = new Cryption();
		switch(op) {//Character is given for encryption or decryption
			case 'e'://Converts each character in string to encrypted integer
				for (int i = 0; i < data.length(); i++)
					text = text + crypt.encrypt(data.charAt(i), n, e) + " ";
				break;
			case 'd'://Converts each integer in string till delimiter to decryption character
				str = data.split(" ");
				for (int i = 0; i < str.length; i++) {
					text = text + crypt.decrypt(Integer.parseInt(str[i]), this.n, this.d);
				}
				break;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setData(Key obj) {//If user object exists in array. Sets the data to the user
		this.e = obj.e;
		this.n = obj.n;
		this.d = obj.d;
		text = "";
	}
	
}
