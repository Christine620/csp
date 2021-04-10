package ÕÛµã¼ÆÊı;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int num = inScanner.nextInt();
		int[] array = new int[num]; 
		for (int i = 0; i < num; i++) {
			array[i] = inScanner.nextInt();
		}
		
		int res = 0;
		
		for (int i = 1; i < array.length-1; i++) {
			if((array[i]<array[i-1]&&array[i]< array[i+1])||(array[i]>array[i-1]&& array[i]>array[i+1])) {
				res++;
			}
		}
		System.out.println(res);
	}
	

}
