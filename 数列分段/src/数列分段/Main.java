package ÊýÁÐ·Ö¶Î;

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int num = inScanner.nextInt();
		int res = 1;
		int prev = inScanner.nextInt();
		for(int i=1; i<num; i++) {
			int now = inScanner.nextInt();
			if(now!=prev) {
				res++;
				prev=now; 
			}
		}
		
		System.out.println(res);
	}

}
