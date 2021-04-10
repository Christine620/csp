package Ïà·´Êý;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] count = new int[1001];
		while(num-- > 0) {
			int value = in.nextInt();
			value = Math.abs(value);
			count[value]++;
		}
		int res = 0;
		for(int i=0; i< count.length;i++) {
			if(count[i]==2) res++;
		}
		System.out.println(res);
	}
}
