package »­Í¼;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int num = inScanner.nextInt();
		int res = 0;
		boolean[][] flag = new boolean[101][101];
		for (int i = 0; i < num; i++) {
			int x1 = inScanner.nextInt();
			int y1 = inScanner.nextInt();
			int x2 = inScanner.nextInt();
			int y2 = inScanner.nextInt();
			
			for (int x = x1; x < x2; x++) {
				for (int y = y1; y <  y2; y++) {
					flag[x][y] = true;
				}
			}
		}
		
		for (int i = 0; i < flag.length; i++) {
			for (int j = 0; j < flag[i].length; j++) {
				if (flag[i][j]) {
					res++;
				}
			}
		}
		
		System.out.println(res);
	}
	
}
