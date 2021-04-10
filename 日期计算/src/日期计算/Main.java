package ÈÕÆÚ¼ÆËã;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int year = inScanner.nextInt();
		int day = inScanner.nextInt();
		int[] run = {31,29,31,30,31,30,31,31,30,31,30,31};
		int[] notRun = {31,28,31,30,31,30,31,31,30,31,30,31};
		int month = 1;
		if(isRun(year)) {
			
			
			for (int i = 0; i < run.length; i++) {
				if((day)>run[i]) {
					day-=run[i];
				}else {
					month = i+1;
					break;
				}
			}
			
			System.out.println(month);
			System.out.println(day);
		}else {
			for (int i = 0; i < notRun.length; i++) {
				if((day)>notRun[i]) {
					day-=notRun[i];
				}else {
					month = i+1;
					break;
				}
			}
			
			System.out.println(month);
			System.out.println(day);
		}
		
	}
	
	public static boolean isRun(int year) {
		if(year%4==0 && year%100!= 0) return true;
		else {
			return false;
		}
	}
	
}
