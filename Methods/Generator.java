package CipherSecurity.Methods;

public class Generator {
	
	int isprime(int a)
	{
		int i;
		for (i = 2; i < a; i++){
			if ((a % i) == 0)
				return 0;
		}
		return 1;
	}

	int gcd(int a, int b)
	{
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		return gcd(b, a%b);
	}

	int getNum(String name){
		int sum = 0;
		for (int i = 0; i<name.length(); i++)
		{
			int temp = name.charAt(i);
			while (temp > 0) {
				sum += temp % 10;
				temp /= 10;
			}
		}

		return sum;
	}

	int getPrime(int prime){
		int primeNum = prime;
		do {
			primeNum++;
		} while (isprime(primeNum) != 1);

		return primeNum;
	}

}
