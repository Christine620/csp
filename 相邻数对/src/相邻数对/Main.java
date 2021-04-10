package ÏàÁÚÊı¶Ô;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] list = new int[num];
		//boolean[] flag = new boolean[num];
		int res = 0;
		for (int i = 0; i < num; i++) {
			list[i] = in.nextInt();
		}
		for (int i = 0; i < num; i++) {
			for (int j = i+1; j < num; j++) {
				if(Math.abs(list[i]-list[j])==1) {
					res ++;
					
				}
			}
		}
		System.out.println(res);
	}
}
