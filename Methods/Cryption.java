package CipherSecurity.Methods;

public class Cryption{
	
	int encrypt(char ch, int n, int e)//Encryptes by using the formula ch^e % n. As thats a large number we put it in loop
	{
		int i;
		int temp = ch;
		for (i = 1; i < e; i++)
			temp = (temp * ch) % n;
		return temp; //Returns integer
	}

	char decrypt(int ch, int n, int d) //Decryptes by using the formula ch^d % n. As thats a large number we put it in loop
	{
		int i;
		int temp = ch;
		for (i = 1; i < d; i++)
			ch = (temp * ch) % n;
		return (char)(ch); //Returns character
	}

}
