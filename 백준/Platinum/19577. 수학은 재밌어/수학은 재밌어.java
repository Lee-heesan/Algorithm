import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());

		for(long x = 1; x<=Math.sqrt(n) ; x++){
		    if(n % x == 0){
		        
		        if(x * phi(x) == n){
		            System.out.println(x);
		            return;
		        }

		        long y = n / x;	
		        if(y * phi(y) == n){
		            System.out.println(y);
		            return;
		        }
		    }
		}

		System.out.println(-1);
	}
	
	
	public static long phi(long num) {
		
		long n = num;
		long temp = n;
		
		for(long i = 2; i<=Math.sqrt(n); i++) {
			if(n%i==0) {
				temp = temp - (temp/i);
				while(n%i==0) {
					n /= i;
				}
			}
		}
		
		if(n>1){
			temp = temp - (temp/n);
		}
		
		return temp;
	}
}
