package CipherSecurity.Methods;

public class Cryption{
	
	int encrypt(char ch, int n, int e)
	{
		int i;
		int temp = ch;
		for (i = 1; i < e; i++)
			temp = (temp * ch) % n;
		return temp;
	}

	char decrypt(int ch, int n, int d)
	{
		int i;
		int temp = ch;
		for (i = 1; i < d; i++)
			ch = (temp * ch) % n;
		return (char)(ch);
	}

}
