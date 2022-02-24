package labs.lab3;

public class PrimeGenerator {

	private int num = 2;
	private int temp;


	
	public PrimeGenerator() {}
	
	public int nextPrime() {
		while (true) {
			if (isPrime(num)) {
				temp = num;
				num++;
				return temp;
			}else {
				num++;
			}
			
		}
	
	}
	
	/*
	 * Citation: https://www.geeksforgeeks.org/prime-numbers/
	 */
	
	private boolean isPrime(int n) {
        if (n <= 1) 
            return false; 
  
        for (int i = 2; i < n; i++) 
            if (n % i == 0) 
                return false; 
  
        return true; 
	}
}




