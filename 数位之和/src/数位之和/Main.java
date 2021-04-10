package 数位之和;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		String lineString = inScanner.nextLine();
		int sum = 0;
		for (int i = 0; i < lineString.length(); i++) {
			sum += lineString.charAt(i)-'0';
		}
		System.out.println(sum);
	}
}
