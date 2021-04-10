package ��������Ϸ;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int n = inScanner.nextInt(), m = inScanner.nextInt();
		int[][] grid = new int[n][m];
		boolean[][] flag = new boolean[n][m];
		//��ʼ��
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = inScanner.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int c = 0;
				int r = 0;
					
				if ( i-1 >= 0 && grid[i][j] == grid[i-1][j] ) {//����
					r++;
					if ( i-2 >= 0 && grid[i][j] == grid[i-2][j] ) r++;
				}
				if ( i+1 < n && grid[i][j] == grid[i+1][j] ) {//����
					r++;
					if ( i+2 < n && grid[i][j] == grid[i+2][j] ) r++;
				}
				
				//��
				if ( j-1 >= 0 && grid[i][j] == grid[i][j-1] ) {//����
					c++;
					if ( j-2 >= 0 && grid[i][j] == grid[i][j-2] ) c++;
				}
				if ( j+1 < m && grid[i][j] == grid[i][j+1] ) {//����
					c++;
					if ( j+2 < m && grid[i][j] == grid[i][j+2] ) c++;

				}
				
				if(r>=2||c>=2) flag[i][j] = true;
			
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (flag[i][j]) {
					System.out.print(0+" ");
				}else {
					System.out.print(grid[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
}